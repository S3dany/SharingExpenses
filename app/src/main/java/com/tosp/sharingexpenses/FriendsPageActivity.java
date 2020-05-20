package com.tosp.sharingexpenses;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.SearchView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.firestore.CollectionReference;
        import com.google.firebase.firestore.DocumentReference;
        import com.google.firebase.firestore.DocumentSnapshot;
        import com.google.firebase.firestore.EventListener;
        import com.google.firebase.firestore.FirebaseFirestore;
        import com.google.firebase.firestore.FirebaseFirestoreException;
        import com.tosp.sharingexpenses.friends.FriendsListAdapter;

        import java.util.ArrayList;

public class FriendsPageActivity extends AppCompatActivity {

    ArrayList<String> friendsList;
    ListView friendsListView;
    SearchView searchView;
    Button addFriendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_page);

        setTitle("Friends");

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        final String currentUser = mAuth.getCurrentUser().getEmail();

        final CollectionReference collRefUsers = db.collection("users");

        //It will update ui each time collection users change in db
        collRefUsers.document(currentUser).addSnapshotListener(new EventListener<DocumentSnapshot>() {

            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                friendsList = (ArrayList<String>) documentSnapshot.get("friends");
                friendsListView = findViewById(R.id.friendsListView);
                FriendsListAdapter friendsListAdapter = new FriendsListAdapter(FriendsPageActivity.this, R.layout.friends_list_item, friendsList);
                friendsListView.setAdapter(friendsListAdapter);
            }
        });

        searchView = findViewById(R.id.addFriendSearchView);
        addFriendBtn = findViewById(R.id.addFriendBtn);

        addFriendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchViewText = searchView.getQuery().toString();
                if (searchViewText.isEmpty()) {
                    Toast.makeText(FriendsPageActivity.this, "Please, enter the user you want to add", Toast.LENGTH_SHORT).show();
                } else {
                    //check if searched email account exists, then add
                    collRefUsers.document(searchViewText)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot document = task.getResult();
                                        if (document.exists()) {
                                            //add current user and serached user to each others friend list
                                            addFriend(collRefUsers, currentUser, searchViewText, currentUser);
                                            addFriend(collRefUsers, searchViewText, currentUser, currentUser);
                                        } else {
                                            Toast.makeText(FriendsPageActivity.this, "User " + searchViewText + " doesn't exists", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(FriendsPageActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

    public void addFriend(final CollectionReference collRefUsers, final String userToUpdate, final String friendToAdd, final String currentUser) {

        final DocumentReference docRefUserToUpdate = collRefUsers.document(userToUpdate);

        docRefUserToUpdate.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        ArrayList<String> newFriendsArray = (ArrayList<String>) document.getData().get("friends");
                        if (newFriendsArray.contains(friendToAdd) && userToUpdate.equals(currentUser)) {
                                Toast.makeText(FriendsPageActivity.this, "Already friends with " + friendToAdd, Toast.LENGTH_SHORT).show();
                        } else if(friendToAdd.equals(userToUpdate)){
                            Toast.makeText(FriendsPageActivity.this, friendToAdd + " is you :D", Toast.LENGTH_SHORT).show();
                        }else {
                            newFriendsArray.add(friendToAdd);
                            docRefUserToUpdate.update("friends", newFriendsArray);
                        }
                    }
                }
            }
        });
    }
}
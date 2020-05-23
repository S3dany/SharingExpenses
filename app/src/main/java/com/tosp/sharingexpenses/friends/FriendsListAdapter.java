package com.tosp.sharingexpenses.friends;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tosp.sharingexpenses.R;

import java.util.ArrayList;
import java.util.List;

public class FriendsListAdapter extends ArrayAdapter<String> {

    //the list of emails of current user's friends
    List<String> friends;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public FriendsListAdapter(Context context, int resource, List<String> friends) {
        super(context, resource, friends);
        this.context = context;
        this.resource = resource;
        this.friends = friends;
    }

    //this will return the ListView Item as a View
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        @SuppressLint("ViewHolder") View view = layoutInflater.inflate(resource, null, false);

        TextView email = view.findViewById(R.id.emailTextView);
        final Button removeFriendBtn = view.findViewById(R.id.removeFriendBtn);

        final String friend = friends.get(position);

        removeFriendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectionReference collRefUsers = FirebaseFirestore.getInstance().collection("users");
                String currentUser = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                String friendToRemove = friends.get(position);
                removeFriend(collRefUsers, currentUser, friendToRemove);
                removeFriend(collRefUsers, friendToRemove, currentUser);
            }
        });

        email.setText(friend);

        return view;
    }

    public void removeFriend(final CollectionReference collRefUsers, final String userToUpdate, final String friendToRemove) {
        final DocumentReference docRefUserToUpdate = collRefUsers.document(userToUpdate);
        docRefUserToUpdate.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        ArrayList<String> newFriendsArray = (ArrayList<String>) document.getData().get("friends");
                        newFriendsArray.remove(friendToRemove);
                        docRefUserToUpdate.update("friends", newFriendsArray);
                    }
                }
            }
        });
    }
}

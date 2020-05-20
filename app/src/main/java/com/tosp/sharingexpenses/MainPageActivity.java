package com.tosp.sharingexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        setTitle("Main Page");

        Button mBillsBtn = findViewById(R.id.billsButton);
        Button mCreateBillBtn = findViewById(R.id.createBillBtn);
        Button mFriendsBtn = findViewById(R.id.friendsBtn);
        Button mLogout = findViewById(R.id.logout);

        mBillsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BillsActivity.class));
                return;
            }
        });

        mCreateBillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateBillActivity.class));
                return;
            }
        });

        mFriendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FriendsPageActivity.class));
                return;
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //firebase takes care of logging out with the next line
                FirebaseAuth.getInstance().signOut();
                //to make current page unavailable for the logged out user
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //we're going to add flags that will tell the activity to clear any running activity on top of it.
                //ie. user will no longer have access to anything are relevant for the logged in users
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

    @Override
    public void onBackPressed() {
        //don't go back from this activity, because previous activity is login or register
    }
}

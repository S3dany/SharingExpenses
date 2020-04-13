package com.tosp.sharingexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.tosp.sharingexpenses.bills.BillsActivity;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button mOthersOwe = findViewById(R.id.othersOwe);
        Button mIOwe = findViewById(R.id.iOwe);
        Button mAddBill = findViewById(R.id.addBill);
        Button mContacts = findViewById(R.id.contacts);
        Button mLogout = findViewById(R.id.logout);

        //click listener for mOtherOwe button
        mOthersOwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BillsActivity.class));
                return;
            }
        });

        //click listener for mIOwe button
        mIOwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BillsActivity.class));
                return;
            }
        });

        //click listener for mAddBill button
        mAddBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), /*PLACE HOLDER FOR THE RELEVANT ACTIVITY*/));
                return;
            }
        });

        //click listener for mContacts button
        mContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), /*PLACE HOLDER FOR THE RELEVANT ACTIVITY*/));
                startActivity(new Intent(getApplicationContext(), FriendsPageActivity.class));
                return;
            }
        });

        //click listener for mLogout button
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
}
package com.example.sharingexpenses.ui.main_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sharingexpenses.R;
import com.example.sharingexpenses.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button mLogout = findViewById(R.id.logout);
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

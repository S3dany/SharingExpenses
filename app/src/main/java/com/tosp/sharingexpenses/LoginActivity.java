package com.tosp.sharingexpenses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText =  findViewById(R.id.emailEditText);
        passwordEditText  =  findViewById(R.id.passwordEditText);
        mAuth = FirebaseAuth.getInstance();


    }

    public void signInClicked(View view){
        //Sign in the user
        mAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString()).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), MainPageActivity.class);
                    startActivity(intent);

                } else {
                    Log.w("ERROR-----------ERROR", task.getException());
                    Toast.makeText(LoginActivity.this, "Sign in failed. Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void signUpTextViewClicked(View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}

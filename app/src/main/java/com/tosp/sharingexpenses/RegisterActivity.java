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

public class RegisterActivity extends AppCompatActivity {

    EditText usernameEditText, emailEditText, passwordEditText, confirmPWEditText;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEditText =  findViewById(R.id.emailEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText  =  findViewById(R.id.passwordEditText);
        confirmPWEditText =  findViewById(R.id.confirmPWeditText);
        mAuth = FirebaseAuth.getInstance();

        //User signed in
        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(this, MainPageActivity.class);
            startActivity(intent);
        }
    }

    public void signUpClicked(View view){
          //Sign up the user
          mAuth.createUserWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString()).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful()) {
                      Toast.makeText(RegisterActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();

                      Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                      startActivity(intent);

                  } else {
                      Log.w("ERROR-----------ERROR", task.getException());
                      Toast.makeText(RegisterActivity.this, "Sign up failed. Try Again", Toast.LENGTH_SHORT).show();
                  }
              }
          });
    }

    public void signInTextViewClicked(View view){
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}

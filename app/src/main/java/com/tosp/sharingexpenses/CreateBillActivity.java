package com.tosp.sharingexpenses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tosp.sharingexpenses.bills.Bill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateBillActivity extends AppCompatActivity {

    ArrayList<String> currentUsersfriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill);

        setTitle("Create a bill");

        final EditText amountEditText = findViewById(R.id.amounEditText);
        final EditText payerEditText = findViewById(R.id.payerEditText);
        final EditText reasonEditText = findViewById(R.id.reasonEditText);
        Button createBillBtn = findViewById(R.id.createBillBtn);

        createBillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountEditText.getText().toString();
                String payer = payerEditText.getText().toString();
                String reason = reasonEditText.getText().toString();

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                final String currentUser = mAuth.getCurrentUser().getEmail();
                final CollectionReference collRefUsers = db.collection("users");
                final CollectionReference collRefBills = db.collection("bills");

                //get current user's list of friends
                collRefUsers.document(currentUser).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                setArrayListOfFriends((ArrayList<String>) document.getData().get("friends"));
                            }
                        }
                    }
                });

                if (amount.isEmpty() || payer.isEmpty() || reason.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (!amount.trim().matches("0|[1-9]\\d*")) {
                    //amount is not non negative natural number
                    Toast.makeText(getApplicationContext(), "Amount should be non negative natural number", Toast.LENGTH_SHORT).show();
                } else if (currentUsersfriends != null && !currentUsersfriends.contains(payer)) {
                    Toast.makeText(getApplicationContext(), payer + " isn't your friend", Toast.LENGTH_SHORT).show();
                } else if (currentUsersfriends != null) {
                    //All input values are valid, create a bill
                    Map<String, Object> bill = new HashMap<>();
                    bill.put("amount", amount);
                    bill.put("payerId", payer);
                    bill.put("receiverId", currentUser);
                    bill.put("status", "waitingForPayment");
                    bill.put("reason", reason);

                    DocumentReference newBillRef = collRefBills.document();
                    newBillRef.set(bill);
                    Toast.makeText(getApplicationContext(), "Bill successfully created ", Toast.LENGTH_SHORT).show();

                    //clean up for creation of a new bill
                    amountEditText.setText("");
                    payerEditText.setText("");
                    reasonEditText.setText("");
                }
            }
        });
    }

    public void setArrayListOfFriends(ArrayList<String> friends) {
        currentUsersfriends = friends;
    }
}
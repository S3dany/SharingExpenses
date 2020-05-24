package com.tosp.sharingexpenses;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.tosp.sharingexpenses.bills.Bill;
import com.tosp.sharingexpenses.bills.BillsListPastAdapter;
import com.tosp.sharingexpenses.bills.BillsListToPayAdapter;
import com.tosp.sharingexpenses.bills.BillsListToReceiveAdapter;

import java.util.ArrayList;
import java.util.List;


public class BillsActivity extends AppCompatActivity {
    List<Bill> toPayList;
    List<Bill> toReceiveList;
    List<Bill> pastList;
    ListView toPaylistView;
    ListView toReceiveListView;
    ListView pastListView;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        setTitle("Bills");
        // firebase check
        final String currentUser = mAuth.getCurrentUser().getEmail();
        toPayList = new ArrayList<Bill>();
        toReceiveList = new ArrayList<Bill>();
        pastList = new ArrayList<Bill>();
        db.collection("bills").addSnapshotListener(MetadataChanges.INCLUDE, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                Log.d("FirebaseTest2", "Hi");
                toPayList = new ArrayList<Bill>();
                toReceiveList = new ArrayList<Bill>();
                pastList = new ArrayList<Bill>();
                for (QueryDocumentSnapshot document: queryDocumentSnapshots){
                    if (document.getData().get("payerId").equals(currentUser)){
                                if (document.getData().get("status").equals("done") || document.getData().get("status").equals("paymentRefused") || document.getData().get("status").equals("notReceived")){
                                    pastList.add(new Bill(document.getId(), document.getData().get("payerId").toString(), document.getData().get("receiverId").toString(), document.getData().get("status").toString(), document.getData().get("reason").toString(), Integer.parseInt(document.getData().get("amount").toString())));
                                }
                                else {
                                    toPayList.add(new Bill(document.getId(), document.getData().get("payerId").toString(), document.getData().get("receiverId").toString(), document.getData().get("status").toString(), document.getData().get("reason").toString(), Integer.parseInt(document.getData().get("amount").toString())));
                                }
                            }
                            else if (document.getData().get("receiverId").equals(currentUser)){
                                if (document.getData().get("status").equals("done") || document.getData().get("status").equals("paymentRefused") || document.getData().get("status").equals("notReceived")){
                                    pastList.add(new Bill(document.getId(), document.getData().get("payerId").toString(), document.getData().get("receiverId").toString(), document.getData().get("status").toString(), document.getData().get("reason").toString(), Integer.parseInt(document.getData().get("amount").toString())));
                                }
                                else {
                                    toReceiveList.add(new Bill(document.getId(), document.getData().get("payerId").toString(), document.getData().get("receiverId").toString(), document.getData().get("status").toString(), document.getData().get("reason").toString(), Integer.parseInt(document.getData().get("amount").toString())));
                                }
                            }
                }
                toPaylistView = (ListView) findViewById(R.id.listToPay);
                        toReceiveListView = (ListView) findViewById(R.id.listToReceive);
                        pastListView = (ListView) findViewById(R.id.listPastBills);

                        BillsListToPayAdapter toPayAdapter = new BillsListToPayAdapter(getApplicationContext(), R.layout.bills_list_topay, toPayList);
                        BillsListToReceiveAdapter toReceiveAdapter = new BillsListToReceiveAdapter(getApplicationContext(), R.layout.bills_list_toreceive, toReceiveList);
                        BillsListPastAdapter pastAdapter = new BillsListPastAdapter(getApplicationContext(), R.layout.bills_list_past, pastList);
                        toPaylistView.setAdapter(toPayAdapter);
                        toReceiveListView.setAdapter(toReceiveAdapter);
                        pastListView.setAdapter(pastAdapter);
            }
        });
    }

    public void hideToPay(View view) {
        toPaylistView = (ListView) findViewById(R.id.listToPay);
        if (toPaylistView.getVisibility() == View.GONE){
            toPaylistView.setVisibility(View.VISIBLE);
        }
        else{
            toPaylistView.setVisibility(View.GONE);
        }
    }

    public void hideToReceive(View view) {
        toReceiveListView = (ListView) findViewById(R.id.listToReceive);
        if (toReceiveListView.getVisibility() == View.GONE){
            toReceiveListView.setVisibility(View.VISIBLE);
        }
        else{
            toReceiveListView.setVisibility(View.GONE);
        }
    }

    public void hidePastBills(View view) {
        pastListView = (ListView) findViewById(R.id.listPastBills);
        if (pastListView.getVisibility() == View.GONE){
            pastListView.setVisibility(View.VISIBLE);
        }
        else{
            pastListView.setVisibility(View.GONE);
        }
    }
}

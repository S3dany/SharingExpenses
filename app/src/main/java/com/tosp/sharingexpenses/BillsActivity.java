package com.example.sharingexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======
>>>>>>> 94c5549833dbdb3fb7bd1c92a7ecf65f26b05bed
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BillsActivity extends AppCompatActivity {

    List<BillsListToPayData> toPayList;
    List<BillsListToPayData> toReceiveList;
<<<<<<< HEAD
    List<BillsListPastData> pastList;
    ListView toPaylistView;
    ListView toReceiveListView;
    ListView pastListView;
=======
    ListView toPaylistView;
    ListView toReceiveListView;
>>>>>>> 94c5549833dbdb3fb7bd1c92a7ecf65f26b05bed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        toPayList = new ArrayList<>();
        toReceiveList = new ArrayList<>();
<<<<<<< HEAD
        pastList = new ArrayList<>();

        toPaylistView = (ListView) findViewById(R.id.listToPay);
        toReceiveListView = (ListView) findViewById(R.id.listToReceive);
        pastListView = (ListView) findViewById(R.id.listPastBills);
=======

        toPaylistView = (ListView) findViewById(R.id.listToPay);
        toReceiveListView = (ListView) findViewById(R.id.listToReceive);
>>>>>>> 94c5549833dbdb3fb7bd1c92a7ecf65f26b05bed

        toPayList.add(new BillsListToPayData("Saadany", 200));
        toPayList.add(new BillsListToPayData("Arash", 300));
        toPayList.add(new BillsListToPayData("Nurbike", 200));

        toReceiveList.add(new BillsListToPayData("Saadany", 200));
        toReceiveList.add(new BillsListToPayData("Arash", 300));
        toReceiveList.add(new BillsListToPayData("Nurbike", 200));

<<<<<<< HEAD
        pastList.add(new BillsListPastData("Saadany", "Incoming", "Accepted", 200));
        pastList.add(new BillsListPastData("Arash", "Outcoming", "Refused", 200));
        pastList.add(new BillsListPastData("Nurbike", "Incoming", "Refused", 200));

        BillsListToPay toPayAdapter = new BillsListToPay(this, R.layout.bills_list_topay, toPayList);
        BillsListToReceive toReceiveAdapter = new BillsListToReceive(this, R.layout.bills_list_topay, toReceiveList);
        BillsListPast pastAdapter = new BillsListPast(this, R.layout.bills_list_past, pastList);
        toPaylistView.setAdapter(toPayAdapter);
        toReceiveListView.setAdapter(toReceiveAdapter);
        pastListView.setAdapter(pastAdapter);
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
=======
        BillsListToPay toPayAdapter = new BillsListToPay(this, R.layout.bills_list_topay, toPayList);
        BillsListToReceive toReceiveAdapter = new BillsListToReceive(this, R.layout.bills_list_topay, toReceiveList);
        toPaylistView.setAdapter(toPayAdapter);
        toReceiveListView.setAdapter(toReceiveAdapter);
>>>>>>> 94c5549833dbdb3fb7bd1c92a7ecf65f26b05bed
    }
}

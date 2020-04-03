package com.example.sharingexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BillsActivity extends AppCompatActivity {

    List<BillsListToPayData> toPayList;
    List<BillsListToPayData> toReceiveList;
    ListView toPaylistView;
    ListView toReceiveListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        toPayList = new ArrayList<>();
        toReceiveList = new ArrayList<>();

        toPaylistView = (ListView) findViewById(R.id.listToPay);
        toReceiveListView = (ListView) findViewById(R.id.listToReceive);

        toPayList.add(new BillsListToPayData("Saadany", 200));
        toPayList.add(new BillsListToPayData("Arash", 300));
        toPayList.add(new BillsListToPayData("Nurbike", 200));

        toReceiveList.add(new BillsListToPayData("Saadany", 200));
        toReceiveList.add(new BillsListToPayData("Arash", 300));
        toReceiveList.add(new BillsListToPayData("Nurbike", 200));

        BillsListToPay toPayAdapter = new BillsListToPay(this, R.layout.bills_list_topay, toPayList);
        BillsListToReceive toReceiveAdapter = new BillsListToReceive(this, R.layout.bills_list_topay, toReceiveList);
        toPaylistView.setAdapter(toPayAdapter);
        toReceiveListView.setAdapter(toReceiveAdapter);
    }
}

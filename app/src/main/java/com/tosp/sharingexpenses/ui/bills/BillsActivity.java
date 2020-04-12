package com.tosp.sharingexpenses.ui.bills;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tosp.sharingexpenses.R;

import java.util.ArrayList;
import java.util.List;


public class BillsActivity extends AppCompatActivity {

    List<BillsListToPayData> toPayList;
    List<BillsListToPayData> toReceiveList;
    List<BillsListPastData> pastList;
    ListView toPaylistView;
    ListView toReceiveListView;
    ListView pastListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        toPayList = new ArrayList<>();
        toReceiveList = new ArrayList<>();
        pastList = new ArrayList<>();

        toPaylistView = (ListView) findViewById(R.id.listToPay);
        toReceiveListView = (ListView) findViewById(R.id.listToReceive);
        pastListView = (ListView) findViewById(R.id.listPastBills);

        toPayList.add(new BillsListToPayData("Saadany", 200));
        toPayList.add(new BillsListToPayData("Arash", 300));
        toPayList.add(new BillsListToPayData("Nurbike", 200));

        toReceiveList.add(new BillsListToPayData("Saadany", 200));
        toReceiveList.add(new BillsListToPayData("Arash", 300));
        toReceiveList.add(new BillsListToPayData("Nurbike", 200));

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
    }
}

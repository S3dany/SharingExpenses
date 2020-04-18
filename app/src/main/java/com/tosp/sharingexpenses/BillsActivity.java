package com.tosp.sharingexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tosp.sharingexpenses.bills.Bill;
import com.tosp.sharingexpenses.bills.BillsListPastAdapter;
import com.tosp.sharingexpenses.bills.PastBill;
import com.tosp.sharingexpenses.bills.PastBillList;
import com.tosp.sharingexpenses.bills.BillsListToPayAdapter;
import com.tosp.sharingexpenses.bills.BillList;
import com.tosp.sharingexpenses.bills.BillsListToReceiveAdapter;

import java.util.ArrayList;
import java.util.List;


public class BillsActivity extends AppCompatActivity {
    BillList toPayList;
    BillList toReceiveList;
    PastBillList pastList;
    ListView toPaylistView;
    ListView toReceiveListView;
    ListView pastListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        toPayList = new BillList();
        toReceiveList = new BillList();
        pastList = new PastBillList();

        toPaylistView = (ListView) findViewById(R.id.listToPay);
        toReceiveListView = (ListView) findViewById(R.id.listToReceive);
        pastListView = (ListView) findViewById(R.id.listPastBills);

        toPayList.addBill(new Bill("Saadany", 200));
        toPayList.addBill(new Bill("Arash", 300));
        toPayList.addBill(new Bill("Nurbike", 200));

        toReceiveList.addBill(new Bill("Saadany", 200));
        toReceiveList.addBill(new Bill("Arash", 300));
        toReceiveList.addBill(new Bill("Nurbike", 200));

        pastList.addBill(new PastBill("Saadany", "Incoming", "Accepted", 200));
        pastList.addBill(new PastBill("Arash", "Outcoming", "Refused", 200));
        pastList.addBill(new PastBill("Nurbike", "Incoming", "Refused", 200));

        BillsListToPayAdapter toPayAdapter = new BillsListToPayAdapter(this, R.layout.bills_list_topay, toPayList.getBills());
        BillsListToReceiveAdapter toReceiveAdapter = new BillsListToReceiveAdapter(this, R.layout.bills_list_topay, toReceiveList.getBills());
        BillsListPastAdapter pastAdapter = new BillsListPastAdapter(this, R.layout.bills_list_past, pastList.getBills());
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

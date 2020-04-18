package com.tosp.sharingexpenses.bills;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.tosp.sharingexpenses.R;

import java.util.List;


//we need to extend the ArrayAdapter class as we are building an adapter
public class BillsListPastAdapter extends ArrayAdapter<PastBill> {

    //the list values in the List of type hero
    List<PastBill> billsList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public BillsListPastAdapter(Context context, int resource, List<PastBill> billsList) {
        super(context, resource, billsList);
        this.context = context;
        this.resource = resource;
        this.billsList = billsList;
    }

    //this will return the ListView Item as a View
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        @SuppressLint("ViewHolder") View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the
        TextView name = view.findViewById(R.id.bills_list_past_name);
        TextView amount = view.findViewById(R.id.bills_list_past_amount);
        TextView type = view.findViewById(R.id.bills_list_past_type);
        TextView status = view.findViewById(R.id.bills_list_past_status);

        //getting the hero of the specified position
        PastBill billsData = billsList.get(position);

        name.setText(billsData.getName());
        amount.setText(Integer.toString(billsData.getAmount()));
        type.setText(billsData.getType());
        status.setText(billsData.getStatus());
        return view;
    }
}
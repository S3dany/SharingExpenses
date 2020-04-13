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
public class BillsListPast extends ArrayAdapter<BillsListPastData> {

    //the list values in the List of type hero
    List<BillsListPastData> billsList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public BillsListPast(Context context, int resource, List<BillsListPastData> billsList) {
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
        BillsListPastData billsData = billsList.get(position);

        name.setText(billsData.getName());
        amount.setText(Integer.toString(billsData.getAmount()));
        type.setText(billsData.getType());
        status.setText(billsData.getStatus());
        /*
        //adding a click listener to the button to remove item from the list
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
                removeHero(position);
            }
        });
        */
        //finally returning the view
        return view;
    }
    /*
    //this method will remove the item from the list
    private void removeHero(final int position) {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");

        //if the response is positive in the alert
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //removing the item
                heroList.remove(position);

                //reloading the list
                notifyDataSetChanged();
            }
        });

        //if response is negative nothing is being done
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //creating and displaying the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    */
}
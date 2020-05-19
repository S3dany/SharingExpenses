package com.tosp.sharingexpenses.bills;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tosp.sharingexpenses.R;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;


//we need to extend the ArrayAdapter class as we are building an adapter
public class BillsListToPayAdapter extends ArrayAdapter<Bill> {

    //the list values in the List of type hero
    List<Bill> toPayList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public BillsListToPayAdapter(Context context, int resource, List<Bill> toPayList) {
        super(context, resource, toPayList);
        this.context = context;
        this.resource = resource;
        this.toPayList = toPayList;
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
        Bill billsData = toPayList.get(position);
        //getting the view elements of the list from the
        TextView name = view.findViewById(R.id.bills_list_topay_name);
        TextView amount = view.findViewById(R.id.bills_list_topay_amount);
        TextView reason = view.findViewById(R.id.bills_list_topay_reason);
        TextView status = view.findViewById(R.id.bills_list_topay_status);
        Button buttonAccept = view.findViewById(R.id.bills_list_topay_accept);
        Button buttonRefuse = view.findViewById(R.id.bills_list_topay_refuse);
        if (billsData.getStatus().equals("waitingForPayment")){
            buttonAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DocumentReference billToUpdate = FirebaseFirestore.getInstance().collection("bills").document(toPayList.get(position).getId());

                    // Set the "isCapital" field of the city 'DC'
                    billToUpdate
                            .update("status", "waitingForReceiver")
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "DocumentSnapshot successfully updated!");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error updating document", e);
                                }
                            });

                }
            });

            buttonRefuse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DocumentReference billToUpdate = FirebaseFirestore.getInstance().collection("bills").document(toPayList.get(position).getId());

                    // Set the "isCapital" field of the city 'DC'
                    billToUpdate
                            .update("status", "paymentRefused")
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "DocumentSnapshot successfully updated!");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error updating document", e);
                                }
                            });
                }
            });
            status.setText("Status: waiting for payment");
        }
        else {
            status.setText("Status: waiting for receiver");
            buttonAccept.setEnabled(false);
            buttonRefuse.setEnabled(false);
        }



        name.setText("To " + billsData.getReceiverId());
        amount.setText(billsData.getAmount() + " HUF");
        reason.setText("Reason: " + billsData.getReason());

        return view;
    }
}
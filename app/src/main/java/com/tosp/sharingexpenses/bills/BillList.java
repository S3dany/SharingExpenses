package com.tosp.sharingexpenses.bills;

import java.util.ArrayList;
import java.util.List;

public class BillList {
    private List<Bill> bills;

    public BillList(){
        bills = new ArrayList<>();
    }

    public List<Bill> getBills () {return bills;}
    public void setBills (List<Bill> bills) {this.bills = bills;}

    public void addBill (Bill bill) {this.bills.add(bill);}
}

package com.tosp.sharingexpenses.bills;

import java.util.ArrayList;
import java.util.List;

public class PastBillList {
    private List<PastBill> bills;

    public PastBillList(){
        bills = new ArrayList<>();
    }

    public List<PastBill> getBills () {return bills;}
    public void setBills (List<PastBill> bills) {this.bills = bills;}

    public void addBill (PastBill bill) {this.bills.add(bill);}
}

package com.tosp.sharingexpenses.ui.bills;

public class BillsListToPayData {
    private String name;
    private int amount;

    BillsListToPayData(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    String getName() {return name;}
    void setName(String name) {this.name = name;}

    int getAmount() {return amount;}
    void setAmount(int amount) {this.amount = amount;}
}

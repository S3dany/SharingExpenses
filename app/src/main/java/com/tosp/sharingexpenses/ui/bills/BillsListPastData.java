package com.tosp.sharingexpenses.ui.bills;

public class BillsListPastData {
    private String name, type, status;
    private int amount;

    BillsListPastData(String name, String type, String status, int amount){
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.status = status;
    }

    String getName() {return name;}
    void setName(String name) {this.name = name;}

    int getAmount() {return amount;}
    void setAmount(int amount) {this.amount = amount;}

    String getType() {return type;}
    void setType(String type) {this.type = type;}

    String getStatus() {return status;}
    void setStatus(String status) {this.status = status;}
}

package com.tosp.sharingexpenses.bills;

public class PastBill extends Bill {
    private String type, status;

    public PastBill(String name, String type, String status, int amount){
        super(name, amount);
        this.type = type;
        this.status = status;
    }

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
}

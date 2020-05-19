package com.tosp.sharingexpenses.bills;

public class Bill {
    private String id, payerId, receiverId, status, reason;
    private int amount;

    public Bill(String id, String payerId, String receiverId, String status, String reason, int amount){
        this.id = id;
        this.payerId = payerId;
        this.receiverId = receiverId;
        this.status = status;
        this.amount = amount;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

package com.tosp.sharingexpenses;

import java.sql.Timestamp;
import java.util.Date;

public class FriendRequest {
    private String request_id;
    private User from;
    private User to;
    private Date timestamp = new Timestamp(System.currentTimeMillis());
    private String status = "Pending";

    public FriendRequest( User from, User to) {
        this.from = from;
        this.to = to;
        this.status = status;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

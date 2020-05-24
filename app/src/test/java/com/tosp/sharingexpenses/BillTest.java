package com.tosp.sharingexpenses;

import com.tosp.sharingexpenses.bills.Bill;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BillTest {
    private Bill bill;

    @Before //This is executed before the @Test executes
    public void setUp(){
        bill = new Bill("1", "maks", "arash", "waitingForPayment", "No reason", 100);
    }

}
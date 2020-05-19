package com.tosp.sharingexpenses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PastBillListTest {
    private PastBillList bills;

    @Before //This is executed before the @Test executes
    public void setUp(){
        bills = new PastBillList();
        assertEquals(bills.getBills().size(), 0);
    }

    @Test
    public void addingNewBillUpdatesTheListCorrectly() {
        PastBill bill = new PastBill ("Maksim", "Incoming", "Accepted",100);
        bills.addBill(bill);
        assertEquals(bills.getBills().size(), 1);
        assertTrue(bills.getBills().contains(bill));
    }

}
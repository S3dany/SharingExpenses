package com.tosp.sharingexpenses;

import com.tosp.sharingexpenses.bills.Bill;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BillListTest {
    private BillList bills;

    @Before //This is executed before the @Test executes
    public void setUp(){
        bills = new BillList();
        assertEquals(bills.getBills().size(), 0);
    }

    @Test
    public void addingNewBillUpdatesTheListCorrectly() {
        Bill bill = new Bill ("Maksim",100);
        bills.addBill(bill);
        assertEquals(bills.getBills().size(), 1);
        assertTrue(bills.getBills().contains(bill));
    }

}
package com.tosp.sharingexpenses.ui.bills;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import androidx.test.rule.ActivityTestRule;

import com.tosp.sharingexpenses.R;

public class BillsActivityTest {

    //to test an activity we use @Rule
    //ActivityTestRule enables lunching of the activity
    //Note: ActivityTestRule was not imported automatically by the IDE. Steps needed:
    //  added       androidTestImplementation 'com.android.support.test:rules:1.0.2'    to app/build.gradle
    //  added       import androidx.test.rule.ActivityTestRule;     to this file
    //  synced the project with the gradle files by clicking the sync button
    @Rule
    public ActivityTestRule<BillsActivity> billsActivityTestRule = new ActivityTestRule<BillsActivity>(BillsActivity.class);

    //a reference to MainPageActivity
    private BillsActivity billsPageActivity = null;

    //this is used to set the necessary preconditions prior to execution of @Test
    @Before
    public void setUp() throws Exception {
        billsPageActivity = billsActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View billsInfo = billsPageActivity.findViewById(R.id.bills_info);
        View textToPay = billsPageActivity.findViewById(R.id.textToPay);
        View listToPay = billsPageActivity.findViewById(R.id.listToPay);
        View textToReceive = billsPageActivity.findViewById(R.id.textToReceive);
        View listToReceive = billsPageActivity.findViewById(R.id.listToReceive);
        View textPastBills = billsPageActivity.findViewById(R.id.textPastBills);
        View listPastBills = billsPageActivity.findViewById(R.id.listPastBills);
        assertNotNull(billsInfo);
        assertNotNull(textToPay);
        assertNotNull(listToPay);
        assertNotNull(textToReceive);
        assertNotNull(listToReceive);
        assertNotNull(textPastBills);
        assertNotNull(listPastBills);
    }

    //this is used to cleanup after the execution of @Test
    @After
    public void tearDown() throws Exception {
    }
}
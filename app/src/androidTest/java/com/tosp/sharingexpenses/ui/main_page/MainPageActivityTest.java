package com.tosp.sharingexpenses.ui.main_page;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import androidx.test.rule.ActivityTestRule;

import com.tosp.sharingexpenses.R;

public class MainPageActivityTest {

    //to test an activity we use @Rule
    //ActivityTestRule enables lunching of the activity
    //Note: ActivityTestRule was not imported automatically by the IDE. Steps needed:
    //  added       androidTestImplementation 'com.android.support.test:rules:1.0.2'    to app/build.gradle
    //  added       import androidx.test.rule.ActivityTestRule;     to this file
    //  synced the project with the gradle files by clicking the sync button
    @Rule
    public ActivityTestRule<MainPageActivity> mActivityTestRule = new ActivityTestRule<MainPageActivity>(MainPageActivity.class);

    //a reference to MainPageActivity
    private MainPageActivity mMainPageActivity = null;

    //this is used to set the necessary preconditions prior to execution of @Test
    @Before
    public void setUp() throws Exception {
        mMainPageActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View vOthersOwe = mMainPageActivity.findViewById(R.id.othersOwe);
        View vIOwe = mMainPageActivity.findViewById(R.id.iOwe);
        View vAddBill = mMainPageActivity.findViewById(R.id.addBill);
        View vContacts = mMainPageActivity.findViewById(R.id.contacts);
        View vLogot = mMainPageActivity.findViewById(R.id.logout);
        assertNotNull(vOthersOwe);
        assertNotNull(vIOwe);
        assertNotNull(vAddBill);
        assertNotNull(vContacts);
        assertNotNull(vLogot);
    }

    //this is used to cleanup after the execution of @Test
    @After
    public void tearDown() throws Exception {
    }
}
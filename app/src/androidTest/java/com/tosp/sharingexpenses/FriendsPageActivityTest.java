package com.tosp.sharingexpenses;

import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class FriendsPageActivityTest {
    @Rule
    public ActivityTestRule<FriendsPageActivity> mActivityTestRule = new ActivityTestRule<FriendsPageActivity>(FriendsPageActivity.class);
    private  FriendsPageActivity mActivity = null;
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}
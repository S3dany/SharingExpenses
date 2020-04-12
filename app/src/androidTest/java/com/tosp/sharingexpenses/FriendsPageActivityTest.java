package com.tosp.sharingexpenses;

import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.cardview.widget.CardView;
import androidx.test.rule.ActivityTestRule;

import com.tosp.sharingexpenses.ui.FriendsPageActivity;

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
        SearchView searchView = mActivity.findViewById(R.id.searchView3);
        View toolbar = mActivity.findViewById(R.id.toolbar);
        CardView cardView = mActivity.findViewById(R.id.cardView);
        TextView textView =mActivity.findViewById(R.id.textView);
        TextView textView2 =mActivity.findViewById(R.id.textView2);
        Button button =mActivity.findViewById(R.id.button);

        assertNotNull(searchView);
        assertNotNull(toolbar);
        assertNotNull(cardView);
        assertNotNull(textView);
        assertNotNull(textView2);
        assertNotNull(button);

    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}
package com.tosp.sharingexpenses;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> RegisterActivityTestRule = new ActivityTestRule<RegisterActivity>(RegisterActivity.class);
    private RegisterActivity mRegisterActivity = null;


    @Before
    public void setUp() throws Exception {
        mRegisterActivity = RegisterActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View emailEditText = mRegisterActivity.findViewById(R.id.emailEditText);
        View passwordEditText = mRegisterActivity.findViewById(R.id.passwordEditText);
        View pwConfirmEditText = mRegisterActivity.findViewById(R.id.confirmPWeditText);
        View signUpBtn = mRegisterActivity.findViewById(R.id.signUpBtn);
        View signInTextView = mRegisterActivity.findViewById(R.id.signInTextView);
        assertNotNull(emailEditText);
        assertNotNull(passwordEditText);
        assertNotNull(pwConfirmEditText);
        assertNotNull(signUpBtn);
        assertNotNull(signInTextView);
    }

    @After
    public void tearDown() throws Exception {
    }
}

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
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private LoginActivity mLoginActivity = null;


    @Before
    public void setUp() throws Exception {
        mLoginActivity = loginActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View emailEditText = mLoginActivity.findViewById(R.id.emailEditTextinLogIn);
        View passwordEditText = mLoginActivity.findViewById(R.id.pwEditTextinLogin);
        View signInBtn = mLoginActivity.findViewById(R.id.signInBtn);
        View signUpTextView = mLoginActivity.findViewById(R.id.signUpTextView);
        assertNotNull(emailEditText);
        assertNotNull(passwordEditText);
        assertNotNull(signInBtn);
        assertNotNull(signUpTextView);
    }

    @After
    public void tearDown() throws Exception {
    }
}

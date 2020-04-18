package com.tosp.sharingexpenses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        BillsActivityTest.class,
        FriendsPageActivityTest.class,
        LoginActivityTest.class,
        MainPageActivityTest.class,
        RegisterActivityTest.class
        })
public class InstrumentedTestSuite {}
package com.tosp.sharingexpenses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({PastBillListTest.class,
        BillListTest.class,
        UserTest.class})
public class UnitTestSuite {}
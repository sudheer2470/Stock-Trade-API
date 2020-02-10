package com.mysampleproject.stocktrade;

import com.mysampleproject.stocktrade.requests.*;
import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TradesControllerTest.class,
    ResourcesControllerTest.class,
    NoResourcesTradesControllerTest.class
})
public class TestSuite {

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(TestSuite.class);
    }
}

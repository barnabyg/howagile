 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionIT {

    /**
     * Delay in ms.
     */
    private static final int DELAY = 2000;
    /**
     * Web driver.
     */
    private WebDriver driver;

    /**
     * Setup.
     */
    @Before
    public void setUp() {

        driver = new FirefoxDriver();

        driver.get("http://localhost:7070/home.go");
    }

    /**
     * Question integration test.
     */
    @Test
    public void questionTest() {

        assertEquals(
                "Home page title invalid", "Welcome", driver.getTitle());

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            // no action required
        }
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}

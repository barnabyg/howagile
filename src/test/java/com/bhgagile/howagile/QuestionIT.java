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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionIT {

    /**
     * Delay in ms.
     */
    private static final int DELAY = 1500;
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
            "Questions page title invalid",
              "How Agile Are You?", driver.getTitle());

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            // no action required
        }

        clickSubmit(driver, "submitNextId");

        clickSubmit(driver, "submitNextId");

        clickSubmit(driver, "submitNextId");

        clickSubmit(driver, "submitNextId");

        clickSubmit(driver, "submitResultsId");
    }

    /**
     * Click on the submit button with the given ID.
     * @param driver web driver
     * @param submitId button id
     */
    private void clickSubmit(final WebDriver driver, final String submitId) {

        final WebElement element =
                driver.findElement(By.id(submitId));

        element.sendKeys(Keys.RETURN);

        final ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(final WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript(
                               "return document.readyState").equals("complete");
                    }
                };

        final WebDriverWait wait = new WebDriverWait(driver, DELAY);

        wait.until(pageLoadCondition);

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

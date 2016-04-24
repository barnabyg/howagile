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
     * Next submit button name.
     */
    private static final String SUBMIT_NEXT = "submitNextId";
    /**
     * Delay in ms.
     */
    private static final int DELAY = 600;
    /**
     * Short delay in ms.
     */
    private static final int SHORT_DELAY = 200;
    /**
     * Web driver.
     */
    private transient WebDriver driver;

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
            "Home page title is invalid",
              "How Agile Are You?", driver.getTitle());

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            // no action required
        }

        clickSubmit(driver, SUBMIT_NEXT);

        selectRadioButton(driver, "questionMap1.selectedAnswer1");
        selectRadioButton(driver, "questionMap2.selectedAnswer1");
        selectRadioButton(driver, "questionMap3.selectedAnswer1");

        clickSubmit(driver, SUBMIT_NEXT);

        selectRadioButton(driver, "questionMap4.selectedAnswer1");
        selectRadioButton(driver, "questionMap5.selectedAnswer1");
        selectRadioButton(driver, "questionMap6.selectedAnswer1");

        clickSubmit(driver, SUBMIT_NEXT);

        selectRadioButton(driver, "questionMap7.selectedAnswer1");
        selectRadioButton(driver, "questionMap8.selectedAnswer1");
        selectRadioButton(driver, "questionMap9.selectedAnswer1");

        clickSubmit(driver, SUBMIT_NEXT);

        selectRadioButton(driver, "questionMap10.selectedAnswer1");
        selectRadioButton(driver, "questionMap11.selectedAnswer1");
        selectRadioButton(driver, "questionMap12.selectedAnswer1");

        clickSubmit(driver, SUBMIT_NEXT);

        selectRadioButton(driver, "questionMap13.selectedAnswer1");
        selectRadioButton(driver, "questionMap14.selectedAnswer1");
        selectRadioButton(driver, "questionMap15.selectedAnswer1");

        clickSubmit(driver, SUBMIT_NEXT);

        selectRadioButton(driver, "questionMap16.selectedAnswer1");
        selectRadioButton(driver, "questionMap17.selectedAnswer1");
        selectRadioButton(driver, "questionMap18.selectedAnswer1");

        clickSubmit(driver, "submitResultsId");
    }

    /**
     * Click on a radio button with the given ID.
     * @param driver web driver
     * @param buttonId radio button id
     */
    private void selectRadioButton(
            final WebDriver driver, final String buttonId) {

        final WebElement element =
                driver.findElement(By.id(buttonId));

        element.click();

        try {
            Thread.sleep(SHORT_DELAY);
        } catch (InterruptedException e) {
            // no action required
        }
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

                    /**
                     * {@inheritDoc}
                     */
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

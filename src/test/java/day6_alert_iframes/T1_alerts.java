package day6_alert_iframes;

import com.loop.day1_selenium_intro.base.TestBase;


import org.openqa.selenium.*;
import org.testng.annotations.*;

import static org.testng.Assert.*;

/**
 * Information alert practice
 * 1. Open browser
 * 2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
 * 3. Click to “Click for JS Alert” button
 * 4. Click the OK button from the alert
 * 5. Validate “You successfully clicked an alert” text is displayed
 * <p>
 * Confirmation alert practice
 * 1. Click to “Click for JS Confirm” button
 * 2. Click the OK button from the alert
 * 3. Verify “You clicked: Ok” text is displayed.
 * 4. Click to “Click for JS Confirm” button
 * 5. Click to Cancel button from alert
 * 6. Validate “You clicked: Cancel” text is displayed.
 * <p>
 * Prompt alert practice
 * 1. Click to “Click for JS Prompt” button
 * 2. Send "Loop Academy"
 * 3. Click Ok
 * 4. Validate "You entered: Loop Academy" text is displayed
 */
public class T1_alerts extends TestBase {


    @Test
    public void informationAlert() {

        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = successMessageForInformationAlert.getText();
        assertEquals(actual, expected, "actual does not match the expected");






        }
        public void promptAlert1() {
            driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
            WebElement clickJSPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
            clickJSPrompt.click();

            String text = "Loop Academy";
            //driver.switchTo().alert().sendKeys(text);
            //driver.switchTo().alert().accept();
            Alert alert1 = driver.switchTo().alert();
            alert1.sendKeys(text);
            alert1.accept();

            WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
            String actual1 = successMessagePromptAlert.getText();
            String expected1 = "You entered: " + text;
            assertEquals(actual1, expected1, "actual does not match the expected");

        }}



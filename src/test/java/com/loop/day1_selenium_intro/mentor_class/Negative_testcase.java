package com.loop.day1_selenium_intro.mentor_class;

import Utility.DocuportConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Negative_testcase {

    /**given @user opens the application login page @url
     * When @user inputs invalid application login page
     * @user sees error message when missing password

     */

    @Test

     public static void login(WebDriver driver, String role) throws InterruptedException{
        driver.get("https://beta.docuport.app/");

        WebElement username = driver.findElement(By.xpath("//label['Username or email']//following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        username.sendKeys(DocuportConstants.USERNAME_CLIENT);
        loginButton.click();

        WebElement errorMessage= driver.findElement(By.xpath("//div[contains(text(), 'enter password')]"));

        String actual1=errorMessage.getText();
        String expected ="enter password";
        Assert.assertEquals(actual1, expected,"TEST FAILED");






    }
}

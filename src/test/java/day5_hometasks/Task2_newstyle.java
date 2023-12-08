package day5_hometasks;

import Utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2_newstyle {


//task2
//=============
//1. go to https://www.etsy.com/
//2. search for rings
//3. validate that Estimated Arrival shows any time
//3. click Estimated Arrival dropdown
//4. click Select custom date
//5. choose december 30 from dropdown
//6. validate Estimated Arrival shows december 30



    WebDriver driver;

    String actual ="Estimated Arrival Any time";
    String  expected;
    String actual2= "By Dec 30";



        @Test
         public void etsy(){
         ///3. validate that Estimated Arrival shows any time
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.get("https://www.etsy.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            WebElement search = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
            search.sendKeys("rings" + Keys.ENTER);



            //3. click Estimated Arrival dropdown
            // create dropdown
              WebElement dataVer = driver.findElement(By.xpath("//div[@class='wt-panel-with-trigger']"));
              expected= dataVer.getText();
              Assert.assertEquals(actual, expected, "Actual does not match expected");

//            Select dropdown = new Select(driver.findElement(By.xpath("")));
//            actual = dropdown.getFirstSelectedOption().getText();
//            Assert.assertEquals(actual, expected, "Actual does not match expected");

            //4. click Select custom date

            WebElement dataCustom = driver.findElement(By.xpath("//div[@class='wt-panel-with-trigger']"));

            dataCustom.click();

            //5. choose december 30 from dropdown

             WebElement dataVer1 = driver.findElement(By.xpath("//select[@id='edd_select_tf']"));
             dataVer1.click();
             Select dataDate= new Select(dataVer1);
             dataDate.selectByVisibleText("By Dec 30");
             //expected=dataDate.getOptions();

             Assert.assertEquals(actual, expected, "Actual does not match expected");

             driver.quit();


        }

    }


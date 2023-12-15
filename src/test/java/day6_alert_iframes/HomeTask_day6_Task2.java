package day6_alert_iframes;

import com.loop.day1_selenium_intro.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTask_day6_Task2 extends TestBase {

    @Test

    // Validate Child Iframe
    public void iframe() {

        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        //WebElement childFr=driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        //driver.switchTo().frame(childFr);
        WebElement childIframeText = driver.findElement(By.xpath("//p[text()='Child Iframe']"));

        String act = childIframeText.getText();
        String exp = "Child Iframe";
        Assert.assertEquals(act, exp, "TEST FAILED => Actual Does not match the expected");

        //Validate "Parent Iframe"
        driver.switchTo().parentFrame();
        WebElement parentFrameText = driver.findElement(By.xpath("//body[text()='Parent frame']"));
        String act1 = parentFrameText.getText();
        String exp1 = "Parent frame";
        Assert.assertEquals(act1, exp1, "TEST FAILED => Actual Does not match the expected");

        //Validate the "Sample Nested Iframe"
        driver.switchTo().defaultContent();
        WebElement SampleNestedFramePage = driver.findElement(By.xpath("//div[contains(text(), 'Sample Nested Iframe page')]"));

        String act2 = SampleNestedFramePage.getText();
        String exp2 = "Sample Nested Iframe page";
        Assert.assertEquals(act2, exp2, "TEST FAILED => Actual Does not match the expected");
        driver.close();
    }
}

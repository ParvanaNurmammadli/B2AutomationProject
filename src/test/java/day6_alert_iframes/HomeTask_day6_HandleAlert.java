package day6_alert_iframes;

import com.loop.day1_selenium_intro.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.naming.InterruptedNamingException;

/**
 * Task 1
 * =============
 * 1. Go to https://demoqa.com/alerts
 * 2. Click - click button to see alert.
 * 3. Handle alert.
 * 4. Click - On button click, alert will appear after 5 seconds.
 * 5. Handle alert.
 * 6. Click - On button click, confirm box will appear.
 * 7. Click ok and validate - You selected Ok.
 * 8. After that, do it again this time cancel and validate - You selected Cancel.
 * 9. Click - On button clicks, prompt box will appear.
 * 10. Enter "Loop Academy" and validate your entered Loop Academy.
 */
public class HomeTask_day6_HandleAlert extends TestBase {

    @Test
    public void alert1(){

        driver.get("https://demoqa.com/alerts");


        WebElement clickForJSAlert  = driver.findElement(By.xpath("//*[@id='alertButton']"));
        clickForJSAlert.click();
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
  @Test
    public void alert2() throws InterruptedException {
      driver.get("https://demoqa.com/alerts");

      WebElement clickForJSAlert  = driver.findElement(By.xpath("//*[@id='timerAlertButton']"));
      clickForJSAlert.click();

      Alert alert= driver.switchTo().alert();
      Thread.sleep(5000);
     // alert.accept();


  }



}

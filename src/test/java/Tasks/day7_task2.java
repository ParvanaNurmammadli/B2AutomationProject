package Tasks;

import com.loop.day1_selenium_intro.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class day7_task2 extends TestBase {

/**

 Task 2
 =============
 Go to https://loopcamp.vercel.app/
 Click "Multiple Windows" link.
 Validate "Powered by Loopcamp" is displayed.
 Validate title is "Windows"
 Click - click here.
 Switch to a new window and validate the title.
 */

@Test
        public void windows(){

    driver.get("https://loopcamp.vercel.app/");
    driver.findElement(By.xpath("//div/ul/li/a[text()='Multiple Windows']")).click();
    System.out.println(driver.findElement(By.xpath("//div[@class='large-4 large-centered columns']")).isDisplayed());

    System.out.println(driver.getTitle());
    driver.findElement(By.xpath("//div/a[text()='Click Here']")).click();


    Set<String> windowHandles = driver.getWindowHandles();

    for (String window : windowHandles) {
        driver.switchTo().window(window);

    }
    Assert.assertEquals(driver.getTitle(), "New Window", "Test Fail");





}

}

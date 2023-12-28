package day8_webtables;

import Utility.DocuportConstants;
import Utility.DocuportUtils;
import Utility.DocuportsWebTableUtils;
import com.loop.day1_selenium_intro.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_WebTables extends TestBase {
 /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */
  @Test
public void test_webTables() throws InterruptedException {


    DocuportUtils.login(driver, DocuportConstants.ADVISOR);
    Thread.sleep(5000);
    WebElement users= driver.findElement(By.xpath("//span[contains(text(), 'Users')]"));
    users.click();

      String expectedUserName = "alexdesouze";
      String actualUserName = DocuportsWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "username");
      assertEquals(actualUserName,expectedUserName,"Actual does not match expected");
}
}

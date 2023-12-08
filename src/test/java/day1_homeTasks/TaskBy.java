package day1_homeTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskBy {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.loopcamp.io/");
       driver.manage().window().maximize();
        WebElement findIte = driver.findElement(By.xpath(""));

    }

}

package Utility;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.InputMismatchException;

/**
 * Logins to the docuport application.
 * @param Driver, which initialized in test base.
 * @param role,   comes from docuport constants.
 * @author Parvana
 **/

public class DocuportUtils {
    public static void login(WebDriver driver, String role) throws InterruptedException {

       // driver.get("https://beta.docuport.app/");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()){
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD_ADVISOR);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            default:
                throw new InputMismatchException(("There us not such a role: " + role));
        }
        loginButton.click();

        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);
            WebElement cont = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }
    }

    /**
     * logs out from the application
     * @param driver
     * @author Parvana
     */

    public static void logOut(WebDriver driver) {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userIcon = Driver.getDriver().findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}

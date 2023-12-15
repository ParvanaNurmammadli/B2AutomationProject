package day7_window;

import Utility.DocuportConstants;
import Utility.DocuportUtils;
import com.loop.day1_selenium_intro.base.TestBase;
import org.testng.annotations.Test;

public class T00_login_docuport extends TestBase {



        @Test
        public void test_login_logout_docuport() throws InterruptedException {
            DocuportUtils.login(driver, DocuportConstants.CLIENT);
            DocuportUtils.logOut(driver);
        }
    }








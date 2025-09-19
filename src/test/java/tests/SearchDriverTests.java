package tests;

import org.testng.annotations.Test;
import pages.LogInPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class SearchDriverTests extends TestBase {

    @Test
    public void searchDriverTests(){
        // 1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        // 2. Login to app
        LogInPage logInPage=new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();
    }

}

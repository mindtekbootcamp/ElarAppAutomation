package tests;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DriversPage;
import pages.LogInPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class SearchDriverTests extends TestBase {

    @Test
    public void ValidatesearchDriverTests(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
    LogInPage logInPage = new LogInPage();
    logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversPage();
//        driversPage.driversTab.click();
//        driversPage.searchBar.click();
        driversPage.idButton.click();
        driversPage.searchBar.sendKeys("1201");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.idButton.isDisplayed());
        Assert.assertEquals(driversPage.validateIdOutcome.getText(), "1201");


    }
    @Test
    public void ValidateDriverIsSearchableByName(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversPage();
        driversPage.nameButton.click();
        driversPage.searchBar.sendKeys("Russell Hamilton");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.title.isDisplayed());
        Assert.assertEquals(driversPage.title.getText(), "Russell Hamilton");
    }

    @Test
    public void ValidateDriverIsSearchableByEmail(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversPage();
        driversPage.emailPhoneButton.click();
        driversPage.searchBar.sendKeys("driver@driver.com");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.emailPhoneButton.isDisplayed());
       // Assert.assertEquals(driversPage.emailPhoneButton.getAttribute("class"), "driver@driver.com");
        //div[contains(text(),'driver@driver.com')]

        Assert.assertEquals(driversPage.validateEmailOutcome.getText(), "driver@driver.com");
    }


    @Test
    public void validateDriverIsSearchableByPhone() {
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        driversPage.searchBar.click();
        driversPage.emailPhoneButton.click();

        driversPage.searchBar.sendKeys("+1 (800) 555-6576");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.emailPhoneButton.isDisplayed());
        Assert.assertEquals(driversPage.validatePhoneOutcome, "+1 (800) 555-6576");

    }

    @Test
    public void validateNegativeScenarioUserCannotBeFoundByID(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        driversPage.searchBar.click();
        driversPage.idButton.click();

        driversPage.searchBar.sendKeys("abc");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.validateIdError.isDisplayed());
        Assert.assertEquals(driversPage.validateIdError.getText(), "User with this ID does not exist");

    }

    @Test
    public void VadidateNegativeScenarioUserCannotBeFoundByName(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        driversPage.searchBar.click();
        driversPage.nameButton.click();

        driversPage.searchBar.sendKeys("@!#$%^");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.validateNameError.isDisplayed());
        Assert.assertEquals(driversPage.validateNameError.getText(), "User with this Name does not exist");

    }

    @Test
    public void ValidateUserCannotBeFoundByEmail(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        driversPage.searchBar.click();
        driversPage.emailPhoneButton.click();

        driversPage.searchBar.sendKeys("MarkDacasces@!@#$%.com");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.validateEmailError.isDisplayed());
        Assert.assertEquals(driversPage.validateEmailError.getText(), "No rows");
    }

    @Test
    public void ValidateUserCannotBeFoundByPhone(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.login();

        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        driversPage.searchBar.click();
        driversPage.emailPhoneButton.click();

        driversPage.searchButton.sendKeys("abc");
        driversPage.searchButton.click();

        Assert.assertTrue(driversPage.validatePhoneError.isDisplayed());
        Assert.assertEquals(driversPage.validatePhoneError.getText(),"No rows");
    }
}


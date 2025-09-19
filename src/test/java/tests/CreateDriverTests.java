package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewDriverPage;
import pages.DriversPage;
import pages.LogInPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class CreateDriverTests extends TestBase {

    @Test
    public void createDriverBackToListAndCreateNewButtonsTests(){
        // 1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        // 2. Login to app
        LogInPage logInPage=new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();
        // 3. Click on Drivers tab
        DriversPage driversPage=new DriversPage();
        driversPage.driversTab.click();
        // 4. Click on Add Driver button
        driversPage.addDriverButton.click();
        // 5. Validate BACK TO LIST and CREATE NEW buttons are in the page
        CreateNewDriverPage createNewDriverPage=new CreateNewDriverPage();
        Assert.assertTrue(createNewDriverPage.backToListButton.isDisplayed());
        Assert.assertTrue(createNewDriverPage.createNewButton.isDisplayed());
    }

    @Test
    public void createDriverStaffUncheckedByDefaultTest(){

    }

}

package tests;

import org.apache.commons.logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewDriverPage;
import pages.DriversPage;
import pages.LogInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.awt.*;

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
        /*
        1. Navigate to https://sandbox.elarbridges.com/auth/login
        2. Login to app
        3. Click on Drivers tab
        4. Click on Add Driver button
        5. Validate Staff checkbox is unchecked by default
         */

        // 1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        // 2. Log in to app
        LogInPage logInPage = new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();
        // 3. Click on Drivers tab
        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        // 4. Click on Add Driver button
        driversPage.addDriverButton.click();
        // 5. Validate Staff checkbox is unchecked by default
        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        if(createNewDriverPage.staffCheckBox.isSelected()){
            System.out.println("Check box is checked");
        }else{
            System.out.println("Check box is unchecked");
        }
        Assert.assertTrue(!createNewDriverPage.staffCheckBox.isSelected());

    }

    @Test
    public void createDriverValidateStaffIsCheckedTest() throws InterruptedException {
    //        1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
    //        2. Login to app
        LogInPage logInPage = new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();
    //        3. Click on Drivers tab
        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
    //        4. Click on Add Driver button
        driversPage.addDriverButton.click();
    //        5. Check the Staff
        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        createNewDriverPage.staffCheckBox.isSelected();
        createNewDriverPage.staffCheckBox.click();
    //        6. Provide Driver Full_name, DL_Exp, Med_exp data
        createNewDriverPage.fullName.sendKeys("John Doe");
        JavascriptExecutor js= ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,600)");
        createNewDriverPage.driverLicenseExp.click();
        createNewDriverPage.selectDateDL.click();
        createNewDriverPage.medicalLicenseExp.click();
        Thread.sleep(500);
        createNewDriverPage.selectDateMedical.click();
    //        7. Click on Create New button
        js.executeScript("window.scrollBy(0,400)");
        createNewDriverPage.createNewButton.click();
    //        8. Click on Go to edit button on popup
        createNewDriverPage.goToEditButtonOnPopup.click();
    //        9. Validate that staff is checked on edit page
        if(createNewDriverPage.staffCheckBox.isSelected()){
            System.out.println("Check box is checked");
        }else{
            System.out.println("Check box is unchecked");
        }
        Assert.assertTrue(createNewDriverPage.staffCheckBox.isSelected());

    }


    @Test
    public void createDriverValidateStaffIsUncheckedTest() throws InterruptedException {
        // 1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        // 2. Login to app
        LogInPage logInPage = new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();
        // 3. Click on Drivers tab
        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        // 4. Click on Add Driver button
        driversPage.addDriverButton.click();
        // 5. Check the Staff
        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        createNewDriverPage.staffCheckBox.isSelected();
        createNewDriverPage.staffCheckBox.click();
        createNewDriverPage.staffCheckBox.click();
        // 6. Provide Driver Full_name, DL_Exp, Med_exp data
        createNewDriverPage.fullName.sendKeys("John Doe");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,600)");
        createNewDriverPage.driverLicenseExp.click();
        createNewDriverPage.selectDateDL.click();
        createNewDriverPage.medicalLicenseExp.click();
        Thread.sleep(500);
        createNewDriverPage.selectDateMedical.click();
        // 7. Click on Create New button
        js.executeScript("window.scrollBy(0,400)");
        createNewDriverPage.createNewButton.click();
        // 8. Click on Go to edit button on popup
        createNewDriverPage.goToEditButtonOnPopup.click();
        // 9. Validate that staff is checked on edit page
        if(createNewDriverPage.staffCheckBox.isSelected()){
            System.out.println("Check box is selected");
        }else{
            System.out.println("Check box is not selected");
        }
        Assert.assertTrue(!createNewDriverPage.staffCheckBox.isSelected());
    }

    @Test
    public void createDriverValidateFullNameMaximumValue50CharactersTests() throws InterruptedException {
        //1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        //2. Login to app
        LogInPage logInPage = new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();
        //3. Click on "Drivers" tab
        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        //4. Click on "Add Driver" button
        driversPage.addDriverButton.click();
        //5. Enter full_name up to 50 characters
        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        createNewDriverPage.fullName.sendKeys("Stephen Lomart");
        createNewDriverPage.fullName.click();

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, 500)");
        createNewDriverPage.driverLicenseExp.click();
        createNewDriverPage.selectDateDL.click();
        createNewDriverPage.driverLicenseExp.click();
        Thread.sleep(500);
        createNewDriverPage.selectDateMedical.click();
        // 7. Click on Create New button
        js.executeScript("window.scrollBy(0,400)");
        createNewDriverPage.createNewButton.click();

        createNewDriverPage.goToEditButtonOnPopup.click();

        Assert.assertTrue(createNewDriverPage.fullName.isDisplayed());
        Assert.assertEquals(createNewDriverPage.fullName.getAttribute("value"),"Stephen Lomart");
    }

    @Test
    public void createValidateFullNameMaximumValue50CharactersNegativeScenario() throws InterruptedException {
        // 1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        // 2. Login to app
        LogInPage logInPage = new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();
        // 3. Click on "Drivers" tab
        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        // 4. Click on "Add Driver" button
        driversPage.addDriverButton.click();
        // 5. Enter full name with more than 50 characters
        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        createNewDriverPage.fullName.sendKeys("qwertuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm");

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, 500)");
        createNewDriverPage.driverLicenseExp.click();
        createNewDriverPage.selectDateDL.click();
        createNewDriverPage.medicalLicenseExp.click();
        Thread.sleep(500);
        createNewDriverPage.selectDateMedical.click();
        // 7. Click on Create New button
        js.executeScript("window.scrollBy(0,400)");
        createNewDriverPage.createNewButton.click();
        js.executeScript("window.scrollBy(0, -1000)");

        // 6. Validate error_message for full_name
        CreateNewDriverPage createNewDriverPage1 = new CreateNewDriverPage();
        Assert.assertTrue(createNewDriverPage.errorMessage.isDisplayed());
        Assert.assertEquals(createNewDriverPage.errorMessage.getText(),"String must contain at most 50 character(s)");
    }

    @Test
    public void createValidateFullNameMaximumValue1Character() throws InterruptedException {
        driver.get(ConfigReader.getProperty("ElarAppURL"));

        LogInPage logInPage = new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();

        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        driversPage.addDriverButton.click();

        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        createNewDriverPage.fullName.sendKeys("a");

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, 500)");
        createNewDriverPage.driverLicenseExp.click();
        createNewDriverPage.selectDateDL.click();
        createNewDriverPage.medicalLicenseExp.click();
        Thread.sleep(500);
        createNewDriverPage.selectDateMedical.click();
        // 7. Click on Create New button
        js.executeScript("window.scrollBy(0,400)");
        createNewDriverPage.createNewButton.click();
        createNewDriverPage.goToEditButtonOnPopup.click();

        Assert.assertTrue(createNewDriverPage.fullName.isDisplayed());
        Assert.assertEquals(createNewDriverPage.fullName.getAttribute("value"),"a");
    }

    @Test
    public void createNegativeScenarioValidateFullNameWithSpecialCharacters() throws InterruptedException {
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        LogInPage logInPage = new LogInPage();
        logInPage.username.sendKeys(ConfigReader.getProperty("ElarUsername"));
        logInPage.password.sendKeys(ConfigReader.getProperty("ElarPassword"));
        logInPage.loginButton.click();

        DriversPage driversPage = new DriversPage();
        driversPage.driversTab.click();
        driversPage.addDriverButton.click();

        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        createNewDriverPage.fullName.sendKeys("!@#$%^&*()");

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, 500)");
        createNewDriverPage.driverLicenseExp.click();
        createNewDriverPage.selectDateDL.click();
        createNewDriverPage.medicalLicenseExp.click();
        Thread.sleep(500);
        createNewDriverPage.selectDateMedical.click();
        // 7. Click on Create New button
        js.executeScript("window.scrollBy(0,400)");
        createNewDriverPage.createNewButton.click();
        js.executeScript("window.scrollBy(0, -1000)");

        Assert.assertTrue(createNewDriverPage.errorMessage.isDisplayed());
        Assert.assertEquals(createNewDriverPage.errorMessage.getText(),"Input must contain only alphanumeric and specific punctuation characters");
    }
}

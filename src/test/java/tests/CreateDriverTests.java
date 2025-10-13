package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewDriverPage;
import pages.DriversPage;
import pages.LogInPage;
import utilities.CSVReader;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;
import java.util.Map;

public class CreateDriverTests extends TestBase {

    List<Map<String, String>> validTestData= CSVReader.readCsvToListOfMaps("createdrivervaliddata");
    List<Map<String, String>> invalidTestData= CSVReader.readCsvToListOfMaps("createdriverinvaliddata");


    public void goToCreateDriverPage(){
        // 1. Navigate to https://sandbox.elarbridges.com/auth/login
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        // 2. Login to app
        LogInPage logInPage=new LogInPage();
        logInPage.login();
        // 3. Click on Drivers tab
        DriversPage driversPage=new DriversPage();
        driversPage.driversTab.click();
        // 4. Click on Add Driver button
        driversPage.addDriverButton.click();
    }

    @Test(groups = {"smoke", "regression"})
    public void createDriverBackToListAndCreateNewButtonsTests(){
        goToCreateDriverPage();
        // 5. Validate BACK TO LIST and CREATE NEW buttons are in the page
        CreateNewDriverPage createNewDriverPage=new CreateNewDriverPage();
        Assert.assertTrue(createNewDriverPage.backToListButton.isDisplayed());
        Assert.assertTrue(createNewDriverPage.createNewButton.isDisplayed());
    }

    @Test(groups = {"regression"})
    public void createDriverStaffUncheckedByDefaultTest(){
        goToCreateDriverPage();
        // 5. Validate Staff checkbox is unchecked by default
        CreateNewDriverPage createNewDriverPage = new CreateNewDriverPage();
        if(createNewDriverPage.staffCheckBox.isSelected()){
            System.out.println("Check box is checked");
        }else{
            System.out.println("Check box is unchecked");
        }
        Assert.assertTrue(!createNewDriverPage.staffCheckBox.isSelected());

    }

    @Test(groups = {"smoke", "regression"})
    public void createDriverValidateStaffIsCheckedTest() throws InterruptedException {
        goToCreateDriverPage();
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


    @Test(groups = { "regression"})
    public void createDriverValidateStaffIsUncheckedTest() throws InterruptedException {
        goToCreateDriverPage();
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

    @Test(groups = {"smoke", "regression"})
    public void createDriverValidateFullNameMaximumValue50CharactersTests() throws InterruptedException {
        goToCreateDriverPage();
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

    @Test(groups = {"regression"})
    public void createValidateFullNameMaximumValue50CharactersNegativeScenario() throws InterruptedException {
        goToCreateDriverPage();
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

    @Test(groups = {"regression"})
    public void createValidateFullNameMaximumValue1Character() throws InterruptedException {
        goToCreateDriverPage();
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

    @Test(groups = {"regression"})
    public void createNegativeScenarioValidateFullNameWithSpecialCharacters() throws InterruptedException {
        goToCreateDriverPage();

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

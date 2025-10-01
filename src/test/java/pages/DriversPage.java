package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DriversPage {

    WebDriver driver;

    public DriversPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='/drivers/list']")
    public WebElement driversTab;

    @FindBy(xpath = "//button[text()='Add driver']")
    public WebElement addDriverButton;

    @FindBy(xpath = "//input[@value='']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[text()='ID']")
    public WebElement idButton;

    @FindBy(xpath = "//button[@aria-label=\"search\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@data-field='full_name' and @role='cell']/div")
    public WebElement title;

    @FindBy(xpath = "//button[text()='Name']")
    public WebElement nameButton;

    @FindBy(xpath = "//button[text()='Email/Phone']")
    public WebElement emailPhoneButton;

    @FindBy(xpath = "//div[@data-field='email' and @role='cell']/div")
    public WebElement validateEmailOutcome;

    @FindBy(xpath = "//div[@data-field='phone' and @role='cell']/div")
    public WebElement validatePhoneOutcome;

    @FindBy(xpath = "//div[@data-field='driver_number' and @role='cell']")
    public WebElement validateIdOutcome;


    @FindBy(xpath = "")
    public WebElement validateIdError;

    @FindBy(xpath = "")
    public WebElement validateNameError;

    @FindBy(xpath = "")
    public WebElement validateEmailError;

    @FindBy(xpath = "")
    public WebElement validatePhoneError;

    public void driversPage(){
        driversTab.click();
        searchBar.click();
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateNewDriverPage {

    WebDriver driver;

    public CreateNewDriverPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='Back to list']")
    public WebElement backToListButton;

    @FindBy(xpath = "//button[text()='Create new']")
    public WebElement createNewButton;

    @FindBy(name = "is_staff")
    public WebElement staffCheckBox;

    @FindBy(name = "full_name")
    public WebElement fullName;

    @FindBy(xpath = "(//button[@aria-label='Choose date'])[1]")
    public WebElement driverLicenseExp;

    @FindBy(xpath = "//button[text()='28']")
    public WebElement selectDateDL;

    @FindBy(xpath = "(//button[@aria-label='Choose date'])[1]")
    public WebElement medicalLicenseExp;

    @FindBy(xpath = "//button[text()='28']")
    public WebElement selectDateMedical;

    @FindBy(xpath = "//button[text()='Go to Edit']")
    public WebElement goToEditButtonOnPopup;

    @FindBy(xpath = "//input[@name='full_name']/../following-sibling::p")
    public WebElement errorMessage;



}

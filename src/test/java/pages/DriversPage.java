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

}

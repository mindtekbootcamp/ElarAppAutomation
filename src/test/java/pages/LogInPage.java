package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogInPage {

    WebDriver driver;

    public LogInPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "login-username")
    public WebElement username;

    @FindBy(id = "login-password")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

}

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


}

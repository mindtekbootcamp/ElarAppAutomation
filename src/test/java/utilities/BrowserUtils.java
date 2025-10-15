package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserUtils {

    public static void scrollPageDownUp(int pixels){
        WebDriver driver=Driver.getDriver();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, "+pixels+")");
    }

}

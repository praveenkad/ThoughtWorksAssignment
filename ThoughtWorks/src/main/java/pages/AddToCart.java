package pages;

import okio.Timeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class AddToCart {

    @FindBy(xpath="//*[@id=\"link-to-cart\"]/a")
    WebElement addToCartBtn;

    public void addToCart(){
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
    }
}

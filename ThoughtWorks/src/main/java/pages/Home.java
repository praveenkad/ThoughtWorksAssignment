package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

    @FindBy(id="link-to-login")
    WebElement loginLink;

    @FindBy(xpath="//*[@id=\"search-bar\"]/form/input[2]")
    WebElement searchBtn;

    @FindBy(id="keywords")
    WebElement searchProd;

    public void clickOnSearchBtn(){
        searchBtn.click();
    }

    public void searchProduct(String productName){
        searchProd.sendKeys(productName);
    }

    public void clickOnLogin(){
        loginLink.click();
    }
}

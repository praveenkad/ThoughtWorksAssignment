package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProduct {

    @FindBy(xpath = "//*[@id=\"product_9\"]/div/div[1]/a[2]")
    WebElement productDescription;

    @FindBy(xpath = "//*[@id=\"product_9\"]/div/div[3]/form/div/div/span/button")
    WebElement selectProduct;

    public String getProductDescription(){
        return productDescription.getText();
    }

    public  void productSelect(){
        selectProduct.click();

    }

}

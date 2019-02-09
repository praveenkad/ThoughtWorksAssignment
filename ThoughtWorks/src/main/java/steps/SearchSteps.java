package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import util.DriverManager;

import java.util.List;

public class SearchSteps {
    Home homepage;
    SearchProduct searchProduct;
    AddToCart addToCart;
    Login loginpage;
    public SearchSteps(){
        homepage = PageFactory.initElements(DriverManager.driver, Home.class);
        searchProduct=PageFactory.initElements(DriverManager.driver,SearchProduct.class);
        addToCart = PageFactory.initElements(DriverManager.driver,AddToCart.class);
        loginpage = PageFactory.initElements(DriverManager.driver,Login.class);
    }

    public String searchForProduct(String productName){
        homepage.searchProduct(productName);
        homepage.clickOnSearchBtn();
        String description=searchProduct.getProductDescription();
        return description;

    }

    public void addToCartProduct(){
        searchProduct.productSelect();
        addToCart.addToCart();
    }

    public void waitForPageToLoad() {
         loginpage.waitForPageToLoad();
    }
}

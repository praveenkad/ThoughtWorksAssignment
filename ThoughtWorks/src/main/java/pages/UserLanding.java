package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLanding {

    //@FindBy(linkText = "MY ACCOUNT")
    @FindBy(xpath="//*[@id=\"nav-bar\"]/li[1]/a")
    WebElement myAccountText;

    public String getMyAccountText(){
        return myAccountText.getText();
    }
}

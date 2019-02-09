package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.Home;
import pages.Login;
import pages.UserLanding;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    Home homepage;
    Login loginpage;
    UserLanding userlandingPage;
    public LoginSteps(){
        homepage = PageFactory.initElements(DriverManager.driver,Home.class);
        loginpage= PageFactory.initElements(DriverManager.driver,Login.class);
        userlandingPage = PageFactory.initElements(DriverManager.driver,UserLanding.class);
    }

    public String login(String username, String passkey) {

        homepage.clickOnLogin();
        loginpage.enterUserName(username);
        loginpage.enterPassword(passkey);
        loginpage.clickOnSubmit();
        String actual=userlandingPage.getMyAccountText();

        return actual;


    }

    public void logout(){
        loginpage.logoutAccount();

    }
    public void waitForPageToLoad(){
        loginpage.waitForPageToLoad();
    }


}

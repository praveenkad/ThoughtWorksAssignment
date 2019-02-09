package logintests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.LoginSteps;
import util.DriverManager;

public class Login {

    @Test(groups = {"regression"})
    @Parameters({"userName","password","browser"})
    public void testValidLogin(String userName,String password,String browser){
        new DriverManager(browser);

        LoginSteps login = new LoginSteps();
        String actualAccountText = login.login(userName,password);
        login.waitForPageToLoad();
        String expectedAccountText = DriverManager.getConfigProperty("testValidLogin.ExpectedAccountText");
        Assert.assertEquals(expectedAccountText,actualAccountText);
        System.out.println("I'm testValidLogin");

    }
    @Test(groups = {"checkout"})
    public void testInvalidLogin(){

        System.out.println("I'm testInvalidLogin");
    }

    @Test(groups={"regression"})
    public void testLoginWithDifferentUser(){
        System.out.println("I'm testLoginWithDifferentUser");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.driver.quit();
    }
}

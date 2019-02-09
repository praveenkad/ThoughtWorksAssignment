package logintests;

import org.testng.Assert;
import org.testng.annotations.*;
import steps.LoginSteps;
import util.DriverManager;

public class LoginDataProvider {


    @Test(dataProvider = "multipleusers",groups={"regression"})
    public void loginWithMultipleUsers(String uname, String pwd) {
        new DriverManager();

        LoginSteps login = new LoginSteps();
        String myTest = login.login(uname, pwd);
        login.waitForPageToLoad();
        Assert.assertEquals("My Account", myTest);
        System.out.println("In to testValidLogin");
        login.logout();
    }

    @DataProvider(name = "multipleusers")
    public Object[][] getMultipleUsers() {
        return new Object[][]
                {
                        {"xt2@xt.com", "infy1234"},
                        {"xt3@xt.com", "infy2234"},
                        {"xt4@xt.com", "infy3234"}
                };
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        System.out.println("I'm tear down");
        DriverManager.driver.quit();

    }

}
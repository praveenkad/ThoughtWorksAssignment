package searchtests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.SearchSteps;
import util.DriverManager;

public class SuiteManger {

    @BeforeSuite
    @Parameters({"userName","password","browser"})
    public void initiateBrowser(String browser){
        System.out.println("I'm Before Suite");
        new DriverManager(browser);
    }

    @Test
    public void testValidLogin(){
        //new DriverManager();
        LoginSteps login1 = new LoginSteps();
        String myTest = login1.login("xt2@xt.com","infy1234");
        Assert.assertEquals("My Account",myTest);
    }

    @Test
    public void validateProduct(){
        //new DriverManager();
        SearchSteps searchSteps = new SearchSteps();
        String actual = searchSteps.searchForProduct("Spaghetti");
        System.out.println(actual);
        Assert.assertTrue(actual.contains("Spaghetti") );
    }

    @AfterSuite
    public void closeBrowser(){
        DriverManager.driver.quit();
        System.out.println("I'm AfterSuite");
    }
}

package searchtests;

import org.testng.Assert;
import org.testng.annotations.*;
import steps.SearchSteps;
import util.DriverManager;

public class Search {



 @Parameters({"userName","password","browser"})
 @Test(groups = {"regression"})
    public void validateProduct(String userName, String password,String browser){
        new DriverManager(browser);
        SearchSteps searchSteps = new SearchSteps();
        String productDescription = searchSteps.searchForProduct(DriverManager.getConfigProperty("validateProduct.SearchKey"));
        Assert.assertTrue(productDescription.contains(DriverManager.getConfigProperty("validateProduct.ExpectedProduct")) );
        searchSteps.addToCartProduct();
        searchSteps.waitForPageToLoad();
        System.out.println("I'm validateProduct");
    }

    @Test(groups = {"regression"})
    public void validateNewProd(){
        System.out.println("I'm to validateNewProd");
    }
    @Test(groups = {"checkout"})
    public void validateOldProd(){
        System.out.println("I'm to validateOldProd");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.driver.quit();
    }




}

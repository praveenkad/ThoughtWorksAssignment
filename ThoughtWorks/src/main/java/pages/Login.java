package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.DriverManager;

public class Login {
    @FindBy(id="spree_user_email")
    WebElement userName;

    @FindBy(id="spree_user_password")
    WebElement password;

    @FindBy(name="commit")
    WebElement submitBtn;

    @FindBy(xpath="//*[@id=\"nav-bar\"]/li[2]/a")
    WebElement logoutBtn;

    public void enterUserName(String user){
        this.userName.sendKeys(user);
    }

    public void enterPassword(String passkey){
        this.password.sendKeys(passkey);
    }

    public void clickOnSubmit(){
        submitBtn.click();
    }

    public void logoutAccount(){logoutBtn.click();}

    /**
     * @author Praveen Kadambari
     * Purpose- This function lets the webdriver wait until the page loads
     * completely
     *
     * @throws TimeoutException
     */
    public boolean waitForPageToLoad() {
        System.out.println("- Waiting for page to load");
        try {

            int waitTime = 0;
            boolean isPageLoadComplete = false;
            do {
                isPageLoadComplete = ((String) ((JavascriptExecutor) DriverManager.driver)
                        .executeScript("return document.readyState")).equals("complete");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitTime++;
                if (waitTime > 250) {
                    System.out.println("- Page Load Complete");
                    break;
                }
            } while (!isPageLoadComplete);
            {
            }
            // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(waitString)));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

}

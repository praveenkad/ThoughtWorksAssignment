package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class DriverManager {
    public static Properties properties= new Properties();
    public static WebDriver driver;

    public DriverManager(){
        initiateChrome();
        driver.get("https://spreecommerce-demo.herokuapp.com/");
    }


    public DriverManager(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            initiateChrome();
        }
        else if(browser.equalsIgnoreCase("firefox")){

        }
        else if(browser.equalsIgnoreCase("IE")){

        }

        //driver.get("http://10.136.127.137:3000");
        driver.get("https://spreecommerce-demo.herokuapp.com/");
    }

    public void initiateChrome(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * @author Praveen Kadambari
     * Returns value for required key from Environment.propeties file
     * @param sKey
     * @return Propety key's value
     */
    public static String getConfigProperty(String sKey){
        String sKeyValue=null;
        try {
            FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"TestData"+File.separator+"TestData.properties"));
            properties.load(inputStream);
            sKeyValue = properties.getProperty(sKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sKeyValue;
    }



}

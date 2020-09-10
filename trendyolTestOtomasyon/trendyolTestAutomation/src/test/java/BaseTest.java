import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Scanner;



public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @Parameters("Browser")

    @BeforeClass

    public void browserParameter(String Browser){
        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
        //when you change the browser parameter that located in testNG.xml this method works to open desired browser

        if(Browser.equalsIgnoreCase("ch")){
            driver=new ChromeDriver();
            Reporter.log("Chrome Browser is opened");
            wait=new WebDriverWait(driver,3);
            driver.manage().window().maximize();
            Reporter.log("Chrome Browser is maximized");
        }else if(Browser.equalsIgnoreCase("ff")){
            driver=new FirefoxDriver();
            Reporter.log("Firefox Browser is opened");
            wait=new WebDriverWait(driver,3);
            driver.manage().window().maximize();
            Reporter.log("Firefox Browser is maximized");
        }else if(Browser.equalsIgnoreCase("ie")){
            driver=new InternetExplorerDriver();
            Reporter.log("Internet Explorer Browser is opened");
            wait=new WebDriverWait(driver,3);
            driver.manage().window().maximize();
            Reporter.log("Internet Explorer Browser is maximized");

            }

    }

    @AfterClass
    //Closes the test browser after test cases are completed.
    public void tearDown(){

        driver.quit();

    }

}

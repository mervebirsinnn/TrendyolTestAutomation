package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {

    //Base page contains common methods which are used other classes

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver,WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;

    }

    public void click(By elementLocation){ //click method via element location (xpath, css locator etc.)

        driver.findElement(elementLocation).click();

    }

    public void writeText(By elementLocation, String text){ //this method sending keys to specified element location

        driver.findElement(elementLocation).sendKeys(text);

    }

    public void waitUntilPageContainElements(String elementName){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName))); //waits until specified element is loaded

    }

    public void waitUntilPageContainElementsID(String elementName){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementName))); //waits until specified element is loaded

    }



    public void VerifyFullyLoaded2(WebDriver driver){ //to verify page ready or not

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String ready = (String)js.executeScript("return document.readyState");
        System.out.println("Ready or not : "+ready);
    }

    public void getCurrentUrl(){driver.getCurrentUrl();} //to get current page url

}







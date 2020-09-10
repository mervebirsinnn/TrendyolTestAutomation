package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AddBasket extends BasePage {

    BasePage basePage = new BasePage(driver,wait);

    String cssSelector = "div#product-detail-app div.add-to-bs-tx";

    String cssSelectorBasket = "li#myBasketListItem a";



    public AddBasket(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void AddProductBasket() throws InterruptedException {

       // String actualString = driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/span[2]")).getText();
        basePage.click(By.cssSelector(cssSelector)); //Adding basket
        Thread.sleep(3000);
        basePage.click(By.cssSelector(cssSelectorBasket));//go to basket

       /* String basketPrice = driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[2]/text()")).getText();
        try {
            Assert.assertTrue(actualString.contains(basketPrice));

            } catch (Exception e) {
            Reporter.log("Different price");
        }*/
    }

   /* public void GoToBasket()
    {

    }
    public void  ComparePrice()
    {

    }*/

}
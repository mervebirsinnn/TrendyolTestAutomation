package resources.PO;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DeleteBasket extends BasePage {

    BasePage basePage = new BasePage(driver, wait);

    public DeleteBasket(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void  DeletingBasket() {
        basePage.click(By.cssSelector("div#partial-basket div:nth-child(2) > div.pb-basket-item > div.pb-basket-item-actions > button > i"));
    }
}

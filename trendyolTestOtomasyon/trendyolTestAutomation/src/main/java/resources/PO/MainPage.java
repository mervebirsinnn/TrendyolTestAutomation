package resources.PO;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;
import java.util.Random;

public class MainPage extends BasePage {

    int invalidImageCount = 0; //initialized to count invalid boutique images

    BasePage basePage = new BasePage(driver, wait);
    Random random = new Random();

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static String icon = "//html[@id='ng-app']//i[@id='logo-icon']";

    public void verifyPageLoaded() { basePage.VerifyFullyLoaded2(driver); }

    //public void popupbekle(){ waitUntilPageContainElementsID("Group-38"); }

    public void popupbekle(){ waitUntilPageContainElements("//div[@class='notification-popup-container']"); }

    public void closePopup(){click(By.cssSelector("div.modal-close"));}

    public void iconClick() {
        click(By.xpath(icon));
    } //to click trendyol icon left upper side on the page

    public void searchKeyButton() throws InterruptedException {

        Thread.sleep(3000);
        //iconClick();
        verifyPageLoaded();



            Thread.sleep(3000);
            WebElement ele = driver.findElement(By.cssSelector("div#auto-complete-app input"));
            ele.sendKeys("bilgisayar");
            WebElement searchButton = driver.findElement(By.cssSelector("div#auto-complete-app i"));
            Thread.sleep(3000);
            searchButton.click();




    }
   public void randomProduct() throws InterruptedException { //Clicking random product

        Thread.sleep(3000);
        //mainPage.iconClick();
        Thread.sleep(3000);
        verifyPageLoaded();

        List<WebElement> linkList = driver.findElements(By.cssSelector("#search-app > div > div > div.srch-prdcts-cntnr > div:nth-child(2) > div"));

        int linkCount = linkList.size();// counting starts from 0

        System.out.println("LinkSize : "+linkCount);

        int randomLinkClick =  random.nextInt(linkCount);

        System.out.println("random number : "+randomLinkClick);

        linkList.get(randomLinkClick).click();

        verifyPageLoaded();
      /* WebElement addButton = driver.findElement(By.cssSelector("div#product-detail-app div.add-to-bs-tx"));
       Thread.sleep(3000);
       addButton.click();*/

    }

    public void verifyActiveBoutique(WebElement imageElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imageElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
                        if (response.getStatusLine().getStatusCode() != 200)
                invalidImageCount++;
        } catch (Exception e) {
            Reporter.log("Boutique Image HTTP ERR");// if there is an error, error will occur in the test report
        }
    }

}


package pages.common;

import constants.locators.PricesPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PricesPage {

    private WebDriver driver;

    public PricesPage(WebDriver driver) {
        this.driver = driver;
    }

    int itemsCount;
    private By itemsList = By.xpath(PricesPageConstants.itemsList);


    public List<WebElement> getPriceItemsList(int itemsCount) {
        List<WebElement> priceItems = new ArrayList<>();
        for (int i = 1; i < itemsCount + 1; i++) {
            WebElement item = driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/" + "li[" + i + "]"));
            priceItems.add(item);
        }
        return priceItems;
    }

}




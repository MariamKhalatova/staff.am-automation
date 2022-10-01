package prices;

import base.BaseTests;
import constants.locators.HomePageConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.HomePage;
import pages.common.PricesPage;

import java.util.List;
import java.util.WeakHashMap;

public class PricesTest extends BaseTests {

    @Test(description = "Test prices")
    public void prices() throws InterruptedException {
        PricesPage pricesPage = homepage.navigateToPricesPage();
        List<WebElement> items = pricesPage.getPriceItemsList(7);

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            String attribute = item.getAttribute("class");
            System.out.println(attribute);
            Assert.assertTrue(attribute.contains(i < 2 ? "on" : "off"));
        }


    }
}

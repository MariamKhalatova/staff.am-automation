package search;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.HomePage;
import pages.common.SearchResultPage;
import java.util.List;

public class SearchTests extends BaseTests {

    @Test
    /*Steps
    1 . Open Staff.am
    2 . Verify that Jobs radio button is checked
    2 . Choose Gyumri city in city filter field
    3 . Tap search */

    public void testSearchByCity() throws InterruptedException {
        By radio = homepage.getJobsRadioButton();
        homepage.verifyRadioButtonIsSelected();
        homepage.setCityFilter("Gyumri");
        SearchResultPage searchpage = homepage.clickSearchButton();
        List<WebElement> results = searchpage.createListOfGyumriJobs();
        for (WebElement result : results) {
            Assert.assertTrue(result.getText().contains("Gyumri"));
        }

    }
}

package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends HomePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> createListOfGyumriJobs() {
        List<WebElement> GyumriJobs = new ArrayList<WebElement>();
        GyumriJobs = driver.findElements(By.className("list-view"));
        return GyumriJobs;

    }
}

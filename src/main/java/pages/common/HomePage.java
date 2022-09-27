package pages.common;

import constants.locators.HomePageConstants;
import constants.locators.SearchResultPageConstants;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    // Homepage Fields
    private WebDriver driver;
    private By citiesFilter = By.id(HomePageConstants.citiesFilterID);
    private By searchButton = By.xpath(HomePageConstants.searchButton);
    private By forJobSeekersDrp = By.xpath(HomePageConstants.forJobSeekersDrp);
    private By jobsRadioButton = By.id(HomePageConstants.JobsRadioButton);
    private By hotJobsBlock = By.id(SearchResultPageConstants.hotJobsList);
    private By registerButton = By.xpath(HomePageConstants.registerButton);
    private By forCompaniesDrp = By.xpath(HomePageConstants.forCompaniesDrp);
    private By jobpackagesBtn = By.xpath(HomePageConstants.jobPackagesBtn);


    //Homepage constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Homepage methods
    public By getJobsRadioButton() {
        return jobsRadioButton;
    }


    public void verifyRadioButtonIsSelected() {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(jobsRadioButton));
        WebElement radio = driver.findElement(By.xpath("//label[1]/div[1]/input[1]"));
        if (radio.isSelected()) {
            System.out.println("selected item");
        } else {
            System.out.println("Not selected");
        }
    }

    public void setCityFilter(String cityName) throws InterruptedException {
        Select countries = new Select(driver.findElement(By.id(HomePageConstants.citiesFilterID)));
        countries.selectByVisibleText(cityName);
        WebElement option = countries.getFirstSelectedOption();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElement(option, cityName));
    }

    public SearchResultPage clickSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }

    public RegistrationPage selectRegisterFromDrp() throws InterruptedException {
        // Thread.sleep(2000);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(forJobSeekersDrp));
        driver.findElement(forJobSeekersDrp).click();
        //????/ vonc karelia waiti vra miangamic click kanchel? aranc noric driver find element anelu
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        driver.findElement(registerButton).click();
        return new RegistrationPage(driver);
    }

    public PricesPage navigateToPricesPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(forCompaniesDrp).click();
        Thread.sleep(2000);
        driver.findElement(jobpackagesBtn).click();
        Thread.sleep(3000);
        return new PricesPage(driver);
    }


}

package pages.common;

import constants.locators.GeneralConstants;
import constants.locators.HomePageConstants;
import constants.locators.SearchResultPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    // Homepage Fields
    protected WebDriver driver;
    private By citiesFilter = By.id(HomePageConstants.citiesFilterID);
    private By searchButton = By.xpath(HomePageConstants.searchButton);
    private By forJobSeekersDrp = By.xpath(HomePageConstants.forJobSeekersDrp);
    private By jobsFilterLine = By.id(HomePageConstants.JobsRadioButton);
    private By hotJobsBlock = By.id(SearchResultPageConstants.hotJobsList);
    private By registerButton = By.xpath(HomePageConstants.registerButton);
    private By forCompaniesDrp = By.xpath(HomePageConstants.forCompaniesDrp);
    private By jobpackagesBtn = By.xpath(HomePageConstants.jobPackagesBtn);
    private By jobsRadioBtn = By.xpath(HomePageConstants.getJobsRadioButton2);

    //Base methods
    public void waitForElementVisible(By locator, int durationSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(durationSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    //Homepage constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Homepage methods
    public By getJobsRadioButton() {
        return jobsFilterLine;
    }

    public boolean verifyRadioButtonIsSelected() {
        WebElement radio = driver.findElement(jobsRadioBtn);
        waitForElementVisible(jobsFilterLine, GeneralConstants.shortWait);
        if (radio.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public void setCityFilter(String cityName) {
        Select countries = new Select(driver.findElement(By.id(HomePageConstants.citiesFilterID)));
        countries.selectByVisibleText(cityName);
        WebElement option = countries.getFirstSelectedOption();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElement(option, cityName));
    }

    public SearchResultPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }

    public RegistrationPage selectRegisterFromDrp() {
        waitForElementVisible(forJobSeekersDrp, GeneralConstants.longWait);
        driver.findElement(forJobSeekersDrp).click();
        waitForElementVisible(registerButton, GeneralConstants.longWait);
        driver.findElement(registerButton).click();
        return new RegistrationPage(driver);
    }

    public PricesPage navigateToPricesPage() {
        driver.findElement(forCompaniesDrp).click();
        driver.findElement(jobpackagesBtn).click();
        return new PricesPage(driver);
    }
}

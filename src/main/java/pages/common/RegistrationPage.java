package pages.common;

import constants.locators.GeneralConstants;
import constants.locators.RegistrationPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends HomePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameInput = By.id(RegistrationPageConstants.firstNameInput);
    private By lastNameInput = By.id(RegistrationPageConstants.lastNameInput);
    private By emailInput = By.id(RegistrationPageConstants.emailInput);
    public By dayDrp = By.id(RegistrationPageConstants.dayDrp);
    public By monthDrp = By.id(RegistrationPageConstants.monthDrp);
    public By yearDrp = By.id(RegistrationPageConstants.yearDrp);
    public By passwordInput = By.id(RegistrationPageConstants.passwordInput);
    public By repeatPasswordInput = By.id(RegistrationPageConstants.confirmPasswordInput);

    public void inputFirstName() throws InterruptedException {
        waitForElementVisible(firstNameInput, GeneralConstants.mediumWait);
        driver.findElement(firstNameInput).sendKeys("Mariam");
    }

    public void inputLastname() {
        driver.findElement(lastNameInput).sendKeys("Khalatova");
    }

    public void inputEmail() {
        driver.findElement(emailInput).sendKeys("mar.khalatova@gmail.com");
    }

    public void inputPassword() {
        driver.findElement(passwordInput).sendKeys("Mynewpassword123");
    }

    public void RepeatPassword() {
        driver.findElement(repeatPasswordInput).sendKeys("Mynewpassword123");
    }

    public void selectDrpValue(By element, String visibleValue) {
        Select selectObj = new Select(driver.findElement(element));
        selectObj.selectByVisibleText(visibleValue);
    }

}

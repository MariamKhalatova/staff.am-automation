package registration;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.common.HomePage;
import pages.common.RegistrationPage;

public class TestRegistration extends BaseTests {

    @Test(description = "fill in the registration form with valid values for Job-seekers without completing last step")
    public void TestRegistration() throws InterruptedException {
        RegistrationPage registrationPage = homepage.selectRegisterFromDrp();
        registrationPage.inputFirstName();
        registrationPage.inputLastname();
        //ask if better to have with 1 method == registrationPage.input();
        registrationPage.selectDrpValue(registrationPage.dayDrp, "24");
        registrationPage.selectDrpValue(registrationPage.monthDrp, "October");
        registrationPage.selectDrpValue(registrationPage.yearDrp, "1996");
        registrationPage.inputEmail();
        registrationPage.inputPassword();
        registrationPage.RepeatPassword();
    }
}

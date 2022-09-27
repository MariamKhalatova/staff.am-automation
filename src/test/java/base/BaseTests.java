package base;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.common.HomePage;

import java.awt.*;

public class BaseTests {
    private static WebDriver driver;
    String baseURL = "https://staff.am";
    protected HomePage homepage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        homepage = new HomePage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}

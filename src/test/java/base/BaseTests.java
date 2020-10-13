package base;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import Utilities.ObjectRepo;
import Utilities.PropertiesConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


// Identify All Objects and Classes
public class BaseTests {

     WebDriver driver;
     WebDriverWait wait;
     HomePage homePage;
     LoginPage loginPage;
     RegistrationPage registrationPage;
     PropertiesConfig propertiesConfig;
     int timeOut = 10;

   @BeforeClass
     public void beforeclass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,timeOut);
        homePage = new HomePage(driver);
        propertiesConfig = new PropertiesConfig();
        driver.get(propertiesConfig.getProperty("baseURL"));
        wait.until(ExpectedConditions.elementToBeClickable(ObjectRepo.MyAccountLocator));
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }



        @Test(priority = 1)
        public void RegistrationWithValidData() {
        homePage.myAccount();
            homePage.signUp();
            registrationPage.fillSignUpDataAndSubmit(propertiesConfig.getProperty("validFirstName"),
           propertiesConfig.getProperty("validLastName"), propertiesConfig.getProperty("validMobileNumber"),
           propertiesConfig.getProperty("validEmail"),propertiesConfig.getProperty("validPassword"),
           propertiesConfig.getProperty("validConfirmPassword"));
            registrationPage.clickSignUpBTN();
            //Assert.assertEquals(driver.getCurrentUrl(), propertiesConfig.getProperty("accountURL"));
            homePage.logout();
            homePage.myAccount();
            homePage.login();
            loginPage.fillLogin(propertiesConfig.getProperty("validEmail"),propertiesConfig.getProperty("validPassword"));
            loginPage.clickLoginBTN();
            homePage.logout();
        }















}



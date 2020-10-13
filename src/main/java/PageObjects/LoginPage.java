package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utilities.ObjectRepo.*;
import static Utilities.ObjectRepo.confirmPasswordField;

public class LoginPage {

    //Identify Object And Class to WebDriver

    WebDriver driver;
    WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30); }
    //	To pass test data for each use case
    public void fillLogin(String user_name , String password){
        driver.findElement(userNameField).sendKeys(user_name);
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginBTN(){
        driver.findElement(LoginBTNLocator).click();
    }

























}

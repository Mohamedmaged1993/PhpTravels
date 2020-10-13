package PageObjects;

import Utilities.ObjectRepo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HomePage {

    //Identify Object And Class to WebDriver

    WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);

    }

    //access to MyAccounts DropDown
    public void myAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(ObjectRepo.MyAccountLocator));
        WebElement myAccountDropDown = driver.findElement(ObjectRepo.MyAccountLocator);
        myAccountDropDown.click();
    }

    //access to signUp
    public void signUp() {
        wait.until(ExpectedConditions.elementToBeClickable(ObjectRepo.SignUpLocator));
        WebElement signUpBtn = driver.findElement(ObjectRepo.SignUpLocator);
        signUpBtn.click();
    }
    //access to login
    public void login() {
        wait.until(ExpectedConditions.elementToBeClickable(ObjectRepo.LoginLocator));
        WebElement loginBtn = driver.findElement(ObjectRepo.LoginLocator);
        loginBtn.click();
    }
    public void logout(){
        wait.until(ExpectedConditions.elementToBeClickable(ObjectRepo.LogoutLocator));
        WebElement logoutBtn = driver.findElement(ObjectRepo.LogoutLocator);
        logoutBtn.click();
    }

    // Function To Take ScreenShoots

    
}
package PageObjects;

import Utilities.ObjectRepo;
import Utilities.PropertiesConfig;
import com.google.gson.JsonObject;
import netscape.javascript.JSObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Iterator;

import static Utilities.ObjectRepo.*;

public class RegistrationPage {

    //Identify Object And Class to WebDriver

    WebDriver driver;
    WebDriverWait wait;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }


    //	To pass test data for each use case
    public void fillSignUpDataAndSubmit(String first_Name, String last_Name, String mobile_Number, String
            mail_Address, String pass, String confirmPass) {
        driver.findElement(firstNameField).sendKeys(first_Name);
        driver.findElement(lastNameField).sendKeys(last_Name);
        driver.findElement(mobileNumberField).sendKeys(mobile_Number);
        driver.findElement(emailField).sendKeys(mail_Address);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(confirmPasswordField).sendKeys(confirmPass);

    }

    public void clickSignUpBTN() {
        driver.findElement(signUpBTNLocator).click();
    }

    public void clickLogOutBTN() {
        driver.findElement(LogoutLocator).click();
    }

    private void getRequestResponse() {
        String currentURL = driver.getCurrentUrl();
        LogEntries logs = driver.manage().logs().get("performance");
        int status = -1;

        for (Iterator<LogEntry> it = logs.iterator(); it.hasNext(); ) {
            LogEntry entry = it.next();
            try {
                JsonObject json = new JsonObject();
                //JsonObject json = new JsonObject(entry.getMessage());
                JsonObject message = json.getAsJsonObject("message");
                String method = message.getAsString();
                if (method != null && "Network.responseReceived".equals(method)) {
                    JsonObject params = message.getAsJsonObject("params");
                    JsonObject response = params.getAsJsonObject("response");
                    String messageUrl = response.getAsString();
                    if (currentURL.equals(messageUrl)) {
                        status = response.getAsInt();
                        PrintStream apiResponse;
                        try {
                            apiResponse = new PrintStream(new FileOutputStream("API_RESPONSE_JSON.txt"));
                            apiResponse.println("returned response for " + messageUrl + ": " + status);
                            apiResponse.println("\nstatus code: " + status);
                            apiResponse.println("headers: " + response.get("headers"));
                            apiResponse.println(json.toString());
                            apiResponse.println("");
                            System.setOut(apiResponse);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (JsonException e) {
                e.printStackTrace();
            }
        }
    }
    // Function To Take ScreenShoots
    public void ScreenShoot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile
            FileUtils.copyFile(src, new File("E:/Pixeloic/ScreenShoot/signup.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
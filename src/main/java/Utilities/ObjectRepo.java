package Utilities;


// Identify All Locator is Used in FrameWork

import org.openqa.selenium.By;

public class ObjectRepo {
    //Identify Locators  MyAccounts DropDown

public static By MyAccountLocator = By.xpath("//div[contains(@class, 'dropdown')][contains(., 'My Account')]");
public static By SignUpLocator = By.linkText("Sign Up");
public static By LoginLocator = By.xpath("//a[contains(@class, 'dropdown-item')][contains(., 'Login')]");
public static By LogoutLocator = By.xpath("//a[contains(@class, 'dropdown-item')][contains(., 'Logout')]");
public static By LoginBTNLocator = By.xpath("//button[contains(@class,'loginbtn')]");
 // Identify Locators SignUp TextFields
 public static By firstNameField = By.name("firstname");
 public static By lastNameField = By.name("lastname");
 public static By mobileNumberField = By.name("phone");
 public static By emailField = By.name("email");
 public static By passwordField = By.name("password");
 public static By confirmPasswordField = By.name("confirmpassword");
 public static By signUpBTNLocator = By.xpath("//button[contains(@class,'signupbtn')]");
 public static By userNameField = By.name("username");


}

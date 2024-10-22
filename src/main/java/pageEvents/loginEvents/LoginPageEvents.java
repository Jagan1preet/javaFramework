package pageEvents.loginEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.logIn.LoginPageElements;
import utils.ElementFetch;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static base.BaseTest.driver;
import static base.BaseTest.logger;

public class LoginPageEvents {

    private ElementFetch elementFetch = new ElementFetch();
    Properties prop = new Properties();

//  Read the data prom the config file
    public LoginPageEvents() {
        try (FileInputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            System.err.println("Error reading config.properties file: " + ex.getMessage());
        }
    }

//  Verifies if the login page is loaded
    public void verifyIfLoginPageIsLoaded() {
        logger.info("Validate if all the elements load properly");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageElements.loginButton)));
    }

//  Logs in with correct credentials
    public void incorrectLogin() {
        logger.info("Enter incorrect credentials");
        WebElement emailField = elementFetch.getWebElement("XPATH", LoginPageElements.emailAddress);
        WebElement passwordField = elementFetch.getWebElement("XPATH", LoginPageElements.passwordField);
        WebElement loginButton = elementFetch.getWebElement("XPATH", LoginPageElements.loginButton);

        passwordField.clear();
        passwordField.click();

//      Use username from config file
        passwordField.sendKeys(prop.getProperty("incorrectpassword"));
        emailField.clear();
        emailField.click();

//      Use password from config.properties
        emailField.sendKeys(prop.getProperty("incorrectemail"));


        logger.info("Click on login button");
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Progetti"));

    }

//  Logs in with correct credentials
    public void login() {
        logger.info("Enter correct credentials");
        WebElement emailField = elementFetch.getWebElement("XPATH", LoginPageElements.emailAddress);
        WebElement passwordField = elementFetch.getWebElement("XPATH", LoginPageElements.passwordField);

        passwordField.clear();
        passwordField.click();

//      Use username from config file
        passwordField.sendKeys(prop.getProperty("password"));
        emailField.clear();
        emailField.click();

//      Use password from config file
        emailField.sendKeys(prop.getProperty("email"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPageElements.loginButton)));

        logger.info("Click on login button");
        loginButton.click();
        logger.info("Login Successful");

    }

}
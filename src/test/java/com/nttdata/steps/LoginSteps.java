package com.nttdata.steps;

import com.nttdata.core.DriverManager;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresar(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.emailInput));
        emailField.sendKeys(email);
        driver.findElement(LoginPage.passwordInput).sendKeys(password);
        driver.findElement(LoginPage.loginButton).click();
        DriverManager.screenShot();
    }
}
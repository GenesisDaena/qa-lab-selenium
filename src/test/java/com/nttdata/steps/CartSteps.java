package com.nttdata.steps;

import com.nttdata.core.DriverManager;
import com.nttdata.page.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSteps {

    private WebDriver driver;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
    }

    public String obtenerTituloCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.cartTitle));
        return driver.findElement(CartPage.cartTitle).getText();
    }

    public String obtenerPrecioProductoCarrito() {
        return driver.findElement(CartPage.productPrice).getText();
    }

    public String obtenerCantidadCarrito() {
        return driver.findElement(CartPage.productQuantity).getAttribute("value");
    }

    public String obtenerTotalCarrito() {
        return driver.findElement(CartPage.cartTotal).getText();
    }
}
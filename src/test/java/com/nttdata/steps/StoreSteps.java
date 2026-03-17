package com.nttdata.steps;

import com.nttdata.core.DriverManager;
import com.nttdata.page.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreSteps {

    private WebDriver driver;

    public StoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void navegarCategoriaYSubcategoria(String categoria, String subCategoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement catLink = wait.until(ExpectedConditions.elementToBeClickable(
                StorePage.categoryLink(categoria)));
        catLink.click();
        WebElement subCatLink = wait.until(ExpectedConditions.elementToBeClickable(
                StorePage.subCategoryLink(subCategoria)));
        subCatLink.click();
        DriverManager.screenShot();
    }

    public void agregarPrimerProductoAlCarrito(int cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.firstProduct)).click();
        WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.quantityInput));
        qty.clear();
        qty.sendKeys(String.valueOf(cantidad));
        driver.findElement(StorePage.addToCartButton).click();
        DriverManager.screenShot();
    }

    public String obtenerNombreProductoPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.popupProductName));
        return driver.findElement(StorePage.popupProductName).getText();
    }

    public String obtenerTotalPopup() {
        return driver.findElement(StorePage.popupTotal).getText();
    }

    public String obtenerConteoItemsPopup() {
        return driver.findElement(StorePage.popupItemsCount).getText();
    }

    public void procederAlCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.popupProceedCheckout)).click();
        DriverManager.screenShot();
    }
}
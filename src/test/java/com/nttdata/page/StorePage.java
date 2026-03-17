package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {
    public static By categoryLink(String categoria) {
        return By.xpath("//ul[@id='top-menu']//a[@data-depth='0' and contains(normalize-space(), '" + categoria + "')]");
    }
    public static By subCategoryLink(String subCategoria) {
        return By.xpath("//a[@class='subcategory-name' and normalize-space()='" + subCategoria + "']");
    }
    public static By firstProduct = By.cssSelector(".js-product:first-child .product-title a");
    public static By quantityInput = By.id("quantity_wanted");
    public static By addToCartButton = By.cssSelector("button[data-button-action='add-to-cart']");
    public static By popupProductName = By.cssSelector(".product-name");
    public static By popupProductPrice = By.cssSelector(".modal-body .product-price");
    public static By popupItemsCount = By.cssSelector(".cart-products-count");
    public static By popupTotal = By.cssSelector(".product-total .value");
    public static By popupContinueShopping = By.cssSelector("button[data-dismiss='modal']");
    public static By popupProceedCheckout = By.cssSelector(".cart-content-btn .btn-primary");
}
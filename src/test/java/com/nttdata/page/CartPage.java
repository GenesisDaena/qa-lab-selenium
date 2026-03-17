package com.nttdata.page;

import org.openqa.selenium.By;

public class CartPage {
    public static By cartTitle = By.cssSelector("h1.h1");
    public static By productPrice = By.cssSelector(".current-price .price");
    public static By productQuantity = By.cssSelector(".js-cart-line-product-quantity");
    public static By cartTotal = By.cssSelector(".cart-total .value");
    public static By cartSubtotal = By.cssSelector("#cart-subtotal-products .value");
}
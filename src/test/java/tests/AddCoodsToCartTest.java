package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddCoodsToCartTest extends BaseTest {
//залогиниться, добавить товар и проверить что товар в корзине есть
@Test
public void checkCart() {
    loginPage.open();
    loginPage.login("standard_user","secret_sauce");
    assertTrue(productPage.titleIsDisplayed());
    assertEquals(productPage.getTitle(), "Products");
    //productPage.addToCart("Sauce Labs Backpack");
    productPage.isOpen();
    productPage.addToCart(0);
    productPage.addToCart(2);
    productPage.addToCart(3);
    productPage.openCart();
    //assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
    assertEquals(cartPage.getProductsNames().size(), 3);
    //assertFalse(cartPage.getProductsNames().isEmpty());
}
}

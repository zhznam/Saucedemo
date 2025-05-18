package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;

public class AddCoodsToCartTest extends BaseTest {

    //@Epic ()
    //@Future
    //@Story

    @Test
    public void checkCart() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), "Products");
        productPage.isOpen();
        productPage.addToCart(0);
        productPage.addToCart(2);
        productPage.addToCart(3);
        productPage.openCart();
        assertEquals(cartPage.getProductsNames().size(), 3);
    }
}

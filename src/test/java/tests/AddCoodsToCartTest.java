package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;

public class AddCoodsToCartTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Khrol Nat Ser bla@gmail.com")
    @TmsLink("UrnSu")
    @Issue("2")
    @Test(description="Проверка, что товары добавлены в корзину")
    @Flaky
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

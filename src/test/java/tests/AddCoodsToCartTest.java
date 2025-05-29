package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;

import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.Assert.*;

public class AddCoodsToCartTest extends BaseTest {
    @Epic("Модуль покупок интернет-магазина")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("zorina.e.k9@gmail.com")
    @Issue("2")
    @Test(description="Проверка, что товары добавлены в корзину")
    @Flaky
    public void checkCart() {
        loginPage
                .open()
                .login(UserFactory.withAdminPermission());
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), PRODUCTS.getDisplayName());
        productPage
                .isOpen()
                .addToCart(0)
                .addToCart(2)
                .addToCart(3)
                .openCart();
        assertEquals(cartPage.getProductsNames().size(), 3);
    }
}

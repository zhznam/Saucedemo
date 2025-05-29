package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserFactory;
import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка авторизации")
    public void correctLogin() {
        loginPage
                .open()
                .login(UserFactory.withAdminPermission());
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @DataProvider(name="incorrectLoginData")
    public Object[][] loginData () {
        return new Object[][]{
                {"","secret_sauce", "Epic sadface: Username is required"},
                {"standard_user","secret_", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "incorrectLoginData")
    public void incorrectLogin(String user, String pass, String errorMsg) {
        loginPage
                .open()
                .fillLoginInput(user)
                .fillPasswordInput(pass)
                .clickBtn();
        assertEquals(loginPage.error(), errorMsg);
    }
}

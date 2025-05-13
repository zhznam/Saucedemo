package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), "Products");
    }

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("","secret_sauce");
        assertEquals(loginPage.error(), "Epic sadface: Username is required");
    }

    @Test
    public void incorrectPasswordLogin() {
        loginPage.open();
        loginPage.login("standard_user","secret_");
        assertEquals(loginPage.error(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void incorrectLockUserLogin() {
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        assertEquals(loginPage.error(), "Epic sadface: Sorry, this user has been locked out.");
    }

}

package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/";
    WebDriver driver;

    //дописать
    public BasePage(WebDriver driver) {
        this.driver=driver;
    }
}

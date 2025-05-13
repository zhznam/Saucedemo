package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    //WebDriver driver;
    private final By title = By.cssSelector("[class='title']");
    private final By title2 = By.xpath("//*[text()='Products']");
    private static final String ADD_TO_CART_BUTTON_PATTERN
            = "div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    public ProductPage(WebDriver driver){
        //this.driver=driver;
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean titleIsDisplayed() {
        return driver.findElement(title2).isDisplayed();
    }

    public void addToCart(String goodsName){
        By addToCart = By.xpath((String.format(ADD_TO_CART_BUTTON_PATTERN, goodsName)));
        //By addToCart2 = By.xpath((String.format(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName)));
        driver.findElement(addToCart).click();
    }

}

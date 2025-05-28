package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{
    private final By title = By.cssSelector("[class='title']");
    private final By title2 = By.xpath("//*[text()='Products']");
    private static final String ADD_TO_CART_BUTTON_PATTERN
            = "div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[text()='Add to cart']");
    private static final By OPEN_CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    @Step("Проверка названия товара")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Проверка, что отображен заголовок страницы")
    public boolean titleIsDisplayed() {
        return driver.findElement(title2).isDisplayed();
    }

    public void addToCart(String goodsName){
        By addToCart = By.xpath((String.format(ADD_TO_CART_BUTTON_PATTERN, goodsName)));
        driver.findElement(addToCart).click();
    }

    @Step ("Добавление товара в корзину")
    public ProductPage addToCart(int index){
        driver.findElements(ADD_TO_CART_BUTTON).get(index).click();
        return this;
    }

    @Step("Ожидание прогрузки карточек товаров")
    public ProductPage isOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON ));
        return this;
    }

    @Step("Открытие корзины")
    public void openCart(){
        driver.findElement(OPEN_CART_BUTTON).click();
    }

    public String confirm(){
        Alert alert = driver.switchTo().alert();
        String actualDialogText = alert.getText();
        alert.dismiss();
       return actualDialogText;
    }
}

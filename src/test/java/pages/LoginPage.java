package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private final By error_message = By.xpath("//*[@class='error-message-container error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Ввод данных пользователя")
    public void login(User user) {
        fillLoginInput(user.getEmail());
        fillPasswordInput(user.getPassword());
        clickBtn();
    }

    public void fillLoginInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
    }

    public void fillPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickBtn() {
        driver.findElement(LOGIN_BUTTON).submit();
    }

    public String error() {
        return driver.findElement(error_message).getText();
    }
}

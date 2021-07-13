package pl.tmobile.prepaidqa.qagui.classic.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.tmobile.prepaidqa.qagui.config.GuiConfig;

import static java.lang.Thread.sleep;

public class LoginPanelPage extends BasePage {

    public LoginPanelPage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "usernameOrEmail")
    public WebElement inputUserName;
//    public WebElement inputUserName = driver.findElement(By.id("usernameOrEmail"));

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement continueButton;
//    public WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));

    @FindBy(id = "password")
    public WebElement inputPassword;
//    public WebElement inputPassword = driver.findElement(By.id("password"));

    @FindBy(css = "button.form-button.is-primary")
    public WebElement logInButton;
//    public WebElement logInButton = driver.findElement(By.cssSelector("button.form-button.is-primary"));

    public void inputUserName(String sendKey) {
        inputUserName.click();
        inputUserName.clear();
        inputUserName.sendKeys(sendKey);
    }

    public void inputPassword(String sendKey) {
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(sendKey);
    }

    public void logIn() {
        inputUserName(GuiConfig.LOGIN);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton.click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputPassword(GuiConfig.PASSWORD);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logInButton.click();
    }
}

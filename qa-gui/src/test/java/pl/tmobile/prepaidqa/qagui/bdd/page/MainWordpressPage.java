package pl.tmobile.prepaidqa.qagui.bdd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainWordpressPage extends BasePage {

    public MainWordpressPage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li.x-nav-item.x-nav-item--wide a[title=\"Log In\"]")
    private WebElement loginButton;
//    private final WebElement loginButton = driver.findElement(By.cssSelector("li.x-nav-item.x-nav-item--wide a[title=\"Log In\"]"));

    @FindBy(id = "lpc-image.2")
    private WebElement picture;

    @FindBy(id = "lpc-button")
    private WebElement startYourWebsite;

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getPicture() {
        return picture;
    }

    public WebElement getStartYourWebsite() {
        return startYourWebsite;
    }
}

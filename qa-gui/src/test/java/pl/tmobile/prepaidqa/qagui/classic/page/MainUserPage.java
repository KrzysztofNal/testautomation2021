package pl.tmobile.prepaidqa.qagui.classic.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainUserPage extends BasePage {

    public MainUserPage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[data-tip-target=\"me\"] img[alt=\"Mój profil\"]")
    public WebElement userAvatar;
//    public WebElement userAvatar = driver.findElement(By.cssSelector("a[data-tip-target=\"me\"] img[alt=\"Mój profil\"]"));
}

package pl.tmobile.prepaidqa.qagui.classic.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationPage extends BasePage {

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href=\"/me/notifications/comments\"] .section-nav-tab__text")
    public WebElement commentSubPage;
}

package pl.tmobile.prepaidqa.qagui.bdd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarModule extends BasePage {
    public SideBarModule(WebDriver driver) {
        super(driver);
        //        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[data-e2e-sidebar=\"Ustawienia powiadomień\"]")
    public WebElement notificationLabel;

    private NotificationSubPage notificationSubPage;

    public NotificationSubPage getNotificationSubPage() {
        if (notificationSubPage == null) {
            notificationSubPage = new NotificationSubPage(driver);
        }
        return notificationSubPage;
    }
}

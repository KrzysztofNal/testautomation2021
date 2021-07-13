package pl.tmobile.prepaidqa.qagui.classic.page.userprofilepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.tmobile.prepaidqa.qagui.classic.page.BasePage;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "profile-gravatar__user-display-name")
    public WebElement displayedUserName;
//    public WebElement displayedUserName = driver.findElement(By.className("profile-gravatar__user-display-name"));

    @FindBy(css = "button[title=\"Log out of WordPress.com\"]")
    public WebElement logOutButton;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement saveDataButton;

    @FindBy(id = "inspector-toggle-control-3")
    public WebElement checkbox;


    private SideBarModule sideBarModule;


    public SideBarModule getSideBarModule() {
        if (sideBarModule == null) {
            sideBarModule = new SideBarModule(driver);
        }
        return sideBarModule;
    }

}

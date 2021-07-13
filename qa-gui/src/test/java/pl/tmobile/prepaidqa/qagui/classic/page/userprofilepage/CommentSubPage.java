package pl.tmobile.prepaidqa.qagui.classic.page.userprofilepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.tmobile.prepaidqa.qagui.classic.page.BasePage;

public class CommentSubPage extends BasePage {
    public CommentSubPage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".notification-settings-form__streams div:nth-child(2) > ul > li:nth-child(1) .form-checkbox")
    public WebElement likeNotifyCheckbox;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement saveSettingsButton;
}

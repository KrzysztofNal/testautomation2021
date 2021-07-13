package pl.tmobile.prepaidqa.qagui.classic.page.userprofilepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.tmobile.prepaidqa.qagui.classic.page.BasePage;

public class NotificationSubPage extends BasePage {

    public NotificationSubPage(WebDriver driver) {
        super(driver);
        //        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href=\"/me/notifications/comments\"]")
    public WebElement commentLabel;

    public CommentSubPage commentSubPage;

    public CommentSubPage getCommentSubPage() {
        if (commentSubPage == null) {
            commentSubPage = new CommentSubPage(driver);
        }
        return commentSubPage;
    }

}

package pl.tmobile.prepaidqa.qagui.classic.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pl.tmobile.prepaidqa.qagui.classic.service.LoginFacade;
import pl.tmobile.prepaidqa.qagui.config.GuiConfig;
import pl.tmobile.prepaidqa.qagui.classic.page.MainUserPage;
import pl.tmobile.prepaidqa.qagui.classic.page.userprofilepage.CommentSubPage;
import pl.tmobile.prepaidqa.qagui.classic.page.userprofilepage.ProfilePage;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Tags({@Tag("GuiTest"), @Tag("login")})
@DisplayName("Login test")
public class LoginTest extends ConfigGui {

    @DisplayName("First basic test")
    @Test
    public void loginTest() throws InterruptedException {
        driver.get(GuiConfig.BASE_WORDPRESS_URL);
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.cssSelector("li.x-nav-item.x-nav-item--wide a[title=\"Log In\"]")).click();
        driver.findElement(By.id("usernameOrEmail")).click();
        driver.findElement(By.id("usernameOrEmail")).clear();
        driver.findElement(By.id("usernameOrEmail")).sendKeys(GuiConfig.LOGIN);
        sleep(1000);
        driver.findElement(By.cssSelector(".button.form-button.is-primary")).click();
        sleep(1000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(GuiConfig.PASSWORD);
        sleep(1000);
        driver.findElement(By.cssSelector("button.form-button.is-primary")).click();
        sleep(3000);
        driver.findElement(By.cssSelector("a[data-tip-target=\"me\"] img[alt=\"Mój profil\"]")).click();
        sleep(1000);
        String text = driver.findElement(By.className("profile-gravatar__user-display-name")).getText();
        System.out.println(text);
        assertTrue(text.equals(GuiConfig.LOGIN));
    }

    MainUserPage mainUserPage;
    ProfilePage profilePage;
    LoginFacade loginFacade;
    CommentSubPage commentSubPage;

    @DisplayName("Using Page object pattern test")
    @Test
    void pageObjectPatternTest() throws InterruptedException {
        driver.get(GuiConfig.BASE_WORDPRESS_URL);
        loginFacade = new LoginFacade();

        loginFacade.logIn(driver);

        mainUserPage = new MainUserPage(driver);
        sleep(2000);

        mainUserPage.userAvatar.click();
        sleep(1000);

        profilePage = new ProfilePage(driver);
        sleep(1000);
        String displayedUserName = profilePage.displayedUserName.getText();

        assertTrue(displayedUserName.equals(GuiConfig.LOGIN));
        assertTrue(profilePage.logOutButton.isDisplayed());
        assertFalse(profilePage.saveDataButton.isEnabled());

        profilePage.checkbox.click();
        assertTrue(profilePage.saveDataButton.isEnabled());
        profilePage.checkbox.click();
        assertFalse(profilePage.saveDataButton.isEnabled());

    }

    @DisplayName("Select notification test")
    @Test
    void selectNotificationTest() throws InterruptedException {
        driver.get(GuiConfig.BASE_WORDPRESS_URL);
        loginFacade = new LoginFacade();

        loginFacade.logIn(driver);

        mainUserPage = new MainUserPage(driver);
//        sleep(1000);
//        mainUserPage.userAvatar.click();
        mainUserPage.waitForElementToBeClickableAndClick(mainUserPage.userAvatar, 5);

//      sleep(1000);

        profilePage = new ProfilePage(driver);
//        sleep(1000);
        mainUserPage.waitForElementToBeClickableAndClick(profilePage.getSideBarModule().notificationLabel, 5);
//        profilePage.getSideBarModule().notificationLabel.click();
//        sleep(1000);
        mainUserPage.waitForElementToBeClickableAndClick(profilePage.getSideBarModule().getNotificationSubPage().commentLabel, 5);
//        profilePage.getSideBarModule().getNotificationSubPage().commentLabel.click();
//        sleep(1000);
        commentSubPage = profilePage.getSideBarModule().getNotificationSubPage().getCommentSubPage();
        commentSubPage.waitForElementToBeSelectedElement(commentSubPage.likeNotifyCheckbox, 5, true);
//        sleep(1000);
        assertTrue(commentSubPage.likeNotifyCheckbox.isSelected());
//        sleep(1000);
        commentSubPage.likeNotifyCheckbox.click();
//        sleep(1000);
        commentSubPage.waitForElementToBeSelectedElement(commentSubPage.likeNotifyCheckbox, 5, false);
        assertFalse(commentSubPage.likeNotifyCheckbox.isSelected());
//        sleep(1000);
        commentSubPage.likeNotifyCheckbox.click();
//        sleep(1000);
        commentSubPage.waitForElementToBeSelectedElement(commentSubPage.likeNotifyCheckbox, 5, true);
        assertTrue(commentSubPage.likeNotifyCheckbox.isSelected());

    }

}

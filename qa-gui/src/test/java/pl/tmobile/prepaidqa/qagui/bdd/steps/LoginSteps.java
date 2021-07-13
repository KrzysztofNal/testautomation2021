package pl.tmobile.prepaidqa.qagui.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.tmobile.prepaidqa.qagui.bdd.ConfigBaseStep;
import pl.tmobile.prepaidqa.qagui.classic.page.MainUserPage;
import pl.tmobile.prepaidqa.qagui.classic.page.userprofilepage.CommentSubPage;
import pl.tmobile.prepaidqa.qagui.classic.page.userprofilepage.ProfilePage;
import pl.tmobile.prepaidqa.qagui.classic.service.LoginFacade;
import pl.tmobile.prepaidqa.qagui.config.GuiConfig;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.tmobile.prepaidqa.qagui.config.GuiConfig.BASE_WORDPRESS_URL;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(ConfigBaseStep configBaseStep) {
        WebDriver driver = configBaseStep.setUpWebDriver();
        this.driver = driver;
    }

    MainUserPage mainUserPage;
    ProfilePage profilePage;
    LoginFacade loginFacade;

    @Given("User starts on main page")
    public void userStartsOnMainPage() {
        driver.get(GuiConfig.BASE_WORDPRESS_URL);
    }

    @When("User logs to the user panel")
    public void userLogsToTheUserPanel() {
        loginFacade = new LoginFacade();
        loginFacade.logIn(driver);
        mainUserPage = new MainUserPage(driver);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainUserPage.userAvatar.click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("User arrived on user profile page")
    public void serArrivedOnUserProfilePage() {
        profilePage = new ProfilePage(driver);

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String displayedUserName = profilePage.displayedUserName.getText();

        assertTrue(displayedUserName.equals(GuiConfig.LOGIN));
        assertTrue(profilePage.logOutButton.isDisplayed());
        assertFalse(profilePage.saveDataButton.isEnabled());

    }

    @Given("User starts on wordpress page")
    public void userStartsOnWordpressPage() {
        System.out.println("User starts on wordpress page");
        driver.navigate().to(BASE_WORDPRESS_URL);
    }
}

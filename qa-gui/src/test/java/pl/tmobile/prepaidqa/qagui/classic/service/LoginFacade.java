package pl.tmobile.prepaidqa.qagui.classic.service;

import org.openqa.selenium.WebDriver;
import pl.tmobile.prepaidqa.qagui.classic.page.LoginPanelPage;
import pl.tmobile.prepaidqa.qagui.classic.page.MainWordpressPage;

public class LoginFacade {


    public void logIn(WebDriver driver) {
        MainWordpressPage mainWordpressPage;
        mainWordpressPage = new MainWordpressPage(driver);
        mainWordpressPage.getLoginButton().click();

        LoginPanelPage loginPanelPage;
        loginPanelPage = new LoginPanelPage(driver);
        loginPanelPage.logIn();
    }
}

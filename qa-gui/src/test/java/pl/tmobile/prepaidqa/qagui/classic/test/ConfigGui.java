package pl.tmobile.prepaidqa.qagui.classic.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pl.tmobile.prepaidqa.qagui.config.GuiConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static pl.tmobile.prepaidqa.qagui.config.GuiConfig.BROWSER;

public class ConfigGui {

    protected WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        if  (GuiConfig.MACHINE.equals("local")) {
            driver = setUpWebDriver();
        } else {
            driver = setUpRemoteWebDriver();
        }
        setUpInitDriver();
    }

    private WebDriver setUpRemoteWebDriver() {
        driver = null;
        try {
            return new RemoteWebDriver(new URL(GuiConfig.SELENIUM_HUB_URL), setUpRemoteBrowser());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            driver = null;
        }
        return driver;
    }

    private DesiredCapabilities setUpRemoteBrowser() {
        switch (BROWSER) {
            case "firefox":
                return new DesiredCapabilities(BrowserType.FIREFOX, "", Platform.LINUX);
            default:
                return new DesiredCapabilities(BrowserType.CHROME, "", Platform.LINUX);
        }
    }

    private WebDriver setUpWebDriver() {
        switch(BROWSER) {
            case "firefox":
                return setFirefoxEnvironment();
            case "chrome" :
            default: return setUpChromeEnvironment();
        }
    }

    private WebDriver setUpChromeEnvironment() {
//            System.setProperty("webdriver.chrome.driver",
//            Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath());
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver setFirefoxEnvironment() {
//            System.setProperty("webdriver.gecko.driver",
//            Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath());
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private void setUpInitDriver() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }
}

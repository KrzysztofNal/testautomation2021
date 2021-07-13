package pl.tmobile.prepaidqa.qagui.bdd;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static pl.tmobile.prepaidqa.qagui.config.GuiConfig.BROWSER;

public class ConfigBaseStep {

    protected WebDriver driver;

    public WebDriver setUpWebDriver() {
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
        driver = new ChromeDriver();
        setUpInitDriver();
        return driver;
    }

    private WebDriver setFirefoxEnvironment() {
//            System.setProperty("webdriver.gecko.driver",
//            Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath());
        WebDriverManager.firefoxdriver().setup();
        driver =  new FirefoxDriver();
        setUpInitDriver();
        return driver;
    }

    private void setUpInitDriver() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("=========================== @After Cucumber Test  =======================================");
        String status;
        if(!scenario.isFailed()) {
            status = "( ͡° ͜ʖ ͡°)";
//            status = "++++++++++";
            scenario.log("Scenario passed");
        } else {
            status = "(✖╭╮✖)";
//            status = "-------------";
            scenario.attach(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"images/png", scenario.getName());
            scenario.log("Scenario failed");
        }
        System.out.println("\n"+status+" End of: " + scenario.getName() + " scenario.");
        driver.quit();
        driver = null;
    }
}

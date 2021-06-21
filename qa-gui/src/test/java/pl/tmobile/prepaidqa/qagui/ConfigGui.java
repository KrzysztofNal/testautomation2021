package pl.tmobile.prepaidqa.qagui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigGui {

    WebDriver driver;

    @BeforeEach
    public void beforeEach() throws URISyntaxException {
//            System.setProperty("webdriver.gecko.driver",
//            Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath());
//         driver = new FirefoxDriver();
//    System.setProperty("webdriver.chrome.driver",
//            Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath());

                    WebDriverManager.chromedriver().setup();
//                    WebDriverManager.firefoxdriver().setup();
        driver = setUpWebDriver();
        setUpInitDriver();
    }

    private WebDriver setUpWebDriver() {
        return new ChromeDriver();
//        return new FirefoxDriver();
//        switch("BROWSER") {
//            case "chrome" :
//                return new ChromeDriver();
//            case "firefox":
//                return new FirefoxDriver();
//            case "edge":
//                return new EdgeDriver();
//        }
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

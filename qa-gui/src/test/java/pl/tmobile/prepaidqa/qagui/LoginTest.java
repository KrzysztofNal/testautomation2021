package pl.tmobile.prepaidqa.qagui;

import com.typesafe.config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.tmobile.prepaidqa.qagui.config.GuiConfig;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

@Tags({@Tag("GuiTest"), @Tag("login")})
@DisplayName("Azure Activities test")
public class LoginTest extends ConfigGui {

    @Test
    public void loginTest() throws InterruptedException {

        driver.get(GuiConfig.BASE_WORDPRESS_URL);
//    driver.findElement(By.linkText("Log In")).click();
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

}

package pl.tmobile.prepaidqa.qagui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
//    System.setProperty("webdriver.gecko.driver",
//            Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath());
//    System.setProperty("webdriver.chrome.driver",
//            Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath());
//    driver = new ChromeDriver();
////    System.setProperty("webdriver.edge.driver",
////            Paths.get(getClass().getClassLoader().getResource("driver/msedgedriver.exe").toURI()).toFile().getAbsolutePath());
////    driver = new EdgeDriver();
//
//    driver = new FirefoxDriver();
    WebDriverManager.chromedriver().setup();
//    WebDriverManager.firefoxdriver().setup();
    driver = new ChromeDriver();
  }


  @Test
  public void testUntitledTestCase() throws Exception {

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();

    driver.get("https://wordpress.com/");
    driver.findElement(By.cssSelector("li.x-nav-item.x-nav-item--wide a[title=\"Log In\"]")).click();
//    driver.findElement(By.linkText("Log In")).click();
    driver.findElement(By.id("usernameOrEmail")).click();
    driver.findElement(By.id("usernameOrEmail")).clear();
    driver.findElement(By.id("usernameOrEmail")).sendKeys("testautomation112020");

    driver.findElement(By.cssSelector(".button.form-button.is-primary")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("automation112020");


    sleep(2000);

    driver.findElement(By.cssSelector("button.form-button.is-primary")).click();

    sleep(3000);
    driver.findElement(By.cssSelector("a[data-tip-target=\"me\"] img[alt=\"Mój profil\"]")).click();
    sleep(2000);

    String text = driver.findElement(By.className("profile-gravatar__user-display-name")).getText();
    System.out.println(text);

    assertTrue(text.equals("testautomation112020"));


  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    driver = null;
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

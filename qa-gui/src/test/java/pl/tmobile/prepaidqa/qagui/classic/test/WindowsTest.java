package pl.tmobile.prepaidqa.qagui.classic.test;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.tmobile.prepaidqa.qagui.config.GuiConfig;

import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

@Tags({@Tag("GuiTest"), @Tag("windows")})
@DisplayName("Frontend windows test")
public class WindowsTest extends ConfigGui {

    @Test
    public void frameTest() {
        driver.navigate().to(GuiConfig.BASE_DIARY_URL);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));
        WebElement testframe = driver.findElement(By.name("testframe"));

        driver.switchTo().frame(testframe);

        String expectedFrameText = driver.findElement(By.id("testpagelink")).getText();

        assertThat(expectedFrameText).isEqualTo("My frame text");

        driver.switchTo().parentFrame();

    }

    @Test
    public void windowTest() {

        String firstPageWindowHandle;
        String secondTestWindowHandle = null;

        driver.navigate().to(GuiConfig.BASE_DIARY_URL);

        final By OpenWindowHyperText = By.linkText("Open page in a new window");

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(OpenWindowHyperText));

        firstPageWindowHandle = driver.getWindowHandle();

//        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getY();
//        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in a new window")).getLocation().getX();
        WebElement openPageInNewWindow = driver.findElement(By.id("mywindowframe"));

        int hyperlinkYCoordinate = openPageInNewWindow.getLocation().getY();
        int hyperlinkXCoordinate = openPageInNewWindow.getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(OpenWindowHyperText));

        driver.findElement(OpenWindowHyperText).click();

        Set<String> testPageWindowHandle = driver.getWindowHandles();

        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }

        driver.switchTo().window(secondTestWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(secondTestWindowHandle).close();

        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(OpenWindowHyperText));

        driver.close();
    }

    @Disabled
    @DisplayName("alert")
    @Test
    public void popupHandler() {
        driver.switchTo().alert();
        driver.findElement(By.id("userId")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();

        String pageId = driver.getWindowHandle();
        driver.switchTo().window(pageId);

        String title = driver.getTitle();
        assertThat(title).isEqualTo("title");
    }

    @Test
    void scrollIntoView(){
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
        WebElement element = driver.findElement(By.id("mCSB_9_container"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}

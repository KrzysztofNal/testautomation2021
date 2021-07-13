package pl.tmobile.prepaidqa.qagui.classic.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pl.tmobile.prepaidqa.qagui.config.GuiConfig;
import pl.tmobile.prepaidqa.qagui.classic.page.MainWordpressPage;

@Tags({@Tag("GuiTest"), @Tag("action")})
@DisplayName("Frontend action test")
public class ActionTest extends ConfigGui {

    @Tag("simpleaction")
    @DisplayName("Simple action")
    @Test
    public void actionTest() {
        driver.navigate().to(GuiConfig.BASE_WORDPRESS_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

        Actions actions = new Actions(driver);

        actions.moveToElement(mainWordpressPage.getPicture())
                .clickAndHold()
                .moveToElement(mainWordpressPage.getStartYourWebsite())
                .release();
        actions.build().perform();
    }

    @Tag("GuiTest")
    @DisplayName("Keys short")
    @Test
    public void keysInteraction() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.CONTROL, "R")).perform();
        actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.ALT, "L")).perform();
        actions.sendKeys(Keys.chord(Keys.ESCAPE)).perform();
        actions.sendKeys(Keys.chord(Keys.ENTER)).perform();
    }

}

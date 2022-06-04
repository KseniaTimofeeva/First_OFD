package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShadowSendsaySubscriptionDialogSteps extends BaseSteps {

    public ShadowSendsaySubscriptionDialogSteps(WebDriver driver) {
        super(driver);
    }

    public void waitDialog() {
        new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofMillis(500))
                .until(webDriver -> shadowSendsaySubscriptionDialog.getRootShadowDialog().isEnabled());
    }
}

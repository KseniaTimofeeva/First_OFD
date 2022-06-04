package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowSendsaySubscriptionDialog extends BasePage{
    public ShadowSendsaySubscriptionDialog(WebDriver driver) {
        super(driver);
    }

    private final String rootXPath = "//sendsay-subscription-dialog";

    public WebElement getRootShadowDialog() {
        return driver.findElement(By.xpath(rootXPath));
    }
}

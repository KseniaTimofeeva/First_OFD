package steps;

import org.openqa.selenium.WebDriver;
import pages.RegistrationForm;
import pages.ShadowSendsaySubscriptionDialog;

public abstract class BaseSteps {

    protected WebDriver driver;
    protected RegistrationForm registrationForm;
    protected ShadowSendsaySubscriptionDialog shadowSendsaySubscriptionDialog;

    BaseSteps(WebDriver driver) {
        this.driver = driver;
        registrationForm = new RegistrationForm(driver);
        shadowSendsaySubscriptionDialog = new ShadowSendsaySubscriptionDialog(driver);
    }
}

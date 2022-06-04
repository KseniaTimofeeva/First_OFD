package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.RegistrationSteps;
import steps.ShadowSendsaySubscriptionDialogSteps;

@Test
public abstract class BaseTest {

    private final String URL = "https://www.1-ofd.ru/";
    private static final String DRIVER_NAME = "Chrome";

    protected WebDriver driver;

    protected RegistrationSteps registrationSteps;
    protected ShadowSendsaySubscriptionDialogSteps shadowSendsaySubscriptionDialogSteps;

    @BeforeMethod
    protected void openApplication() {
        setup();
    }

    @AfterMethod
    protected void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    private void setup() {
        driver = new DriverConfig().initDriver(DRIVER_NAME);
        driver.get(URL);
        registrationSteps = new RegistrationSteps(driver);
        shadowSendsaySubscriptionDialogSteps = new ShadowSendsaySubscriptionDialogSteps(driver);
    }
}

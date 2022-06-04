import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @BeforeMethod
    @Override
    protected void openApplication() {
        super.openApplication();
        shadowSendsaySubscriptionDialogSteps.waitDialog();
        registrationSteps.setFIO("Ivanov Ivan Ivanovich");
        registrationSteps.setEmail("ivan.ivanov@mail.ru");
    }

    @DataProvider
    public Object[][] telephoneNumberData() {
        return new Object[][]{
                {"1234567890", true},
                {"12345678901", true},
                {"123456789", false},
                {"", false},
                {"abc", false},
                {"abcdefghij", false},
                {"1         ", false},
                {"1        1", false},
                {"!@#$%^&*()", false},
        };
    }

    @Test(dataProvider = "telephoneNumberData",
            description = "Check that telephone field accepts 10 digits format only")
    public void telephoneFieldTest(String telephone, boolean isActiveButton) {
        registrationSteps.setTelephone(telephone);
        registrationSteps.checkRegistrationButtonState(isActiveButton);
    }

    @Test(dataProvider = "telephoneNumberData",
            description = "Check that tooltip appears in case of wrong telephone format")
    public void telephoneFieldTooltipTextTest(String telephone, boolean hiddenTooltip) {
        registrationSteps.setTelephone(telephone);
        registrationSteps.checkTelephoneFieldTooltip(hiddenTooltip);
    }
}

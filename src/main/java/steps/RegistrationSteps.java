package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationSteps extends BaseSteps {

    public RegistrationSteps(WebDriver driver) {
        super(driver);
    }

    public void setFIO(String fio) {
        registrationForm.getFio().sendKeys(fio);
    }

    public void setEmail(String email) {
        registrationForm.getEmail().sendKeys(email);
    }

    public void clickEmail() {
        registrationForm.getEmail().click();
    }

    public void setTelephone(String telephone) {
        registrationForm.getTelephone().sendKeys(telephone);
    }

    public void clickTelephone() {
        registrationForm.getTelephone().click();
    }

    public void clickRegisterButton() {
        registrationForm.getEnterButton().click();
    }

    public void checkRegistrationButtonState(boolean isActiveButton) {
        boolean registrationButtonStateActual = false;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofMillis(500))
                    .until(webDriver -> registrationForm.isActiveFormRegistrationButton());
            registrationButtonStateActual = registrationForm.isActiveFormRegistrationButton();
        } catch (TimeoutException ignored) {
        } finally {
            Assert.assertEquals(registrationButtonStateActual, isActiveButton,
                    String.format("Is button 'Подключиться к ОФД' active? Actual: %s, expected %s.",
                            registrationButtonStateActual, isActiveButton));
        }
    }

    public void checkTelephoneFieldTooltip(boolean hiddenTooltip) {
        String expectedText = "Номер должен состоять из 10 цифр";

        clickTelephone();
        clickEmail();
        checkTelephoneFieldTooltipExist(hiddenTooltip);
        if (!hiddenTooltip) {
            Assert.assertEquals(registrationForm.getTelephoneFieldTooltipText(), expectedText,
                    String.format("Telephone field tooltip text. Actual '%s', expected '%s'.",
                            registrationForm.getTelephoneFieldTooltipText(), expectedText));
        }
    }

    private void checkTelephoneFieldTooltipExist(boolean expectedHidden) {
        boolean actual = registrationForm.getTelephoneFieldTooltipList().isEmpty();
        Assert.assertEquals(actual, expectedHidden, String.format("Telephone field tooltip exists. Actual '%s', expected '%s'.",
                actual, expectedHidden));

    }
}

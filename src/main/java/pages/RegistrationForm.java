package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class RegistrationForm extends BasePage {

    public RegistrationForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "form-registration-promo-name")
    private WebElement fio;

    @FindBy(xpath = "//*[@id='form-registration-promo-email']")
    private WebElement email;

    @FindBy(id = "form-registration-promo-phone")
    private WebElement telephone;

    @FindBy(xpath = "//form[@id='form-registration-promo']//span[contains(@class,'tooltip')]")
    private List<WebElement> telephoneFieldTooltipList;

    @FindBy(xpath = "//form[@id='form-registration-promo']")
    private WebElement registrationForm;

    @FindBy(xpath = "//form[@id='form-registration-promo']//button[text()='Подключиться к ОФД']")
    private WebElement enterButton;

    public boolean isActiveFormRegistrationButton() {
        return registrationForm.findElement(By.xpath("//button[text()='Подключиться к ОФД']"))
                .getAttribute("class").contains("active");
    }

    public String getTelephoneFieldTooltipText() {
        return registrationForm.findElement(By.xpath("//span[contains(@class,'tooltip')]")).getText();
    }


}

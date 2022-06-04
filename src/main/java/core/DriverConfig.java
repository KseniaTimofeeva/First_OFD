package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.time.Duration;

public class DriverConfig {

    public WebDriver initDriver(String driverName) {
        switch (driverName) {
            case "Chrome":
                return initChrome();
        }
        throw new RuntimeException("Unknown driver name");
    }

    private WebDriver initChrome() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(System.getProperty("user.dir") + "/driver/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        WebDriver driver = new ChromeDriver(service);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        return driver;
    }
}

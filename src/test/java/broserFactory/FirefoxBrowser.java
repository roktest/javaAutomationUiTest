package broserFactory;

import enums.Enums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirefoxBrowser implements IBrowser{
    WebDriver driver;

    @Override
    public WebDriver withWebDriverProperties() {
        System.setProperty(Enums.FIREFOX_DRIVER_KEY.getEnum(), Enums.FIREFOX_DRIVER_PATH.getEnum());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;
    }

}
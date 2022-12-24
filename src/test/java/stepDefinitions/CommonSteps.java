package stepDefinitions;

import enums.Enums;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    WebDriver driver;

    @Before(order = 0) //this hook is executed before each Scenario
    public void startChromeDriver(){
        System.setProperty(Enums.CHROME_DRIVER_KEY.getEnum(), Enums.DRIVER_PATH.getEnum());
        driver = new ChromeDriver();
        System.out.println("------------------------");
        System.out.println("** Global before hook **");
        System.out.println("------------------------");
    }

    @After(order = 0)//this hook is executed after each Scenario
    public void closeDriver(){
        driver.quit();
        System.out.println("-----------------------");
        System.out.println("** Global after hook **");
        System.out.println("-----------------------");
    }

    public WebDriver getDriver() {
        return driver;
    }
}

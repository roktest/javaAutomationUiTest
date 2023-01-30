package stepDefinitions;

import enums.Enums;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DependencyUtilities;

import java.util.concurrent.TimeUnit;

public class CommonSteps {

    WebDriver driver;
    DependencyUtilities dependencyUtilitiesService;

    public CommonSteps(DependencyUtilities dependencyUtilitiesService) {
        super();
        this.dependencyUtilitiesService = dependencyUtilitiesService;
    }
    @Before(order = 0) //this hook is executed before each Scenario
    public void startChromeDriver(){
        System.setProperty(Enums.CHROME_DRIVER_KEY.getEnum(), Enums.DRIVER_PATH.getEnum());
        driver = new ChromeDriver();

        /**
         * ImplicitlyWait is deprecated in Java and Selenium because it has proven to be unreliable and
         * causes more problems than it solves. The main issue with ImplicitlyWait is that it waits for
         * an element to appear on the page for a set amount of time before giving up. If the element
         * does not appear within that time frame, an error is thrown.
         *
         * This can cause issues when the page takes longer than expected to load, leading to
         * false positive test results. Additionally, it can slow down the test execution time and
         * make the test suite less efficient.
         *
         * To address these issues, it is recommended to use ExplicitWait instead.
         * ExplicitWait allows you to set a condition for the element to appear on the page
         * and will wait only until that condition is met. This results in more reliable
         * and efficient test execution.
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

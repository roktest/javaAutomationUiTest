package stepDefinitions;

import broserFactory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.DependencyUtilities;

public class CommonSteps {

    WebDriver chromeDriver;
    DependencyUtilities dependencyUtilitiesService;

    public CommonSteps(DependencyUtilities dependencyUtilitiesService) {
        super();
        this.chromeDriver = BrowserFactory.open("chrome").withWebDriverProperties();
        this.dependencyUtilitiesService = dependencyUtilitiesService;
    }

    @Before(order = 0) //this hook is executed before each Scenario
    public void startChromeDriver(){

        System.out.println("------------------------");
        System.out.println("** Chrome Global before hook **");
        System.out.println("------------------------");
    }

    @After(order = 0)//this hook is executed after each Scenario
    public void closeDriver(){
        chromeDriver.quit();
        System.out.println("-----------------------");
        System.out.println("** Chrome Global after hook **");
        System.out.println("-----------------------");
    }

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }
}

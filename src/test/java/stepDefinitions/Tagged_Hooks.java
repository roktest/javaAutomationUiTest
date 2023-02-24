package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DependencyUtilities;

public class Tagged_Hooks {

    WebDriver driver;
    DependencyUtilities dependencyUtilitiesService;

    public Tagged_Hooks(DependencyUtilities dependencyUtilitiesService, CommonSteps commonSteps){
        super();
        this.dependencyUtilitiesService = dependencyUtilitiesService;
        this.driver = commonSteps.getChromeDriver();
        this.dependencyUtilitiesService = dependencyUtilitiesService;
    }

    @Before(order = 1, value = "@setCookies") //will be executed before the scenarios which have @setCookies as particular tag
    public void setCookies() {
        System.out.println("------------------------------------------------");
        System.out.println("** Scenario specific before hook - setCookies **");
        System.out.println("------------------------------------------------");
    }

    @After(order = 1, value = "@unsetCookies") //will be executed after the scenarios which have @unsetCookies as particular tag
    public void unsetCookies(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", " Status: " + scenario.getStatus().toString() + ". Click to see attached screenshot");
        System.out.println("-----------------------------------------------");
        System.out.println("** Scenario specific after hook - setCookies **");
        System.out.println("-----------------------------------------------");
    }
}

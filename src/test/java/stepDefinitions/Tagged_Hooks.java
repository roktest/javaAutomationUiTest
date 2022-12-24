package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Tagged_Hooks {

    WebDriver driver;

    public Tagged_Hooks(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
    }

    @Before(order = 1, value = "@setCookies") //will be executed before the scenarios which have @setCookies as particular tag
    public void setCookies(){
        System.out.println("------------------------------------------------");
        System.out.println("** Scenario specific before hook - setCookies **");
        System.out.println("------------------------------------------------");
    }

    @After(order = 1, value = "@unsetCookies") //will be executed after the scenarios which have @unsetCookies as particular tag
    public void unsetCookies(){
        System.out.println("-----------------------------------------------");
        System.out.println("** Scenario specific after hook - setCookies **");
        System.out.println("-----------------------------------------------");
    }
}

package actionFactories;

import org.openqa.selenium.WebDriver;
import stepDefinitions.CommonSteps;

public class CommonActions {

    WebDriver driver;

    public CommonActions(CommonSteps commonSteps){
        this.driver = commonSteps.getChromeDriver();
    }

    public void go_to_url(String url){
        driver.get(url);
    }

    public String get_current_url(){
        return driver.getCurrentUrl();
    }

    public String get_page_title(){
        return driver.getTitle();
    }

}

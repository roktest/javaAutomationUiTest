package enums;

/**
 * Class to group constants
 */
public enum Enums {

    CHROME_DRIVER_PATH("C:/Users/Rodri/intellij-workspace/com.ebay.automation.demo/src/test/resources/drivers/chromedriver.exe"),
    CHROME_DRIVER_KEY("webdriver.chrome.driver"),
    FIREFOX_DRIVER_PATH("C:/Users/Rodri/intellij-workspace/com.ebay.automation.demo/src/test/resources/drivers/geckodriver.exe"),
    FIREFOX_DRIVER_KEY("webdriver.gecko.driver"),
    EBAY_URL("https://www.ebay.com/");

    private String enums;

    private Enums(String enums) {
        this.enums = enums;
    }

    public String getEnum(){
        return this.enums;
    }

}

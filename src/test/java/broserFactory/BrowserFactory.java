package broserFactory;

public class BrowserFactory {

    public static IBrowser open(String browserName){
        IBrowser browser;

        switch (browserName.toLowerCase()){
            case "chrome":
                browser = new ChromeBrowser();
                break;
            default:
                browser = new FirefoxBrowser();
                break;
        }

        return browser;
    }
}

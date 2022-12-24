package actionFactories;

import org.openqa.selenium.WebDriver;
import pageFactories.EbayAdvanceSearch_ElementsFactory;
import stepDefinitions.CommonSteps;

public class EbayAdvanceSearch_ActionsFactory {

    private WebDriver driver;

    EbayAdvanceSearch_ElementsFactory ebayAdvanceSearchElements;

    public EbayAdvanceSearch_ActionsFactory(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
        this.ebayAdvanceSearchElements = new EbayAdvanceSearch_ElementsFactory(driver);
        // we can instantiate another ElementFactory if we need it
    }

    public void click_on_ebay_logo(){
        ebayAdvanceSearchElements.ebayLogo.click();
    }

    public void enter_keyword(String keyWord){
        ebayAdvanceSearchElements.searchKeywordInput.sendKeys(keyWord);
    }

    public void enter_excludeword(String excludeKeyWord){
        ebayAdvanceSearchElements.excludeKeywordInput.sendKeys(excludeKeyWord);
    }

    public void enter_minimum(String minimum){
        ebayAdvanceSearchElements.maximumPrice.sendKeys(minimum);
    }

    public void enter_maximum(String maximum){
        ebayAdvanceSearchElements.maximumPrice.sendKeys(maximum);
    }

    public void click_search_button(){
        ebayAdvanceSearchElements.searchButton.click();
    }

}

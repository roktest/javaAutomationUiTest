package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvanceSearch_ElementsFactory {

    WebDriver driver;

    @FindBy(id = "gh-la") public WebElement ebayLogo;
    @FindBy(id = "_nkw") public WebElement searchKeywordInput;
    @FindBy(id = "_ex_kw") public WebElement excludeKeywordInput;
    @FindBy( xpath = "//*[@id='adv_search_from']/fieldset[3]/input[2]") public WebElement minimumPrice;
    @FindBy( xpath = "//*[@id='adv_search_from']/fieldset[3]/input[3]") public WebElement maximumPrice;
    @FindBy(id = "searchBtnLowerLnk") public WebElement searchButton;

    public EbayAdvanceSearch_ElementsFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}

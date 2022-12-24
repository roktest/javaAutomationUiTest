package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHome_ElementsFactory {

    WebDriver driver;

    @FindBy(id = "gh-as-a") public WebElement advanceSearchButton;
    @FindBy(id = "gh-ac") public WebElement searchKeywordInput;
    @FindBy(id = "gh-btn") public WebElement searchButton;
    @FindBy(xpath = "//*[@id='mainContent']/div[1]/div/div[2]/div[1]/div[1]/h1/span[1]") public WebElement searchResultsWithDot;
    @FindBy(id = "gh-cat") public WebElement categoryDropDownButton;
    @FindBy(xpath = "//select[@id='gh-cat']/option") public List<WebElement> categoriesDropDown;

    public EbayHome_ElementsFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}

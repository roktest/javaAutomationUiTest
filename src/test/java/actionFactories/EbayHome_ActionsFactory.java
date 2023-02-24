package actionFactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageFactories.EbayHome_ElementsFactory;
import stepDefinitions.CommonSteps;

import java.util.List;


public class EbayHome_ActionsFactory {

    private WebDriver driver;
    EbayHome_ElementsFactory ebayHomeElements;

    public EbayHome_ActionsFactory(CommonSteps commonSteps){
        this.driver = commonSteps.getChromeDriver();
        this.ebayHomeElements = new EbayHome_ElementsFactory(driver);
    }

    public void click_on_advanced_search_from_home_page(){
        ebayHomeElements.advanceSearchButton.click();
    }

    public void search_for_item_on_ebay_home_page(String item){
        ebayHomeElements.searchKeywordInput.sendKeys(item);
    }

    public void click_on_search_button(){
        ebayHomeElements.searchButton.click();
    }

    public void click_on_navbar_option_by_text(String text){
        driver.findElement(By.linkText(text)).click();
    }

    public int get_items_count(){
        String strResult = ebayHomeElements.searchResultsWithDot.getText();
        String strNumber = strResult.replace(".", "");
        return Integer.parseInt(strNumber);
    }

    public void click_on_category_dropdown_button(){
        ebayHomeElements.categoryDropDownButton.click();
    }

    public void search_for_item_on_category(String categoryToSearch){
        List<WebElement> categoriesList = ebayHomeElements.categoriesDropDown;
        for (WebElement category: categoriesList) {
            if(categoryToSearch.equalsIgnoreCase(category.getText())){
                category.click();
                break;
            }
        }
    }
}

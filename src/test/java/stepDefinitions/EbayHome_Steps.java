package stepDefinitions;

import actionFactories.CommonActions;
import actionFactories.EbayHome_ActionsFactory;
import enums.Enums;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DependencyUtilities;
import utilities.ExcelConfiguration;
import utilities.ExcelDataReader;
import utilities.IDataReader;

import java.util.List;
import java.util.Map;

public class EbayHome_Steps {
    DependencyUtilities dependencyUtilitiesService;
    CommonActions commonActions;
    EbayHome_ActionsFactory ebayHomeActionsFactory;

    public EbayHome_Steps(DependencyUtilities dependencyUtilitiesService, CommonActions commonActions, EbayHome_ActionsFactory ebayHomeActionsFactory) {
        super();
        this.dependencyUtilitiesService = dependencyUtilitiesService;
        this.commonActions = commonActions;
        this.ebayHomeActionsFactory = ebayHomeActionsFactory;
    }

    @Given("I am on Ebay home page")
    public void i_am_on_ebay_home_page() throws Exception{
        //driver.get(Enums.EBAY_URL.getEnum());
        commonActions.go_to_url(Enums.EBAY_URL.getEnum());
        Thread.sleep(1500);
    }

    @When("I click on Advanced search")
    public void i_click_on_advanced_search() {
        //driver.findElement(By.id("gh-as-a")).click();
        ebayHomeActionsFactory.click_on_advanced_search_from_home_page();
    }

    @Then("I navigate to Advanced search page")
    public void i_navigate_to_advanced_search_page() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        //String actualUrl = driver.getCurrentUrl();
        String actualUrl = commonActions.get_current_url();
        try {
            Assert.assertEquals(expectedUrl, actualUrl);
            System.out.println("Test passed");
        } catch (AssertionError e) {
            Assert.fail();
            System.out.println("Test failed");
        }
    }

    @When("I search for {string} on Ebay home page")
    public void i_search_for_iphone_on_ebay_home_page(String thingToSearch) {
        /*
        driver.findElement(By.id("gh-ac")).sendKeys(thingToSearch);
        driver.findElement(By.id("gh-btn")).click();
        */
        ebayHomeActionsFactory.search_for_item_on_ebay_home_page(thingToSearch);
        ebayHomeActionsFactory.click_on_search_button();
    }

    @Then("I validate at least {} search items present")
    public void i_validate_at_least_search_items_present(int intNumber) {
        //String stringSearchResultsWithDot = driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div/div[2]/div[1]/div[1]/h1/span[1]")).getText();
        //String countSearchResults = Integer.parseInt(stringSearchResultsWithDot.replace(".", ""));
        int countSearchResults = ebayHomeActionsFactory.get_items_count();
        try {
            Assert.assertTrue(countSearchResults > intNumber);
            System.out.println("Test passed");
        } catch (AssertionError e) {
            Assert.fail();
            System.out.println("Test failed");
        }
    }

    @When("I search for {string}, on {string} category on Ebay home page")
    public void i_search_for_item_on_category_on_ebay_home_page(String thingToSearch, String categoryToSearch) {
        /*driver.findElement(By.id("gh-ac")).sendKeys(thingToSearch);
        driver.findElement(By.cssSelector("#gh-cat")).click();
        List<WebElement> categoriesList = driver.findElements(By.cssSelector("#gh-cat option"));
        for (WebElement category: categoriesList) {
            if(categoryToSearch.equalsIgnoreCase(category.getText())){
                category.click();
                break;
            }
        }
        driver.findElement(By.id("gh-btn")).click();*/
        ebayHomeActionsFactory.search_for_item_on_ebay_home_page(thingToSearch);
        ebayHomeActionsFactory.click_on_category_dropdown_button();
        ebayHomeActionsFactory.search_for_item_on_category(categoryToSearch);
        ebayHomeActionsFactory.click_on_search_button();
    }

    @When("I click on navigation bar {string} of the Ebay home page")
    public void i_click_on_navigation_bar_of_the_ebay_home_page(String navBarOption) throws Exception{
        //driver.findElement(By.linkText(navBarOption)).click();
        ebayHomeActionsFactory.click_on_navbar_option_by_text(navBarOption);
        Thread.sleep(1000);
    }

    @Then("I want validate if the page navigates to {string} and that page title {string} changes accordingly")
    public void i_want_validate_if_the_page_navigates_to_and_that_page_title_changes_accordingly(String expectedUrl, String expectedPageTitle) throws Exception{
        //String currentUrl = driver.getCurrentUrl();
        //String currentPageTitle = driver.getTitle();
        String currentUrl = commonActions.get_current_url();
        String currentPageTitle = commonActions.get_page_title();
        try {

            Assert.assertTrue(currentUrl.equalsIgnoreCase(expectedUrl));
            Assert.assertTrue(currentPageTitle.contains(expectedPageTitle));
            System.out.println("Test passed");
            Thread.sleep(1000);
        } catch (AssertionError e) {
            Assert.fail();
            System.out.println("Test failed");
        }
    }

    @And("I have the excel file and its location with the available menus")
    public void i_have_the_excel_file_and_its_location_with_the_available_menus(IDataReader dataTable) {
        System.out.println(dataTable.getAllRows());
        List<Map<String, String>> data = dataTable.getAllRows();
        System.out.println(data.get(3).get("expectedPageTitle"));
    }

    // create another method for the excel file
    // parameter to the method will be a map object
    // IDataReader will be return type
    // @DataTableType will let the cucumber framework know that we have a different implementation for converting the data table
    @DataTableType
    public IDataReader excelToDataTable(Map<String, String> entry){
        // [Excel=<fileName>, ExcelLocation=<FileLocation>, ...]
        ExcelConfiguration excelConfiguration = new ExcelConfiguration.ExcelConfigurationBuilder()
                .setFileName(entry.get("Excel"))
                .setFileLocation(entry.get("Location"))
                .setSheetName(entry.get("Sheet"))
                .setIndex(Integer.valueOf(entry.getOrDefault("Index", "0")))
                .build();
        return new ExcelDataReader(excelConfiguration);
    }

}

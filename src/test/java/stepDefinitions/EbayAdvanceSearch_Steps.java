package stepDefinitions;

import actionFactories.CommonActions;
import actionFactories.EbayAdvanceSearch_ActionsFactory;
import enums.Enums;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DependencyUtilities;

public class EbayAdvanceSearch_Steps {
    DependencyUtilities dependencyUtilitiesService;
    CommonActions commonActions;
    EbayAdvanceSearch_ActionsFactory ebayAdvanceSearchActionsFactory;

    public EbayAdvanceSearch_Steps(DependencyUtilities dependencyUtilitiesService, CommonActions commonActions, EbayAdvanceSearch_ActionsFactory ebayAdvanceSearchActionsFactory){
        super();
        this.dependencyUtilitiesService = dependencyUtilitiesService;
        this.commonActions = commonActions;
        this.ebayAdvanceSearchActionsFactory = ebayAdvanceSearchActionsFactory;
    }

    @Given("I am on Ebay advance search page")
    public void i_am_on_ebay_advance_search_page() {
        //driver.get(Enums.EBAY_URL.getEnums() + "/sch/ebayadvsearch");
        commonActions.go_to_url(Enums.EBAY_URL.getEnum() + "/sch/ebayadvsearch");
    }

    @When("I click on Ebay logo")
    public void i_click_on_ebay_logo() {
        //driver.findElement(By.id("gh-la")).click();
        ebayAdvanceSearchActionsFactory.click_on_ebay_logo();
    }

    @Then("I navigate to Ebay home page")
    public void i_navigate_to_ebay_home_page() {
        String expectedUrl = Enums.EBAY_URL.getEnum();
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

    @When("I enter a keyword, exclude word, minimum and maximum fields")
    public void i_enter_a_keyword_excludeword_minimum_and_maximum_fields(DataTable dataTable) throws Exception{
        /* driver.findElement(By.id("_nkw")).sendKeys(dataTable.cell(1, 0));
        driver.findElement(By.id("_ex_kw")).sendKeys(dataTable.cell(1, 1));
        driver.findElement(By.xpath("//*[@id='adv_search_from']/fieldset[3]/input[2]")).sendKeys(dataTable.cell(1, 2));
        driver.findElement(By.xpath("//*[@id='adv_search_from']/fieldset[3]/input[3]")).sendKeys(dataTable.cell(1, 3));
        Thread.sleep(1000);
        driver.findElement(By.id("searchBtnLowerLnk")).click();*/
        ebayAdvanceSearchActionsFactory.enter_keyword(dataTable.cell(1, 0));
        ebayAdvanceSearchActionsFactory.enter_excludeword(dataTable.cell(1, 1));
        ebayAdvanceSearchActionsFactory.enter_maximum(dataTable.cell(1, 2));
        ebayAdvanceSearchActionsFactory.enter_minimum(dataTable.cell(1, 3));
        Thread.sleep(1000);
        ebayAdvanceSearchActionsFactory.click_search_button();
    }

}

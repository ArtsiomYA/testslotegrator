package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.AdminPanelPage;
import pages.Helper;
import utils.ChromeWebDriver;

public class AdminPanelStepdefs {

    private Helper helper = new Helper();
    private AdminPanelPage adminPanelPage = new AdminPanelPage(ChromeWebDriver.getInstanceDriver());

    @And("Click on the option in the menu")
    public void clickOnTheOptionInTheMenu() {
        adminPanelPage.getOptionUsers().click();
    }

    @And("Click on the option in the Users menu")
    public void clickOnTheOptionInTheUsersMenu() {
        adminPanelPage.getOptionPlayers().click();
    }

    @Then("Show list users the Dashboard")
    public void showListUsersTheDashboard() {
        helper.waitIsVisibleElement(adminPanelPage.getTableUsers());
    }

    @When("click on the status drop down")
    public void clickOnTheStatusDropDown() {
        adminPanelPage.getDropDownStatus().click();
    }

    @And("click on not active status")
    public void clickOnNotActiveStatus() {
        adminPanelPage.getOptionNotActive().click();
    }

    @Then("Show players with status not active")
    public void showPlayersWithStatusNotActive() {
        helper.waitIsVisibleElements(adminPanelPage.getStatusList());
        Assertions.assertEquals(1, adminPanelPage.getStatusList().stream().filter(x->x.getText().contains("Not active")).count());
    }

}

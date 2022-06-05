package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import utils.ChromeWebDriver;

public class AuthorizationStepdefs {

    private WebDriver driver = ChromeWebDriver.getInstanceDriver();

    private SignInPage signInPage = new SignInPage(driver);

    @Then("Open page {string}")
    public void openPage(String arg0) {
        driver.get(arg0);
    }

    @Then("Input login {string}")
    public void inputLogin(String arg0) {
        signInPage.getInputLogin().sendKeys(arg0);
    }

    @And("Input password {string}")
    public void inputPassword(String arg0) {
        signInPage.getInputPassword().sendKeys(arg0);
    }

    @Then("Click button")
    public void clickButton() {
        signInPage.getButtonSubmit().click();
    }

    @Then("Title shows it the Admin Panel")
    public void titleShowsItTheAdminPanel() {
        Assertions.assertEquals("Dashboard - Casino", driver.getTitle());
    }
}

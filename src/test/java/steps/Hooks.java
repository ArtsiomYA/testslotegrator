package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import utils.ChromeWebDriver;

@Data
public class Hooks {

    private WebDriver driver = ChromeWebDriver.getInstanceDriver();

    @Before
    public void init() {
        driver = ChromeWebDriver.getInstanceDriver();
    }

    @After
    public void destroy() {
        driver.quit();
    }

}

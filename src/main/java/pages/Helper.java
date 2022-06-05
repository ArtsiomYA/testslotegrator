package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ChromeWebDriver;

import java.time.Duration;
import java.util.List;

public class Helper {

    private WebDriver driver = ChromeWebDriver.getInstanceDriver();

    public void waitIsVisibleElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitIsVisibleElements(List<WebElement> elements) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}

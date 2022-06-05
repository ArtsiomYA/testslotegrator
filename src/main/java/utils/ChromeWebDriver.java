package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeWebDriver {

    private static WebDriver webDriver;

    private ChromeWebDriver() {

    }

    public static synchronized WebDriver getInstanceDriver() {
        return (webDriver == null) ? webDriver = initDriver() : webDriver;
    }

    private static WebDriver initDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
//        webDriver = new ChromeDriver(options);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return webDriver;
    }

}

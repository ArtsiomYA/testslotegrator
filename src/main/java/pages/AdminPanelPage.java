package pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class AdminPanelPage {

    private WebDriver driver;

    public AdminPanelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='main-side-menu']//li[8]")
    private WebElement optionUsers;

    @FindBy(xpath = "//ul[@class='collapse in']//li[1]")
    private WebElement optionPlayers;

    @FindBy(css = ".table")
    private WebElement tableUsers;

    @FindBy(name = "PlayerSearch[status]")
    private WebElement dropDownStatus;

    @FindBy(xpath = "//*[text()='Not active']")
    private WebElement optionNotActive;

    @FindBy(xpath = "//tbody//tr//td[@class='checkbox-column']/preceding::td[1]")
    private List<WebElement> statusList;

}

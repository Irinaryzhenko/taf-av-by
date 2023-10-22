package ui.testing;

import driver.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class FinancePage {
    WebDriver driver;
    private String financeTitleDescriptionLocator = "//div[@class = 'finance-type__description']";

    public FinancePage() {
        driver = Singleton.getDriver();
    }
    public String getFinanceTitleText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(By.xpath(financeTitleDescriptionLocator)).getText();
    }
}


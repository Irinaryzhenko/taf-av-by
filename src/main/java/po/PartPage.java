package po;

import driver.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartPage {
    WebDriver driver;
    private String partTitlePageLocator = "//h1[@class='heading__text']";

    public PartPage() {
        driver = Singleton.getDriver();
    }
    public String getPartTitlePageText() {
        return driver.findElement(By.xpath(partTitlePageLocator)).getText();
    }
}

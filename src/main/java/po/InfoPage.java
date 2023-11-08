package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class InfoPage {
    WebDriver driver;
    private String infoPageTitleTextLocator = "//h1[@class = 'heading-title']";

    public InfoPage() {
        driver = Driver.getDriver();
    }
    public String getInfoPageTitleText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElement(By.xpath(infoPageTitleTextLocator)).getText();
    }
}

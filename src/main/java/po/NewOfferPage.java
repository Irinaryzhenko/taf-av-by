package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class NewOfferPage {
    WebDriver driver;
    private String newOfferTitleLocator = "//div[@class = 'heading__main']/h1[@class = 'heading__text']";

    public NewOfferPage() {
        driver = Driver.getDriver();
    }
    public String getNewOfferTitleText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       return driver.findElement(By.xpath(newOfferTitleLocator)).getText();
    }
}

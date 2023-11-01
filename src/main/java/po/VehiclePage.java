package po;

import driver.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Waiter;

import java.time.Duration;

public class VehiclePage {
    WebDriver driver;
    private String transportTitleLocator = "//h1[@class = 'heading__text']";

    public VehiclePage() {
        driver = Singleton.getDriver();
    }
    public String getTransportTitleText() {
        Waiter.waitFor(2);
        return driver.findElement(By.xpath(transportTitleLocator)).getText();
    }
}

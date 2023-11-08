package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehiclePage {
    WebDriver driver;
    private String transportTitleLocator = "//h1[@class = 'heading__text']";

    public VehiclePage() {
        driver = Driver.getDriver();
    }
    public String getTransportTitleText() {
        Driver.waitFor(2);
        return driver.findElement(By.xpath(transportTitleLocator)).getText();
    }
}

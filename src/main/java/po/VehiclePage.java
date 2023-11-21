package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehiclePage {
    WebDriver driver;
    private String transportTitleLocator = "//h1[@class = 'heading__text']";
    private String busPageTitleLocator = "//div[@class = 'heading__main']";

    public VehiclePage() {
        driver = Driver.getDriver();
    }
    public String getTransportTitleText() {
        Driver.waitFor(2);
        return driver.findElement(By.xpath(transportTitleLocator)).getText();
    }
    public String getBusPageTitleText() {
                return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(busPageTitleLocator)))
                .findElement(By.xpath(busPageTitleLocator)).getText();
    }
}

package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewsPage {
    WebDriver driver;
    private String newsPageTitleLocator = "//p[@class = 'journal-logo__tagline']";

    public NewsPage() {
        driver = Driver.getDriver();
    }
    public String getNewsTitleText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(newsPageTitleLocator)));
        return driver.findElement(By.xpath(newsPageTitleLocator)).getText();
    }
}

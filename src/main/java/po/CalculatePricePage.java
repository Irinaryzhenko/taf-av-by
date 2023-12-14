package po;

import driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class CalculatePricePage {
    WebDriver driver;
    private String selectCarBrandCalculationLocator = "//span[@class = 'catalog__description-text'][text()='Volkswagen']";
    private String selectCarModelCalculatorLocator = "//span[@class = 'catalog__description-text'][text() ='Sharan']";
    private String selectCarYearCalculatorLocator = "//span[@class = 'catalog__description-text'][text() ='2019']";
    private String selectGenerationLocator = "//div[@class = 'generations__content']";
    private String resultPriceLocator = "//h2[@class = 'stats__price-primary']";
    private String actualCalculateResult;
    public CalculatePricePage() {
        driver = Driver.getDriver();
    }
    public void selectCarBrandForCalculation() {
        driver.findElement(By.xpath(selectCarBrandCalculationLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void selectCarModelCalculatorLocator() {
        driver.findElement(By.xpath(selectCarModelCalculatorLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void selectCarYearCalculatorLocator() {
        driver.findElement(By.xpath(selectCarYearCalculatorLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public void selectCarGenerationCalculatorLocator() {
        driver.findElement(By.xpath(selectGenerationLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public String getResultPriceText() {
        actualCalculateResult = driver.findElement(By.xpath(resultPriceLocator)).getText();
        return actualCalculateResult;
    }
    public void checkPriceResult() {
        int price = Integer.parseInt(actualCalculateResult.replaceAll("[^0-9]", ""));
        Assertions.assertTrue((actualCalculateResult.contains("~")&&actualCalculateResult.contains("$"))
                && (price > 15000 && price < 30000));
    }
}

package po;

import driver.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VinCheckPage {
    WebDriver driver;
    private String vinCheckPageTitleLocator = "//h1[@class = 'heading__text']";
    private String inputVinCodeFieldLocator = "//input[@class = 'form-control form-control--large']";
    private String checkVinCodeButtonLocator = "//div [@class = 'vin-main']//button[@class = 'button button--primary button--block button--large']";
    private String buyVinCodeResultButtonLocator = "//div [@class = 'vin-check-services']//button[@class = 'button button--secondary button--block button--large']";
    private String errorNumberVinMessageLocator = "//div[@class = 'error-message'][text() = 'VIN-номер состоит из 17 символов']";
    private String errorVinFormatMessageLocator = "//div[@class = 'error-message'][text() = 'Неверно указан VIN-номер']";

    public VinCheckPage() {
        driver = Singleton.getDriver();
    }
    public String getVinCheckPageTitleText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElement(By.xpath(vinCheckPageTitleLocator)).getText();
    }
    public void fillInputVinCodeField(String vinCode) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          driver.findElement(By.xpath(inputVinCodeFieldLocator)).sendKeys(vinCode);
    }
    public void clickCheckVinCode() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath(checkVinCodeButtonLocator)).click();
    }
    public String getBuyVinCodeResultButtonText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(buyVinCodeResultButtonLocator)));
       return driver.findElement(By.xpath(buyVinCodeResultButtonLocator)).getText();
    }
    public String getErrorNumberVinMessageText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorNumberVinMessageLocator)));
       return driver.findElement(By.xpath(errorNumberVinMessageLocator)).getText();
    }
    public String getErrorVinFormatMessageText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorVinFormatMessageLocator)));
        return driver.findElement(By.xpath(errorVinFormatMessageLocator)).getText();
    }
}

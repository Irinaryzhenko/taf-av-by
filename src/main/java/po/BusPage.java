package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BusPage {
    private WebDriver driver;
    private String selectedBusLocator = "//li[@class ='dropdown__listitem']/ button[@data-item-label = 'Fiat']";
    private String selectedBusModelLocator = "//li[@class ='dropdown__listitem']/button[@data-item-label = 'Ducato']";
    private String quantityOfSeatsFromLocator = "//span[@class = 'dropdown-floatlabel__value'][text() = 'Кол-во мест от']";
    private String quantityOfSeatsUntilLocator = "//div[@id='p-7-seats_count']//span[@class = 'dropdown-floatlabel__value'][text() = 'до']";
    private String selectedQuantitySeatsFromLocator = "//ul[@class = 'dropdown-list dropdown-list--opened']/li [@class = 'dropdown__listitem']/button[@data-item-label = '8']";
    private String selectedQuantitySeatsUntilLocator = "//ul[@class = 'dropdown-list dropdown-list--opened']/li [@class = 'dropdown__listitem']/button[@data-item-label = '10']";
    private String busCapacityDropDownFromLocator = "//div[@class='dropdown__box']/button[@name = 'p-14-engine_capacity']//span[@class = 'dropdown-floatlabel__value'][text() = 'Объём от']";
    private String busCapacityDropDownUntilLocator = "//div[@class='dropdown__box']/button[@name = 'p-14-engine_capacity']//span[@class = 'dropdown-floatlabel__value'][text() = 'до']";
    private String selectedBusCapacityFromLocator = "//ul[@class = 'dropdown-list dropdown-list--opened']/li[@class = 'dropdown__listitem']/button[@data-item-label = '1,4 л.']";
    private String selectedBusCapacityUntilLocator = "//ul[@class = 'dropdown-list dropdown-list--opened']/li[@class = 'dropdown__listitem']/button[@data-item-label = '3,0 л.']";
    private String mechanicTransmissionTypeLocator = "//label[@for = 'p-12-transmission_type_2']";
    private String engineTypeDropDownLocator = "//button[@name = 'p-13-engine_type']";
    private String selectedDiselEngineTypeLocator = "//span[@class = 'checkbox__description'][text() = 'дизель']";
    private String mileageDropDownLocator = "//button[@name = 'p-15-mileage_km']";
    private String selectedMileageLocator = "//li[@ class= 'dropdown__listitem']/button[@data-item-label = 'до 600 тыс.']";
    public BusPage() {
        this.driver = Driver.getDriver();
    }
    public void selectBusBrand() {
        Driver.waitFor(3);
                driver.findElement(By.xpath(selectedBusLocator)).click();
//        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3))
//                .until(ExpectedConditions
//                        .presenceOfElementLocated(By.xpath(selectedBusLocator))).click();
    }
    public void selectBusModel() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectedBusModelLocator))).click();
    }
    public void openQuantitySetsFromDropDownMenu() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(quantityOfSeatsFromLocator))).click();
    }
    public void openQuantitySetsUntilDropDownMenu() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(quantityOfSeatsUntilLocator))).click();
    }
    public void selectQuantityOfSeatsFrom() {
        driver.findElement(By.xpath(selectedQuantitySeatsFromLocator)).click();
    }
    public void selectQuantityOfSeatsUntil() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectedQuantitySeatsUntilLocator))).click();
    }
    public void openBusCapacityDropDownFrom() {
        driver.findElement(By.xpath(busCapacityDropDownFromLocator)).click();
    }
    public void openBusCapacityDropDownUntil() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(busCapacityDropDownUntilLocator))).click();
    }
    public void selectBusEngineCapacityFrom() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectedBusCapacityFromLocator))).click();
    }
    public void selectBusEngineCapacityUntil() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectedBusCapacityUntilLocator))).click();
    }
    public void selectMechanicTransmissionType() {

        driver.findElement(By.xpath(mechanicTransmissionTypeLocator)).click();
    }
    public void openEngineTypeDropDown() {
        driver.findElement(By.xpath(engineTypeDropDownLocator)).click();
    }
    public void selectDiselEngine() {
        driver.findElement(By.xpath(selectedDiselEngineTypeLocator)).click();
    }
    public void openMileageDropDown() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(mileageDropDownLocator))).click();
    }
    public void selectMileage() {
        driver.findElement(By.xpath(selectedMileageLocator)).click();
    }
}

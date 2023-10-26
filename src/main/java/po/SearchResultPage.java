package po;

import domain.search.Car;
import driver.Singleton;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Waiter;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    private String topCarResultLocator = "//div[@class = 'listing__top']";
    private String topCarTitleLocator = "//h3[@class ='listing-top__title']";
    private String topCarPriceLocator = "//div[@class ='listing-top__price-usd']";
    private String topCarParamsLocator = "//div[@class ='listing-top__summary']/div[@class='listing-top__params']";
    private String carParamsLocator = "//div[@class = 'listing-item__params']";
    private String actualTitle;
    private int actualPrice;
    boolean isPriceInRange;
    private boolean isYearInRange;
    private int actualYear;
    private boolean isCapacityInRange;
    private double actualCapacity;

    public SearchResultPage() {
        driver = Singleton.getDriver();
    }

    public String getTopCarResultText() {
        return driver.findElement(By.xpath(topCarResultLocator)).getText();
    }

    public String getTitleTopCarText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(By.xpath(topCarTitleLocator)).getText();
    }

    public String getTopCarPriceText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(By.xpath(topCarPriceLocator)).getText();
    }

    public void getCarSearchTopResult() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String actualTitleTopCar = getTitleTopCarText();
        String actualPriceTopCar = getTopCarPriceText();
        int price = Integer.parseInt(actualPriceTopCar.replaceAll("[^0-9]", ""));
        boolean isPriceInRange = price >= 10000 && price <= 50000;
        Assertions.assertTrue((actualTitleTopCar.contains("Audi Q2")) && isPriceInRange);
    }

    public void getCarTitleSearchResults() {
        Waiter.waitFor(3);
        List<WebElement> searchTitles = driver.findElements(By.xpath("//div[@class = 'listing__items']/div/div/div/h3/a/span"));
        for (WebElement element : searchTitles) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                actualTitle = element.getText();
            } catch (Exception e) {
                System.out.println("Error! Text not found");
            }
        }
    }

    public void getCarPriceSearchResult() {
        Waiter.waitFor(5);
        List<WebElement> searchPrices = driver.findElements(By.xpath("//div[@class = 'listing-item__priceusd']"));
        for (WebElement element : searchPrices) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                String price = element.getText();
                actualPrice = Integer.parseInt(price.replaceAll("[^0-9]", ""));
                isPriceInRange = actualPrice >= 10000 && actualPrice <= 50000;
            } catch (Exception e) {
                System.out.println("Error! Price not found");
            }
        }
    }

    public void checkCarSearchParamsText() {
        List<WebElement> paramsResults = driver.findElements(By.xpath(carParamsLocator));
        for (WebElement element : paramsResults) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                String actualParamText = element.getText();
                String year = actualParamText.substring(0, 4);
                actualYear = Integer.parseInt(year);
                isYearInRange = actualYear >= 2015 && actualYear <= 2023;

                String str = actualParamText.substring(8);
                String[] arr = str.split(", ");
                actualCapacity = Double.parseDouble(arr[1].substring(0, 3));
                isCapacityInRange = actualCapacity >= 1.6 && actualCapacity <= 3.0;

            } catch (Exception e) {
                System.out.println("Error! Param Text not found");
            }
        }
    }

    public void checkCarSearchResult() {
        Assertions.assertTrue((actualTitle.contains("Audi Q2 I")) && isPriceInRange
                        && isYearInRange && isCapacityInRange,
                "Warning! Search result don't match with request query!");
        //        Car expectedCar = new Car("Audi Q2 I", 1.6, 2018, 21200);
//        Car actualCar = new Car(actualTitle, actualCapacity, actualYear, actualPrice);
//        Assertions.assertEquals(expectedCar, actualCar);
    }
}

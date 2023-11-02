package po;

import domain.constant.Constant;
import driver.Singleton;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Waiter;
import java.time.Duration;
import java.util.List;


public class SearchResultPage {
    WebDriver driver;
    private String topCarTitleLocator = "//h3[@class ='listing-top__title']";
    private String topCarPriceLocator = "//div[@class ='listing-top__price-usd']";
    private String topCarParamsLocator = "//div[@class = 'listing-top__params']";
    private String carParamsLocator = "//div[@class = 'listing-item__params']";
    private String carTitleLocator = "//div[@class = 'listing__items']/div/div/div/h3/a/span";
    private String carPriceLocator = "//div[@class = 'listing-item__priceusd']";
    private String actualTitle;
    boolean isPriceInRange;
    private boolean isYearInRange;
    private boolean isCapacityInRange;
    private static Logger logger = LoggerFactory.getLogger(SearchResultPage.class);
    public SearchResultPage() {
        driver = Singleton.getDriver();
    }
    public String getTitleTopCarText() {
        try {
            Waiter.waitFor(2);
            return driver.findElement(By.xpath(topCarTitleLocator)).getText();
        } catch (Exception e) {
            logger.error("No top car title was found");
        } return null;
    }

    public String getTopCarPriceText() {
        try {
            Waiter.waitFor(1);
            return driver.findElement(By.xpath(topCarPriceLocator)).getText();
        } catch (Exception e) {
            logger.error("No top price was found");
        } return null;
    }

    public String getTopCarParamsText() {
        try {
            Waiter.waitFor(1);
            return driver.findElement(By.xpath(topCarParamsLocator)).getText();
        } catch (Exception e) {
           logger.error("No top text was found");
        }
        return null;
    }

    public void checkCarSearchTopResult() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualTitleTopCar = getTitleTopCarText();;
        String actualPriceTopCar = getTopCarPriceText();
        if (actualTitleTopCar !=null && actualPriceTopCar !=null) {
            int topPrice = Integer.parseInt(actualPriceTopCar.replaceAll("[^0-9]", ""));
            boolean isTopPriceInRange = topPrice >= 10000 && topPrice <= 50000;

            String topYear = getTopCarParamsText();
            String actualTopYear = topYear.substring(0, 4);
            int yearTopCar = Integer.parseInt(actualTopYear);
            boolean isTopYearInRange = yearTopCar >= 2015 && yearTopCar <= 2023;

            String str = topYear.substring(8);
            String[] arr = str.split(", ");
            double actualTopCapacity = Double.parseDouble(arr[1].substring(0, 3));
            boolean isTopCapacityInRange = actualTopCapacity >= 1.6 && actualTopCapacity <= 3.0;

            Assertions.assertTrue((actualTitleTopCar.contains("Audi Q2"))
                            && isTopPriceInRange && isTopYearInRange && isTopCapacityInRange,
                    "Warning! Top Results do not match with search query!");
        } else {
            logger.error("There is no top car offer!");
        }
    }

        //        Car expectedCar = new Car("Audi Q2 I", 1.6, 2018, 19800);
//        Car actualCar = new Car(actualTitleTopCar, actualTopCapacity, yearTopCar, topPrice);
//        Assertions.assertEquals(expectedCar, actualCar);
//    }

    public void getCarTitleSearchResults() {
        Waiter.waitFor(3);
        List<WebElement> searchTitles = driver.findElements(By.xpath(carTitleLocator));
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
        List<WebElement> searchPrices = driver.findElements(By.xpath(carPriceLocator));
        for (WebElement element : searchPrices) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                String price = element.getText();
                int actualPrice = Integer.parseInt(price.replaceAll("[^0-9]", ""));
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
                int actualYear = Integer.parseInt(year);
                isYearInRange = actualYear >= 2015 && actualYear <= 2023;

                String str = actualParamText.substring(8);
                String[] arr = str.split(", ");
               double actualCapacity = Double.parseDouble(arr[1].substring(0, 3));
                isCapacityInRange = actualCapacity >= 1.6 && actualCapacity <= 3.0;

            } catch (Exception e) {
                System.out.println("Error! Param Text not found");
            }
        }
    }

    public void checkCarSearchResult() {
        Assertions.assertTrue((actualTitle.contains(Constant.CAR_BRAND_SEARCH)) && isPriceInRange
                        && isYearInRange && isCapacityInRange,
                "Warning! Search result don't match with request query!");
        logger.info("Searching was successfully ended");
    }
}

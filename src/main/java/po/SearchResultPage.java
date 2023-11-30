package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    private String topCarTitleLocator = "//h3[@class ='listing-top__title']";
    private String topCarPriceLocator = "//div[@class ='listing-top__price-usd']";
    private String topCarParamsLocator = "//div[@class = 'listing-top__params']";
    private String carParamsLocator = "//div[@class = 'listing-item__params']";
    private String busParamsLocator = "//div[@class = 'listing-item__params']";
    private String carTitleLocator = "//div[@class = 'listing__items']/div/div/div/h3/a/span";
    private String busTitleLocator = "//h3[@class = 'listing-item__title']";
    private String carPriceLocator = "//div[@class = 'listing-item__priceusd']";
    private String busPriceLocator = "//div[@class = 'listing-item__priceusd']";
    private String actualTopTitle;

    private boolean isTopYearInRange;
    private boolean isTopPriceInRange;
    private boolean isTopCapacityInRange;
    private String actualCarTitle;
    private String actualBusTitle;
    private boolean isCarPriceInRange;
    private boolean isBusPriceInRange;
    private boolean isCarYearInRange;
    private boolean isBusYearInRange;
    private boolean isCarCapacityInRange;
    private boolean isBusCapacityInRange;
    private String actualBusTransmission;
    private String actualBusEngineType;
    private boolean isQuantityOfSeatsInRange;
    private static Logger logger = LoggerFactory.getLogger(SearchResultPage.class);

    public SearchResultPage() {
        driver = Driver.getDriver();
    }

    public String getTitleTopCarText() {
        try {
            Driver.waitFor(2);
            return driver.findElement(By.xpath(topCarTitleLocator)).getText();
        } catch (Exception e) {
            logger.error("No top car title was found");
        }
        return null;
    }

    public String getTopCarPriceText() {
        try {
            Driver.waitFor(2);
            return driver.findElement(By.xpath(topCarPriceLocator)).getText();
        } catch (Exception e) {
            logger.error("No top price was found");
        }
        return null;
    }

    public String getTopCarParamsText() {
        try {
            Driver.waitFor(2);
            return driver.findElement(By.xpath(topCarParamsLocator)).getText();
        } catch (Exception e) {
            logger.error("No top text was found");
        }
        return "";
    }

    public void getCarSearchTopResult() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actualTopTitle = getTitleTopCarText();
        String actualPriceTopCar = getTopCarPriceText();

        if (actualTopTitle != null && actualPriceTopCar != null) {
            int topPrice = Integer.parseInt(actualPriceTopCar.replaceAll("[^0-9]", ""));
            isTopPriceInRange = topPrice >= 10000 && topPrice <= 50000;

            String topYear = getTopCarParamsText();
            String actualTopYear = topYear.substring(0, 4);
            int yearTopCar = Integer.parseInt(actualTopYear);
            isTopYearInRange = yearTopCar >= 2015 && yearTopCar <= 2023;

            String str = topYear.substring(8);
            String[] arr = str.split(", ");
            double actualTopCapacity = Double.parseDouble(arr[1].substring(0, 3));
            isTopCapacityInRange = actualTopCapacity >= 1.6 && actualTopCapacity <= 3.0;
        } else {
//            actualTopTitle = "";
            logger.error("There is no top car offer!");
        }
    }

    public void getCarTitleSearchResults() {
        Driver.waitFor(2);
        List<WebElement> searchTitles = driver.findElements(By.xpath(carTitleLocator));
        if (searchTitles != null) {
            for (WebElement element : searchTitles) {
                try {
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                    actualCarTitle = element.getText();
                    logger.info("Car brand is {}", actualCarTitle);
                } catch (Exception e) {
                    logger.error("Error! Text not found");
                }
            }
        } else {
            logger.info("Not found any offers match with inputted search query");
        }
    }
    public void getBusTitleSearchResults() {
        Driver.waitFor(2);
        List<WebElement> searchTitles = driver.findElements(By.xpath(busTitleLocator));
        if (searchTitles != null) {
            for (WebElement element : searchTitles) {
                try {
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                    actualBusTitle = element.getText();
                    logger.info("Bus name is {}", actualBusTitle);
                } catch (Exception e) {
                    logger.error("Error! Text not found");
                }
            }
        } else {
            logger.info("Not found any offers match with inputted search query");
        }
    }

    public void getCarPriceSearchResult() {
        Driver.waitFor(2);
        List<WebElement> searchPrices = driver.findElements(By.xpath(carPriceLocator));
        for (WebElement element : searchPrices) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                String price = element.getText();
                int actualPrice = Integer.parseInt(price.replaceAll("[^0-9]", ""));
                isCarPriceInRange = actualPrice >= 10000 && actualPrice <= 50000;
            } catch (Exception e) {
                logger.error("Error! Price not found");
            }
        }
    }

    public void getCarSearchParamsText() {
        List<WebElement> paramsResults = driver.findElements(By.xpath(carParamsLocator));
        for (WebElement element : paramsResults) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                String actualParamText = element.getText();
                String year = actualParamText.substring(0, 4);
                int actualYear = Integer.parseInt(year);
                isCarYearInRange = actualYear >= 2015 && actualYear <= 2023;

                String str = actualParamText.substring(8);
                String[] arr = str.split(", ");
                double actualCapacity = Double.parseDouble(arr[1].substring(0, 3));
                isCarCapacityInRange = actualCapacity >= 1.6 && actualCapacity <= 3.0;

            } catch (Exception e) {
                logger.error("Error! Param Text not found");
            }
        }
    }
    public void getBusPriceSearchResult() {
        Driver.waitFor(2);
        List<WebElement> searchPrices = driver.findElements(By.xpath(busPriceLocator));
        for (WebElement element : searchPrices) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                String price = element.getText();
                int actualPrice = Integer.parseInt(price.replaceAll("[^0-9]", ""));
                logger.info("price is {}", actualPrice);
               isBusPriceInRange= actualPrice >= 5000 && actualPrice <= 30000;
            } catch (Exception e) {
                logger.error("Error! Price not found");
            }
        }
    }
    public void getBusSearchParamsText() {
        List<WebElement> paramsResults = driver.findElements(By.xpath(busParamsLocator));
        Driver.waitFor(5);
        for (WebElement element : paramsResults) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                String actualParamText = element.getText();

                String year = actualParamText.substring(0, 4);
                int actualYear = Integer.parseInt(year);
                logger.info("Year is {}", actualYear);
                isBusYearInRange = actualYear >= 2010 && actualYear <= 2020;

                String str = actualParamText.substring(8);
                String[] arr = str.split(", ");

                double actualCapacity = Double.parseDouble(arr[2].substring(0, 3));
                logger.info("Capacity is {}", actualCapacity);
                isBusCapacityInRange = actualCapacity >= 1.4 && actualCapacity <= 3.0;

                actualBusTransmission = (arr[1].substring(0, 8));
                logger.info("Transmission is {}", actualBusTransmission);

                actualBusEngineType = (arr[3].substring(0, 6));
                logger.info("Engine type is {}", actualBusEngineType);

                String quantitySeatsText = (arr[0].substring(0, 1));
                int actualSeatsQuantity = Integer.parseInt(quantitySeatsText);
                logger.info("Quantity of seats is {}", actualSeatsQuantity);
                isQuantityOfSeatsInRange = actualSeatsQuantity >= 8 && actualSeatsQuantity <= 10;

            } catch (Exception e) {
                logger.error("Error! Param Text not found");
            }
        }
    }
    public String getActualTopTitle() {
        return actualTopTitle;
    }

    public boolean isTopYearInRange() {
        return isTopYearInRange;
    }

    public boolean isTopPriceInRange() {
        return isTopPriceInRange;
    }

    public boolean isTopCapacityInRange() {
        return isTopCapacityInRange;
    }

    public String getActualCarTitle() {
        return actualCarTitle;
    }

    public String getActualBusTitle() {
        return actualBusTitle;
    }

    public boolean isCarPriceInRange() {
        return isCarPriceInRange;
    }

    public boolean isBusPriceInRange() {
        return isBusPriceInRange;
    }

    public boolean isCarYearInRange() {
        return isCarYearInRange;
    }

    public boolean isBusYearInRange() {
        return isBusYearInRange;
    }

    public boolean isCarCapacityInRange() {
        return isCarCapacityInRange;
    }

    public boolean isBusCapacityInRange() {
        return isBusCapacityInRange;
    }

    public String getActualBusTransmission() {
        return actualBusTransmission;
    }

    public String getActualBusEngineType() {
        return actualBusEngineType;
    }

    public boolean isQuantityOfSeatsInRange() {
        return isQuantityOfSeatsInRange;
    }
}

package po;

import driver.Singleton;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class SearchResultPage {
    WebDriver driver;
    private String topCarResultLocator = "//div[@class = 'listing__top']";
    private String topCarTitleLocator = "//h3[@class ='listing-top__title']";
    private String topCarPriceLocator = "//div[@class ='listing-top__price-usd']";
    private String topCarParamsLocator = "//div[@class ='listing-top__summary']/div[@class='listing-top__params']";
    private String carResult = "//div[@class = 'listing__items']/div[@class = 'listing-item']";

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
//    public String getTopCarParamsText() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        return driver.findElement(By.xpath(topCarParamsLocator)).getText();
//    }
    public void getCarSearchTopResult() {
        String actualTitleTopCar = getTitleTopCarText();
        String actualPriceTopCar = getTopCarPriceText();
        int price = Integer.parseInt(actualPriceTopCar.replaceAll("[^0-9]", ""));
        boolean isPriceInPange = price >= 10000 && price <= 50000;
        Assertions.assertTrue((actualTitleTopCar.contains("Audi Q2"))&&isPriceInPange);
    }
    public void getCarSearchResults() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> results = driver.findElements(By.xpath(carResult));
        WebElement nameElement;
        String name;
        int index = 0;
                String actualText = "";
        for (int i = 0; i < results.size(); i++) {

            try {
                nameElement = results.get(i).findElement(By.xpath("//a[@class = 'listing-item__link']"));

                name = nameElement.getText();
                if (name.equals("Audi Q2 I")) {
                    index = i;
                    actualText = name;
                }
            } catch (Exception e) {
                System.out.println("Error! Try again.");
            }
        }
        System.out.println(actualText);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement priceElement = results.get(index)
                .findElement(By.xpath(".//div[@class = 'listing-item__priceusd']"));
        String actualPrice = priceElement.getText();
        System.out.println(actualPrice);
        int price = Integer.parseInt(actualPrice.replaceAll("[^0-9]", ""));
        boolean isPriceInPange = price >= 10000 && price <= 50000;
        Assertions.assertEquals("Audi Q2 I", actualText);
        Assertions.assertTrue(isPriceInPange);
    }

    @Override
    public String toString() {
        return "SearchResultPage{" +
                "topCarResult='" + topCarResultLocator + '\'' +
                ", carResult='" + carResult + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResultPage that = (SearchResultPage) o;
        return Objects.equals(driver, that.driver)
                && Objects.equals(topCarResultLocator, that.topCarResultLocator)
                && Objects.equals(topCarTitleLocator, that.topCarTitleLocator)
                && Objects.equals(topCarPriceLocator, that.topCarPriceLocator)
                && Objects.equals(topCarParamsLocator, that.topCarParamsLocator)
                && Objects.equals(carResult, that.carResult);
    }
}

package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private String copyrightLocator = "//p[@class = 'footer__copy']";
    private String loginButtonLocator = "//span[@class = 'nav__link-text'] [text() = 'Войти']";
    private String cookiesButtonSubmitLocator = "//button[@class = 'button button--primary button--block button--large']";
    private String profileDropDownMenuLocator = "//li[@class = 'nav__item nav__item--user nav__item--dropdown']";
    private String financeTabLocator = "//span[@class = 'nav__link-text'][text() = 'Финансы']";
    private String vehicleTabLocator = "//span[@class = 'nav__link-text'][text() = 'Транспорт']";
    private String partTabLocator = "//span[@class = 'nav__link-text'][text() = 'Запчасти и шины']";
    private String newsTabLocator = "//span[@class = 'nav__link-text'][text() = 'Журнал']";
    private String infoTabLocator = "//span[@class = 'nav__link-text'][text() = 'Знания']";
    private String vinCheckTabLocator = "//span[@class = 'nav__link-text'][text() ='Проверка VIN']";
    private String addNewOfferButtonLocator = "//button[@class = 'button button--primary button--block button--small']";
    private String brandDropdownButtonLocator = "//span[@class ='dropdown-floatlabel__value'][text() = 'Марка']";
    private String selectedCarLocator = "//li[@class ='dropdown__listitem']/ button[@data-item-label = 'Audi']";
    private String modelDropdownButtonLocator = "//span[@class = 'dropdown-floatlabel__value'][text() = 'Модель']";
    private String selectModelLocator = "//li[@class ='dropdown__listitem']/button[@data-item-label = 'Q2']";
    private String carGenerationDropDownLocator = "//span[@class = 'dropdown-floatlabel__value'][text() = 'Поколение']";
    private String selectedCarGenerationLocator = "//div[@class = 'dropdown__card']";
    private String yearFromDropDownLocator = "//span[@class = 'dropdown-floatlabel__value'][text() = 'Год от']";
    private String selectedYearFromLocator = "//ul[@class='dropdown-list dropdown-list--opened']//button[@data-item-label='2015']";
    private String yearUntilDropDownLocator = "//span[@class = 'dropdown-floatlabel__value'][text() = 'до']";
    private String selectedYearUntil = "//ul[@class = 'dropdown-list dropdown-list--opened']//button[@data-item-label = '2023']";
    private String priceFromDropDownMenuLocator = "//input[@id='p-9-price_usd']";
    private String priceUntilDropDownMenuLocator = "//div[@class ='richinput-control'] //input [@id='p-9-price_usd']";
    private String engineCapacityFromDropDownLocator ="//div[@class='dropdown__box']/button[@name = 'p-12-engine_capacity']//span[@class = 'dropdown-floatlabel__value'][text() = 'Объём от']";
    private String selectedCapacityFromLocator = "//ul[@class = 'dropdown-list dropdown-list--opened']/li[@class = 'dropdown__listitem']/button[@data-item-label = '1,6 л.']";
    private String engineCapacityUntilDropDownLocator = "//div[@class = 'dropdown__box']//span[@class = 'dropdown-floatlabel__value'][text() = 'до']";
    private String selectedCapacityUntilLocator = "//ul[@class = 'dropdown-list dropdown-list--opened']/li[@class = 'dropdown__listitem']/button[@data-item-label = '3,0 л.']";
    private String showResultsButtonLocator = "//div[@class = 'filter__show-result']";
    private String busInDropDownLocator = "//a[@href='https://bus.av.by']/span[@class = 'nav__dropdown-text']";
    Actions actions = new Actions(Driver.getDriver());
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    public HomePage() {
        this.driver = Driver.getDriver();
    }
    public void openHomePage() {
        driver.get("https://av.by/");
    }

    public void openLoginForm() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath(loginButtonLocator)).click();
    }

    public void submitCookies() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath(cookiesButtonSubmitLocator)).click();
    }

    public void openPersonalAccountPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
        driver.findElement(By.xpath(profileDropDownMenuLocator)).click();
    } catch (Exception e) {
       logger.error("You are banned! Don't joke with valid credentials"); }
    }

    public String getCopyrightText() {
        return driver.findElement(By.xpath(copyrightLocator)).getText();
    }

    public void openFinancePage() {
        driver.findElement(By.xpath(financeTabLocator)).click();
    }

    public void openTransportPage() {
        driver.findElement(By.xpath(vehicleTabLocator)).click();
    }

    public void openPartPage() {
        driver.findElement(By.xpath(partTabLocator)).click();
    }

    public void openNewsPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath(newsTabLocator)).click();
    }

    public void openInfoPage() {
        driver.findElement(By.xpath(infoTabLocator)).click();
    }

    public void openVinCheckPage() {
        driver.findElement(By.xpath(vinCheckTabLocator)).click();
    }

    public void clickAddNewOfferButton() {
        driver.findElement(By.xpath(addNewOfferButtonLocator)).click();
    }

    public void openBrandDropDownMenu() {
        driver.findElement(By.xpath(brandDropdownButtonLocator)).click();
    }

    public void selectCarBrand() {
        Driver.waitFor(2);
        driver.findElement(By.xpath(selectedCarLocator)).click();
    }

    public void openModelDropDownMenu(){
        Driver.waitFor(3);
        driver.findElement(By.xpath(modelDropdownButtonLocator)).click();
    }

    public void selectCarModel() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath(selectModelLocator)).click();
    }
    public void openCarGenerationDropDownMenu() {
        Driver.waitFor(3);
        driver.findElement(By.xpath(carGenerationDropDownLocator)).click();
    }
    public void selectCarGeneration() {
        driver.findElement(By.xpath(selectedCarGenerationLocator)).click();
    }
    public void openYearFromDropDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(yearFromDropDownLocator)).click();
    }
    public void selectYearFrom() {
        driver.findElement(By.xpath(selectedYearFromLocator)).click();
    }
    public void openYearUntilDropDown() {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(yearUntilDropDownLocator)).click();
    }
    public void selectYearUntil() {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(selectedYearUntil)).click();
    }
    public void inputPriceFrom(String priceFrom) {
       WebElement priceInputFieldElement = driver.findElement(By.xpath(priceFromDropDownMenuLocator));
       priceInputFieldElement.click();
       priceInputFieldElement.sendKeys(priceFrom);
    }
    public void inputPriceUntil(String priceUntil) {
        WebElement priceInputFieldElement = driver.findElement(By.xpath(priceUntilDropDownMenuLocator));
        priceInputFieldElement.click();
        priceInputFieldElement.sendKeys(priceUntil);
    }
    public void openEngineCapacityFromDropDownMenu() {
        driver.findElement(By.xpath(engineCapacityFromDropDownLocator)).click();
    }
    public void selectEngineCapacityFrom() {
        driver.findElement(By.xpath(selectedCapacityFromLocator)).click();
    }
    public void openEngineCapacityUntilDropDownMenu() {
        driver.findElement(By.xpath(engineCapacityUntilDropDownLocator)).click();
    }
    public void selectEngineCapacityUntil() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(selectedCapacityUntilLocator)).click();
    }
    public void submitSearchQuery() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(showResultsButtonLocator)).click();
    }
    public void openBusSearchPageFromVehicle() {
        WebElement vehicleTabElement = driver.findElement(By.xpath(vehicleTabLocator));
        WebElement busInDropDownElement = driver.findElement(By.xpath(busInDropDownLocator));
        actions.moveToElement(vehicleTabElement).moveToElement(busInDropDownElement).click().build().perform();
    }
}

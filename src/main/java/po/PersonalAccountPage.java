package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonalAccountPage {

    public WebDriver driver;
    private String myOffersTabLocator = "//a[@class = 'sidenav__link sidenav__link--active'][@href='https://av.by/profile/offers']";
    private String personalDropDownLocator = "//li [@class = 'nav__item nav__item--user nav__item--dropdown']";
    private String logOutButtonLocator = "//a[@href ='https://av.by/logout?redirect_to=https%3A%2F%2Fav.by']";
    private final static Logger logger = LoggerFactory.getLogger(PersonalAccountPage.class);


    public PersonalAccountPage() {
        this.driver = Driver.getDriver();
    }
   Actions actions = new Actions(Driver.getDriver());

    public String getMyOffersTabLocatorTabText() {
        return driver.findElement(By.xpath(myOffersTabLocator)).getText();
    }

    public void clickLogOut() {
        WebElement personalDropDownElement = driver.findElement(By.xpath(personalDropDownLocator));
        WebElement logOutButtonElement = driver.findElement(By.xpath(logOutButtonLocator));
        actions.moveToElement(personalDropDownElement)
                .moveToElement(logOutButtonElement).click().build().perform();
        logger.info("User has logged out");
    }
}

package po;

import driver.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    public WebDriver driver;
    private String myOffersTabLocator = "//a[@class = 'sidenav__link sidenav__link--active'][@href='https://av.by/profile/offers']";
    private String addNewOfferButtonLocator = "//button[@class = 'button button--primary button--block button--small']";
    public PersonalAccountPage() {
        driver = Singleton.getDriver();
    }
    public String getMyOffersTabLocatorTabText() {
        return driver.findElement(By.xpath(myOffersTabLocator)).getText();
    }
    public void openAddingNewOfferPage() {
        driver.findElement(By.xpath(addNewOfferButtonLocator)).click();
    }

}

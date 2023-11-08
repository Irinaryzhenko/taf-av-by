package po;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginFormPage {
    WebDriver driver;
    private String authFormLocator = "//div[@class = 'drawer__view']";
    private String loginViaMailLocator = "//button[@type = 'button'][text() = 'почте или логину']";
    private String loginInputFieldLocator = "//input[@id = 'authLogin']";
    private String passwordInputFieldLocator = "//input[@id = 'loginPassword']";
    private String submitAuthDataButtonLocator = "//button[@class = 'button button--action']";
    private String errorMessageLocator = "//form[@method = 'POST']//div[@class = 'error-message']";
    private String logInTitleLocator = "//div[@class = 'auth__title'][text() = 'Вход']";

    public LoginFormPage() {
        this.driver = Driver.getDriver();
    }
    public void openLoginFormViaMail() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       driver.findElement(By.xpath(loginViaMailLocator)).click();

    }
    public void fillLoginPasswordField(String loginText, String passwordText) {
        driver.findElement(By.xpath(loginInputFieldLocator)).sendKeys(loginText);
        driver.findElement(By.xpath(passwordInputFieldLocator)).sendKeys(passwordText);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath(authFormLocator)));
    }
    public void submitAuthData() {
        driver.findElement(By.xpath(submitAuthDataButtonLocator)).click();
    }
    public String getErrorMessageText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(By.xpath(errorMessageLocator)).getText();
    }
    public String getLogInTitleText(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElement(By.xpath(logInTitleLocator)).getText();
    }
}

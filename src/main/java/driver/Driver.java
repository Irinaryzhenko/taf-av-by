package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    public Driver() {
    }
    public static WebDriver getDriver(){
        if(driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } return driver;
    }
    public static  void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

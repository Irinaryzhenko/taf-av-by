package ui.testing.testsuits;

import driver.Singleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import po.HomePage;


public class BaseTest {
    @BeforeEach
    public void setUpDriver() {
       HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        };
    }

//    @AfterEach
//    public void closeDriver() {
//        Singleton.quitDriver();
//    }
}

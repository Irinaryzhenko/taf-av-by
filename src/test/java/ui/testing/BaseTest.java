package ui.testing;

import driver.Singleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void setupDriver() {
        Singleton.getDriver();
    }
//    @AfterEach
//    public void closeDriver() {
//        Singleton.quitDriver();
//    }
}

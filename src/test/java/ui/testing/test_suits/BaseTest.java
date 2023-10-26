package ui.testing.test_suits;

import driver.Singleton;
import org.junit.jupiter.api.AfterEach;


public class BaseTest {

    @AfterEach
    public void closeDriver() {
        Singleton.quitDriver();
    }
}

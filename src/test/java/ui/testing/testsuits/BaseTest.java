package ui.testing.testsuits;

import driver.Driver;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {

    @AfterEach
    public void closeDriver() {
        Driver.quitDriver();
    }
}

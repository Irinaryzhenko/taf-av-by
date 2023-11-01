package ui.testing.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;

public class CommonSteps {
    private final static Logger logger = LoggerFactory.getLogger(CommonSteps.class);
        public static void openHomePageSubmitCookies() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
            logger.info("Cookies have been shown.");
        };
    }
}

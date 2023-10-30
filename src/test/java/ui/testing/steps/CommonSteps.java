package ui.testing.steps;

import po.HomePage;

public class CommonSteps {
        public static void openHomePageSubmitCookies() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        };
    }
}

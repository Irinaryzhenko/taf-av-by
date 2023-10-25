package ui.testing.steps;

import po.HomePage;

public class CommonSteps {
    private static HomePage homePage;

    public static void startIteration() {
        homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        };
    }
}

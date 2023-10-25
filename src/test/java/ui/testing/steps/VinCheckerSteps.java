package ui.testing.steps;

import domain.vincode.Generator;
import org.junit.jupiter.api.Assertions;
import po.HomePage;
import po.VinCheckPage;

public class VinCheckerSteps extends CommonSteps {
    private static HomePage homePage = new HomePage();
    private static VinCheckPage vinCheckPage = new VinCheckPage();

    public static void inputValidVinCodeInChecker() {
        homePage.openVinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateValidFormatVinCode());
        vinCheckPage.clickCheckVinCode();
    }

    public static void checkValidVinCode() {
        Assertions.assertEquals("Купить отчёт",
                vinCheckPage.getBuyVinCodeResultButtonText());
    }

    public static void inputInvalidNumberVinCodeInChecker() {
        homePage.openVinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidNumberCharactersVinCode());
        vinCheckPage.clickCheckVinCode();
    }
    public static void checkInvalidNumberVinCode() {
        Assertions.assertEquals("VIN-номер состоит из 17 символов",
                vinCheckPage.getErrorNumberVinMessageText());
    }
    public static void inputInvalidFormatVinCode() {
        homePage.openVinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidCharactersInVinCode());
        vinCheckPage.clickCheckVinCode();
    }
    public static void checkInvalidFormatVinCode() {
        Assertions.assertEquals("Неверно указан VIN-номер",
                vinCheckPage.getErrorVinFormatMessageText());
    }
}

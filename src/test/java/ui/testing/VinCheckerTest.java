package ui.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import po.HomePage;
import po.VinCheckPage;
import domain.vincode.Generator;

public class VinCheckerTest extends BaseTest {
    @DisplayName("Check VinChecker with valid vin code")
    @Test
        public void vinCheckerWithValidVinCode() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateValidFormatVinCode());
        vinCheckPage.clickCheckVinCode();
        Assertions.assertEquals("Купить отчёт", vinCheckPage.getBuyVinCodeResultButtonText());
    }
    @DisplayName("Check VinChecker with invalid number of characters of vin code")
    @Test
    public void vinCheckerWithInvalidNumberOfCharactersOfVinCode() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidNumberCharactersVinCode());
        vinCheckPage.clickCheckVinCode();
        Assertions.assertEquals("VIN-номер состоит из 17 символов", vinCheckPage.getErrorNumberVinMessageText());
    }
    @DisplayName("Check VinChecker with invalid format of characters of vin code")
    @Test
    public void vinCheckerWithInvalidFormatOfCharactersOfVinCode() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidCharactersInVinCode());
        vinCheckPage.clickCheckVinCode();
        Assertions.assertEquals("Неверно указан VIN-номер", vinCheckPage.getErrorVinFormatMessageText());
    }
}

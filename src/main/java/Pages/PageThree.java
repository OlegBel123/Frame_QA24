package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageThree extends BasePage{  //extends(наследуется) от BasePage
    public PageThree(WebDriver driver) {
        super(driver);//реализуем(генерируем) конструктор драйвера на основе родительского
    }
    private static class Locators {
        private final static By dellClik = By.xpath("//div[@id='group-9501']/following-sibling::div/a[6]");//клик Dell
        private final static By oknoClik = By.xpath("//div[@class='listing__submit-wrap']/a");// клик окна
        private final static By noutAdKorzina = By.xpath("//div[@data-title='Ноутбук Lenovo IdeaPad Gaming 3 15ACH6 Shadow Black (82K201N8RA)']/following-sibling::div[2]/div");// ноут, корзина
        private final static By korzina = By.xpath("//i[@id='basket-icon']");// корзина
        private final static By nameNout = By.xpath("//a[@class='header-tooltip__cards-item__title ']");
        private final static By MacOC = By.xpath("//div[@id='group-10850']/following-sibling::div/div[6]");// локатор MacOc
        private final static By opersistem = By.xpath("//div[@id='group-10850']");// локатор опер.систем
        private final static By textsravnenie = By.xpath("//p[@class='product-listing__empty_text']");
        private final static By clikKorzina = By.xpath("//div[@class='button button_initial clear-credit-button']");
        private final static By closedKorzina = By.xpath("//i[@id='cartTooltipClose']");

    }
    public void fiLterSectionDell(){
        elements.clickOnElementBy(Locators.dellClik);
        elements.clickOnElementBy(Locators.oknoClik);
    }
    public void noutAdKorzina(){
        elements.clickOnElementBy(Locators.noutAdKorzina);
        waiters.waitVisabilityOfWebElent(Locators.korzina);
        elements.clickOnElementBy(Locators.clikKorzina);
        elements.clickOnElementBy(Locators.closedKorzina);
    }
    public void incorectFilter(){
        elements.clickOnElementBy(Locators.dellClik);
        //waiters.waitVisabilityOfWebElent(Locators.opersistem);
        elements.clickOnElementBy(Locators.opersistem);
        waiters.waitVisabilityOfWebElent(Locators.MacOC);
        elements.clickOnElementBy(Locators.MacOC);
        waiters.waitVisabilityOfWebElent(Locators.oknoClik);
        elements.clickOnElementBy(Locators.oknoClik);
    }
}

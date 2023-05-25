package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSecond extends BasePage {  //extends(наследуется) от BasePage
    public PageSecond(WebDriver driver) {
        super(driver);//реализуем(генерируем) конструктор драйвера на основе родительского
    }

    private static class Locators {
        private final static By h1Element = By.xpath("//h1[text()]");
        private final static By labelElement = By.xpath("//div[@class='search-page__box-title']/label");
        private final static By iconkaElement = By.xpath("//div[@class='header-logo']");
        private final static By modelRowAppleElement = By.xpath("//div[@class='listing__sidebar-col'][24]");//модельный ряд
        private final static By telekOne = By.xpath("//div[@data-url='L3VrL3Byb2R1Y3RzL2dldHNob3J0cHJvcGVydGllcy80NDI5P2NsYXNzSWQ9OTc3']");//
        private final static By telekTwo = By.xpath("//div[@data-url='L3VrL3Byb2R1Y3RzL2dldHNob3J0cHJvcGVydGllcy80MzEwP2NsYXNzSWQ9OTc3']");//
        private final static By telekOnesravnenie = By.xpath("//div[@data-id='4429']/label/span[text()='Порівняти']");//
        private final static By telekTwosravnenie = By.xpath("//div[@data-id='4310']/label/span[text()='Порівняти']");//
        private final static By sravnenieClik = By.xpath("//div[@data-id='4429']/label/span[text()='У порівнянні']");//
        private final static By sravnenie2Clik = By.xpath("//div[@data-id='4310']/label/span[text()='У порівнянні']");//
        private final static By buttonSravnenieClik = By.xpath("//div[@class='header-tooltip unselectable']");//
        private final static By textSravnenieTelek = By.xpath("//div[@class='header-tooltip__cards-col groups-to-compare']/div/div/div/following-sibling::div[2]/a");//
        private final static By praceMonth = By.xpath("//label[@class='filter-label filter-label-price-month']");//
        private final static By praceOneTelek = By.xpath("//a[@data-id='4429']/span[2]");//
        private final static By сhepExpensivTelek = By.xpath("//ul[@class='listing__body-sort']/li[4]");//
        private final static By praceChepTelek = By.xpath("//div[@data-id='3643']/following-sibling::div/div[2]/div/div/div[2]");//
        private final static By jjjjjjTelek = By.xpath("//a [@href='/uk/shop/zaporozhye/led_televizory_samsung.html']");//
    }

    private static class Label {
        private final static String partOfUrlText = "Найдено по запросу";
    }

    public static void waitForPageLoaded() {
        waiters.waitTitleContainsText(Label.partOfUrlText);
    }

    public static void waitForH1Loaded() {
        elements.findSingleElement(Locators.h1Element);
    }

    public String getTextFromH1() {
        return elements.getTextFromElementBy(Locators.h1Element);
    }

    public String getTextFromLabel() {
        return elements.getTextFromElementBy(Locators.labelElement);
    }

    public void checkH1ElementContainsText(String input) {
        String resultOfReach = elements.getTextFromElementBy(Locators.h1Element).replace("Найдено по запросу ", "");
        assertions.equalsOfStrings(resultOfReach, "«" + input + "»");
    }

    public void checkLabelElementContainsText(String input) {
        String resultOfReach = elements.getTextFromElementBy(Locators.labelElement);
        assertions.equalsOfStrings(resultOfReach, "«" + input + "»");
    }

    public void clickIcon() {
        elements.clickOnElementBy(Locators.iconkaElement);
    }

    public void clickmodelRowAppleElement() { //  модельный ряд
        elements.clickOnElementBy(Locators.modelRowAppleElement);
    }

    public void clickcommunicationsElement() { //  модельный ряд
        elements.clickOnElementBy(Locators.modelRowAppleElement);
    }

    public void clickOnElement(By by) {
        elements.clickOnElementBy(by);
    }

    public void sravnenieTelek() {
        action.moveToElementLocation(Locators.telekOne);
        action.moveToElementLocation(Locators.telekOnesravnenie);
        elements.clickOnElementBy(Locators.telekOnesravnenie);
        waiters.waitVisabilityOfWebElent(Locators.sravnenieClik);

        action.moveToElementLocation(Locators.telekTwo);
        action.moveToElementLocation(Locators.telekTwosravnenie);
        elements.clickOnElementBy(Locators.telekTwosravnenie);
        waiters.waitVisabilityOfWebElent(Locators.sravnenie2Clik);
    }
    public void checkButtonTelek(){
        elements.clickOnElementBy(Locators.buttonSravnenieClik);
    }
    public void chekpraceMonth(){
        elements.clickOnElementBy(Locators.praceMonth);
        waiters.waitVisabilityOfWebElent(Locators.praceOneTelek);
    }//
    public void checChepExpensivTelek() {
        elements.clickOnElementBy(Locators.сhepExpensivTelek);
        waiters.waitVisabilityOfWebElent(Locators.praceChepTelek);

    }
    ///
    public void fiLterSectionS(){
        elements.clickOnElementBy(Locators.jjjjjjTelek);
        //elements.clickOnElementBy(Locators.jjjjjjTelek);
    }}









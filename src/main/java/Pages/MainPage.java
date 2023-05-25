package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage { //extends(наследуется) от BasePage
    public MainPage(WebDriver driver) {
        super(driver);//реализуем(генерируем) конструктор драйвера на основе родительского
    }

    //////Прописывем все локаторы, которые используем на странице, которые можем потом использовать в любых тестах
    private static class Locators {//Все локаторы, лейблы реализуем во вложенном классе


        private final static By searchCarzina = By.xpath("//i[@id='basket-icon']");//корзина
        private final static By searchCuk = By.xpath("//a[@class='button user-confirm-location-button']");
        //закрытие окна
        private final static By searchField = By.xpath("//input[@type='search']");//локатор для поисковой строки (поля)
        private final static By searchButton = By.xpath("//input[@class='header-search__button evinent-search-button']");
        //локатор для кнопки поиска
        private final static By catalog=By.xpath("//ul[@class='menu-categories menu-categories_type_main']");
        private final static By search=By.xpath("//input[@type='search']");
        private final static By buttonLocation=By.xpath("//i[@class='icon-location-white']");
        private final static By inputCity=By.xpath("//input[@id='city-search']");
        private final static By language=By.xpath("//a[@data-lang='ru']");
        private final static By Facebook=By.xpath("//i[@class='icon icon-facebook']");
        private final static By sectionNoyt=By.xpath("//p[text()='Ноутбуки, ПК, планшети']");
        private final static By section=By.xpath("//i[@class='icon-grid']");//каталог товаров
        private final static By noytbuk=By.xpath("//a[@data-url='L3VrL3Nob3AvemFwb3Jvemh5ZS9ub3V0YnVraS5odG1s']");//ноутбуки
        private final static By sectionTelek=By.xpath("//p[text()='Телевізори, аудіотехніка']");//секция телевизоры
        private final static By telek=By.xpath("//a[@data-url='L3VrL3Nob3AvemFwb3Jvemh5ZS9sZWRfdGVsZXZpem9yeS5odG1s']");//телевизоры
        private final static By ZP=By.xpath("//li[@data-id='38061']");//ZP

    }
    private static class Url { //Создаем класс с url (ссылка сайта)
        private final static String url = "https://www.foxtrot.com.ua/uk";
    }

    public void searchByText(String text){ //Прописываем все необходимые методы
        elements.sendKeysToElementBy(Locators.searchField,text);// используем метод поиск по тексту
        elements.clickOnElementBy(Locators.searchButton);// метод кликаем на элемент
    }
    public void openPage(){
        driver.get(Url.url);
    }//открытие адреса страницы
    public void acceptCity(){ //подтверждение локации
        elements.clickOnElementBy(By.xpath("//a[@class='button user-confirm-location-button']"));
    }

    public void changeCity(){//
        elements.clickOnElementBy(Locators.buttonLocation);
        elements.isElementDisplayed(Locators.inputCity);

    }
    public void choiceCity(String city){ //выбрать город
        elements.sendKeysToElementBy(Locators.inputCity,city);
        elements.isElementDisplayed(By.xpath("//li[@class='popup__cities_item popup__cities_item-bold']"));
        elements.clickOnElementBy(By.xpath("//li[@class='popup__cities_item popup__cities_item-bold']"));
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//p[@class='city-title']")),city);

    }
    public void switchLanguage(){//переключения язіка
        waiters.waitForVisibilityOfElementLocated(Locators.language);
        elements.clickOnElementBy(Locators.language);
        waiters.waitVisabilityOfWebElent(By.xpath("//div[@class='current-offer-head']/div[@class='page__title']"));

    }
    public void waitPageLoaded(){
        elements.findSingleElement(By.xpath("//div[@class='current-offer-head']/div[@class='page__title']"));
    }
    public void clickFacebook() {
        elements.clickOnElementBy(Locators.Facebook);
    }
    public void switchToSectionNoyt(){
        waiters.waitVisabilityOfWebElent(Locators.section);
        action.moveToElementLocationAndClick(Locators.section);
        action.moveToElementLocation(Locators.sectionNoyt);
        action.moveToElementLocationAndClick(Locators.noytbuk);
    }
    public void switchToSectionTelek(){
        waiters.waitVisabilityOfWebElent(Locators.section);
        action.moveToElementLocationAndClick(Locators.section);
        action.moveToElementLocation(Locators.sectionTelek);
        action.moveToElementLocationAndClick(Locators.telek);
    }
    public void combekZP(){
        elements.clickOnElementBy(Locators.buttonLocation);
        elements.clickOnElementBy(Locators.ZP);
    }
}




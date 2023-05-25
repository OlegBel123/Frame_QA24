package Pages;
//Создаем базовую страницу от которой потом будем наследоваться

import Functions.ActionClass;
import Functions.Assertions;
import Functions.Elements;
import Functions.Waiters;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;
    static Waiters waiters;
    static ActionClass action;
    static Assertions assertions;
    static Elements elements;


    public BasePage(WebDriver driver) { //Создаем конструктор
        this.driver = driver;
        waiters = new Waiters(driver);
        assertions = new Assertions(driver);
        action = new ActionClass(driver);
        elements = new Elements(driver);
    }
}

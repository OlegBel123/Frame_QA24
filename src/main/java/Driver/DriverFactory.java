package Driver;
//В этом классе будет происходить инициализация драйвера
//Создаем определенные поля для этого класса


import Functions.ActionClass;
import Functions.Assertions;
import Functions.Elements;
import Functions.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static final long IMPLICITY_WAIT= 20l;//создаем поле с ожиданием
    //Создаем экземпляры функций (с инициализацией определенных методов), чтобы драйвер мог с ними работать и даем им название.
    static Waiters waiters;
    static ActionClass action;
    static Assertions assertions;
    static Elements elements;
    private static WebDriver driver;

    //Создаем методы для настройки драйвера
    private static WebDriver setUpDriver(){ //Метод возвращает экземпляр нашего драйвера
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        waiters = new Waiters(driver); //инициализируем вэйтеры
        elements = new Elements(driver);//инициализируем элементы
        action = new ActionClass(driver);//инициализируем
        assertions = new Assertions(driver);//инициализируем

        driver.manage().window().maximize();// открытие полного окна
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);//добавляем неявные ожидания
        return driver;
    }
    //Настраиваем, чтобы возвращался один и тот же экземпляр драйвере
    //Метод будет проверять приинициализирован драйвер, либо нет
    //Если драйвер не пустой он будет возвращать не пустое значение,
    // а если драйвер еще не инициализировался тогда он его будет инициализировать
    private static WebDriver getInstance(){ //метод возвращает сущность драйвера
        if (driver == null) {//если драйвер не инициализирован - инициализируем его
            try{
                driver= setUpDriver();
            }catch (Exception e){
                e.printStackTrace();//(один из методов, который выводим всю инфо в консоль: что за исключение, какой меседж) в обработке исключения вывести всю информацию об исключении.
            }
        }return driver;
    }
    public static WebDriver startChromeDriver(){ //Всегда будем начинать работу с драйвером при помощи метода startChromeDriver
        logger.info("Trying to start driver");
        driver = getInstance();
        return driver;
    }

}

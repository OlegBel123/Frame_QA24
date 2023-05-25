import Driver.DriverFactory;
import Functions.ActionClass;
import Functions.Assertions;
import Functions.Elements;
import Functions.Waiters;
import Pages.MainPage;
import Pages.PageSecond;
import Pages.PageThree;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import Pages.BasePage;

import Utils.TestResultListeners;

@Listeners(TestResultListeners.class)
public class BaseTest {
    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver = DriverFactory.startChromeDriver();//Инициализируем драйвер

    //Создаем все экземпляры страниц (BasePage, MainPage, PageSecond, PageThree)
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected PageSecond secondPage = new PageSecond(driver);
    protected PageThree threePage = new PageThree(driver);
    protected Waiters waiters = new Waiters(driver);
    protected ActionClass action = new ActionClass(driver);
    protected Assertions assertions = new Assertions(driver);
    protected Elements elements = new Elements(driver);

    @AfterSuite
    public void closeDriver(){
        logger.info("driver is closing");
        driver.quit();
    }
}

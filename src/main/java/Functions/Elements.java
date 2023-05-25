package Functions;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Elements {
    static final Logger logger = LoggerFactory.getLogger(Elements.class);
    private final WebDriver driver;
    private final Waiters waiters;

    public Elements(WebDriver driver){
        this.driver=driver;
        waiters = new Waiters(driver);
    }

    public WebElement findSingleElement(By by){
        try {
            waiters.waitVisabilityOfWebElent(by);
            logger.info("trying to find element by locator "+by.toString());
            return driver.findElement(by);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElementByXpath(String xpath){
        try {
            waiters.waitVisabilityOfWebElent(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean isElementDisplayed(String xpath){
        return findElementByXpath(xpath).isDisplayed();
    }
    public String getTextFromElementXpath(String xpath){
        return  findElementByXpath(xpath).getText();
    }
    public String getTextFromElementBy(By locator){
        logger.info("getting text from element "+locator.toString());
        return  findSingleElement(locator).getText();
    }
    public void clickOnElementByXpath(String xpath){
        findElementByXpath(xpath).click();
    }
    public void clickOnElementBy(By locators){
        waiters.waitVisabilityOfWebElent(locators);//добавили доп.ожидание
        logger.info("clicking on Element "+locators.toString());
        findSingleElement(locators).click();
    }
    public void sendKeysToElementWithXpath(String xpath,String text){
        findElementByXpath(xpath).sendKeys(text);
    }
    public void sendKeysToElementBy(By locator,String text){
        findSingleElement(locator).sendKeys(text);
    }
    public boolean isElementDisplayed(By by) {
        return findSingleElement(by).isDisplayed();
    }
        public boolean isElementSelected(By by){
            return findSingleElement(by).isSelected();
        }
    }



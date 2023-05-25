package Functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class Waiters {
    private final WebDriver driver;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    private static final long EXPLICITY_WAIT = 20L;

    private FluentWait<WebDriver> fluentWait(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function, Long timeout) {
        FluentWait<WebDriver> wait = fluentWait(timeout);
        wait.until(function);
    }
    //VisabilityOfElement - Ожидание видимости всех элементов.
    public void waitForVisabilityOfElement(By by) {
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by), EXPLICITY_WAIT);
    }

    public WebElement waitForVisabilityOfElementReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForFrameAndSwitchToIt(By by) {
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by), EXPLICITY_WAIT);
    }

    public Alert waitForAlertAndSwitchToIt() {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }
    //ElementToBeClickable - Ожидание кликабельности элемента.
    public void waitElementToBeClickable(By by) {
        waitForFunction(ExpectedConditions.elementToBeClickable(by), EXPLICITY_WAIT);
    }
    public void waitElementToBeClickable(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeClickable(element), EXPLICITY_WAIT);
    }
    public WebElement waitElementToBeClickableReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitElementToBeClickableReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }
    //ElementToBeSelected - Ожидание чтобы элемент был выбран.
    public void waitElementToBeSelected(By by) {
        waitForFunction(ExpectedConditions.elementToBeSelected(by), EXPLICITY_WAIT);
    }

    public void waitElementToBeSelected(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeSelected(element), EXPLICITY_WAIT);
    }

    public void waitElementStateToBe(WebElement element, boolean boo) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, boo), EXPLICITY_WAIT);
    }
    //VisabilityOfWebElent - Ожидание видимости всех элементов.
    public void waitVisabilityOfWebElent(WebElement element) {
        waitForFunction(ExpectedConditions.visibilityOf(element), EXPLICITY_WAIT);
    }

    public void waitVisabilityOfWebElent(By by) {
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public WebElement waitVisabilityOfWebElentReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitVisabilityOfWebElentReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    //Метод presenceOfElementLocated - Ожидание появления элемента расположенного по заданному локатору.
    public void waitpresenceOfElementLocated(By locator) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(locator), EXPLICITY_WAIT);
    }
    public void waitpresenceOfElement(By locator) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(locator), EXPLICITY_WAIT);
    }

    public WebElement waitPresenceOfElementReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitPresenceOfElement(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICITY_WAIT);
    }

    public void waitTitleContainsText(String text) {
        waitForFunction(ExpectedConditions.titleContains(text), EXPLICITY_WAIT);
    }
    //Метод textToBePresentInElementValue() - Ожидание появления текста в элементе.
    public void waittextToBePresentInElementValue(By locator, String text) {
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(locator, text), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waittextToBePresentInElementValue(WebElement element, String text) {
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(element, text), EXPLICITY_WAIT);
    }
    //Метод invisibilityOf() - Ожидание видимости элемента
    public void waitinvisibilityOf(WebElement element) {
        waitForFunction(ExpectedConditions.invisibilityOf(element), EXPLICITY_WAIT);
    }
    //Метод titleContains() - Ожидание что в названии странице находится указанный текст.
    public void waittitleContains(String text) {
        waitForFunction(ExpectedConditions.titleContains(text), EXPLICITY_WAIT);
    }

    //Метод titleIs() - Ожидание указанного названия страницы.
    public void waittitleIs(String expectedTitle) {
        waitForFunction(ExpectedConditions.titleIs(expectedTitle), EXPLICITY_WAIT);
}
    //Метод elementSelectionStateToBe() - Ожидание от элемента быть или не быть выбранным.
    public void waitElementSelectionStateToBe(WebElement element, boolean boo) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, boo), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitelementSelectionStateToBe(By locator, boolean boo) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(locator, boo), EXPLICITY_WAIT);
    }
    //Метод visibilityOfElementLocated() - Ожидание видимости элемента.
    public void waitForVisibilityOfElementLocated(By locator) {
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(locator),EXPLICITY_WAIT);
    }
    public WebElement waitForVisibilityOfElementLocatedReturn(By locator) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Метод frameToBeAvailableAndSwitchToIt() - Ожидание доступности фрейма и переключение на него.
    public void waitframeToBeAvailableAndSwitchToIt(By frameLocator) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator), EXPLICITY_WAIT);
    }
    //
    public void waitframeToBeAvailableAndSwitchToIt(String text) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(text), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitframeToBeAvailableAndSwitchToIt(WebElement element) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element), EXPLICITY_WAIT);
    }
    //Перегруз
    public void waitframeToBeAvailableAndSwitchToIt(int integer) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(integer), EXPLICITY_WAIT);
    }
    //Метод alertIsPresent() - Ожидает появления алерта и возвращает его.
    public void waitAlertIsPresent(){
        waitForFunction(ExpectedConditions.alertIsPresent(), EXPLICITY_WAIT);
    }
}

package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Assertions {
    private final Elements elements;
    private final ActionClass actions;
    private final WebDriver driver;
    private final Waiters waiters;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        actions = new ActionClass(driver);
        waiters = new Waiters(driver);
    }

    public void elementIsDisplayed(String xpath){
        assertTrue(elements.isElementDisplayed(xpath), "Элемент не отображается, хотя должен был");
    }
    public void equalsOfElementAndLabelText(String xpathOfElement, String expectedString){
        assertEquals(elements.getTextFromElementXpath(xpathOfElement),expectedString,
                "Я ожидал получить "+expectedString+". А получил "+ elements.getTextFromElementXpath(xpathOfElement));
    }

    public void equalsOfStrings(String actualString, String expectedString){
        assertEquals(actualString,expectedString,
                "Я ожидал получить "+expectedString+". А получил "+ actualString);
    }
    public void equalsOfElementAndLabelText(By xpathOfElement, String expectedString){
        assertEquals(elements.getTextFromElementBy(xpathOfElement),expectedString,
                "Я ожидала получить "+expectedString+". А получила "+ elements.getTextFromElementBy(xpathOfElement));
    }


}

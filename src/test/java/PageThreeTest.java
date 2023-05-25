import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PageThreeTest extends BaseTest {
    @Test(priority = 2)
    public void sectionNoytTest() { // Ноутбуки
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionNoyt();
        List<WebElement> filter = driver.findElements
                (By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/following-sibling::div/following-sibling::div/div/p"));
        assertTrue(filter.size() == 37);
    }

    @Test(priority = 3)
    public void filterNoutDellTest() { // Ноутбуки DELL
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionNoyt();
        threePage.fiLterSectionDell();
        String resFiltr = "Торгова марка: DELL";
        //System.out.println(elements.getTextFromElementBy
                //(By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']")));
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//div[@class='listing__sidebar listing__sidebar_main js-listing-sidebar order--1 listing-filter']/div/ul[@class='listing__sidebar-tags']")),resFiltr);
    }
    @Test(priority = 1)
    public void titleNoutTest() { // соответствие страницы "ноутбуки" +
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionNoyt();
        System.out.println(driver.getTitle());
        String titleNout = "Ноутбуки у Запоріжжі - купити за найкращою ціною у Запоріжжі - Фокстрот";
        assertions.equalsOfStrings(driver.getTitle(), titleNout);
    }
    @Test(priority = 4)
    public void noNoutBayincorectFilterTest() { //+
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionNoyt();
        threePage.incorectFilter();
        System.out.println(elements.getTextFromElementBy(By.xpath("//p[@class='product-listing__empty_text']")));
        String text = "На жаль, товарів по заданих параметрах, не знайдено. Виберіть інші параметри.";
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//p[@class='product-listing__empty_text']")), text);
    }
    @Test(priority = 5)
    public void korzinaTest() { // добавление товара в корзину (ноутбука)
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchToSectionNoyt();
        threePage.noutAdKorzina();
        System.out.println(elements.getTextFromElementBy(By.xpath("//a[@class='header-tooltip__cards-item__title ']")));
        String nameNout = "Ноутбук Lenovo IdeaPad Gaming 3 15ACH6 Shadow Black (82K201N8RA)";
        assertions.equalsOfStrings(elements.getTextFromElementBy(By.xpath("//a[@class='header-tooltip__cards-item__title ']")),nameNout);
    }

}
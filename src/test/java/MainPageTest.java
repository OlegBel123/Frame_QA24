import Functions.Waiters;
import Pages.MainPage;
import Pages.PageSecond;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotEquals;

public class MainPageTest extends BaseTest{
    @Test(priority = 1)
    public void titleTest() { //открытие сайта +
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        String title="≡ Інтернет магазин ФОКСТРОТ | Мережа магазинів побутової техніки та електроніки в Україні";
        assertions.equalsOfStrings(driver.getTitle(), title);
    }

    @Test(priority = 4) //+
    public void locationTest(){
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.changeCity();// обращаемся к классу mainPage и вызываем метод мой стандартный до момента ввода необходимого города
        mainPage.choiceCity("Львів");//мы обращаемся к классу mainPage и вызываем метод кот.принимает город
    }
    @Test(priority = 3)
    public void switchLangTest(){ //переключения языка +
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.switchLanguage();
        String elementToTest="Актуальные предложения";
        assertions.equalsOfElementAndLabelText(By.xpath("//div[@class='current-offer-head']/div[@class='page__title']"),elementToTest);
    }
    @Test(priority = 2) //+
    public void logoTest(){
        //mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        mainPage.searchByText("iPhone");
        secondPage.waitForH1Loaded();
        secondPage.clickIcon();
        String currentURL="https://www.foxtrot.com.ua/uk/shop/zaporozhye.html";
        assertions.equalsOfStrings(driver.getCurrentUrl(), currentURL);
    }
    @Test(priority = 5)
    public void FacebookTest(){//FB +
        mainPage.openPage();//обращаемся к классу mainPage и вызываем метод открыть страницу
        //mainPage.acceptCity();//обращаемся к классу mainPage и вызываем метод подтвердить местоположение
        Set<String> setFirst = driver.getWindowHandles(); //получаем идент.номер первого окна из множества открытых окон
        mainPage.clickFacebook();
        Set<String> setSecond = driver.getWindowHandles(); //получаем идент.номер второго окна из множества открытых окон
        setSecond.removeAll(setFirst);//убираем дубликаты
        String secondDesc = setSecond.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(secondDesc);
        String curURLFB="https://www.facebook.com/foxtrotinfo";
        System.out.println(driver.getCurrentUrl());
        assertions.equalsOfStrings(driver.getCurrentUrl(),curURLFB);


    }}
















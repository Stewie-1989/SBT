package com.work.sbt.testN1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HelperManagerForN1
{
    private final static WebDriver driver = new DriverClassController().getDriver();

    private final static String Selector_ELEMENTS = "span[class='living-list-card-title__text']";

    public static String actionAfterWorkField(String str)
    {
        // Нажать на кнопку Найти
        driver.findElement(By.cssSelector("button[class='search-bar__btn _submit']")).click();

        // Вернуть текст со страницы
        return getTextFromPage(str);
    }

    /**
     * Осуществляет поиск элемента  по cssSelector и заполняет значение текстом
     * @param str строка заполнения
     * @param locator строковое значение локатора
     */
    public static void findElementAndPutString(String str,String locator)
    {
        driver.findElement(By.cssSelector(locator)).sendKeys(str);;
    }

    /**
     * Осуществляет нажатие на кнопки комнат
     * @param rooms список комнат
     */
    public static void setRoom(String ... rooms)
    {
        for(String room : rooms)
        {
            List<WebElement> elements = driver.findElements(By.tagName("label"));

            for(WebElement element : elements)
            {
                if(element.getText().equals(room))
                {
                    element.click();
                    break;
                }
            }
        }
    }

    /**
     * Осуществляет получение строки объекта по cssSelector
     *
     * @param str строковое значение объекта
     * @return возвращает строку объекта
     */
    public static String getTextFromPage(String str)
    {
        return driver.findElement(By.cssSelector(str)).getText();
    }

    /**
     * Осуществляет сравнение по выбранному критериюиз списка объектов имеющих
     * строку. Критериесм является наличие слова в строке.
     * @param str является параметром сверки выборки
     * @return возвращает true в случае если сделанна правельная выборка
     * в противном случае false
     */
    public static boolean confirmingCorrect(String str)
    {
        List<WebElement> elements = driver.findElements(By.cssSelector(Selector_ELEMENTS));
        for(WebElement element : elements)
        {
            if(!element.getText().contains(str))
                return false;
        }

        return true;
    }

    /**
     * Осуществляет сравнение по выбранным критериям списка объектов имеющих
     * строку. Критериесм является наличие слова в строке.
     * @param str1 является параметром сверки выборки
     * @param str2 является параметром сверки выборки
     * @return возвращает true в случае если сделанна правельная выборка
     * в противном случае false
     */
    public static boolean confirmingCorrect(String str1,String str2)
    {
        List<WebElement> elements = driver.findElements(By.cssSelector(Selector_ELEMENTS));
        for(WebElement element : elements)
        {
            if(!(element.getText().contains(str1)|| element.getText().contains(str2)))
                return false;
        }

        return true;
    }

    /**
     * Осуществляет сравнение по выбранным критериям списка объектов имеющих
     * строку. Критериесм является наличие слова в строке.
     * @param str1 является параметром сверки выборки
     * @param str2 является параметром сверки выборки
     * @param str3 является параметром сверки выборки
     * @return возвращает true в случае если сделанна правельная выборка
     * в противном случае false
     */
    public static boolean confirmingCorrect(String str1,String str2, String str3)
    {
        List<WebElement> elements = driver.findElements(By.cssSelector(Selector_ELEMENTS));

        for(WebElement element : elements)
        {
            if(!(element.getText().contains(str1)|| element.getText().contains(str2) || element.getText().contains(str3)))
                return false;
        }

        return true;
    }

    /**
     * Осуществляет сравнение по выбранным критериям списка объектов имеющих
     * строку. Критериесм является наличие слова в строке.
     * @param str1 является параметром сверки выборки
     * @param str2 является параметром сверки выборки
     * @param str3 является параметром сверки выборки
     * @param str4 является параметром сверки выборки
     * @return возвращает true в случае если сделанна правельная выборка
     * в противном случае false
     */
    public static boolean confirmingCorrect(String str1,String str2, String str3,String str4)
    {
        List<WebElement> elements = driver.findElements(By.cssSelector(Selector_ELEMENTS));

        for(WebElement element : elements)
        {
            if(!(element.getText().contains(str1)|| element.getText().contains(str2) || element.getText().contains(str3)||element.getText().contains(str4)))
                return false;
        }

        return true;
    }


    /**
     * Установление занчения города
     */
    public static void citySelection()
    {
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.cssSelector("div[data-test='login-user-name']"));

        actions.moveToElement(element).build().perform();

        driver.findElement(By.xpath("//*[@id=\"qtip-0-content\"]/div/ul[2]")).click();

        // Ожидание элемента
        driver.findElement(By.className("ui-dialog-wrapper"));

        driver.findElement(By.cssSelector("span[item-id='89026']")).click();

    }



}

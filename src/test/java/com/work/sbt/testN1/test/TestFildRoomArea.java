package com.work.sbt.testN1.test;

import com.work.sbt.testN1.DriverClassController;
import com.work.sbt.testN1.HelperManagerForN1;
import io.qameta.allure.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class TestFildRoomArea
{
    private final static WebDriver driver = new DriverClassController().getDriver();

    // Значение поля цены
    private final static String FILD_AREA = "input[placeholder='Площадь от']";

    // Получения страки текста
    private final static String ELEMENT_TEXT = "h1[class='search-rooms-sell-header__title']";

    // Сравнивоевая строка текста в открывшемся окне
    private final static String COMPARISON_STRING =  "Продажа комнат в Новосибирске";

    // URL при сравнении
    private final static String COMPARISON_URL = "https://novosibirsk.n1.ru/komnaty/";

    // Селектор поля площади
    private final static String SELECTOR_FIND = "div[data-test='offers-list-item-param-total-area']";

    @Before
    public void setUp()
    {
        // Открытье стартовой страницы сайта
        driver.get(DriverClassController.PATH_START_SITE);

        // Устанавливает город
        HelperManagerForN1.citySelection();

        // Нажатие на выподающую вкладку квартиры
        driver.findElement(By.id("s2id_autogen1")).click();

        // Выбор значения комнаты
        driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[2]")).click();
    }

    @AfterClass
    public static void closeSite()
    {
        //В случае если тест является последним осуществляется закрытья драйвера
        if(DriverClassController.counter == DriverClassController.getTEST())
            driver.quit();
    }

    /**
     * Вводим в корректное значение площади
     */
    @Test
    @Description("Correct value of the area")
    public void testCheckingFieldСorrect() throws InterruptedException {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение "50"
        HelperManagerForN1.findElementAndPutString("50",FILD_AREA);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL + "?total_area_min=50"));

        // Получение элементов строки определяющей площадь
        List<WebElement> elements = driver.findElements(By.cssSelector(SELECTOR_FIND));

        elements.forEach((webElement)->{
            // Строка площади с оттеделением букв
            String str =webElement.getText().replaceAll(" м2","");
            // Проверка на что строка не пуста
            if(!str.equals(""))
                // Проверка что площадь пеньше 50
                Assert.assertTrue(Integer.parseInt(str) >= 50);
        });


    }

    /**
     * Вводим в поле строку
     */
    @Test
    @Description("Entry string value of the area")
    public void testCheckingFieldOnNumbers()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение "dfh"
        HelperManagerForN1.findElementAndPutString("dfh",FILD_AREA);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяем что выпали комнаты
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("Ком,"));
    }

    /**
     * Нечего не вводим в поле
     */
    @Test
    @Description("Do not enter anything in the field of the area")
    public void testCheckingFieldOnNothing()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение ""
        HelperManagerForN1.findElementAndPutString("",FILD_AREA);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяем что выпали комнаты
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("Ком,"));
    }

    /**
     * Вводим в поле спецсимволы
     */
    @Test
    @Description("Enter special characters in the field area")
    public void testCheckingFieldSpecialCharacters()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение ":)(^#@"
        HelperManagerForN1.findElementAndPutString(":)(^#@",FILD_AREA);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяем что выпали комнаты
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("Ком,"));
    }

    /**
     * Проверка на SQL запрос
     */
    @Test
    @Description("Enter SQL in the field area")
    public void testCheckingFieldSQL()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение "SELECT id FROM products"
        HelperManagerForN1.findElementAndPutString("SELECT id FROM products",FILD_AREA);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяем что выпали комнаты
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("Ком,"));
    }


}

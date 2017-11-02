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



public class TestOnQuantityRoom
{

    private final static WebDriver driver = new DriverClassController().getDriver();

    // Получения страки текста
    private final static String ELEMENT_TEXT = "h1[class='search-flats-sell-header__title']";

    // Сравнивоевая строка текста в открывшемся окне (Много комнат)
    private final static String COMPARISON_STRING =  "Продажа квартир в Новосибирске";

    // Сравнивоевая строка текста в открывшемся окне (Одна комната)
    private final static String COMPARISON_STRING_ONE =  "Продажа однокомнатных квартир в Новосибирске";

    // Сравнивоевая строка текста в открывшемся окне (Две комнаты)
    private final static String COMPARISON_STRING_TWO=  "Продажа двухкомнатных квартир в Новосибирске";

    // Сравнивоевая строка текста в открывшемся окне (Три комната)
    private final static String COMPARISON_STRING_THREE=  "Продажа трехкомнатных квартир в Новосибирске";

    @Before
    public void setUp()
    {
        // Открытье стартовой страницы сайта
        driver.get(DriverClassController.PATH_START_SITE);

        // Устанавливает город
        HelperManagerForN1.citySelection();

        // Нажатие на выподающую вкладку квартиры
        driver.findElement(By.id("s2id_autogen1")).click();

        // Выбор значения квартиры
        driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[1]")).click();
    }

    @AfterClass
    public static void closeSite()
    {
        //В случае если тест является последним осуществляется закрытья драйвера
        if(DriverClassController.counter == DriverClassController.getTEST())
            driver.quit();
    }

    /**
     * Проверка на нажатия кнопки "1"
     */
    @Test
    @Description("Check the choice of 1-apartment")
    public void testOneRoom()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Осуществляется нажатие на кнопку "1"
        HelperManagerForN1.setRoom("1");

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT ),COMPARISON_STRING_ONE);

        // Проверяем однокомнатные квартиры
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("1-к,"));
    }

    /**
     * Проверка на нажатия кнопки "2"
     */
    @Test
    @Description("Check the choice of 2-apartment")
    public void testTwoRoom()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Осуществляется нажатие на кнопку "2"
        HelperManagerForN1.setRoom("2");

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING_TWO);

        // Проверяем двухкомнатные квартиры
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("2-к,"));
    }

    /**
     * Проверка на нажатия кнопки "3"
     */
    @Test
    @Description("Check the choice of 3-apartment")
    public void testThreeRoom()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Осуществляется нажатие на кнопку "3"
        HelperManagerForN1.setRoom("3");

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING_THREE);

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("3-к,"));
    }

    /**
     * Проверка на нажатия кнопки "4+"
     */
    @Test
    @Description("Check the choice of (4+)-apartment")
    public void testFourPlusRoom()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Осуществляется нажатие на кнопку "+4"
        HelperManagerForN1.setRoom("4+");

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("4-к,","5-к,"));
    }

    /**
     * Проверка на нажатия двух кнопок
     */
    @Test
    @Description("Check the choice of 1-apartment and 3-apartment")
    public void testOneThreeRoom()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Осуществляется нажатие на кнопки "1" , "3"
        HelperManagerForN1.setRoom("1","3");

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("1-к,","3-к,"));
    }

    /**
     * Проверка на нажатие 3 кнопок
     */
    @Test
    @Description("Check the choice of 1-apartment, 3-apartment and (4+)-apartment")
    public void testTwoThreeFoorPlusRoom()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Осуществляется нажатие на кнопки "2" , "3", "4+"
        HelperManagerForN1.setRoom("1","3","4+");

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("1-к,","3-к,", "4-к,","5-k,"));
    }

}

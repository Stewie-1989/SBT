package com.work.sbt.testN1.test;

import com.work.sbt.testN1.DriverClassController;
import com.work.sbt.testN1.HelperManagerForN1;
import io.qameta.allure.Description;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class TestFieldPrice
{
    private final static WebDriver driver = new DriverClassController().getDriver();

    // Значение поля цены
    private final static String FILD_PRICES = "input[placeholder='Цена до']";

    // Получения страки текста
    private final static String ELEMENT_TEXT = "h1[class='search-flats-sell-header__title']";

    // Сравнивоевая строка текста в открывшемся окне
    private final static String COMPARISON_STRING =  "Продажа квартир в Новосибирске";

    // URL при некорректном вводе значения
    private final static String COMPARISON_URL = "https://novosibirsk.n1.ru/search/?rubric=flats";

    // Селектор поиска
    private final static String SELECTOR_FIND = "div[data-test='offers-list-item-param-price']";



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
     * Вводим в поле число
     */
    @Test
    @Description("Enter number in the field")
    public void testCheckingFieldСorrect()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение "4000000"
        HelperManagerForN1.findElementAndPutString("4000000",FILD_PRICES);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().contains("price_max=4000000"));

        // Получение Элементов содержащимх цену
        List<WebElement> elements = driver.findElements(By.cssSelector(SELECTOR_FIND));

        elements.forEach((webElement)-> {
            // Формирование строки цен
            String str = webElement.getAttribute("title")
                    .replaceAll("руб","")
                    .replaceAll(" ","");

            // Проверка соответствия выбраной цене
            Assert.assertTrue(Integer.parseInt(str) < 4_000_000);
        });

    }

    /**
     * Вводим в поле строку
     */
    @Test
    @Description("Enter string in the field")
    public void testCheckingFieldOnString()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение "uaisdhas"
        HelperManagerForN1.findElementAndPutString("uaisdhas",FILD_PRICES);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяет объект на квартиру
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("-к"));
    }

    /**
     * Нечего не вводим в поле
     */
    @Test
    @Description("Do not enter anything in the field")
    public void testCheckingFieldOnNothing()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение ""
        HelperManagerForN1.findElementAndPutString("",FILD_PRICES);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяет объект на квартиру
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("-к"));
    }

    /**
     * Вводим в поле спецсимволы
     */
    @Test
    @Description("Enter special characters in the field")
    public void testCheckingFieldSpecialCharacters()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение ":)(^#@"
        HelperManagerForN1.findElementAndPutString(":)(^#@",FILD_PRICES);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяет объект на квартиру
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("-к"));
    }

    /**
     * Проверка на SQL
     */
    @Test
    @Description("Enter SQL in the field")
    public void testCheckingFieldSQL()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода цены и вводим значение "SELECT id FROM products"
        HelperManagerForN1.findElementAndPutString("SELECT id FROM products",FILD_PRICES);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяет объект на квартиру
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("-к"));
    }



}

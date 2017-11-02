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

public class TestsFieldDistrict
{

    private final static WebDriver driver = new DriverClassController().getDriver();

    // Значение поля локации
    private final static String FILD_DISTRICT = "input[placeholder='Улица, район, микрорайон, метро']";

    // Получения страки текста
    private final static String ELEMENT_TEXT = "h1[class='search-flats-sell-header__title']";

    // Сравнивоевая строка текста в открывшемся окне
    private final static String COMPARISON_STRING =  "Продажа квартир в Новосибирске";

    // URL при некорректном вводе значения
    private final static String COMPARISON_URL= "https://novosibirsk.n1.ru/search/?rubric=flats";

    // Селектор поиска
    private final static String SELECTOR_FIND = "span[class='living-list-card-district__item _base']";

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
     * Вводим в корректное значение строки
     */
    @Test
    @Description("Enter correct string in the field")
    public void testCheckingFieldСorrect()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода локации и вводим значение "Советский район"
        HelperManagerForN1.findElementAndPutString("Советский район",FILD_DISTRICT);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING +" в Советском районе");

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().contains("district=1306096"));

        // Получение объектов содержащих название локации
        List<WebElement> elements = driver.findElements(By.cssSelector(SELECTOR_FIND));

        // Проверка локации на соответствие выбранной
        elements.forEach((webElement) -> Assert.assertTrue(webElement.getText().contains("Советский район")));


    }

    /**
     * Вводим в поле цифры
     */
    @Test
    @Description("Enter number in the field")
    public void testCheckingFieldOnNumbers()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода локации и вводим значение "5235235423"
        HelperManagerForN1.findElementAndPutString("5235235423",FILD_DISTRICT);

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

        // Находим элемент ввода локации и вводим значение ""
        HelperManagerForN1.findElementAndPutString("",FILD_DISTRICT);

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

        // Находим элемент ввода локации и вводим значение ":)(^#@"
        HelperManagerForN1.findElementAndPutString(":)(^#@",FILD_DISTRICT);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяет объект на квартиру
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("-к"));
    }

    /**
     * Проверка на SQL запрос
     */
    @Test
    @Description("Enter SQL in the field")
    public void testCheckingFieldSQL()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Находим элемент ввода локации и вводим значение "SELECT id FROM products"
        HelperManagerForN1.findElementAndPutString("SELECT id FROM products",FILD_DISTRICT);

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.actionAfterWorkField(ELEMENT_TEXT),COMPARISON_STRING);

        // Проверяем совпадение URL
        Assert.assertTrue(driver.getCurrentUrl().equals(COMPARISON_URL));

        // Проверяет объект на квартиру
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("-к"));
    }


}

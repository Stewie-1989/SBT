package com.work.sbt.testN1.test;

import com.work.sbt.testN1.DriverClassController;
import com.work.sbt.testN1.HelperManagerForN1;
import com.work.sbt.testN1.interfacefunc.WorkWithString;
import io.qameta.allure.Description;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class TestTopTabSales
{
    private final static WebDriver driver = new DriverClassController().getDriver();

    // Основной текст из раздела квартиры
    private final static String TEXT_FROM_PAGE = "h1[class='search-flats-sell-header__title']";

    // Основной текст из раздела коттеджи
    private final static String TEXT_FROM_PAGE_COTTAGE = "h1[class='search-cottage-sell-header__title']";

    // Основной текст из раздела комнаты
    private final static String TEXT_FROM_PAGE_ROOMS = "h1[class='search-rooms-sell-header__title']";

    // Объект позволяющий складывать две строки
    private WorkWithString workWithString = (str) -> "a[href='https://novosibirsk.n1.ru/" + str + "/?owl_from_block=mainMenu']";

    @Before
    public void setUp()
    {
        // Открытье стартовой страницы сайта
        driver.get(DriverClassController.PATH_START_SITE);

        // Устанавливает город
        HelperManagerForN1.citySelection();

        // Нахождение элемента "Продажа"
        WebElement element = driver.findElement(By.cssSelector("li[data-test='top-panel-sell']"));

        //Определение объекта Actions
        Actions builder = new Actions(driver);

        //Наведение курсора на элемент
        builder.moveToElement(element).build().perform();

    }

    @AfterClass
    public static void closeSite()
    {
        //В случае если тест является последним осуществляется закрытья драйвера
        if(DriverClassController.counter == DriverClassController.getTEST())
            driver.quit();
    }

    /**
     * Проверяет переход по ссылки квартиры
     */
    @Test
    @Description("Checks the transition to the flat")
    public void testMoveToFlat() {

        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка

        driver.findElement(By.cssSelector(workWithString.somthingWithString("search"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE),"Продажа квартир в Новосибирске");



    }

    /**
     * Проверяет переход по ссылки квартиры студии
     */
    @Test
    @Description("Checks the transition to the studio flat")
    public void testMoveToFlatStudio(){

        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка
        driver.findElement(By.cssSelector(workWithString.somthingWithString("search/type-studija"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE),"Продажа студий в Новосибирске");

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("1-к","2-к","3-к"));

    }

    /**
     * Проверяет переход по ссылки однакомнатные квартиры
     */
    @Test
    @Description("Checks the transition to the 1-room-flat")
    public void testMoveToFlatOneRoom() {

        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка
        driver.findElement(By.cssSelector(workWithString.somthingWithString("search/rooms-odnokomnatnye"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE),"Продажа однокомнатных квартир в Новосибирске");

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("1-к,"));

    }

    /**
     * Проверяет переход по ссылки двухкомнатные квартиры
     */
    @Test
    @Description("Checks the transition to the 2-room-flat")
    public void testMoveToFlatTwoRoom() {

        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка
        driver.findElement(By.cssSelector(workWithString.somthingWithString("search/rooms-dvuhkomnatnye"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE),"Продажа двухкомнатных квартир в Новосибирске");

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("2-к,"));

    }

    /**
     * Проверяет переход по ссылки трехкомнатные квартиры
     */
    @Test
    @Description("Checks the transition to the 3-room-flat")
    public void testMoveToFlatThreeRoom() {

        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка
        driver.findElement(By.cssSelector(workWithString.somthingWithString("search/rooms-trehkomnatnye"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE),"Продажа трехкомнатных квартир в Новосибирске");

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("3-к,"));

    }

    /**
     * Проверяет переход по ссылки многокомнатные квартиры
     */
    @Test
    @Description("Checks the transition to the (4+)-room-flat")
    public void testMoveToFlatFoorPlusRoom() {

        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка

        driver.findElement(By.cssSelector( workWithString.somthingWithString("search/rooms-chetyrehkomnatnye_plus"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE),"Продажа квартир в Новосибирске");

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("4-к,","5-к"));

    }

    /**
     * Проверяет переход по ссылки котеджи и дома
     */
    @Test
    @Ignore
    @Description("Checks the transition to cottages and houses")
    public void testMoveToСottagesAndHouses()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка

        driver.findElement(By.cssSelector(workWithString.somthingWithString("cottedzhy"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE_COTTAGE),"Продажа коттеджей, домов в Новосибирске");

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("Коттедж","Таунхаус","Дом", "Часть дома"));
    }

    /**
     * Проверяет переход по ссылки комнаты
     */
    @Test
    @Description("Checks the transition to rooms")
    public void testMoveToRooms()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Нахождение элемента из выпавшего списка
        driver.findElement(By.cssSelector(workWithString.somthingWithString("komnaty"))).click();

        // Проверяем совпадение текстовых строк
        Assert.assertEquals(HelperManagerForN1.getTextFromPage(TEXT_FROM_PAGE_ROOMS),"Продажа комнат в Новосибирске");

        // Проверка совпадений предлагаемых вариантов
        Assert.assertTrue(HelperManagerForN1.confirmingCorrect("Ком,"));
    }

}

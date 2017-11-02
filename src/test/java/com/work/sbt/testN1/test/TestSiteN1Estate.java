package com.work.sbt.testN1.test;

import com.work.sbt.testN1.DriverClassController;
import com.work.sbt.testN1.HelperManagerForN1;
import io.qameta.allure.Description;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class TestSiteN1Estate
{
    private static WebDriver driver = new DriverClassController().getDriver();

    @Before
    public void setUpSite()
    {
        driver.get(DriverClassController.PATH_START_SITE);

        // Устанавливает город
        HelperManagerForN1.citySelection();
    }

    @AfterClass
    public static void closeSite()
    {
        if(DriverClassController.counter == DriverClassController.getTEST())
            driver.quit();
    }

    /**
     * Проверяет что мы находимся на сайте "N1Недвижимость"
     */
    @Test
    @Description("Checks that we are on the site")
    public void testCheckingOnSite()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Сравнение URL страницы
        Assert.assertEquals(driver.getCurrentUrl(),DriverClassController.PATH_START_SITE + "prodazha/");
    }

    /**
     *Нажатье на кнопку "Продажа"
     *
     */
    @Test
    @Description("Entery on the button sale")
    public void testClickLinkSale()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Нажатие на кнопку Продажа
        driver.findElement(By.cssSelector("a[href='/prodazha/']")).click();

        // Сравнение URL страницы
        Assert.assertEquals(driver.getCurrentUrl(),DriverClassController.PATH_START_SITE + "prodazha/");
    }

    /**
     * Нажатие на кнопку "Аренда"
     */
    @Test
    @Description("Entery on the button rent")
    public void testClickLinkRent()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Нажатие на кнопку Аренда
        driver.findElement(By.cssSelector("a[href='/arenda/']")).click();

        // Сравнение URL страницы
        Assert.assertEquals(driver.getCurrentUrl(),DriverClassController.PATH_START_SITE + "arenda/");
    }

    /**
     * Нажатие на кнопку "Новостройки"
     */
    @Test
    @Description("Entery on the button NewBuildings")
    public void testClickLinkNewBuildings()
    {
        // Счетчик теста
        DriverClassController.counter ++;

        // Нажатие на кнопку новостройки
        driver.findElement(By.cssSelector("a[href='/katalog_novostroek/']")).click();

        // Сравнение URL страницы
        Assert.assertEquals(driver.getCurrentUrl(),DriverClassController.PATH_START_SITE + "katalog_novostroek/");
    }




}

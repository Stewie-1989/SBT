package com.work.sbt.testN1;

import com.work.sbt.testN1.interfacefunc.MergeString;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;


import java.util.concurrent.TimeUnit;


public class DriverClassController
{
    public static final String PATH_START_SITE = "https://novosibirsk.n1.ru/";

    private static final String NAME_DRIVER_CHROME = "webdriver.chrome.driver";

    private static final String PASH_TO_DRIVER = "src/test/resources";

    private static final String CHROME = "chromedriver.exe";

    // Время ожидания
    private static final int TIME_OUT = 10;

    // Сложение двух строк
    private MergeString mergeString = (str1, str2) -> str1 + "/" +str2;

    // Драйвер брайзера
    private static WebDriver driver;

    // Количество тестов Selenium
    private static final int TEST = 33;

    // Счетчик тестов
    public static int counter = 0;

    public DriverClassController()
    {
        if(driver == null)
        {
            //Запуск драйвера
            System.setProperty(NAME_DRIVER_CHROME, mergeString.doSomtingWithString(PASH_TO_DRIVER, CHROME));

            Capabilities crom = DesiredCapabilities.chrome();

            //Инициализация хром драйвера
            driver = WebDriverPool.DEFAULT.getDriver(crom);

            // Максимально вощзмоджный размер браузера
            driver.manage().window().maximize();

            // Задание глобального ожидания
            driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public static int getTEST() {
        return TEST;
    }
}

package ru.gb.webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Start2 {
    private static WebDriver driver;
    // private static final String LOGIN_PAGE_URL = "https://crm.gb.space/user/login";
    // для авторизации нужно прописать тестовые данные логин и пароль
    private static final String MAIN_PAGE = "https://gb.ru";
    private static final String LOGIN = "LoginTest";
    private static final String PASSWORD = "Test123";



    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get(MAIN_PAGE);
        Thread.sleep(1000);

        // Демонстрация разворачивания окна браузера
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // По имени тега
        WebElement elementNameTag = driver.findElement(By.cssSelector("div[@id='header-monolit']"));

        // По имени класса? по имени тега с id  пока не нашла, добавлю
        WebElement elementNameClass = driver.findElement(By.cssSelector("span[class='mn-header-nav-line__link mn-btn-default__programms mn-with-triangle']"));
        elementNameClass.click();
        // elementNameClass.sendKeys("LoginTest"); // Можно передавать какой-то текст в виде текста
        // elementNameClass.sendKeys(PASSWORD); // или константы

        Thread.sleep(1000);

        // По xpath
        WebElement elementXpath = driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/a[1]"));
        elementXpath.click();
        Thread.sleep(2000);





        // Демонстрация QUIT - закрывает браузер
        driver.quit();

    }
}

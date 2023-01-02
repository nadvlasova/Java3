package ru.gb.webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Start1 {
    private static WebDriver driver;
    // private static final String LOGIN_PAGE_URL = "https://crm.gb.space/user/login";
    // для авторизации нужно прописать тестовые данные логин и пароль
    private static final String MAIN_PAGE = "https://gb.ru";


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        //driver.get(LOGIN_PAGE_URL);
        driver.get(MAIN_PAGE);
        Thread.sleep(1000);

        // Демонстрация разворачивания окна браузера
        driver.manage().window().maximize();
        // driver.manage().window().fullscreen();
        // driver.manage().window().getSize();
        // driver.manage().window().getPosition();
        Thread.sleep(1000);


        // Демонстрация установки конкретных размеров окна
        driver.manage().window().setSize(new Dimension(500, 500));
        Thread.sleep(1000);

        // Создаем новую вкладку. Разбор в уроке 5
        ((JavascriptExecutor) driver).executeScript("window.open()"); // похоже у него он где-то готовый
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Переключаемся на вторую вкладку
        driver.switchTo().window(tabs.get(1));
        driver.get(MAIN_PAGE);
        Thread.sleep(1000);

        // Возвращаемся на первую вкладку
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);

        // Демонстрация - закрывает вкладку
        driver.close();
        Thread.sleep(1000);

        // Демонстрация QUIT - закрывает браузер
        driver.quit();

    }
}












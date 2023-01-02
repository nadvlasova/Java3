package ru.gb.webui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// Заменяем все Thread на ожидания
public class Start3 {
    private static final String MAIN_PAGE = "https://gb.ru";
    private static final WebDriver driver;

    static  {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(MAIN_PAGE);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

        driver.findElement(By.linkText("Выбор программы")).click();

        driver.quit();
    }
}

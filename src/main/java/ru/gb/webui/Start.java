package ru.gb.webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Start {
    public static void main(String[] args) throws InterruptedException{
        // в resources скачиваем chromedriver и запускаем через него
        // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        // а теперь устанавливаем webdrivermanager и запускаем через него chromedriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}

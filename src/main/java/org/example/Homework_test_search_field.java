package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework_test_search_field {
    private static final WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://www.ikea.com/ru/ru/profile/login";
    private static final String LOGIN = "eremina.1906@gmail.com";
    private static final String PASSWORD = "1234567891abcABC!";

    static {
            System.setProperty("webdriver.chrome.driver", "src/main/resourses/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

    public static void main(String[] args) throws InterruptedException {

        login();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");


        //клик на строку поиска

        WebElement search = driver.findElement(By.xpath(".//input[@class='search-field__input_' and name='q']"));
        search.sendKeys("сагоскатт");
//<input type="search" name="q" maxlength="150" class="search-field__input " spellcheck="false"
// aria-label="Искать товары, новинки и вдохновение" aria-placeholder="Искать товары, новинки и вдохновение"
// placeholder="Что вы ищете?" autocapitalize="off" autocomplete="off" autocorrect="off">


    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement login = driver.findElement(By.cssSelector("input[id='username']"));
        login.sendKeys(LOGIN);

        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@class='btn btn--transactional sc-dxgOiQ sc-eNQAEJ cDdCyP']"));
        loginButton.click();

        driver.quit();
    }
}

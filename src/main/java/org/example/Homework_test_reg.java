package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_test_reg {
    private static final String LOGIN_PAGE_URL = "https://www.ikea.com/ru/ru/profile/login";
    private static final String LOGIN = "eremina.1906@gmail.com";
    private static final String PASSWORD = "1234567891abcABC!";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().setSize(new Dimension(1000,1000));


       WebElement login = driver.findElement(By.cssSelector("input[id='username']"));
        login.sendKeys(LOGIN);
        Thread.sleep(2000);


        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys(PASSWORD);
        Thread.sleep(2000);

       WebElement loginButton = driver.findElement(By.xpath(".//button[@class='btn btn--transactional sc-dxgOiQ sc-eNQAEJ cDdCyP']"));
        loginButton.click();
        Thread.sleep(4000);
        driver.quit();

    }
}

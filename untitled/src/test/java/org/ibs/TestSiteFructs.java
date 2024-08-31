package org.ibs;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestSiteFructs {

   private static WebDriver driver;

    @BeforeAll
   static void addVegetable(){
        System.setProperty("webdriver.chromedriver.driver", "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/food");
    }

    @AfterAll
    static void afterTests(){
        driver.quit();
    }


    @Test
    void addProductWithHardName() {

        WebElement btnAdd = driver.findElement(By.xpath("//button[@data-target='#editModal']"));

        btnAdd.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputName = driver.findElement(By.xpath("//input[@id = 'name']"));
        inputName.sendKeys("dghj%:*ГўвЂћвЂ“5ГђВїГђВ°ГђВІГђВ»ГђВї");

        WebElement selectType = driver.findElement(By.xpath("//select[@id='type']"));
        selectType.click();

        WebElement optionType = driver.findElement(By.xpath("//option[@value='VEGETABLE']"));
        optionType.click();

        WebElement checkboxExotic = driver.findElement(By.xpath("//input[@id='exotic']"));
        checkboxExotic.click();

        WebElement btnSave = driver.findElement(By.xpath("//button[@id='save']"));
        btnSave.click();

        WebElement addedProductName = driver.findElement(By.xpath("//td[text()='dghj%:*ГўвЂћвЂ“5ГђВїГђВ°ГђВІГђВ»ГђВї']"));

        Assertions.assertEquals(addedProductName.getText(),"dghj%:*ГўвЂћвЂ“5ГђВїГђВ°ГђВІГђВ»ГђВї");
    }

    @Test
    void addExoticFruct() {

        WebElement btnAdd = driver.findElement(By.xpath("//button[@data-target='#editModal']"));

        btnAdd.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement selectType = driver.findElement(By.xpath("//select[@id='type']"));
        selectType.click();

        WebElement optionType = driver.findElement(By.xpath("//option[@value='FRUIT']"));
        optionType.click();

        WebElement checkboxExotic = driver.findElement(By.xpath("//input[@id='exotic']"));
        checkboxExotic.click();

        WebElement btnSave = driver.findElement(By.xpath("//button[@id='save']"));
        btnSave.click();

        WebElement addedProductName = driver.findElement(By.xpath("//td[not(text())]"));

        Assertions.assertEquals(addedProductName.getText(),"");
    }


    }

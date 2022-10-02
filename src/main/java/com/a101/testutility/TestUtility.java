package com.a101.testutility;

import com.github.javafaker.Faker;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestUtility {
    WebDriver driver;

    private int timeOut = Integer.parseInt(ConfigurationReader.readConfigProperties("timeOut"));

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Random create title
    public String randomTitle(){
        Faker faker = new Faker();
        return faker.name().title();
    }

    //Random create street address
    public String randomAddress(){
        Faker faker=new Faker();
        return faker.address().streetAddress();
    }

    //Random create zipcode
    public String randomZipCode(){
        Faker faker=new Faker();
        return faker.number().digits(8);
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
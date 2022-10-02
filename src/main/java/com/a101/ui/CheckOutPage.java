package com.a101.ui;

import com.a101.testutility.ConfigurationReader;
import com.a101.testutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
    WebDriver driver;
    TestUtility testUtility;

//    String city = ReadFromFile.readConfigProperties("city");
//    String townShip = ReadFromFile.readConfigProperties("townShip");
//    String district = ReadFromFile.readConfigProperties("district");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }


    @FindBy(css = "a[title=\"Yeni adres oluştur\"]")
    WebElement createNewAddress;

    @FindBy(name = "title")
    WebElement addressTitle;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "phone_number")
    WebElement phoneNumber;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "township")
    WebElement townShip;

    @FindBy(name = "district")
    WebElement district;

    @FindBy(name = "line")
    WebElement addressDetail;

    @FindBy(name = "postcode")
    WebElement postCode;

    @FindBy(xpath = "//button[contains(text(),'KAYDET')]")
    WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),'Sendeo')]")
    WebElement chooseCargo;

    @FindBy(xpath = "//button[contains(text(),'Kaydet ve Devam Et')]")
    WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'Siparişi Tamamla')]")
    WebElement orderComplete;

    @FindBy(xpath = "//span[contains(text(),'Lütfen kart seçin veya kart bilgisi girin.')]")
    WebElement verifyOrderComplete;

    public void clickCreateNewAddress(){
        testUtility.waitForElementPresent(createNewAddress);
        createNewAddress.click();
    }

    public void fillAddressTitle(){
        testUtility.waitForElementPresent(addressTitle);
        addressTitle.sendKeys(testUtility.randomTitle());
    }

    public void fillFirstName(){
        testUtility.waitForElementPresent(firstName);
        firstName.sendKeys(ConfigurationReader.readConfigProperties("firstName"));
    }

    public void fillLastName(){
        testUtility.waitForElementPresent(lastName);
        lastName.sendKeys(ConfigurationReader.readConfigProperties("lastName"));
    }

    public void fillPhoneNumber(){
        testUtility.waitForElementPresent(phoneNumber);
        phoneNumber.sendKeys(ConfigurationReader.readConfigProperties("phoneNumber"));
    }

    public void selectCity(){
        testUtility.waitForElementPresent(city);
        Select select = new Select(city);
        select.selectByValue(ConfigurationReader.readConfigProperties("cityValue"));
    }

    public void selectTownShip(){
        testUtility.waitForElementPresent(townShip);
        Select select = new Select(townShip);
        select.selectByValue(ConfigurationReader.readConfigProperties("townShipValue"));
    }

    public void selectDistrict(){
        testUtility.waitForElementPresent(district);
        Select select = new Select(district);
        select.selectByValue(ConfigurationReader.readConfigProperties("districtValue"));
    }

    public void fillAddressDetail(){
        testUtility.waitForElementPresent(addressDetail);
        addressDetail.sendKeys(testUtility.randomAddress());
    }

    public void fillPostCode(){
        testUtility.waitForElementPresent(postCode);
        postCode.sendKeys(testUtility.randomZipCode());
    }

    public void clickSaveButton(){
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public void chooseCargoField(){
        testUtility.waitForElementPresent(chooseCargo);
        chooseCargo.click();
    }

    public void clickSubmitButton(){
        testUtility.waitForElementPresent(submitButton);
        submitButton.click();
    }

    public void clickOrderComplete(){
        testUtility.waitForElementPresent(orderComplete);
        orderComplete.click();
    }

    public boolean verifyMessage(){
        testUtility.waitForElementPresent(verifyOrderComplete);
        if (verifyOrderComplete.getText().equals("Lütfen kart seçin veya kart bilgisi girin.")){
            System.out.println("You are in Payment Screen");
            return true;
        }else {
            return false;
        }
    }

    public void checkOutPage(){
        clickCreateNewAddress();
        fillAddressTitle();
        fillFirstName();
        fillLastName();
        fillPhoneNumber();
        selectCity();
        testUtility.sleep(2);
        selectTownShip();
        testUtility.sleep(2);
        selectDistrict();
        fillAddressDetail();
        fillPostCode();
        clickSaveButton();
        chooseCargoField();
        testUtility.sleep(2);
        clickSubmitButton();
        testUtility.sleep(2);
        clickOrderComplete();
    }
}
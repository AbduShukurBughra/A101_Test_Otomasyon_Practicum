package com.a101.ui;

import com.a101.testutility.ConfigurationReader;
import com.a101.testutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    TestUtility testUtility;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(css = "button[data-pk=\"18864\"]")
    WebElement addToCart;

    @FindBy(css = "a[class=\"go-to-shop\"]")
    WebElement viewCart;

    @FindBy(partialLinkText = "Sepeti Onay")
    WebElement confirmCart;

    @FindBy(xpath = "//a[contains(text(),'ÜYE OLMADAN DEVAM ET')]")
    WebElement continueWithoutRegis;

    @FindBy(name = "user_email")
    WebElement userEmail;

    @FindBy(xpath = "//button[contains(text(),'DEVAM ET')]")
    WebElement submitContinueButton;

    public void clickAddToCart(){
        testUtility.waitForElementPresent(addToCart);
        addToCart.click();
    }

    public void clickViewCart(){
        testUtility.waitForElementPresent(viewCart);
        viewCart.click();
    }

    public void clickConfirmCart(){
        testUtility.waitForElementPresent(confirmCart);
        confirmCart.click();
    }

    public void clickContinueWithoutRegis(){
        testUtility.waitForElementPresent(continueWithoutRegis);
        continueWithoutRegis.click();
    }

    public void enterUserEmail(){
        testUtility.waitForElementPresent(userEmail);
        userEmail.sendKeys(ConfigurationReader.readConfigProperties("userEmail"));
    }

    public void clickContinueButton(){
        testUtility.waitForElementPresent(submitContinueButton);
        submitContinueButton.click();
    }

    public void cartPageActions(){
        clickAddToCart();
        clickViewCart();
        clickConfirmCart();
        clickContinueWithoutRegis();
        enterUserEmail();
        clickContinueButton();
    }
}
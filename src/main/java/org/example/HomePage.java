package org.example;

import org.openqa.selenium.By;

import org.testng.Assert;

import java.util.*;

public class HomePage extends Utils {

    LoadProp loadProp = new LoadProp();

    By _registerBtn = By.className("ico-register");
    By _computerCategoryHomepage = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
    By _selectEuroCurrency = By.id("customerCurrency");
    By _actualPriceOfProduct = By.xpath("//div[@data-productid=\"1\"]//child::span[contains(text(),\"€\")]");
    By _clickOnProductName = By.xpath("//a[contains(text(),\"own computer\")]");
    By _radioBTNOfPoll = By.id("pollanswers-2");
    By _clickOnVoteBtn = By.id("vote-poll-1");
    By _errorMessageVote = By.id("block-poll-vote-error-1");
    By _successMessageOfVote = By.xpath("//ul[@class='poll-results']/following-sibling::span");
    By _facebookIcon = By.xpath("//a[contains(text(),'Facebook')]");
    By _searchSpace = By.id("small-searchterms");
    By _clickOnSearchBtn = By.xpath("//button[@type=\"submit\"]");
    By _clickOnDetails = By.xpath("//div[@class=\"news-items\"]/div[2]//a[@class='read-more']");



    public void clickOnNewsReleaseDetails(){

    //Click on Details
        driverClickOnElement(_clickOnDetails);

    }

    public void typeInSearch(String value){
        driverSendKeys((_searchSpace),value);
    }

    public  void clickOnSearchBtn(){
        driverClickOnElement(_clickOnSearchBtn);
    }

    public void fbButtonVerificationWithPopUpWindow(){

        driverClickOnElement(_facebookIcon);
        //Main Window Handle
        String mainWindow = driver.getWindowHandle();
        //Multiple Window Handles
        Set<String> handles = driver.getWindowHandles();
        //Iterator to every Handles
        Iterator<String> itr = handles.iterator();

        while (itr.hasNext()){
            String subWindows = itr.next();

            if (!mainWindow.equals(subWindows)){
                //go to new window
               driver.switchTo().window(subWindows);
               //
                driverWaitUrlToBe("https://www.facebook.com/nopCommerce",5);
               //Get url
               String actualUrl = driver.getCurrentUrl();
               System.out.println("actual ="+actualUrl);
               System.out.println("Expected =https://www.facebook.com/nopCommerce");

               //verification
                Assert.assertEquals(actualUrl,"https://www.facebook.com/nopCommerce","Facebook URL is not matching");
                //switch to main window
                driver.switchTo().window(mainWindow);
                //Close the window
                driver.close();
            }
        }
    }

    public void switchToPopUpAlertGetTextsWithVerification(){
        //Get Text
        String actual = driver.switchTo().alert().getText();
        //Expected Text
        String expected = "Please select an answer";
        //Verification
        Assert.assertEquals(actual,expected,"Alert Message is not matching");
    }

    //Accept PopUp window
    public  void switchToPopUpAlertAccept(){
        driver.switchTo().alert().accept();
    }

    public void clickOnRegister() {
        // click on register button
        driver.findElement(_registerBtn).click();
        //driverClickOnElement(By.className("ico-register"));
    }

    public void clickOnComputer() {
        driverClickOnElement(_computerCategoryHomepage);

    }

    public void selectEuroCurrency() {
        selectByIndex(_selectEuroCurrency, 1);
    }

    public void verifyCurrencyOnProductPrice(char capture, int charAt) {
        char expected = capture;
        char actualPrice = gettext(_actualPriceOfProduct).charAt(charAt);
        Assert.assertEquals(actualPrice, expected, "Currency is WRONG");
    }

    public void verifyURLtoBe() {
        driverWaitUrl("https://demo.nopcommerce.com/", 2);
    }

    public void clickOnProductName() {
        driverClickOnElement(_clickOnProductName);
    }

    public void clickOnPollRadioButton() {
        driverClickOnElement(_radioBTNOfPoll);
    }

    public void clickOnVote() {
        driverWaitsUntilClick(_clickOnVoteBtn, 5);
    }

    public void verifyErrorMessageOfPole() {

        driverTextToBe(_errorMessageVote, "Only registered users can vote.", 10);
        String actual = driver.findElement(_errorMessageVote).getText();
        String expected = "Only registered users can vote.";
        Assert.assertEquals(actual, expected, "Error message dose not matched");
    }

    public void verifyVoteSuccess() {
        String actual = driver.findElement(_successMessageOfVote).getText().substring(3);
        String expected = "vote(s)...";
        Assert.assertEquals(actual, expected, "Text does not matched");

    }


}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends Utils {


    By _registerBtn = By.className("ico-register");
    By _registerLink = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
    By _selectEuroCurrency = By.id("customerCurrency");
    By _actualPriceOfProduct = By.xpath("//div[@data-productid=\"1\"]//child::span[contains(text(),\"€\")]");
    By _clickOnProductName = By.xpath("//a[contains(text(),\"own computer\")]");
    By _radioBTNOfPoll =By.id("pollanswers-2");
    By _clickOnVoteBtn =By.id("vote-poll-1");
    By _errorMessageVote = By.id("block-poll-vote-error-1");
    By _successMessageOfVote = By.xpath("//ul[@class='poll-results']/following-sibling::span");


    public void clickOnRegister() {
        // click on register button
        driver.findElement(_registerBtn).click();
        //driverClickOnElement(By.className("ico-register"));
    }

    public void clickOnComputer() {
        driverClickOnElement(_registerLink);

    }

    public void selectEuroCurrency() {
        selectByIndex(_selectEuroCurrency, 1);
    }

    public void verifyCurrencyOnProductPrice(char capture, int charAt) {
        char Expected = capture;
        char ActualPrice = gettext(_actualPriceOfProduct).charAt(charAt);
        Assert.assertEquals(ActualPrice, Expected, "Currency is WRONG");
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
        driverWaitsUntilClick(_clickOnVoteBtn,5);
    }

    public void verifyVoteSuccess() {
            String actual = driver.findElement(_successMessageOfVote).getText().substring(3);
            String expected = "vote(s)...";
            Assert.assertEquals(actual,expected,"Text does not matched");
            System.out.println("Expected :- " + expected);
            System.out.println("Actual :- " + actual);
        }

    public void verifyErrorMessageOfPole(){

        waitforText(_errorMessageVote,"Only registered users can vote.",10);
        String actual= driver.findElement(_errorMessageVote).getText();
        String expected = "Only registered users can vote.";
        System.out.println("Actual:- "+actual);
        System.out.println("Expected:- "+expected);

      Assert.assertEquals(actual,expected,"Error message dose not matched");
    }
    public void verify(){



    }

    }

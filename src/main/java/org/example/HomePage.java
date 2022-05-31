package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {

    public void clickOnRegister() {
        // click on register button
        driver.findElement(By.className("ico-register")).click();
        //driverClickOnElement(By.className("ico-register"));
    }

    public void clickOnComputer() {
        driverClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));

    }

    public void selectEuroCurrency() {
        selectByIndex(By.id("customerCurrency"), 1);
    }

    public void verifyCurrencyOnProductPrice(char capture, int charAt) {
        char Expected = capture;
        char ActualPrice = gettext(By.xpath("//div[@data-productid=\"1\"]//child::span[contains(text(),\"€\")]")).charAt(charAt);
        Assert.assertEquals(ActualPrice, Expected, "Currency is WRONG");
    }

    public void verifyURLtoBe() {
        driverWaitUrl("https://demo.nopcommerce.com/", 2);
    }

    public void clickOnProductName() {
        driverClickOnElement(By.xpath("//a[contains(text(),\"own computer\")]"));
    }

    public void clickOnPollRadioButton() {
        driverClickOnElement(By.id("pollanswers-2"));
    }

    public void clickOnVote() {
        driverClickOnElement(By.id("vote-poll-1"));
    }

    public void verifyVoteSuccess() {
            String actual = driver.findElement(By.xpath("//ul[@class='poll-results']/following-sibling::span")).getText().substring(3);
            String expected = "vote(s)...";
            Assert.assertEquals(actual,expected,"Text does not matched");
            System.out.println("Expected :- " + expected);
            System.out.println("Actual :- " + actual);

        }

    }

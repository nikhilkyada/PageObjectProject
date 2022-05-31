package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.regex.Pattern;

public class Utils extends BasePage{

    //All Re-usable Methods

    //Assert
    public static void waitAssertEqualsIgnoreCase(By by,String text, int time){

        String actual = driver.findElement(by).getText();
        String expected =driver.findElement(by).getText().substring(3);
        System.out.println("Expected"+expected);
        System.out.println("actual"+actual);
    }

    //Screenshot
    public static void takeScreenshot(String filename){
        //Convert Web Driver Object to Screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Calling getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Copy file at Destination folder
        try {
            FileUtils.copyFile(srcFile, new File("Screenshots\\"+filename+rendomdate()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Select by Index
    public static void selectByIndex(By by,int index){
        Select selectDay = new Select(driver.findElement(by));
        selectDay.selectByIndex(index);
    }
    //Select by Visible Text
    public static void selectByVisibleText(By by,String text){
        Select selectYear = new Select(driver.findElement(by));
        selectYear.selectByVisibleText(text);
    }

    //Click on Element
    public static void driverClickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    //Send Text Values
    public static void driverSendKeys(By by, String value)
    {
        driver.findElement(by).sendKeys(value);
    }

    //Time stamp
    public static String rendomdate()
    {
        Date dat = new Date();
        SimpleDateFormat formate = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formate.format(dat);
    }

    //Wait for element to be click-able
    public static void WaitUntilClickableByWebElement(By by, int time)
    {
        WebElement element=driver.findElement(by);
        element.findElement(by).click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //Wait for element to be click-able
    public static void driverWaitsUntilClick(By by, int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    //wait for url
    public static void driverWaitUrl(String url, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    //Get text
    public static String gettext(By by)
    {
        return driver.findElement(by).getText();
    }

    public static String titleOfPage(){
        return driver.getTitle();
    }

    //Wait until Presence of Element (All)
    public static void driverPresenceofElement(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    //wait until presence of Element Located (One only)
    public static void driverPresenceOfElement(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //URL Fraction or Contains
    public static void  driverURLContains(String URLContains,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(URLContains));
    }

    //wait until Element title contains
    public static void DriverElementTitleContains (String title,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(title));
    }

    //Wait until Invisibility of WebElement
    public static void driverInvisibilityOfElement(WebElement element,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //Wait until alert is Present >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Quation<<<<<<<<<<<<<<<<<<<<<<<<<
    public static void driverAlertsPresent (int time)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //Wait until Attribute ToBe  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Quation<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public static void driverAttributeToBe(By by, String attribute, String value, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by,attribute,value));
    }

    //Wait until Attribute not Empty (WebElement & Attribute)
    public static void driverAttributeNotEmpty(WebElement webelement, String attribute, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webelement,attribute));
    }

    //Wait until Element to be Selected (Locator)
    public static void driverElementToBeSelected(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    //Wait until TextToBe
    public static void driverTextToBe(By by,String value,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by,value));
    }

    //Wait until Text tobe Match<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Quation>>>>>>>>>>>>>>>>>>>
    public static void driverTextTobeMatch(By by, Pattern pattern , int time)
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textMatches(by,pattern));
    }

    //DOM Attribute tobe <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Quation>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public static void driverDomAttributesToBe(WebElement element,String attribute, String value,int time)
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.domAttributeToBe(element,attribute,value));
    }
}

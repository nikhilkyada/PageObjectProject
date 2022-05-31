package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends Utils {


    public void verifyRegistrationPageURL(){
        //Verify the URL
        driverWaitUrl("https://demo.nopcommerce.com/register?returnUrl=%2F",5);
    }


    public void enterAllRegistrationDetails(){

        //Select Male Radio button----------------------------------------------------------------Radio button
        driver.findElement(By.id("gender-male")).click();

        //Enter First name
        driverSendKeys(By.xpath("//input[@name='FirstName']"), "Rajesh");

        //Enter Last name
        driverSendKeys(By.id("LastName"), "Patel");

        //Birth Day-----------------------------------------------------------------------------Birthdate & All
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByIndex(9);
        //Month
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("12");
        //Year
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByVisibleText("1996");

        //Enter Email and Printout Time
        driverSendKeys(By.id("Email"), "abc" + rendomdate() + "@gmail.com");
        System.out.println(rendomdate());

        //Enter password
        driverSendKeys(By.id("Password"), "asd@123");

        //Enter Confirmed Password
        driverSendKeys(By.id("ConfirmPassword"), "asd@123");

        //Click on Register button
        driverWaitsUntilClick(By.id("register-button"),5);
    }
}

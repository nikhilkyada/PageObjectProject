package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends Utils {

    public void enterAllRegistrationDetails(){
        //Select Male Radio button----------------------------------------------------------------Radio button
        driver.findElement(By.id("gender-male")).click();

        //Enter First name
        driverSendValue(By.xpath("//input[@name='FirstName']"), "Rajesh");

        //Enter Last name
        driverSendValue(By.id("LastName"), "Patel");

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
        driverSendValue(By.id("Email"), "abc" + rendomdate() + "@gmail.com");
        System.out.println(rendomdate());

        //Enter password
        driverSendValue(By.id("Password"), "asd@123");

        //Enter Confirmed Password
        driverSendValue(By.id("ConfirmPassword"), "asd@123");

        //Click on Register button
        driverWaitsUntil(By.id("register-button"),5);
    }
}

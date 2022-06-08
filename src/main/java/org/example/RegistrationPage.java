package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends Utils {

    By _radioMaleRegister = By.id("gender-male");
    By _firstNameField =  By.xpath("//input[@name='FirstName']");
    By _lastnameField = By.id("LastName");
    By _birthdate = By.name("DateOfBirthDay");
    By _birthMonth =By.name("DateOfBirthMonth");
    By _birthYear = By.name("DateOfBirthYear");
    By _emailAddress = By.id("Email");
    By _passwordField = By.id("Password");
    By _confPassword = By.id("ConfirmPassword");
    By _clickOnRegister = By.id("register-button");


    public void verifyRegistrationPageURL(){
        //Verify the URL
        driverWaitUrl("https://demo.nopcommerce.com/register?returnUrl=%2F",5);
    }


    public void enterAllRegistrationDetails(){

        //Select Male Radio button----------------------------------------------------------------Radio button
        driver.findElement(_radioMaleRegister).click();

        //Enter First name
        driverSendKeys((_firstNameField), "Rajesh");

        //Enter Last name
        driverSendKeys(_lastnameField, "Patel");

        //Birth Day-----------------------------------------------------------------------------Birthdate & All
        Select selectDay = new Select(driver.findElement(_birthdate));
        selectDay.selectByIndex(9);
        //Month
        Select selectMonth = new Select(driver.findElement(_birthMonth));
        selectMonth.selectByValue("12");
        //Year
        Select selectYear = new Select(driver.findElement(_birthYear));
        selectYear.selectByVisibleText("1996");

        //Enter Email and Printout Time
        driverSendKeys(_emailAddress, "abc" + rendomdate() + "@gmail.com");
        System.out.println(rendomdate());

        //Enter password
        driverSendKeys(_passwordField, "asd@123");

        //Enter Confirmed Password
        driverSendKeys(_confPassword, "asd@123");

        //Click on Register button
        driverWaitsUntilClick(_clickOnRegister,5);
    }
}

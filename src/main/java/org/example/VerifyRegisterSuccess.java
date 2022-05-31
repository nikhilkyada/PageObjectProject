package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyRegisterSuccess extends Utils {

    public void verifyRegistrationSuccess(){

        //Result verification for Registration
        String actual = gettext(By.className("result"));
        String expected = "Your registration completed";
        Assert.assertEquals(actual, expected, "Registration is not success full");

    }

    public void clickOnContinue(){
        driverWaitsUntilClick(By.xpath("//a[contains(text(),\"Continue\")]"),5);
    }
}

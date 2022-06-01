package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyRegisterSuccess extends Utils {
    By _getSuccessMessage = By.className("result");
    By _continueBtn = By.xpath("//a[contains(text(),\"Continue\")]");

    public void verifyRegistrationSuccess(){

        //Result verification for Registration
        String actual = gettext(_getSuccessMessage);
        String expected = "Your registration completed";
        Assert.assertEquals(actual, expected, "Registration is not success full");

    }

    public void clickOnContinue(){
        driverWaitsUntilClick(_continueBtn,5);
    }
}

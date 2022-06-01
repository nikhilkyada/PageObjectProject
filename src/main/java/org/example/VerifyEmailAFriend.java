package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyEmailAFriend extends Utils{
    By _verifyEmailAFriend = By.className("result");

   //Verification
    public void verifyEmailAFriend(){
        String expected = "Your message has been sent.";
        String actual = gettext(_verifyEmailAFriend);
        Assert.assertEquals(actual,expected,"Sending Email to Friend was FAILED");

    }
}

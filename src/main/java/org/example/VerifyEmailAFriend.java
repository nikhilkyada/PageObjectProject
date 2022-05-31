package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyEmailAFriend extends Utils{
   //Verification
    public void verifyEmailAFriend(){
        String expected = "Your message has been sent.";
        String actual = gettext(By.className("result"));
        Assert.assertEquals(actual,expected,"Sending Email to Friend was FAILED");

    }
}

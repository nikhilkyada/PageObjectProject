package org.example;

import org.openqa.selenium.By;

public class EmailaFriend extends Utils{

    By _friendEmailField = By.id("FriendEmail");
    By _typeMessage = By.id("PersonalMessage");
    By _clickSend = By.xpath("//button[contains(text(),\"Send email\")]");

    public void verifyURLtoBe(){
        driverWaitUrl("https://demo.nopcommerce.com/productemailafriend/1",3);
    }
    public void typeFriendEmail(){
        driverSendKeys(_friendEmailField,"asd"+rendomdate()+"@gmail.com");
    }
    public void typeMessage(){
        driverSendKeys(_typeMessage,"This item is good");
    }
    public void clickOnSendButton(){
        driverClickOnElement(_clickSend);
    }
}

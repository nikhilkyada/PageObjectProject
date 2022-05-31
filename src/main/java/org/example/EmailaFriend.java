package org.example;

import org.openqa.selenium.By;

public class EmailaFriend extends Utils{
    public void verifyURLtoBe(){
        driverWaitUrl("https://demo.nopcommerce.com/productemailafriend/1",3);
    }
    public void typeFriendEmail(){
        driverSendKeys(By.id("FriendEmail"),"asd"+rendomdate()+"@gmail.com");
    }
    public void typeMessage(){
        driverSendKeys(By.id("PersonalMessage"),"This item is good");
    }
    public void clickOnSendButton(){
        driverClickOnElement(By.xpath("//button[contains(text(),\"Send email\")]"));
    }
}

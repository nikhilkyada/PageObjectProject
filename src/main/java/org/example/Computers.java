package org.example;

import org.openqa.selenium.By;

public class Computers extends Utils{

    public void verifyDesktopURL(){
        driverWaitUrl("https://demo.nopcommerce.com/computers",5);
    }
    public void clickOnDesktopCategory(){
        driverClickOnElement(By.xpath("//li[@class='inactive']//a[contains(text(),\"Desktops\")]"));
    }

}

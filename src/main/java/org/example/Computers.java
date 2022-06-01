package org.example;

import org.openqa.selenium.By;

public class Computers extends Utils{

    By _desktopCategory = By.xpath("//li[@class='inactive']//a[contains(text(),\"Desktops\")]");

    public void verifyDesktopURL(){
        driverWaitUrl("https://demo.nopcommerce.com/computers",5);
    }
    public void clickOnDesktopCategory(){
        driverClickOnElement(_desktopCategory);
    }

}

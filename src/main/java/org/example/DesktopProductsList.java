package org.example;

import org.openqa.selenium.By;

public class DesktopProductsList extends Utils {

    public void clickOnButtonAddToCart(){
        //Click on Add to cart button on Desktop page
        driverClickOnElement(By.xpath("//div[@data-productid='1']//child::button[contains(text(),\"Add to cart\")]"));
    }
}

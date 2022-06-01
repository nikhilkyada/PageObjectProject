package org.example;

import org.openqa.selenium.By;

public class DesktopProductsList extends Utils {

    By _addToCartBtn = By.xpath("//div[@data-productid='1']//child::button[contains(text(),\"Add to cart\")]");

    public void clickOnButtonAddToCart(){
        //Click on Add to cart button on Desktop page
        driverClickOnElement(_addToCartBtn);
    }
}

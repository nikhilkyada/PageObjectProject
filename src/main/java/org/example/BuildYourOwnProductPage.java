package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOwnProductPage extends Utils {

    public void verifyURLOfBuildYourOwnDesktopProduct(){
        driverWaitUrl("https://demo.nopcommerce.com/build-your-own-computer",5);
    }
    public void selectAllOptionsAndClickOnAddToCart(){

        //Select Processor
        Select select1 = new Select(driver.findElement(By.id("product_attribute_1")));
        select1.selectByIndex(1);

        //Select RAM
        Select select2 = new Select(driver.findElement(By.id("product_attribute_2")));
        select2.selectByIndex(1);

        //Click on HDD (320 gb)
        driverClickOnElement(By.xpath("//label[contains(text(),\"320 GB\")]"));

        //Click on OS (Vista Premium [+$60.00])
        driverClickOnElement(By.id("product_attribute_4_9"));

        //Select Software
        driverClickOnElement(By.id("product_attribute_5_11"));
        driverClickOnElement(By.id("product_attribute_5_12"));

        //Click on Add to cart button
        driverWaitsUntilClick(By.xpath("//div[@class=\"add-to-cart\"]//child::button") ,3);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //Click on Shopping Cart
        driverWaitsUntilClick(By.xpath("//a[.=\"shopping cart\"]"),6);
        //driverWaitsUntilClick(By.xpath("//span[@class=\"cart-label\"]"),7);
    }

    public void clickOnEmailAFriend(){
        driverClickOnElement(By.xpath("//button[contains(text(),\"Email a friend\")]"));
    }
}

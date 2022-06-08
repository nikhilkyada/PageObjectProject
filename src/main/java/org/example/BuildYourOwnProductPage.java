package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuildYourOwnProductPage extends Utils {

    By _processor = By.id("product_attribute_1");
    By _Ram = By.id("product_attribute_2");
    By _HDD320 = By.xpath("//label[contains(text(),\"320 GB\")]");
    By _OS = By.id("product_attribute_4_9");
    By _soft1 =By.id("product_attribute_5_11");
    By _soft2 = By.id("product_attribute_5_12");
    By _addToCartBtn = By.xpath("//div[@class=\"add-to-cart\"]//child::button");
    By _shoppingCart = By.xpath("//a[.=\"shopping cart\"]");
    By _emailAFriend = By.xpath("//button[contains(text(),\"Email a friend\")]");

    public void verifyURLOfBuildYourOwnDesktopProduct(){
        driverWaitUrl("https://demo.nopcommerce.com/build-your-own-computer",5);
    }
    public void selectAllOptionsAndClickOnAddToCart(){

        //Select Processor
        Select select1 = new Select(driver.findElement(_processor));
        select1.selectByIndex(1);

        //Select RAM
        Select select2 = new Select(driver.findElement(_Ram));
        select2.selectByIndex(1);

        //Click on HDD (320 gb)
        driverClickOnElement(_HDD320);

        //Click on OS (Vista Premium [+$60.00])
        driverClickOnElement(_OS);

        //Select Software
        driverClickOnElement(_soft1);
        driverClickOnElement(_soft2);

        //Click on Add to cart button
        driverWaitsUntilClick(_addToCartBtn ,3);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //Click on Shopping Cart
        driverWaitsUntilClick(_shoppingCart,6);
        //driverWaitsUntilClick(By.xpath("//span[@class=\"cart-label\"]"),7);
    }

    public void clickOnEmailAFriend(){
        driverClickOnElement(_emailAFriend);
    }
}

package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyProductAddedToCart extends Utils {

    public void checkURLTobe(String url,int a){
        driverWaitUrl((url),(a));
    }

    public void productAddedToCart() {
        //Page Checking
        String title = titleOfPage();
        String expectedTitle = "nopCommerce demo store. Shopping Cart";
        Assert.assertEquals(title, expectedTitle, "Page Title is not Matching");

        //Product Verification
        String actual = gettext(By.xpath("//a[@href=\"/build-your-own-computer\" and @class=\"product-name\"]"));
        String expected = "Build your own computer";
        Assert.assertEquals(actual, expected, "Product name is NOT matching");
    }

}

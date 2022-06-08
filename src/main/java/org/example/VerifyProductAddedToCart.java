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
        String actual = gettext(By.xpath("//td[@class=\"product\"]//child::a[.=\"Build your own computer\"]"));
        String expected = "Build your own computer";
       Assert.assertTrue(gettext(By.xpath("//td[@class=\"product\"]//child::a[.=\"Build your own computer\"]")).equalsIgnoreCase("Build your own computer"),"Product name is not matching");

//        Assert.assertEquals(actual, expected, "Product name is NOT matching"); //This assert is not working in EDGE
//        System.out.println(actual +" "+ expected);
    }

}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.*;

public class SerchNikeProductPage extends Utils{

    public void verifyUrlNike(){
        driverWaitUrl("https://demo.nopcommerce.com/search?q=NIKE",5);
    }

    public void findWordInProductTitle(String searchtext){
        //Store String name of product titles
        ArrayList<String> products = new ArrayList<>();
        ArrayList<String> nproduct = new ArrayList<>();

        //List of WebElements to get test
        List<WebElement> productLocators = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2"));
        for (WebElement e : productLocators){
            products.add(e.getText());
        }
        System.out.println(products);
        String filtterInput = searchtext.substring(1,4).toLowerCase();

        System.out.println("Value -->"+filtterInput);
        //load
        for (String element : products){
            if (element.contains(filtterInput)){
                System.out.println(element);
                nproduct.add(element);
            }
        }
        Assert.assertTrue(products.equals(nproduct),"Title does not contains Keyword"+filtterInput);
    }
}

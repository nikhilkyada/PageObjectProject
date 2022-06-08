package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopSubProductsList extends Utils {

    public void verifyDesktopProductsListPage(){
        driverWaitUrl("https://demo.nopcommerce.com/desktops",5);
    }

    public void clickOnButtonAddToCart() {
        //Click on Add to cart button on Desktop page
        driverClickOnElement(By.xpath("//div[@data-productid='1']//child::button[contains(text(),\"Add to cart\")]"));
    }

    public  void selectDropdownMenu(){
        selectByIndex(By.id("products-orderby"),2);
    }

    @Test
    public  void getProductTitlesProprties(){
        driver.get("https://demo.nopcommerce.com/desktops");
        //Store String name of product names
        ArrayList<String> productName = new ArrayList<>();

        //List of WebElements to get text
        List<WebElement> productTitles = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2"));
        for (WebElement e : productTitles) {
            productName.add(e.getText());
        }
        System.out.println("\nBefore(Actual) -->"+productName);

        //Sorted Product Names
        ArrayList<String> sortList = new ArrayList<>();
        for(String s : productName){
            sortList.add(s);
        }

        //Sorting the list
        Collections.sort(sortList);
        System.out.println("\nsorted List A to Z:--> "+sortList);
        //Reverse
        Collections.reverse(sortList);
        System.out.println("\nAfter Reverse Sorting (Expected) --> "+sortList);

        //Verification
        Assert.assertTrue(sortList.equals(productName),"Items are not in Descending order");

    }
}

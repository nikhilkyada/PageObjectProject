package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils {

    public void clickOnRegister() {
        // click on register button
        driver.findElement(By.className("ico-register")).click();
        //driverClickOnElement(By.className("ico-register"));
    }

    public void clickOnComputer(){
        driverClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));

    }

}

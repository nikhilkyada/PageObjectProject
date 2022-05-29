package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager extends Utils{

    //Browser open and close methods
    public void openBrowser(){
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            //Open Chrome
            driver = new ChromeDriver();  // import chrome web-Driver dependency (In 'POM' file)

            //Duration to be wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //if this line 'RED' ,Click on bulb and select first option

            //Maximize the screen
            driver.manage().window().maximize();

            //Open Web page
            driver.get("https://demo.nopcommerce.com/");
    }

    public void closeBrowser(){
        //Close the browser
        driver.quit();
    }
}

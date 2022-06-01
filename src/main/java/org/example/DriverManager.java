package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils{

    //Browser open and close methods

    String browserName = "firefox";

    public void openBrowser(){

        //Chrome
        if(browserName.equalsIgnoreCase("Chrome")) {
            //Open Chrome
            System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
            driver = new ChromeDriver();  // import chrome web-Driver dependency (In 'POM' file)

        }else if(browserName.equalsIgnoreCase("Firefox")) {
            //Firefox
            System.setProperty("webdriver.gecko.driver","src/test/java/Drivers/geckodriver.exe" );
            driver= new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("Edge")){
            //Edge
            System.setProperty("webdriver.edge.driver","src/test/java/Drivers/msedgedriver.exe");
            //instance of EdgeDriver
             driver = new EdgeDriver();
        }else{
            System.out.println("You Entered un-valid Browser name :" + browserName);

        }

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

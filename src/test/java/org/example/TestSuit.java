package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{
    //All Test cases

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyRegisterSuccess verifyRegisterSuccess = new VerifyRegisterSuccess();
    Computers computers = new Computers();
    DesktopProductsList desktopProductsList = new DesktopProductsList();
    BuildYourOwnProductPage buildYourOwnProductPage = new BuildYourOwnProductPage();
    VerifyProductAddedToCart verifyProductAddedToCart = new VerifyProductAddedToCart();


    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {

        //Click on Register(Homepage)
        homePage.clickOnRegister();

        //Enter All Registration Details and Click on Register button
        registrationPage.enterAllRegistrationDetails();

        //Verify
        verifyRegisterSuccess.verifyRegistrationSuccess();







    }
    @Test
    public  void userShouldAbleToAddProductIntoCart(){
        homePage.clickOnComputer();
        computers.clickOnDesktopCategory();
        desktopProductsList.clickOnButtonAddToCart();
        buildYourOwnProductPage.selectAllOptionsAndClickOnAddToCart();
        verifyProductAddedToCart.checkURLTobe("https://demo.nopcommerce.com/cart",3);
        verifyProductAddedToCart.productAddedToCart();



    }
}

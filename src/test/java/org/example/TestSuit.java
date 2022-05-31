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
    EmailaFriend emailaFriend = new EmailaFriend();
    VerifyEmailAFriend verifyEmailAFriend = new VerifyEmailAFriend();


    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {

        //Click on Register(Homepage)
        homePage.clickOnRegister();
        //Verify Registration URL
        registrationPage.verifyRegistrationPageURL();
        //Enter All Registration Details and Click on Register button
        registrationPage.enterAllRegistrationDetails();
        //Verify
        verifyRegisterSuccess.verifyRegistrationSuccess();
    }
    @Test
    public  void userShouldAbleToAddProductIntoCart(){
        //Click on Computers link
        homePage.clickOnComputer();
        //Verify URL to be
        computers.verifyDesktopURL();
        //Click on Desktop category
        computers.clickOnDesktopCategory();
        //Click on "Add to cart" button on 1st product
        desktopProductsList.clickOnButtonAddToCart();
        //Verify Product page URL to be
        buildYourOwnProductPage.verifyURLOfBuildYourOwnDesktopProduct();
        //Select all options and Click on "Add to cart" Button
        buildYourOwnProductPage.selectAllOptionsAndClickOnAddToCart();
        //Verify Cart URL to be
        verifyProductAddedToCart.checkURLTobe("https://demo.nopcommerce.com/cart",3);
        //Verify Product name added into cart
        verifyProductAddedToCart.productAddedToCart();



    }
    @Test
    public void userShouldBeAbleToChangeCurrency(){
        //Change currency from dropdown (Homepage)
        homePage.selectEuroCurrency();
        //Verify on product price
        homePage.verifyCurrencyOnProductPrice('€',0);
    }
    @Test
    public void userShouldAbleToReferFriendAfterRegistration(){
        //Click on Register link
        homePage.clickOnRegister();
        //Verify Registration page URL
        registrationPage.verifyRegistrationPageURL();
        //Fill register details
        registrationPage.enterAllRegistrationDetails();
        //Verify Registration completed
        verifyRegisterSuccess.verifyRegistrationSuccess();
        //Continue
        verifyRegisterSuccess.clickOnContinue();
        //Verify URL
        homePage.verifyURLtoBe();
        //Click on product name
        homePage.clickOnProductName();
        //Click on email a friend
        buildYourOwnProductPage.clickOnEmailAFriend();
        //Verify Email a Friend URL
        emailaFriend.verifyURLtoBe();
        //write friends email
        emailaFriend.typeFriendEmail();
        //write message
        emailaFriend.typeMessage();
        //Click on Send Button
        emailaFriend.clickOnSendButton();
        //verify
        verifyEmailAFriend.verifyEmailAFriend();


    }
    @Test
    public void userShouldBeAbleToSelectCommunityPollRadioButton(){
//        "1.Click on Register
        homePage.clickOnRegister();
//        2.Check that user is on right page
        registrationPage.verifyRegistrationPageURL();
//        3.Fill all registration details
        registrationPage.enterAllRegistrationDetails();
//        Verify that registration is Successful
        verifyRegisterSuccess.verifyRegistrationSuccess();
        //Click on Continue Button
        verifyRegisterSuccess.clickOnContinue();
//        Select one radio button.
        homePage.clickOnPollRadioButton();
//        Click on ""Vote"" button
        homePage.clickOnVote();
//        Verify with ""vote(s)"" Keyword
        homePage.verifyVoteSuccess();



    }

}

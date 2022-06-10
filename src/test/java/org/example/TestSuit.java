package org.example;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSuit extends BaseTest {

    //Objects
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyRegisterSuccess verifyRegisterSuccess = new VerifyRegisterSuccess();
    Computers computers = new Computers();
    DesktopSubProductsList desktopSubProductsList = new DesktopSubProductsList();
    BuildYourOwnProductPage buildYourOwnProductPage = new BuildYourOwnProductPage();
    VerifyProductAddedToCart verifyProductAddedToCart = new VerifyProductAddedToCart();
    EmailaFriend emailaFriend = new EmailaFriend();
    VerifyEmailAFriend verifyEmailAFriend = new VerifyEmailAFriend();
    SoftAssert softAssert = new SoftAssert();
    SerchNikeProductPage serchNikeProductPage = new SerchNikeProductPage();
    NewReleasePage newReleasePage = new NewReleasePage();

    //All Test 

    @Test
    public void newReleaseProductList(){
        homePage.clickOnNewsReleaseDetails();
        newReleasePage.verifyUrl("https://demo.nopcommerce.com/nopcommerce-new-release");
        newReleasePage.getListOfCommentTitles("India","tial1");

    }

    @Test
    public void userShouldAbleToSearchProductsByName(){
        homePage.typeInSearch(("nike").toUpperCase());
        homePage.clickOnSearchBtn();
        serchNikeProductPage.verifyUrlNike();
        serchNikeProductPage.findWordInProductTitle("NiKE");


    }

    @Test
    public void userShouldSeePopUpAlertEmptyVoteBtnWithVerify(){
        //Click on Vote button without poll
        homePage.clickOnVote();
        //Go to alert and get text and verify
        homePage.switchToPopUpAlertGetTextsWithVerification();
        //Accept alert
        homePage.switchToPopUpAlertAccept();
    }

    @Test
    public void verifyFBPopUp(){
        //Go to new window alert and get url and verify
        homePage.fbButtonVerificationWithPopUpWindow();
    }

    //Should be fail
    @Test
    public void productShouldBeZtoA(){
        //Click on Computers link
        homePage.clickOnComputer();
        //Verify URL to be
        computers.verifyDesktopURL();
        //Click on Desktop category
        computers.clickOnDesktopCategory();
        //Verify page
        desktopSubProductsList.verifyDesktopProductsListPage();
        //Select sort list Z to A
        desktopSubProductsList.selectDropdownMenu();
        //Get Name
        desktopSubProductsList.getProductTitlesProprties();
    }

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
    public void userShouldAbleToAddProductIntoCart() {
        //Click on Computers link
        homePage.clickOnComputer();
        //Verify URL to be
        computers.verifyDesktopURL();
        //Click on Desktop category
        computers.clickOnDesktopCategory();
        //Click on "Add to cart" button on 1st product
        desktopSubProductsList.clickOnButtonAddToCart();
        //Verify Product page URL to be
        buildYourOwnProductPage.verifyURLOfBuildYourOwnDesktopProduct();
        //Select all options and Click on "Add to cart" Button
        buildYourOwnProductPage.selectAllOptionsAndClickOnAddToCart();
        //Verify Cart URL to be
        verifyProductAddedToCart.checkURLTobe("https://demo.nopcommerce.com/cart", 3);
        //Verify Product name added into cart
        verifyProductAddedToCart.productAddedToCart();


    }

    @Test
    public void userShouldBeAbleToChangeCurrency() {
        //Change currency from dropdown (Homepage)
        homePage.selectEuroCurrency();
        //Verify on product price
        homePage.verifyCurrencyOnProductPrice('€', 0);
    }

    @Test
    public void userShouldAbleToReferFriendAfterRegistration() {
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
    public void userShouldBeAbleToSelectCommunityPollRadioButton() {

        //User dose not able to give vote without Valid account and show Error message
        homePage.clickOnPollRadioButton();
        homePage.clickOnVote();
        homePage.verifyErrorMessageOfPole();

        //USer should be able to give vote with valid account
        //Click on Register
        homePage.clickOnRegister();
        //Check that user is on right page
        registrationPage.verifyRegistrationPageURL();
        //Fill all registration details
        registrationPage.enterAllRegistrationDetails();
        //Verify that registration is Successful
        verifyRegisterSuccess.verifyRegistrationSuccess();
        //Click on Continue Button
        verifyRegisterSuccess.clickOnContinue();
        //Select one radio button.
        homePage.clickOnPollRadioButton();
        //Click on ""Vote"" button
        homePage.clickOnVote();
        //Verify with ""vote(s)"" Keyword
        homePage.verifyVoteSuccess();
    }
}

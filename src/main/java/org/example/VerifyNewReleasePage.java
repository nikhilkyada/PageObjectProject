package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class VerifyNewReleasePage extends  Utils{

    By _listOfComments = By.xpath("//div[@class='comment-title']");

    SoftAssert softAssert = new SoftAssert();

    public void verifyUrl(String url){
        //Verify URL
        driverWaitUrl(url,5);
    }

    public void getListOfCommentTitles(String massageTitle,String comment){

        //Verify Title Of Page
        String pageTitles = driver.getTitle();
        System.out.println("Actual title ="+pageTitles);
        System.out.println("Expected title =nopCommerce demo store. nopCommerce new release!");

        //Type Massage Title
        driverSendKeys(By.id("AddNewComment_CommentTitle"),massageTitle);
        //Type Comment
        driverSendKeys(By.id("AddNewComment_CommentText"),comment);
        //Click on New Comment
        driverClickOnElement(By.name("add-comment"));
        //Verify your comment should be added
        String resultMessage = gettext(By.className("result"));
        //Expected Message
        String expectedResult = "News comment is successfully added.";
        //Verification
        softAssert.assertEquals(resultMessage,expectedResult,"Your Comment does not added.");
        //Verify your comment is added in list
        softAssert.assertAll();


        //List of web elements
        List<WebElement> comments = driver.findElements(_listOfComments);
        List<String> commentList = new ArrayList<>();

        for (WebElement e : comments){
            commentList.add(e.getText());
        }
        System.out.println(commentList);
        //Verification
        Assert.assertTrue(commentList.contains(massageTitle));
        //Get Last comment
        String lastComment = commentList.get(commentList.size()-1);
        //Printing last comment
        System.out.println("The latest comment title is :-"+lastComment);
        //Verify
        Assert.assertEquals(lastComment,massageTitle,"Your comment does not contains keyword or not in order :-"+massageTitle);
    }

}

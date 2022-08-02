package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day12_Assertions {


    @Test
    public void hardAssert(){
        //import org.testng.Assert; Hard assertion
        System.out.println("This is line 8");
        Assert.assertEquals(5,5);//fail
        System.out.println("This is line 15");// Hard assert fails, next lines will not run
    }

    @Test
    public void softAssert(){
        //1. Create a SoftAssert object

        SoftAssert softAssert = new SoftAssert();

        System.out.println("This is line 23");
        softAssert.assertEquals(4,5);//fail. This will be on the console as FAILED
        System.out.println("This is line 25");
        softAssert.assertTrue("java".contains("e"));//fail. This will be on the console as FAILED
        System.out.println("This is line 27");
        softAssert.assertEquals(10,11);//fail. This will be on the console as FAILED
        softAssert.assertEquals(5,5);//pass This will not be on the console cause it pass

        //Be careful when you use soft assertion
        //We must use assertAll() to check which one pass which one fails
        softAssert.assertAll();

         /*
          What is soft assertion? : Verifying all test cases using soft assertion.
      In this type of assertion, we use soft assert object.
      We also use assertAll to actually see if any soft assert fails.

      What is difference between hard and soft assertion?
        Hard Assert= If hard assert fails, the test case will not continue to run.
        SoftAssert = If soft assert fails, the test case will continue to run.We must create the object.

      Which assertion do you prefer to use? Why?
      Ahmet's answer: I prefer hard assertion, b/c if a step fails, I should immediately check the issue without wasting my time
      Sometimes, I use soft assert when I write my initial test cases.
      Then I see what fails what pass at the end.
       */

    }
}

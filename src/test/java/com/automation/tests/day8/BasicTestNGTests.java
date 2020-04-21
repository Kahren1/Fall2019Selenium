package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    //Assert class provides hard assertions
    //with hard assertion text executions stops due to exception
    //w soft assertion test execution doesn't stop.
    //for soft assertion there is SoftAssert class
    //Common practice is to use only hard assertions
    //Junit, for example, uses on hard assertions

    //runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");

    }

    //runs before every test automatically
    //works as a pre-condition for
    @BeforeMethod
    public void setup() {
    System.out.println("before method");
}

//will run after every test
@AfterMethod
public void teardown(){
    System.out.println("after method");
}



    @Test
    public void test1(){
        System.out.println("Test 1");
        String expected ="apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1=5;
        int num2 = 10;
        //it calls had assertion
        //if assertion fails - it stops the execution (due to exception)
        Assert.assertTrue(num1>num2);

    }
}

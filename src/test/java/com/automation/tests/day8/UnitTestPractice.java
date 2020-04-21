package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        String expected = "a";
        String toTruncate = "abc";
        String actual = truncateString(toTruncate);
        //Assertion
        verifyEquals(expected, actual);
    }//end main

    //this is created outside the main method

    //annotaton -comes from testNG
    //the method is a NON-static method
    //we can add a description
    @Test (description = "verify if method can truncate a string")
    public void test(){
String expected = "b";
String actual = truncateString("apple");
//make sure to choose assert from TestNG
        //method is coming from testng, junit also has this class
        //you can compare any data types here: strings, primitives, arrays, objects)
        //to verify if expected result is equals to actual
        Assert.assertEquals(actual, expected);
    }

    //another test
    @Test(description ="Verify if method can reverse a string")
    public void test2(){
        String expected = "c";
        String actual = truncateString("car");
        Assert.assertEquals(actual, expected);
    }


    public static String truncateString (String str){
        return (str.substring(0,1));
    }
    public static boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("test passed");
            return true;
        }else{
            System.out.println("test failed");
            return false;
        }

    }

}

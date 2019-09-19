package com.amdocs.training;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {
    @Test
    @Parameters({"number1","number2"})
    //@Test(dataProvider = "getData", dependsOnMethods = "testAddMultiple")
    public void testAddition(@Optional ("10") String n1, @Optional ("20") String n2) {

        int result = Integer.parseInt(n1)+Integer.parseInt(n2);
        System.out.println("Testing Addition Functionality. Result = "+result);
    }

    @Test(dataProvider = "getData", priority = 2)
    public void testAddMultiple(int a, int b, int expected) {
        int result = a+b;
        Assert.assertEquals(result,expected);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[5][3];

        //first row
        data[0][0] = 10;
        data[0][1] = 20;
        data[0][2] = 30;

        //second row
        data[1][0] = 20;
        data[1][1] = 25;
        data[1][2] = 45;

        //third row
        data[2][0] = 1;
        data[2][1] = 2;
        data[2][2] = 3;

        //fourth row
        data[3][0] = 10;
        data[3][1] = 20;
        data[3][2] = 30;

        //fifth row
        data[4][0] = 15;
        data[4][1] = 20;
        data[4][2] = 35;

        return data;
    }

    @BeforeTest
    public void setUpCalculator() {
        System.out.println("Setting up calculator");
    }

    @AfterTest
    public void tearDownCalculator() {
        System.out.println("Closing Calculator");
    }

    @Test (priority = 1)
    public void testSubtraction() {
        System.out.println("Testing Subtraction Functionality");

        try {
            int a = 2/0;
        } catch (Exception e) {
            System.out.println("Caught divide by zero exception");
        }
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Will be executed before every method");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Will be executed after every method");
    }

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Setting up my suite");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("Closing the Test Suite");
    }
}
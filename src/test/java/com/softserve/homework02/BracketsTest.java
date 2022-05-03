package com.softserve.homework02;

import com.softserve.homework01.Brackets;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BracketsTest {
    Brackets bracketsTest= new Brackets();

    @BeforeSuite
    public static void setupBeforeClass() throws Exception {
        System.out.println("@BeforeClass setUpBeforeClass()");
    }

    @AfterSuite
    public static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterClass tearDownAfterClass()");
    }

    @BeforeTest
    public void setUp() throws Exception {

        System.out.println("\t@Before setUp()");
    }

    @AfterTest
    public void tearDown() throws Exception {
        System.out.println("\t@After tearDown()");
    }

    @Test
    public void testApp01P() {
        System.out.println("\t\t@Test A01 Positive");
        boolean actual;
        //actual = bracketsTest.verifyBrackets("test((text)test1)456(try)!");
        actual = bracketsTest.verifyBrackets("test(try)abs(a(bc)d)123");
        Assert.assertTrue(actual);
        //
        actual = bracketsTest.verifyBrackets("!hhj(test456(test123_+)fhfh)fhf(sjs)");
        Assert.assertEquals(true, actual);
    }

    @Test
    public void testApp01N() {
        System.out.println("\t\t@Test A01 Negative");
        boolean actual;
        boolean expected;
        expected = false;
        actual = bracketsTest.verifyBrackets("(())());");
        Assert.assertEquals(expected, actual);
        //
        actual = bracketsTest.verifyBrackets("open)and(shut");
        Assert.assertEquals(expected, actual);
    }
}

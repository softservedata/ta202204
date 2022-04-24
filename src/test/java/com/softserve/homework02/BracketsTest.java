package com.softserve.homework02;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.homework01.CheckBrackets;

public class BracketsTest {
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("After Class");
    }

    @Before
    public void setUp() throws Exception {
    	System.out.println("\tBefore Method");
    }
    
    @After
    public void tearDown() throws Exception {
    	System.out.println("\tAfter Method");
    }

    @Test
    public void testMethod() {
    	CheckBrackets message = new CheckBrackets();
		boolean actual = true;
		actual = message.verifyBrackets("()()((()))");
		System.out.println("\t\tResult of verifying brackets is: " + actual);
		Assert.assertTrue(actual);
    }

}

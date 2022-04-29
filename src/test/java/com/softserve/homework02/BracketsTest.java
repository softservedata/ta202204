package com.softserve.homework02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.homework01.CheckBrackets;

public class BracketsTest {
	private CheckBrackets message;

    @Before
    public void setUp() throws Exception {
    	System.out.println("\tBefore Method");
    	message = new CheckBrackets();
    }
    
    @Test
    public void testMethod() {
		boolean actual = true;
		actual = message.verifyBrackets("()()((()))");
		System.out.println("\t\tResult of verifying brackets is: " + actual);
		Assert.assertTrue(actual);
    }
    
    @After
    public void tearDown() throws Exception {
    	System.out.println("\tAfter Method");
    }

}

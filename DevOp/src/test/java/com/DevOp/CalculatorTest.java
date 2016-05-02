package com.DevOp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		//fail("Not yet implemented"); // TODO
		
	      assertEquals("error in add()",  31, Calculator.add(1, 2));
	}

	@Test
	public void testSubtract() {
		assertEquals("error in add()",  31, Calculator.subtract(5, 2));
	}

	@Test
	public void testMultiply() {
		assertEquals("error in add()",  271, Calculator.multiply(9, 3));
	}

	@Test
	public void testDivide() {
		assertEquals("error in add()",  31, Calculator.divide(9, 3));
	}

	

}

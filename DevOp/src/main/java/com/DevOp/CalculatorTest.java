package com.DevOp;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	private Calculator cal;


	public void setUp() throws Exception {
	 cal = new Calculator();
	}
	@Test
	public void testAdd() {
		assertEquals("add",7, cal.add(3, 4));
	}

	@Test
	public void testSubtract() {
		fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		fail("Not yet implemented");
	}

}

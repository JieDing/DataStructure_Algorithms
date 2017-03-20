package com.jieding.test;

import com.jieding.algorithms.Stack_DecimalToBinary;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Stack_DecimalToBinaryTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testDecimalToBinary() {
		Assert.assertEquals("10001", Stack_DecimalToBinary.decimalToBinary(17));
		Assert.assertEquals("10000000", Stack_DecimalToBinary.decimalToBinary(128));
		Assert.assertEquals("1111111", Stack_DecimalToBinary.decimalToBinary(127));
	}

}

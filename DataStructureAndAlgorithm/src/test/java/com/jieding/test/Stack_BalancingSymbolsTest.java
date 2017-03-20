package com.jieding.test;

import com.jieding.algorithms.Stack_BalancingSymbols;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Stack_BalancingSymbolsTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testSequenceLegal() {
		Assert.assertEquals(true, Stack_BalancingSymbols.sequenceLegal("({})"));
		Assert.assertEquals(true, Stack_BalancingSymbols.sequenceLegal("({}[]{}(){[()]})"));
		Assert.assertEquals(false, Stack_BalancingSymbols.sequenceLegal("({)}"));
		Assert.assertEquals(true, Stack_BalancingSymbols.sequenceLegal("({})"));
		Assert.assertEquals(false, Stack_BalancingSymbols.sequenceLegal("[](){]"));
		Assert.assertEquals(true, Stack_BalancingSymbols.sequenceLegal("{([])()}"));
	}

}

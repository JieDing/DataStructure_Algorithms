package com.jieding.test;

import com.jieding.algorithms.Recursion_Hanoi;

import junit.framework.TestCase;

public class Recursion_HanoiTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testPrintAllElements() {
		Recursion_Hanoi rh = new Recursion_Hanoi(1);
		rh.printAllElements();
	}
	public void testRecursionSolution() {
		Recursion_Hanoi rh = new Recursion_Hanoi(2);
		rh.recursionSolution(rh.currentCapacity, rh.A, rh.B, rh.C);
		rh.printAllElements();
	}

}

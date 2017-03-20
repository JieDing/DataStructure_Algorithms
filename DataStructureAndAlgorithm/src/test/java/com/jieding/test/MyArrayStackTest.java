package com.jieding.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.jieding.datastructure.MyArrayStack;

public class MyArrayStackTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testMyArrayStack() {
		MyArrayStack<String> as = new MyArrayStack<String>();
		Assert.assertEquals(0, as.size());
	}

	public void testMyArrayStackInt() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		Assert.assertEquals(0, as.size());
	}

	public void testClear() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		as.push("abc");
		as.push("bcd");
		as.push("cde");
		as.clear();
		Assert.assertEquals(0, as.size());
		Assert.assertEquals(true, as.isEmpty());
	}

	public void testSize() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		as.push("abc");
		as.push("bcd");
		as.push("cde");
		//as.clear();
		Assert.assertEquals(3, as.size());
	}

	public void testIsEmpty() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		Assert.assertEquals(true, as.isEmpty());
	}

	public void testContains() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(true, as.contains("abc"));
		Assert.assertEquals(true, as.contains(null));
		Assert.assertEquals(false, as.contains("cde"));
	}

	public void testPeek() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(null, as.peek());
		Assert.assertEquals(true, as.contains(null));
		Assert.assertEquals(false, as.contains("cde"));
	}

	public void testSearch() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(3, as.search(null));
		Assert.assertEquals(2, as.search("bcd"));
		Assert.assertEquals(1, as.search("abc"));
		Assert.assertEquals(-1, as.search("aabc"));
	}

	public void testPop() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(null, as.pop());
		Assert.assertEquals(false, as.contains(null));
		Assert.assertEquals(2, as.size());
		Assert.assertEquals(true, as.contains("bcd"));
		Assert.assertEquals("bcd", as.pop());
		Assert.assertEquals(false, as.contains("bcd"));
		Assert.assertEquals(1, as.size());
	}

	public void testPush() {
		MyArrayStack<String> as = new MyArrayStack<String>(2);
		as.push("abc");
		as.push("bcd");
		as.push(null);
		
		Assert.assertEquals(null, as.peek());
		Assert.assertEquals(true, as.contains(null));
		Assert.assertEquals(3, as.size());
		Assert.assertEquals(null, as.pop());
		Assert.assertEquals("bcd", as.pop());
		Assert.assertEquals(false, as.contains("bcd"));
		Assert.assertEquals(1, as.size());
	}

}

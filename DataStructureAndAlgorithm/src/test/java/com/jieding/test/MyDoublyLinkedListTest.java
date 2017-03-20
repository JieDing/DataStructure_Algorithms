package com.jieding.test;

import com.jieding.datastructure.MyDoublyLinkedList;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MyDoublyLinkedListTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testMyDoublyLinkedList() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		Assert.assertEquals(0, sll.size());
	}

	public void testClear() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add("abc");
		sll.clear();
		Assert.assertEquals(0, sll.size());
	}

	public void testSize() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals(1, sll.size());
	}

	public void testIsEmpty() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals(false, sll.isEmpty());
	}

	public void testContains() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals(false, sll.contains(null));
		Assert.assertEquals(true, sll.contains("abc"));
	}

	public void testGet() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals(1, sll.size());
		Assert.assertEquals("abc", sll.get(1));
		//sll.add(null);
		//Assert.assertEquals(null, sll.get(2));
	}

	public void testIndexOf() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add("abc");
		
		Assert.assertEquals(1, sll.indexOf("abc"));
		sll.add(0,null);
		Assert.assertEquals(1, sll.indexOf(null));
	}

	public void testAddE() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals("abc", sll.get(1));
		sll.add(null);
		Assert.assertEquals(null, sll.get(2));
		Assert.assertEquals(2, sll.size());
	}

	public void testAddIntE() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add(0,"abc");
		
		Assert.assertEquals("abc", sll.get(1));
		
		sll.add(1,"bcd");
		Assert.assertEquals("bcd", sll.get(2));
		
		sll.add(0,"start");
		Assert.assertEquals("start", sll.get(1));
		Assert.assertEquals("abc", sll.get(2));
		Assert.assertEquals("bcd", sll.get(3));
		
		Assert.assertEquals(3, sll.size());
	}

	public void testRemoveInt() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add(0,"abc");
		
		Assert.assertEquals("abc", sll.get(1));
		
		sll.add(1,"bcd");
		Assert.assertEquals("bcd", sll.get(2));
		
		sll.add(0,"start");
		Assert.assertEquals("start", sll.get(1));
		Assert.assertEquals("abc", sll.get(2));
		Assert.assertEquals("bcd", sll.get(3));
		
		sll.remove(1);
		Assert.assertEquals("abc", sll.get(1));
		Assert.assertEquals("bcd", sll.get(2));
		
		sll.remove(2);
		Assert.assertEquals("abc", sll.get(1));
		Assert.assertEquals(1, sll.size());
	}

	public void testRemoveE() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add(0,"abc");
		
		Assert.assertEquals("abc", sll.get(1));
		
		sll.add(1,"bcd");
		Assert.assertEquals("bcd", sll.get(2));
		
		sll.add(0,"start");
		Assert.assertEquals("start", sll.get(1));
		Assert.assertEquals("abc", sll.get(2));
		Assert.assertEquals("bcd", sll.get(3));
		
		sll.remove("start");
		Assert.assertEquals("abc", sll.get(1));
		Assert.assertEquals("bcd", sll.get(2));
		
		sll.remove("bcd");
		Assert.assertEquals("abc", sll.get(1));
		Assert.assertEquals(1, sll.size());
	}

	public void testSet() {
		MyDoublyLinkedList<String> sll = new MyDoublyLinkedList<String>();
		sll.add(0,"abc");
		
		Assert.assertEquals("abc", sll.get(1));
		
		sll.add(1,"bcd");
		Assert.assertEquals("bcd", sll.get(2));
		 sll.set(2, "www");
		Assert.assertEquals("www",sll.get(2));
	}

}

package com.jieding.test;

import com.jieding.datastructure.MySinglyLinkedList;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MySinglyLinkedListTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testMySinglyLinkedList() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		Assert.assertEquals(0, sll.size());
	}

	public void testClear() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add("abc");
		sll.clear();
		Assert.assertEquals(0, sll.size());
	}

	public void testSize() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals(1, sll.size());
	}

	public void testIsEmpty() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals(false, sll.isEmpty());
	}

	public void testContains() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals(false, sll.contains(null));
		Assert.assertEquals(true, sll.contains("abc"));
	}

	public void testGet() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals("abc", sll.get(1));
		sll.add(null);
		Assert.assertEquals(null, sll.get(2));
	}

	public void testIndexOf() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add("abc");
		
		Assert.assertEquals(1, sll.indexOf("abc"));
		sll.add(0,null);
		Assert.assertEquals(1, sll.indexOf(null));
	}

	public void testAddE() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add("abc");
		Assert.assertEquals("abc", sll.get(1));
		sll.add(null);
		Assert.assertEquals(null, sll.get(2));
		Assert.assertEquals(2, sll.size());
	}

	public void testAddIntE() {
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
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
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
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
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
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
		MySinglyLinkedList<String> sll = new MySinglyLinkedList<String>();
		sll.add(0,"abc");
		
		Assert.assertEquals("abc", sll.get(1));
		
		sll.add(1,"bcd");
		Assert.assertEquals("bcd", sll.get(2));
		 sll.set(2, "www");
		Assert.assertEquals("www",sll.get(2));
	}

}

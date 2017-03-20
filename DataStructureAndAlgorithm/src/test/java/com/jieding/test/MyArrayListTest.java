package com.jieding.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.jieding.datastructure.MyArrayList;

public class MyArrayListTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testMyArrayList() {
		MyArrayList<String> list = new MyArrayList<String>();
		Assert.assertEquals(0,list.size());
	}

	public void testMyArrayListInt() {
		MyArrayList<String> list = new MyArrayList<String>(15);
		Assert.assertEquals(0,list.size());
	}

	public void testClear() {
		MyArrayList<String> list = new MyArrayList<String>();
		list.clear();
		Assert.assertEquals(0,list.size());
	}

	public void testSize() {
		MyArrayList<String> list = new MyArrayList<String>();
		list.add(null);
		list.add("adad");
		Assert.assertEquals(2, list.size());
	}

	public void testIsEmpty() {
		MyArrayList<String> list = new MyArrayList<String>();
		list.clear();
		Assert.assertEquals(true,list.isEmpty());
	}

	public void testContains() {
		MyArrayList<String> list = new MyArrayList<String>();
		list.add(null);
		Assert.assertEquals(true,list.contains(null));
		list.add("abc");
		Assert.assertEquals(true,list.contains("abc"));
		Assert.assertEquals(false,list.contains("bcd"));
	}

	public void testGet() {
		MyArrayList<String> list = new MyArrayList<String>();
		list.add(null);
		Assert.assertEquals(null,list.get(0));
		list.add("abc");
		Assert.assertEquals("abc",list.get(1));
		
	}

	public void testIndexOf() {
		MyArrayList<String> list = new MyArrayList<String>(2);
		list.add(0,null);
		Assert.assertEquals(0,list.indexOf(null));
		list.add(0,"abc");
		Assert.assertEquals(0,list.indexOf("abc"));
		Assert.assertEquals(1,list.indexOf(null));
		list.add(1,"bcd");
		Assert.assertEquals(0,list.indexOf("abc"));
		Assert.assertEquals(1,list.indexOf("bcd"));
		Assert.assertEquals(2,list.indexOf(null));
		
		Assert.assertEquals(3,list.size());
	}

	public void testAddE() {
		MyArrayList<String> list = new MyArrayList<String>(2);
		list.add(null);
		Assert.assertEquals(null,list.get(0));
		list.add("abc");
		Assert.assertEquals("abc",list.get(1));
		list.add(null);
		Assert.assertEquals(null,list.get(2));
		Assert.assertEquals(3,list.size());
	}

	public void testAddIntE() {
		MyArrayList<String> list = new MyArrayList<String>(2);
		list.add(0,null);
		Assert.assertEquals(null,list.get(0));
		list.add(0,"abc");
		Assert.assertEquals("abc",list.get(0));
		Assert.assertEquals(null,list.get(1));
		list.add(1,"bcd");
		Assert.assertEquals("bcd",list.get(1));
		Assert.assertEquals(null,list.get(2));
		Assert.assertEquals("abc",list.get(0));
		
		Assert.assertEquals(3,list.size());
	}

	public void testRemoveInt() {
		MyArrayList<String> list = new MyArrayList<String>(2);
		list.add(0,null);
		Assert.assertEquals(null,list.get(0));
		list.add(0,"abc");
		Assert.assertEquals("abc",list.get(0));
		Assert.assertEquals(null,list.get(1));
		list.add(1,"bcd");
		Assert.assertEquals("bcd",list.get(1));
		Assert.assertEquals(null,list.get(2));
		Assert.assertEquals("abc",list.get(0));
		
		list.remove(0);
		Assert.assertEquals("bcd",list.get(0));
		Assert.assertEquals(null,list.get(1));
		
		list.remove(1);
		Assert.assertEquals("bcd",list.get(0));
		list.remove(0);
		Assert.assertEquals(0,list.size());
		Assert.assertEquals(true,list.isEmpty());
	}

	public void testRemoveE() {
		MyArrayList<String> list = new MyArrayList<String>(2);
		list.add(0,null);
		Assert.assertEquals(null,list.get(0));
		list.add(0,"abc");
		Assert.assertEquals("abc",list.get(0));
		Assert.assertEquals(null,list.get(1));
		list.add(1,"bcd");
		Assert.assertEquals("bcd",list.get(1));
		Assert.assertEquals(null,list.get(2));
		Assert.assertEquals("abc",list.get(0));
		
		list.remove("abc");
		Assert.assertEquals("bcd",list.get(0));
		Assert.assertEquals(null,list.get(1));
		
		list.remove(null);
		Assert.assertEquals("bcd",list.get(0));
		list.remove("bcd");
		Assert.assertEquals(0,list.size());
		Assert.assertEquals(true,list.isEmpty());
	}

	public void testSet() {
		MyArrayList<String> list = new MyArrayList<String>(2);
		list.add(0,null);
		Assert.assertEquals(null,list.get(0));
		list.add(0,"abc");
		Assert.assertEquals("abc",list.get(0));
		Assert.assertEquals(null,list.get(1));
		list.add(1,"bcd");
		Assert.assertEquals("bcd",list.get(1));
		Assert.assertEquals(null,list.get(2));
		Assert.assertEquals("abc",list.get(0));
		
		list.set(0, "1");
		list.set(1, "1");
		list.set(2, "1");
		Assert.assertEquals("1",list.get(1));
		Assert.assertEquals("1",list.get(2));
		Assert.assertEquals("1",list.get(0));
		
		Assert.assertEquals(3,list.size());
		Assert.assertEquals(false,list.isEmpty());
	}

}

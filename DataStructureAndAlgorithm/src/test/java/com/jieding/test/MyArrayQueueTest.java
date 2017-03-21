package com.jieding.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.jieding.adt.QueueADT;
import com.jieding.datastructure.MyArrayQueue;

public class MyArrayQueueTest extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public void testClear() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		q.clear();
		Assert.assertEquals(0, q.size());
		Assert.assertEquals(null, q.peek());
	}

	public void testSize() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		q.enqueue("cde");
		q.enqueue("def");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		Assert.assertEquals(0, q.size());

	}

	public void testIsEmpty() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		Assert.assertEquals(false, q.isEmpty());
	}

	public void testContains() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		q.enqueue("cde");
		q.enqueue("def");
		Assert.assertEquals(true, q.contains("abc"));
		q.dequeue();
		Assert.assertEquals(false, q.contains("abc"));
		Assert.assertEquals("bcd", q.peek());
	}

	public void testPeek() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		q.enqueue("cde");
		q.enqueue("def");
		Assert.assertEquals("abc", q.peek());
		q.dequeue();
		Assert.assertEquals("bcd", q.peek());
	}

	public void testSearch() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		q.enqueue("cde");
		q.enqueue("def");
		Assert.assertEquals(1, q.search("abc"));
		Assert.assertEquals(3, q.search("cde"));
		q.dequeue();
		Assert.assertEquals(-1, q.search("abc"));
		Assert.assertEquals(2, q.search("cde"));
	}

	public void testEnqueue() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		q.enqueue("cde");
		q.enqueue("def");
		Assert.assertEquals(1, q.search("abc"));
		Assert.assertEquals(3, q.search("cde"));
		q.dequeue();
		Assert.assertEquals(-1, q.search("abc"));
		Assert.assertEquals(2, q.search("cde"));
		Assert.assertEquals(true, q.contains("bcd"));
		Assert.assertEquals("bcd", q.peek());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		Assert.assertEquals(null, q.peek());
		Assert.assertEquals(0, q.size());
	}

	public void testDequeue() {
		QueueADT<String> q = new MyArrayQueue<String>(2);
		q.enqueue("abc");
		q.enqueue("bcd");
		q.enqueue("cde");
		q.enqueue("def");
		Assert.assertEquals(1, q.search("abc"));
		Assert.assertEquals(3, q.search("cde"));
		q.dequeue();
		Assert.assertEquals(-1, q.search("abc"));
		Assert.assertEquals(2, q.search("cde"));
		Assert.assertEquals(true, q.contains("bcd"));
		Assert.assertEquals("bcd", q.peek());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		Assert.assertEquals(null, q.peek());
		Assert.assertEquals(0, q.size());
	}

}

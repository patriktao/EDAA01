package testqueue;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue.FifoQueue;

public class TestAppendFifoQueue<E> {
	private FifoQueue<Integer> q1;
	private FifoQueue<Integer> q2;

	@Before
	public void setUp() throws Exception {
		q1 = new FifoQueue<Integer>();
		q2 = new FifoQueue<Integer>();

	}

	@After
	public void tearDown() throws Exception {
		q1 = null;
		q2 = null;

	}

	@Test
	public void test() {
		assertTrue(q1.isEmpty());
		assertTrue(q1.size() == 0);
		assertTrue(q2.isEmpty());
		assertTrue(q2.size() == 0);
	}

	@Test
	public final void testTwoEmpthyQueue() {
		q1.append(q2);
		assertTrue("Wrong size after poll", q1.size() == 0);

	}

	@Test
	public final void testAppendOneEmptQueue() {
		q2.offer(1);
		q2.offer(2);
		q2.offer(3);
		q1.append(q2);
		assertTrue("Wrong size after poll", q2.size() == 3);
	}

	@Test
	public final void testAppendOneEmptyQueue2() {
		q1.offer(1);
		q1.offer(2);
		q1.append(q2);
		assertTrue("Wrong size after poll", q1.size() == 2);
	}

	@Test
	public final void testAppendNoneEmpty() {

		q1.offer(1);
		q1.offer(2);
		q2.offer(1);
		q2.offer(2);
		q1.append(q2);

		assertTrue("Wrong size after poll", q1.size() == 4);
	}

}
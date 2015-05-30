package queue;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {

	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator() {
			if (last == null) {
				pos = null;
			} else {
				pos = last.next;
			}
		}

		public boolean hasNext() {
			return pos != null;

		}

		public E next() {
			if (hasNext()) {
				E elem = pos.element;
				pos = pos.next;

				if (pos == last.next) {
					pos = null;
				}
				return elem;
			} else {
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param x
	 *            the element to insert
	 * @return true if it was possible to add the element to this queue, else
	 *         false
	 */
	public boolean offer(E x) {
		QueueNode<E> n = new QueueNode(x);
		size++;

		if (last == null) {
			last = n;
			n.next = n;

		} else {
			n.next = last.next;
			last.next = n;
			last = n;
		}

		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is
	 * empty. post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {

		if (size() == 0) {
			return null;
		}

		E head = last.next.element;

		if (size() == 1) {
			last = null;
		} else {
			last.next = last.next.next;
		}

		size--;
		return head;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {		
		return size() == 0 ? null : last.next.element;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}

	public void append(FifoQueue<E> q) {

		if (last == null && q.last == null) {
			last = q.last;
			q.last = null;

		} else if (last == null && q.last != null) {
			last = q.last;

		} else if (last != null && q.last != null) {
			last = q.last.next;
			q.last = last.next;

		}
		size += q.size();
	}
}

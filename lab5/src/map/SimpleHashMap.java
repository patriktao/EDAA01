package map;

import java.util.Random;
import java.util.Scanner;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K, V>[] table;
	private int size;
	private static final double loadfactor = 0.75;

	public SimpleHashMap() {
		this(16);
		size = 0;
	}

	public SimpleHashMap(int capacity) {
		table = (Entry<K, V>[]) new Entry[16];
	}

	public String show() {

		StringBuilder sb = new StringBuilder();
		int i = 0;

		for (Entry<K, V> s : table) {
			sb.append(i + "\t");
			i++;
			while (s != null) {
				sb.append(s + " ");
				s = s.next;
			}

			sb.append("\n");
		}
		return sb.toString();
	}

	private int index(K key) {
		return Math.abs(key.hashCode() % table.length);
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> x = table[index];
		while (x != null) {
			if (x.getKey().equals(key)) {
				return x;
			}
			x = x.next;
		}
		return null;
	}

	@Override
	public V get(Object arg0) {
		K key = (K) arg0;
		Entry<K, V> e = find(index(key), key);

		if (e != null) {
			return e.getValue();
		}

		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		int index = index(key);
		Entry<K, V> e = find(index, key);

		if (e != null) {
			return e.setValue(value);
		}

		e = new Entry<K, V>(key, value);
		if (table[index] != null) {
			e.next = table[index];
		}

		table[index] = e;
		size++;

		if ((double) size / table.length > 0.75) {
			rehash();
		}

		return null;
	}

	private void rehash() {

		Entry<K, V>[] old = table;
		table = (Entry<K, V>[]) new Entry[old.length * 2];
		size = 0;

		for (int i = 0; i < old.length; i++) {
			Entry<K, V> e = old[i];

			while (e != null) {
				put(e.getKey(), e.getValue());
				e = e.next;

			}
		}
	}

	@Override
	public V remove(Object arg0) {

		if (size == 0) {
			return null;
		}

		K key = (K) arg0;
		Entry<K, V> e = find(index(key), key);

		if (e == null) {
			return null;
		} else if (e == table[index(key)]) {
			table[index(key)] = table[index(key)].next;
		} else {
			Entry<K, V> x = table[index(key)];
			while (x.next != e) {
				x = x.next;
			}
			x.next = x.next.next;
		}
		size--;
		return e.getValue();

	}

	@Override
	public int size() {
		return size;
	}

	public static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		public String toString() {
			return key.toString() + " = " + value.toString();
		}
	}

	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> hash = new SimpleHashMap<Integer, Integer>();

		for (int i = 0; i < 15; i++) {
			hash.put(i, i);
		}

		System.out.println(hash.show());

	}

}

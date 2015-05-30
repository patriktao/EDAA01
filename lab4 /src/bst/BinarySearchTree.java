package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;
	boolean added = false;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		root = add(root, x);
		return added;
	}

	private BinaryNode<E> add(BinaryNode<E> n, E x) {

		if (n == null) {
			added = true;
			size++;
			return new BinaryNode<E>(x);
		} else if (x.compareTo(n.element) == 0) {
			added = false;
			return n;
		} else if (x.compareTo(n.element) < 0) {
			n.left = add(n.left, x);
			return n;
		} else {
			n.right = add(n.right, x);
			return n;
		}
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return calcHeight(root);
	}

	private int calcHeight(BinaryNode<E> n) {
		if (n == null) {
			return 0;
		} else if (n.left == null && n.right == null) {
			return 1;
		} else {
			int left = calcHeight(n.left);
			int right = calcHeight(n.right);
			if (right > left) {
				return right + 1;
			} else if (right < left) {
				return left + 1;
			} else {
				return right + 1;
			}

		}
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */

	public void printTree() {
		printInorder(root);
	}

	private void printInorder(BinaryNode<E> n) {
		if (n != null) {
			printInorder(n.left);
			System.out.println(n.element);
			printInorder(n.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

		E[] a = (E[]) new Comparable[size];
		int first = 0;
		int last = toArray(root, a, 0);
		root = buildTree(a, first, last - 1);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1
	 * (the first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {

		if (n != null) {
			index = toArray(n.left, a, index);
			a[index] = n.element;
			index = toArray(n.right, a, index + 1);

			return index;

		}
		return index;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in
	 * the array a are assumed to be in ascending order. Returns the root of
	 * tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		if (first > last) {
			return null;
		}

		int mid = (first + last) / 2;
		BinaryNode<E> root = new BinaryNode<E>(a[mid]);
		root.left = buildTree(a, first, mid - 1);
		root.right = buildTree(a, mid + 1, last);

		return root;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		for (int i = 0; i < 20; i++) {
			tree.add(i);
		}

		tree.rebuild();
		tree.add(16);

		System.out.println("Height : " + tree.height());
		System.out.println("Size: " + tree.size());

		BSTVisualizer bst = new BSTVisualizer("Tree", 700, 700);
		bst.drawTree(tree);
	}

}

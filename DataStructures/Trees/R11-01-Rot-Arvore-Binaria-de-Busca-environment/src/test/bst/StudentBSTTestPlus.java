package adt.bst;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import adt.bt.BTNode;

public class StudentBSTTestPlus {

	private BSTImpl<Integer> tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12, 76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}

	@Test
	public void customTest() {
		BSTImpl<Integer> bst = new BSTImpl<>();
	
		// Testando todos os pre-requisitos
		assertTrue(bst.isEmpty());
		assertEquals(bst.size(), 0);
		assertEquals(bst.height(), -1);
		assertNull(bst.maximum());
		assertNull(bst.minimum());
		assertNotNull(bst.search(1));
		assertNull(bst.search(1).getData());
		assertTrue(bst.search(1).isEmpty());
		Integer[] vazio = {};
		assertArrayEquals(bst.order(), vazio);
		assertArrayEquals(bst.preOrder(), vazio);
		assertArrayEquals(bst.postOrder(), vazio);
		assertNotNull(bst.search(null));
		assertNull(bst.predecessor(null));
		assertNull(bst.sucessor(null));
	
		synchronized (bst) {
			int[] ns = new int[] { 100, 50, 200, 250, 150, 140, 180, 75, 25, 10, 70, 60, 73, 65, 55, 71 };
			int size = 0;
			for (int e : ns) {
				assertEquals(bst.size(), size++);
				bst.insert(e);
			}
		}
	
		// Os pre-requisitos nao devem mais ser validos
		assertFalse(bst.isEmpty());
		assertNotEquals(bst.size(), 0);
		assertNotEquals(bst.height(), -1);
		assertNotNull(bst.maximum());
		assertNotNull(bst.minimum());
		// Aqui eh excecao, claro
		assertNotNull(bst.search(10));
		assertNotNull(bst.search(10).getData());
		assertFalse(bst.search(10).isEmpty());
		// birl
		try {
			assertArrayEquals(bst.order(), vazio);
			fail();
		} catch (AssertionError e) {
		}
		try {
			assertArrayEquals(bst.preOrder(), vazio);
			fail();
		} catch (AssertionError e) {
		}
		try {
			assertArrayEquals(bst.postOrder(), vazio);
			fail();
		} catch (AssertionError e) {
		}
	
		// Testando as infos da arvere
		assertFalse(bst.isEmpty());
		assertEquals(bst.height(), 5);
		assertEquals(bst.size(), 16);
		assertTrue(bst.maximum().getData().equals(new Integer(250)));
		assertTrue(bst.minimum().getData().equals(new Integer(10)));
	
		assertNull(bst.sucessor(bst.maximum().getData()));
		assertNull(bst.predecessor(bst.minimum().getData()));
	
		assertNotNull(bst.sucessor(bst.getRoot().getData()));
		assertTrue(bst.sucessor(bst.getRoot().getData()).getData().equals(new Integer(140)));
		assertNotNull(bst.predecessor(bst.getRoot().getData()));
		assertTrue(bst.predecessor(bst.getRoot().getData()).getData().equals(new Integer(75)));
	
		assertNotNull(bst.search(null));
		assertTrue(bst.search(null).isEmpty());
		assertNull(bst.predecessor(null));
		assertNull(bst.sucessor(null));
	
		bst.insert(null);
		assertEquals(bst.height(), 5);
		assertEquals(bst.size(), 16);
	
		bst.remove(null);
		assertEquals(bst.height(), 5);
		assertEquals(bst.size(), 16);
	
		assertTrue(bst.predecessor(55).getData().equals(new Integer(50)));
		assertTrue(bst.predecessor(71).getData().equals(new Integer(70)));
		assertTrue(bst.sucessor(10).getData().equals(new Integer(25)));
		assertTrue(bst.predecessor(140).getData().equals(new Integer(100)));
		assertNull(bst.sucessor(250));
		assertNull(bst.predecessor(10));
		assertTrue(bst.sucessor(150).getData().equals(new Integer(180)));
		assertTrue(bst.predecessor(50).getData().equals(new Integer(25)));
		
		assertTrue(bst.predecessor(50).getData().equals(new Integer(25)));
		bst.remove(25);
		assertEquals(bst.height(), 5);
		assertEquals(bst.size(), 15);
		assertTrue(bst.predecessor(50).getData().equals(new Integer(10)));
	
		bst.remove(50);
		assertEquals(bst.height(), 5);
		assertEquals(bst.size(), 14);
		assertTrue(bst.sucessor(10).getData().equals(new Integer(55)));
		
		assertEquals(bst.height(), 5);
		bst.insert(135);
		assertEquals(bst.height(), 5);
		bst.insert(130);
		assertEquals(bst.height(), 5);
		bst.insert(125);
		assertEquals(bst.height(), 6);
		bst.insert(120);
		assertEquals(bst.height(), 7);
		
		assertTrue(bst.predecessor(120).getData().equals(new Integer(100)));
		assertTrue(bst.sucessor(120).getData().equals(new Integer(125)));
		
		assertEquals(bst.size(), 18);
		assertFalse(bst.search(71).isEmpty());
		bst.remove(71);
		assertTrue(bst.search(71).isEmpty());
		bst.remove(73);
		assertNull(bst.predecessor(73));
		assertNull(bst.sucessor(71));
		assertEquals(bst.size(), 16);
		assertEquals(bst.height(), 7);
		
		bst.remove(55);
		bst.remove(65);
		assertEquals(bst.size(), 14);
		assertEquals(bst.height(), 7);
		
		bst.remove(60);
		bst.remove(75);
		assertEquals(bst.size(), 12);
		assertEquals(bst.height(), 7);
		
		assertTrue(bst.sucessor(70).getData().equals(100));
		assertTrue(bst.predecessor(70).getData().equals(10));
		
		bst.remove(200);
		assertEquals(bst.size(), 11);
		assertEquals(bst.height(), 7);
		
		bst.remove(250);
		assertEquals(bst.size(), 10);
		assertEquals(bst.height(), 6);
		
		bst.remove(150);
		assertEquals(bst.size(), 9);
		assertEquals(bst.height(), 6);
		
		bst.remove(180);
		assertEquals(bst.size(), 8);
		assertEquals(bst.height(), 5);
		
		assertTrue(bst.sucessor(100).getData().equals(120));
		assertTrue(bst.predecessor(125).getData().equals(120));
		assertTrue(bst.predecessor(120).getData().equals(100));
		
		bst.remove(100);
		assertEquals(bst.size(), 7);
		assertEquals(bst.height(), 4);
		
		assertTrue(bst.getRoot().getData().equals(120));
		assertTrue(bst.search(100).isEmpty());
		assertNull(bst.predecessor(100));
		assertNull(bst.sucessor(100));
		assertTrue(bst.predecessor(120).getData().equals(70));
		assertTrue(bst.sucessor(120).getData().equals(125));
		
		bst.remove(120);
		assertEquals(bst.size(), 6);
		assertEquals(bst.height(), 3);
		
		assertTrue(bst.getRoot().getData().equals(125));
		assertTrue(bst.search(120).isEmpty());
		assertNull(bst.predecessor(120));
		assertTrue(bst.minimum().getData().equals(10));
		assertTrue(bst.maximum().getData().equals(140));
		
		bst.remove(10);
		bst.remove(135);
		bst.remove(130);
		
		assertTrue(bst.maximum().getData().equals(140));
		assertTrue(bst.minimum().getData().equals(70));
		assertEquals(bst.size(), 3);
		assertEquals(bst.height(), 1);
		assertNull(bst.sucessor(140));
		assertNull(bst.predecessor(70));
		assertTrue(bst.sucessor(bst.getRoot().getData()).getData().equals(140));
		assertTrue(bst.predecessor(bst.getRoot().getData()).getData().equals(70));
		
		bst.remove(140);
		bst.remove(70);
		
		assertEquals(bst.height(), 0);
		assertEquals(bst.size(), 1);
		assertTrue(bst.maximum().equals(bst.minimum()));
		
		bst.remove(bst.getRoot().getData());
		// Voltamos ao come\E7o
		assertTrue(bst.isEmpty());
		assertEquals(bst.size(), 0);
		assertEquals(bst.height(), -1);
		assertNull(bst.maximum());
		assertNull(bst.minimum());
		assertNotNull(bst.search(1));
		assertNull(bst.search(1).getData());
		assertTrue(bst.search(1).isEmpty());
		assertArrayEquals(bst.order(), vazio);
		assertArrayEquals(bst.preOrder(), vazio);
		assertArrayEquals(bst.postOrder(), vazio);
		assertNotNull(bst.search(null));
		assertNull(bst.predecessor(null));
		assertNull(bst.sucessor(null));
	}

	@Test
	public void testRemoveRandom() {
		Random random = new Random();
		BST<Integer> tree = new BSTImpl<>();

		int length = random.nextInt(10000);
		Set<Integer> array = new HashSet<>();

		for (int i = 0; i < length; i++) {
			int value = random.nextInt(Integer.MAX_VALUE);
			array.add(value);
			tree.insert(value);
		}

		int x = random.nextInt(array.size() - 1);
		int size = array.size();

		ArrayList<Integer> arr = new ArrayList<>(array);
		Collections.sort(arr);

		for (int i = x; i > -1; i--) {
			assertEquals(arr.get(i), tree.search(arr.get(i)).getData());
			tree.remove(arr.get(i));
			array.remove(arr.get(i));
			assertEquals(--size, tree.size());
		}

		for (int i = x + 1; i < arr.size(); i++) {
			assertEquals(arr.get(i), tree.search(arr.get(i)).getData());
			tree.remove(arr.get(i));
			array.remove(arr.get(i));
			assertEquals(array.size(), tree.size());
		}
	}
}

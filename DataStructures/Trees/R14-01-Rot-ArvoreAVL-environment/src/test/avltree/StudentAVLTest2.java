package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTNode;

public class StudentAVLTest2 {

	private AVLTree<Integer> avl;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(avl.isEmpty());
		assertEquals(0, avl.size());
		assertEquals(-1, avl.height());
		assertEquals(NIL, avl.getRoot());
	}

	@Test
	public void testInsert() {
		avl.insert(-10);
		assertEquals(1, avl.size());
		assertEquals(0, avl.height());
		assertArrayEquals(new Integer[] { -10 }, avl.preOrder());

		assertFalse(avl.isEmpty());
		assertEquals(new Integer(-10), avl.getRoot().getData());

		avl.insert(-15);
		assertEquals(2, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15 }, avl.preOrder());

		avl.insert(20);
		assertEquals(3, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15, 20 }, avl.preOrder());
	}

	@Test
	public void testRemove() {
		avl.insert(55);
		avl.insert(9);
		avl.insert(91);
		avl.insert(12);

		avl.remove(-1);
		assertEquals(4, avl.size());

		avl.remove(91);
		assertEquals(3, avl.size());
		assertArrayEquals(new Integer[] { 12, 9, 55 }, avl.preOrder());

		avl.remove(12);
		assertEquals(2, avl.size());
		assertArrayEquals(new Integer[] { 55, 9 }, avl.preOrder());

		avl.remove(9);
		avl.remove(55);
		assertEquals(NIL, avl.getRoot());
		assertTrue(avl.isEmpty());
	}
	
	@Test
	public void testQ() {
		for (int i = 1; i < 20; i++) {
			avl.insert(i);
		}
		assertEquals(avl.height(), 4);
	}
	
	@Test
	public void testSimples() {
		avl.insert(100);
		avl.insert(150);
		avl.insert(50);
		avl.insert(25);
		avl.insert(75);
		avl.insert(125);
		avl.insert(175);
		avl.insert(60);
		
		
		assertTrue(avl.getRoot().getData().equals(100));
		assertEquals(avl.height(), 3);
	}
	
	@Test
	public void testRotateRight() {
		avl.insert(100);
		avl.insert(99);
		avl.insert(98);
		assertEquals(avl.height(), 1);
		assertTrue(avl.getRoot().getData().equals(99));
		
		avl.insert(97);
		assertEquals(avl.height(), 2);
		avl.insert(96);
		assertEquals(avl.height(), 2);
		
		avl.insert(95);
		assertEquals(avl.height(), 2);
		assertTrue(avl.getRoot().getData().equals(97));
	}
	
	@Test
	public void testRotateLeft() {
		avl.insert(100);
		avl.insert(101);
		avl.insert(102);
		assertEquals(avl.height(), 1);
		assertTrue(avl.getRoot().getData().equals(101));
		
		avl.insert(103);
		assertEquals(avl.height(), 2);
		avl.insert(104);
		assertEquals(avl.height(), 2);
		
		avl.insert(105);
		assertEquals(avl.height(), 2);
		assertEquals(avl.height(), 2);
		assertTrue(avl.getRoot().getData().equals(103));
	}
	
	@Test
	public void testRotateRightLeft() {
		avl.insert(100);
		avl.insert(105);
		avl.insert(103);
		assertTrue(avl.getRoot().getData().equals(103));
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		
		avl.insert(108);
		avl.insert(106);
		assertTrue(avl.getRoot().getData().equals(103));
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		
		avl.insert(110);
		avl.insert(109);
		assertTrue(avl.getRoot().getData().equals(106));
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
	}
	
	@Test
	public void testRotateLeftRight() {
		avl.insert(100);
		avl.insert(95);
		avl.insert(98);
		assertTrue(avl.getRoot().getData().equals(98));
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		
		avl.insert(92);
		avl.insert(94);
		assertTrue(avl.getRoot().getData().equals(98));
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		
		avl.insert(90);
		avl.insert(91);
		assertTrue(avl.getRoot().getData().equals(94));
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
	}
	
	@Test
	public void testRemoveAleatorio() {
		for(int i = 1; i < 32; i++){
			avl.insert(i);
		}
		assertEquals(4, avl.height(), 0.1);
		assertTrue(avl.getRoot().getData().equals(16));
		

		avl.remove(8);
		avl.remove(13);
		avl.remove(15);
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		assertTrue(avl.getRoot().getData().equals(16));
		
		avl.remove(14);
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		assertTrue(avl.getRoot().getData().equals(16));
		
		avl.remove(24);
		avl.insert(24);
		avl.remove(25);
		avl.remove(27);
		avl.remove(31);
//		((BSTNode<?>) avl.getRoot()).printTree();
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 1.1);
		assertTrue(avl.getRoot().getData().equals(16));
//		
		avl.remove(20);
		avl.remove(22);
		avl.remove(21);
		avl.remove(17);
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		assertTrue(avl.getRoot().getData().equals(16));
		
		avl.remove(28);
		avl.remove(30);
//		((BSTNode<?>) avl.getRoot()).printTree();
	}
	
	// @author: Estacio Pereira
	@Test
	public void testTest() {
		for(int i = 1; i < 8; i++){
			avl.insert(i);
		}
		assertEquals(7, avl.size());
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);

		avl.remove(8);
		assertEquals(7, avl.size());
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);

		avl.remove(7);
		assertEquals(6, avl.size());
		assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);

		for(int i = 1; i < 6; i++){
			avl.remove(i);
			assertEquals(Math.floor(Math.log(avl.size()) / Math.log(2)), avl.height(), 0.1);
		}
	}
	
	@Test
	public void testRemove2() {
		avl.insert(55);
		avl.insert(9);
		avl.insert(91);
		avl.insert(12);

		avl.remove(-1);
		assertEquals(4, avl.size());

		avl.remove(91);
		assertEquals(3, avl.size());
		assertArrayEquals(new Integer[] { 12, 9, 55 }, avl.preOrder());

		avl.remove(12);
		assertEquals(2, avl.size());
		assertArrayEquals(new Integer[] { 55, 9 }, avl.preOrder());

		avl.remove(9);
		avl.remove(55);
		assertEquals(NIL, avl.getRoot());
		assertTrue(avl.isEmpty());

		avl = new AVLTreeImpl<>();
		avl.insert(10);
		avl.insert(15);
		avl.insert(6);
		avl.insert(4);
		avl.insert(8);
		avl.insert(12);
		avl.insert(18);
		avl.insert(2);
		avl.insert(5);
		avl.insert(7);
		avl.insert(9);
		avl.insert(13);
		avl.insert(16);
		avl.insert(19);
		avl.insert(3);
		avl.insert(17);

//		((BSTNode)avl.getRoot()).printTree();
		avl.remove(10);
//		((BSTNode)avl.getRoot()).printTree();
		assertEquals(avl.getRoot().getRight().getData(), new Integer(16));
	}
}
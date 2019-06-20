package test.linkedListPlus;

import main.linkedList.DoubleLinkedList;
import main.linkedList.RecursiveDoubleLinkedListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTestPlus extends StudentLinkedListTestPlus {
	
	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() {
		super.setUp();
		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista2.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
		lista3 = new RecursiveDoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		setUp();
		Assert.assertEquals(3, lista1.size());
		lista1.insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
		Assert.assertEquals(4, lista1.size());
		lista1.insertFirst(5);
		Assert.assertArrayEquals(new Integer[] { 5, 4, 3, 2, 1 }, lista1.toArray());
		Assert.assertEquals(5, lista1.size());

		lista1.insertFirst(null);
		Assert.assertArrayEquals(new Integer[] { 5, 4, 3, 2, 1 }, lista1.toArray());
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista3.size());
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
		lista3.insertFirst(null);
		Assert.assertEquals(0, lista3.size());
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
	}

	@Test
	public void testRemoveFirst() {
		setUp();
		lista1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		Assert.assertEquals(2, lista1.size());
		lista1.removeFirst();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista1.toArray());
		Assert.assertEquals(1, lista1.size());
		lista1.removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
		Assert.assertEquals(0, lista1.size());
		lista1.removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
		Assert.assertEquals(0, lista1.size());

		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
		Assert.assertEquals(0, lista3.size());
		lista3.removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
		Assert.assertEquals(0, lista3.size());
	}

	@Test
	public void testRemoveLast() {
		setUp();
		lista1.removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		Assert.assertEquals(2, lista1.size());
		lista1.removeLast();
		Assert.assertArrayEquals(new Integer[] { 3 }, lista1.toArray());
		Assert.assertEquals(1, lista1.size());
		lista1.removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
		Assert.assertEquals(0, lista1.size());
		lista1.removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
		Assert.assertEquals(0, lista1.size());
	}

	@Test
	public void testSearch() {
		setUp();
		Assert.assertNotNull(lista1.search(1));
		Assert.assertTrue(lista1.search(1).equals(1));
		Assert.assertNotNull(lista1.search(2));
		Assert.assertTrue(lista1.search(2).equals(2));
		Assert.assertNotNull(lista1.search(3));
		Assert.assertTrue(lista1.search(3).equals(3));
		Assert.assertNull(lista1.search(0));

		lista1.insert(0);
		Assert.assertNotNull(lista1.search(0));
		Assert.assertNull(lista1.search(10));

		lista1.insertFirst(10);
		Assert.assertNotNull(lista1.search(10));

		lista1.removeLast();
		Assert.assertNull(lista1.search(0));

		Assert.assertNull(lista3.search(1));
		lista3.insert(1);
		Assert.assertNotNull(lista3.search(1));
		Assert.assertTrue(lista3.search(1).equals(1));
		lista3.removeFirst();
		Assert.assertNull(lista3.search(1));
		lista3.insertFirst(1);
		Assert.assertNotNull(lista3.search(1));
		Assert.assertTrue(lista3.search(1).equals(1));
		lista3.removeLast();
		Assert.assertNull(lista3.search(1));
		
		Assert.assertNull(lista2.search(null));
	}
	
	@Test
	public void testDuplicates() {
		setUp();
		lista1.insert(1);
		lista1.insert(1);
		Assert.assertEquals(5, lista1.size());
		Assert.assertNotNull(lista1.search(1));
		lista1.removeLast();
		Assert.assertEquals(4, lista1.size());
		Assert.assertNotNull(lista1.search(1));
		lista1.removeLast();
		Assert.assertEquals(3, lista1.size());
		Assert.assertNotNull(lista1.search(1));
		lista1.removeLast();
		Assert.assertEquals(2, lista1.size());
		Assert.assertNull(lista1.search(1));
		
		Assert.assertNotNull(lista2.search(1));
		lista2.remove(1);
		Assert.assertEquals(0, lista2.size());
		Assert.assertNull(lista2.search(1));
		lista2.insert(1);
		lista2.insertFirst(1);
		Assert.assertEquals(2, lista2.size());
		Assert.assertNotNull(lista2.search(1));
		lista2.remove(1);
		Assert.assertNotNull(lista2.search(1));
		lista2.remove(1);
		Assert.assertNull(lista2.search(1));
		Assert.assertEquals(0, lista2.size());
	}
	
	@Test
	public void testInsert() {
		setUp();
		lista2.insert(10);
		Assert.assertNotNull(lista2.search(10));
		lista2.insert(11);
		Assert.assertNotNull(lista2.search(11));
		lista2.insert(12);
		Assert.assertNotNull(lista2.search(12));
		
		lista2.removeLast();
		Assert.assertNull(lista2.search(12));
		lista2.removeLast();
		Assert.assertNull(lista2.search(11));
	}
	
	@Test
	public void testRemove() {
		setUp();
		Assert.assertNotNull(lista1.search(1));
		lista1.remove(1);
		Assert.assertNull(lista1.search(1));
		
		lista2.insert(10);
		lista2.insert(11);
		lista2.insert(12);
		Assert.assertEquals(4, lista2.size());
		
		lista2.remove(10);
		Assert.assertEquals(3, lista2.size());
		Assert.assertNull(lista2.search(10));
	}
}
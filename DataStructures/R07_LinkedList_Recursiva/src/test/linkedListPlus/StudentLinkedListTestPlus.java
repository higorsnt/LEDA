package test.linkedListPlus;

import main.linkedList.LinkedList;
import main.linkedList.RecursiveSingleLinkedListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTestPlus {
	
	private LinkedList<Integer> lista1;
	private LinkedList<Integer> lista2;
	private LinkedList<Integer> lista3;
	private LinkedList<Integer> lista4;

	@Before
	public void setUp() {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 5 elementos
		Assert.assertTrue(lista3.size() == 0);
		lista3.insert(1);
		lista3.insert(null);
		Assert.assertTrue(lista3.size() == 1);
		lista3.insert(1);
		Assert.assertTrue(lista3.size() == 2);
		lista3.insert(1);
		lista3.insert(null);
		Assert.assertTrue(lista3.size() == 3);
		lista3.insert(1);
		Assert.assertTrue(lista3.size() == 4);
		lista3.insert(1);
		Assert.assertTrue(lista3.size() == 5);

		lista4.insert(5);
		lista4.insert(4);
		lista4.insert(3);
		lista4.insert(2);
		lista4.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveSingleLinkedListImpl<>();
		lista2 = new RecursiveSingleLinkedListImpl<>();
		lista3 = new RecursiveSingleLinkedListImpl<>();
		lista4 = new RecursiveSingleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
		Assert.assertFalse(lista3.isEmpty());
		Assert.assertFalse(lista4.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
		Assert.assertEquals(5, lista3.size());
		Assert.assertEquals(5, lista3.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));

		Assert.assertTrue(2 == lista4.search(2));
		Assert.assertTrue(3 == lista4.search(3));
		Assert.assertNull(lista4.search(6));
		Assert.assertTrue(4 == lista4.search(4));
		Assert.assertNull(lista4.search(0));
		Assert.assertTrue(5 == lista4.search(5));
		Assert.assertTrue(1 == lista4.search(1));

	}

	@Test
	public void testInsert() {

		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		lista1.insert(null);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {

		Assert.assertTrue(lista3.size() == 5);
		lista3.remove(1);
		Assert.assertTrue(lista3.size() == 4);
		lista3.remove(100);
		lista3.remove(500);
		Assert.assertTrue(lista3.size() == 4);
		lista3.remove(1);
		lista3.remove(329);
		lista3.remove(32989);
		lista3.remove(1);
		lista3.remove(null);
		Assert.assertTrue(lista3.size() == 2);
		lista3.remove(1);
		Assert.assertTrue(lista3.size() == 1);
		lista3.remove(1);
		Assert.assertTrue(lista3.size() == 0);
		Assert.assertTrue(lista3.isEmpty());

		Assert.assertTrue(lista4.size() == 5);
		Assert.assertTrue(1 == lista4.search(1));
		lista4.remove(1);
		lista4.remove(null);
		Assert.assertNull(lista4.search(1));
		Assert.assertTrue(lista4.size() == 4);

		Assert.assertTrue(lista4.size() == 4);
		Assert.assertTrue(5 == lista4.search(5));
		lista4.remove(5);
		Assert.assertNull(lista4.search(5));
		Assert.assertTrue(lista4.size() == 3);

		Assert.assertTrue(lista4.size() == 3);
		Assert.assertTrue(3 == lista4.search(3));
		lista4.remove(3);
		Assert.assertNull(lista4.search(3));
		Assert.assertTrue(lista4.size() == 2);

		Assert.assertTrue(lista4.size() == 2);
		Assert.assertTrue(2 == lista4.search(2));
		lista4.remove(2);
		Assert.assertNull(lista4.search(2));
		Assert.assertTrue(lista4.size() == 1);

		Assert.assertTrue(lista4.size() == 1);
		Assert.assertTrue(4 == lista4.search(4));
		lista4.remove(4);
		Assert.assertNull(lista4.search(4));
		Assert.assertTrue(lista4.size() == 0);
		Assert.assertTrue(lista4.isEmpty());

		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

		lista1.remove(4);
		lista1.remove(20);
		lista1.remove(10);
		Assert.assertEquals(1, lista1.size());
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 1, 1, 1, 1 }, lista3.toArray());
		Assert.assertArrayEquals(new Integer[] { 5, 4, 3, 2, 1 }, lista4.toArray());
	}
}
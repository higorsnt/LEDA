package test.hashtable.plus;

import main.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import main.hashtable.open.AbstractHashtableOpenAddress;
import main.hashtable.open.HashtableElement;
import main.hashtable.open.HashtableOpenAddressLinearProbingImpl;
import main.hashtable.open.HashtableOverflowException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;

public class StudentTestHashtableOpenAddressLinearProbingPlus {

	protected AbstractHashtableOpenAddress<HashtableElement> table1;
	protected AbstractHashtableOpenAddress<HashtableElement> table2;

	protected final int PROPOSED_SIZE = 10;

	@Before
	public void setUp() throws Exception {
		table1 = new HashtableOpenAddressLinearProbingImpl<HashtableElement>(
				PROPOSED_SIZE, HashFunctionClosedAddressMethod.DIVISION);
		// o tamanho real utilizado vai ser PROPOSED_SIZE
		table1.insert(new HashtableElement(2)); // coloca no slot indexado com 2
		table1.insert(new HashtableElement(3)); // coloca no slot indexado com 3
		table1.insert(new HashtableElement(4)); // coloca no slot indexado com 4
		table1.insert(new HashtableElement(5)); // coloca no slot indexado com 5

		table2 = new HashtableOpenAddressLinearProbingImpl<HashtableElement>(
				PROPOSED_SIZE, HashFunctionClosedAddressMethod.DIVISION);
	}

	@Test
	public void testInsert() {


		for(int i = 0 ; i < 100 ; i++){
			table1.insert(null);
			table1.insert(new HashtableElement(2));
			table1.insert(new HashtableElement(3));
			table1.insert(new HashtableElement(4));
			table1.insert(new HashtableElement(5));
		}

		assertEquals(0, table1.getCOLLISIONS());
		table1.insert(new HashtableElement(7)); // nao produz colisao. coloca no
		// slot indexado com 7
		assertEquals(7, table1.indexOf(new HashtableElement(7)));
		assertEquals(0, table1.getCOLLISIONS());

		table1.insert(new HashtableElement(9)); // nao produz colisao. coloca no
		// slot indexado com 9
		assertEquals(9, table1.indexOf(new HashtableElement(9)));
		assertEquals(0, table1.getCOLLISIONS());

		table1.insert(new HashtableElement(12)); // produz colisao com o 2.
		// coloca no slot indexado
		// com 6 (prox disponivel)
		assertEquals(6, table1.indexOf(new HashtableElement(12)));
		assertEquals(4, table1.getCOLLISIONS());
		table1.remove(new HashtableElement(12));
		assertEquals(0, table1.getCOLLISIONS());

		assertEquals(6, table1.size());
		table1.remove(new HashtableElement(9));
		assertEquals(5, table1.size());
		table1.remove(new HashtableElement(7));
		assertEquals(4, table1.size());
		table1.remove(new HashtableElement(5));
		assertEquals(3, table1.size());
		table1.remove(new HashtableElement(4));
		assertEquals(2, table1.size());
		table1.remove(new HashtableElement(3));
		assertEquals(1, table1.size());
		table1.remove(new HashtableElement(2));
		assertEquals(0, table1.size());

		assertTrue(table1.isEmpty());

		table2.insert(new HashtableElement(14)); // nao produz colisao. coloca
		// no slot indexado com 4
		assertEquals(4, table2.indexOf(new HashtableElement(14)));
		assertEquals(0, table2.getCOLLISIONS());

		table2.insert(new HashtableElement(24)); // nao produz colisao. coloca
		// no slot indexado com 4
		assertEquals(5, table2.indexOf(new HashtableElement(24)));
		assertEquals(1, table2.getCOLLISIONS());

		table2.insert(new HashtableElement(34)); // nao produz colisao. coloca
		// no slot indexado com 4
		assertEquals(6, table2.indexOf(new HashtableElement(34)));
		assertEquals(3, table2.getCOLLISIONS());

	}

	@Test
	public void testRemove() {


		for(int i = 0 ; i < 100 ; i++){
			table1.remove(null);
			table1.remove(new HashtableElement(9328));
			table1.remove(new HashtableElement(4325));
			table1.remove(new HashtableElement(3213));
		}

		assertEquals(4, table1.size());

		table1.remove(new HashtableElement(12)); // elemento inexistente
		assertEquals(4, table1.size());

		table1.insert(new HashtableElement(12)); // produz colisao com o 2.
		// coloca no slot indexado
		// com 6 (prox disponivel)

		assertEquals(4, table1.getCOLLISIONS());
		table1.remove(new HashtableElement(12)); // Zerar colisões
		assertEquals(0, table1.getCOLLISIONS());

		table1.remove(new HashtableElement(5)); // elemento existente
		assertEquals(3, table1.size());
		assertNull(table1.search(new HashtableElement(5)));

	}

	@Test
	public void testSearch() {

		assertEquals(new HashtableElement(4),
				table1.search(new HashtableElement(4)));

		assertEquals(new HashtableElement(3),
				table1.search(new HashtableElement(3)));

		assertEquals(new HashtableElement(2),
				table1.search(new HashtableElement(2)));


		assertEquals(new HashtableElement(5),
				table1.search(new HashtableElement(5))); // elemento que existe
		assertNull(table1.search(new HashtableElement(15))); // elemento que nao
		// existe

		assertNull(table1.search(null));
		assertNull(table1.search(new HashtableElement(1)));

	}

	@Test
	public void testIsEmpty() {
		assertFalse(table1.isEmpty());
		table1.remove(new HashtableElement(2)); // esvazia
		table1.remove(new HashtableElement(3));
		table1.remove(new HashtableElement(4));
		table1.remove(new HashtableElement(5));
		assertTrue(table1.isEmpty());

		assertTrue(table2.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(table1.isFull());
		table1.insert(new HashtableElement(1)); // enche a tabela
		table1.insert(new HashtableElement(6));
		table1.insert(new HashtableElement(7));
		table1.insert(new HashtableElement(8));
		table1.insert(new HashtableElement(9));
		table1.insert(new HashtableElement(10));
		assertTrue(table1.isFull());

		assertFalse(table2.isFull());

		for(int i = 0 ; i < 100 ; i++){

			table2.insert(null);

			try{

				table2.insert(new HashtableElement(i));

			} catch (HashtableOverflowException e){

			}

		}

		assertTrue(table2.isFull());
		assertEquals(0, table2.getCOLLISIONS());

	}

	@Test
	public void testSize() {

		assertEquals(4, table1.size());
		assertEquals(0, table2.size());

		for (int i = 0; i < 10; i++) {

			table2.insert(null);
			table2.insert(new HashtableElement(i));
			assertEquals(i + 1, table2.size());
		}

		assertEquals(10, table2.size());

		for (int i = 0; i < 10; i++) {

			table2.remove(null);
			table2.remove(new HashtableElement(i));
			assertEquals(9 - i, table2.size());
		}

		assertEquals(0, table2.size());

		for (int i = 0; i < 10; i++) {

			table2.insert(null);
			table2.insert(new HashtableElement((i * 10) + 2));
			assertEquals(i + 1, table2.size());
			int j = table2.getCOLLISIONS();
			assertEquals(j, colisoes(i));
		}

		assertEquals(10, table2.size());

	}

	public int colisoes(int index){

		if(index == 0){
			return 0;
		}

		return (index == 1) ? 1 : index + colisoes(index - 1);
	}

	@Test
	public void testCollisions(){

		table1.insert(new HashtableElement(1));
		table1.insert(new HashtableElement(6));
		table1.insert(new HashtableElement(7));
		table1.insert(new HashtableElement(8));
		table1.insert(new HashtableElement(9));
		table1.insert(new HashtableElement(10));
		assertEquals(0, table1.getCOLLISIONS());
		assertTrue(table1.isFull());

		try{
			table1.insert(new HashtableElement(99));
			fail();
		} catch (HashtableOverflowException e){
			assertEquals(0, table1.getCOLLISIONS());
		}

		table1.remove(new HashtableElement(10));
		table1.insert(new HashtableElement(11)); //vai dar colisao com tudo de 1 ate 9
		assertTrue(table1.isFull());
		assertEquals(9, table1.getCOLLISIONS());
		assertEquals(0, table2.size());

		for (int i = 0; i < 10; i++) {

			table2.insert(null);
			table2.insert(new HashtableElement((i * 10) + 2));
			assertEquals(i + 1, table2.size());
			int j = table2.getCOLLISIONS();
			assertEquals(j, colisoes(i));
		}

		assertEquals(10, table2.size());

	}

	@Test
	public void testIndexOf(){

		//2 3 4 5
		assertEquals(2, table1.indexOf(new HashtableElement(2)));
		assertEquals(3, table1.indexOf(new HashtableElement(3)));
		assertEquals(4, table1.indexOf(new HashtableElement(4)));
		assertEquals(5, table1.indexOf(new HashtableElement(5)));

		for(int i = 23 ; i < 1203 ; i++) {
			assertEquals(-1, table1.indexOf(new HashtableElement(i)));
			assertEquals(-1, table1.indexOf(null));
		}

		table1.insert(new HashtableElement(12));
		assertEquals(6, table1.indexOf(new HashtableElement(12)));

	}

	@Test
	public void testWithHashSet(){

		final int SIZE = 10000;

		HashSet<Integer> h = new HashSet<>();
		HashtableOpenAddressLinearProbingImpl<HashtableElement> table3 = new HashtableOpenAddressLinearProbingImpl<HashtableElement>(
				SIZE , HashFunctionClosedAddressMethod.DIVISION);

		Random r = new Random();

		for(int i = 0 ; i <= 3929 ; i++){
			int element = Math.abs(r.nextInt());
			h.add(element);
			table3.insert(new HashtableElement(element));
		}

		assertEquals(h.size(), table3.size());
		assertFalse(table3.isFull());
		assertFalse(table3.isEmpty());

	}

}
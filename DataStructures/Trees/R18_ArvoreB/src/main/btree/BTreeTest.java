package main.btree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class BTreeTest {
	
	BTree<Integer> tree1;
	
	@Before
	public void setUp() {
		tree1 = new BTreeImpl<>(4);
	}
	@Test
	public void testDepthLeftOrder() {

		tree1.insert(13);
		tree1.insert(9);
		tree1.insert(5);
	}

	@Test
	public void testInsert2() {

		tree1.insert(13);
		tree1.insert(9);
		tree1.insert(5);

		assertEquals(tree1.getRoot().getElementAt(0), new Integer(5));
		assertEquals(tree1.getRoot().getElementAt(1), new Integer(9));
		assertEquals(tree1.getRoot().getElementAt(2), new Integer(13));

		assertEquals(tree1.size(), 3);
		assertEquals(tree1.height(), 0);

		tree1.insert(12);

		assertEquals(tree1.size(), 4);
		assertEquals(tree1.height(), 1);

		tree1.insert(122);
		tree1.insert(3);

		assertEquals(tree1.size(), 6);
		assertEquals(tree1.height(), 1);
		
		tree1.insert(76);

		tree1.insert(10);
		assertEquals(1, tree1.height());

		tree1.insert(7);
		assertEquals(1, tree1.height());
		tree1.insert(8);
		assertEquals(1, tree1.height());
		
		printTree(tree1);
		tree1.insert(6);
		printTree(tree1);

		tree1.insert(1000);
		assertEquals(2, tree1.height());

		for (int i = 0; i < 4332; i++) {
			tree1.insert(null);
		}

	}

	@Test
	public void testAdd() {
		BTreeImpl<Integer> arvere = new BTreeImpl<>(4);
		assertEquals(arvere.size(), 0);

		assertNull(arvere.search(1).node);
		arvere.insert(0);
		arvere.insert(1);
		assertNotNull(arvere.search(1).node);
		assertNull(arvere.search(-1).node);
		arvere.insert(-1);
		assertNotNull(arvere.search(-1).node);

		assertEquals(arvere.size(), 3);
		assertEquals(arvere.height(), 0);

		arvere.insert(2);
		assertEquals(arvere.height(), 1);
		arvere.insert(-2);
		assertEquals(arvere.size(), 5);
		assertEquals(arvere.height(), 1);
		assertNotNull(arvere.search(-2).node);

		arvere.insert(3);
		arvere.insert(-3);
		assertEquals(arvere.height(), 1);
		assertEquals(arvere.size(), 7);

		arvere.insert(4);
		assertEquals(arvere.height(), 1);
		arvere.insert(5);
		arvere.insert(6);
		assertEquals(arvere.height(), 1);
		arvere.insert(7);
		assertEquals(arvere.size(), 11);
		assertEquals(arvere.height(), 1);
		assertNotNull(arvere.search(7).node);
	}

	@Test
	public void testLuciano() {
		BTreeImpl<Integer> arvere = new BTreeImpl<>(4);

		arvere.insert(1);
		arvere.insert(4);
		arvere.insert(18);
		arvere.insert(3);
	}

	private void printTree(BTree<?> t) {
		BNode<?> node = t.getRoot();
		class Pair {
			BNode<?> node;
			int c;
			boolean hasLeft;

			Pair(BNode<?> node, int c, boolean hl) {
				this.node = node;
				this.c = -c;
				this.hasLeft = hl;
			}
		}
		;
		LinkedList<Pair> lista = new LinkedList<>();
		HashSet<BNode<?>> visitados = new HashSet<>();

		lista.add(new Pair(node, 1, false));
		int ultimaCor = -1;
		while (!lista.isEmpty()) {
			Pair top = lista.removeFirst();
			if (top.c != ultimaCor)
				System.out.println();

			System.out.print(top.node + (top.hasLeft ? "=" : " "));

			for (BNode<?> b : top.node.getChildren()) {
				if (visitados.add(b))
					lista.addLast(new Pair(b, top.c, !b.equals(top.node.getChildren().getLast())));
			}
			ultimaCor = top.c;
		}
		System.out.println();
	}
}

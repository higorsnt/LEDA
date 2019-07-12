package main.rbtree;

import main.bt.BTNode;
import main.rbtree.RBNode.Colour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StudentTest {

	public RBTreeImpl<Integer> myRB;

	@Before
	public void initialize() {
		myRB = new RBTreeImpl<Integer>();
	}

	@Test
	public void testInsert0() {
		Integer[] preOrder = { 11 };
		Colour[] preOrderColour = { Colour.BLACK };

		myRB.insert(11);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert1() {
		Integer[] preOrder = { 11, 2 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert2() {
		Integer[] preOrder = { 11, 2, 14 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.RED, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert3() {
		Integer[] preOrder = { 11, 2, 1, 14 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.BLACK, Colour.RED,
				Colour.BLACK };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert4() {
		Integer[] preOrder = { 11, 2, 1, 14, 15 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.BLACK, Colour.RED,
				Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);
		myRB.insert(15);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert5() {
		Integer[] preOrder = { 11, 2, 1, 7, 14, 15 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.BLACK, Colour.RED,
				Colour.RED, Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);
		myRB.insert(15);
		myRB.insert(7);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert6() {
		Integer[] preOrder = { 11, 2, 1, 7, 5, 14, 15 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.RED, Colour.BLACK,
				Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);
		myRB.insert(15);
		myRB.insert(7);
		myRB.insert(5);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testSePassarAquiTaCerto(){

		Random r = new Random();

        for(int i = 0 ; i < 4382 ; i++){
            int insertedElement = r.nextInt();
            myRB.insert(insertedElement);
            assertTrue(myRB.height() <= 2 * Math.log(myRB.size() + 1));
        }

        assertTrue(myRB.verifyProperties());

	}

	@Test
    public void testDiniz1(){

	    myRB.insert(5);
        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);

	    assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.BLACK);

        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.BLACK);

        myRB.insert(71);

        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);

        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.RED);


        //FIX-UP CASE 5
        // 5 -> 71-> 90
        //5 <- 71 -> 90
        myRB.insert(90);


        //RAIZ DEVE SER BLACK
        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);


        //NESSE CASO OS FILHOS DA RAIZ DEVEM SER AMBOS RED
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.RED);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.RED);

        //FOLHAS NIL DEVEM SER BLACK
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getLeft()).getColour() == Colour.BLACK);

        //FOLHAS NIL DEVEM SER BLACK
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft()).getColour() == Colour.BLACK);


        assertEquals(new Integer(71), myRB.getRoot().getData());
        assertEquals(new Integer(90), myRB.getRoot().getRight().getData());
        assertEquals(new Integer(5), myRB.getRoot().getLeft().getData());

        //FIX-UP CASE 3 => FIX-UP CASE 1
        //6 <- 5 <- 71 -> 90
        myRB.insert(6);

        assertEquals(new Integer(71), myRB.getRoot().getData());
        assertEquals(new Integer(90), myRB.getRoot().getRight().getData());
        assertEquals(new Integer(5), myRB.getRoot().getLeft().getData());
        assertEquals(new Integer(6), myRB.getRoot().getLeft().getRight().getData());

        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight()).getColour() == Colour.RED);


        //FIX-UP CASE 5
        myRB.insert(8);

        assertEquals(new Integer(71), myRB.getRoot().getData());
        assertEquals(new Integer(90), myRB.getRoot().getRight().getData());
        assertEquals(new Integer(6), myRB.getRoot().getLeft().getData());
        assertEquals(new Integer(8), myRB.getRoot().getLeft().getRight().getData());
        assertEquals(new Integer(5), myRB.getRoot().getLeft().getLeft().getData());

        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight()).getColour() == Colour.RED);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft()).getColour() == Colour.RED);


        //FOLHAS NIL DEVEM SER PRETAS
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getRight()).getColour() == Colour.BLACK);

    }

    @Test
    public void testDiniz2(){

        myRB.insert(50);
        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);

        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.BLACK);

        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.BLACK);

        myRB.insert(71);

        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);

        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.RED);


        //FIX-UP CASE 5
        // 5 -> 71-> 90
        //5 <- 71 -> 90
        myRB.insert(90);


        //RAIZ DEVE SER BLACK
        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);


        //NESSE CASO OS FILHOS DA RAIZ DEVEM SER AMBOS RED
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.RED);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.RED);

        //FOLHAS NIL DEVEM SER BLACK
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getLeft()).getColour() == Colour.BLACK);

        //FOLHAS NIL DEVEM SER BLACK
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft()).getColour() == Colour.BLACK);


        assertEquals(new Integer(71), myRB.getRoot().getData());
        assertEquals(new Integer(90), myRB.getRoot().getRight().getData());
        assertEquals(new Integer(50), myRB.getRoot().getLeft().getData());

        //FIX-UP CASE 3 => FIX-UP CASE 1
        myRB.insert(60);

        assertEquals(new Integer(71), myRB.getRoot().getData());
        assertEquals(new Integer(90), myRB.getRoot().getRight().getData());
        assertEquals(new Integer(50), myRB.getRoot().getLeft().getData());
        assertEquals(new Integer(60), myRB.getRoot().getLeft().getRight().getData());

        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight()).getColour() == Colour.RED);


        //FIX-UP CASE 4 => FIX-UP CASE 5
        myRB.insert(55);


        assertEquals(new Integer(71), myRB.getRoot().getData());
        assertEquals(new Integer(90), myRB.getRoot().getRight().getData());
        assertEquals(new Integer(55), myRB.getRoot().getLeft().getData());
        assertEquals(new Integer(60), myRB.getRoot().getLeft().getRight().getData());
        assertEquals(new Integer(50), myRB.getRoot().getLeft().getLeft().getData());

        assertTrue(((RBNode<Integer>)myRB.getRoot()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight()).getColour() == Colour.RED);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft()).getColour() == Colour.RED);


        //FOLHAS NIL DEVEM SER PRETAS
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getRight().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getLeft().getLeft().getRight()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getLeft()).getColour() == Colour.BLACK);
        assertTrue(((RBNode<Integer>)myRB.getRoot().getRight().getRight()).getColour() == Colour.BLACK);


    }

    @Test
    public void myTestWithAReallyLongAndPointlessNameJustForTheLulzStillFollowingThePatternsAndGoodManners() {
        Integer[] joaoArray = { 84, 61, 30, 65, 80, 8, 3, 5, 76, 65 };
        for (Integer anotherVariableWithALongAndPointlessName : joaoArray) {
            myRB.insert(anotherVariableWithALongAndPointlessName);
        }

        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.getRoot().getData().equals(61));
        assertTrue(myRB.verifyProperties());
    }

    @Test
    public void joaoArrayReturnsPT1() {
        Integer[] joaoArray = { 84, 61, 30, 65, 80, 8, 3, 5, 76, 65 };

        myRB.insert(84);
        assertEquals(myRB.blackHeight(), 1);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(84));

        myRB.insert(joaoArray[1]);
        assertEquals(myRB.blackHeight(), 1);
        assertTrue(myRB.getRoot().getData().equals(84));

        myRB.insert(30);
        assertEquals(myRB.blackHeight(), 1);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));

        myRB.insert(65);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));

        myRB.insert(80);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));

        myRB.insert(8);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));

        myRB.insert(3);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));

        myRB.insert(joaoArray[7]);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));

        myRB.insert(joaoArray[8]);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));

        myRB.insert(joaoArray[9]);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        assertTrue(myRB.getRoot().getData().equals(61));
    }

    @Test
    public void naoOqueVoceEsperavaPontoPy() {
        assertNotNull(myRB.search(1));
        assertTrue(myRB.search(1).isEmpty());
        assertTrue(myRB.isEmpty());

        assertEquals(myRB.blackHeight(), 0);
        assertTrue(myRB.verifyProperties());
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));

        myRB.insert(1);
        assertFalse(myRB.isEmpty());
        assertEquals(myRB.blackHeight(), 1);
        assertTrue(myRB.verifyProperties());
        assertNotNull(myRB.search(1));

        myRB.insert(5);
        myRB.insert(10);
        myRB.insert(15);
        myRB.insert(20);
        assertFalse(myRB.isEmpty());
        assertEquals(myRB.size(), 5);
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));

        myRB.insert(25);
        myRB.insert(30);
        assertFalse(myRB.search(25).isEmpty());
        assertFalse(myRB.search(30).isEmpty());
        assertFalse(myRB.search(10).isEmpty());
        assertEquals(myRB.size(), 7);
        assertFalse(myRB.isEmpty());
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));

        myRB.insert(35);
        myRB.insert(40);
        assertEquals(myRB.size(), 9);
        assertFalse(myRB.search(35).isEmpty());
        assertEquals(myRB.blackHeight(), 2);
        assertTrue(myRB.verifyProperties());
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));

        myRB.insert(45);
        myRB.insert(50);
        myRB.insert(55);
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));

        myRB.insert(60);
        myRB.insert(65);
        myRB.insert(66);
        assertEquals(myRB.size(), 15);
        assertFalse(myRB.search(50).isEmpty());
        assertFalse(myRB.search(65).isEmpty());
        assertTrue(myRB.getRoot().getData().equals(15));
        assertEquals(myRB.blackHeight(), 3);
        assertTrue(myRB.verifyProperties());
        assertFalse(myRB.isEmpty());
        //new RuntimeException().printStackTrace();
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));

        myRB.insert(-4);
        myRB.insert(-9);
        myRB.insert(-14);
        myRB.insert(-19);
        assertEquals(myRB.size(), 19);
        assertFalse(myRB.search(-4).isEmpty());
        assertFalse(myRB.search(-19).isEmpty());
        assertEquals(myRB.blackHeight(), 3);
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));

        myRB.insert(-24);
        myRB.insert(-29);
        myRB.insert(-34);
        assertEquals(myRB.size(), 22);
        assertFalse(myRB.search(-34).isEmpty());
        assertFalse(myRB.search(-29).isEmpty());
        assertEquals(myRB.blackHeight(), 3);
        Assert.assertArrayEquals(myRB.rbPreOrder(), awyiss((RBNode<Integer>) myRB.getRoot()));
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    /**
     * Faz umas magicas e cria o preorder
     *
     * @param eric
     *            Criador do metodo
     * @return Preorder
     */
    @SuppressWarnings("rawtypes")
    private RBNode[] awyiss(RBNode eric) {
        RBNode<?>[] er = (RBNode<?>[]) new RBNode[0];
        if (!eric.isEmpty()) {
            RBNode[] eri = awyiss(e(eric.getLeft()));
            RBNode[] ericb = awyiss(e(eric.getRight()));
            er = (RBNode<?>[]) new RBNode[1 + eri.length + ericb.length];
            int ericbr = 0;
            er[ericbr++] = eric;
            for (RBNode<?> e : eri)
                er[ericbr++] = e;
            for (RBNode<?> e : ericb)
                er[ericbr++] = e;
        }
        return er;
    }

    private RBNode<? extends Comparable<?>> e(BTNode<?> ue) {
        return (RBNode<? extends Comparable<?>>) ue;
    }

}
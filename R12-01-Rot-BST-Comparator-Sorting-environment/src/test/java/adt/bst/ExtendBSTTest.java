package adt.bst;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import adt.bst.extended.SortComparatorBSTImpl;

class paresMaiores implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		if (o1 % 2 == 0 && o2 % 2 == 0) {
			return o1.compareTo(o2);

		} else if (o1 % 2 == 0) {
			return 1;

		} else if (o2 % 2 == 0) {
			return -1;

		} else {
			return o1.compareTo(o2);
		}
	}
}

class imparesMaiores implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		if (o1 % 2 != 0 && o2 % 2 != 0) {
			return o2.compareTo(o1);

		} else if (o1 % 2 != 0) {
			return 1;

		} else if (o2 % 2 != 0) {
			return -1;

		} else {
			return o2.compareTo(o1);
		}
	}
}

class Compara implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}

public class ExtendBSTTest {

	paresMaiores compPares = new paresMaiores();
	imparesMaiores compImpar = new imparesMaiores();
	Compara comp = new Compara();

	SortComparatorBSTImpl<Integer> tree;

	private void fill() {
		Integer[] array = { 5, 6, 54, 4623, 6887, 654, 91, 69416, 31576, 13, 0, -30, 77 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Test
	public void test() {
		Integer[] a = {10, 15, 16, 9, 12, 1, 3, 7, 6, 5, 2, 0, 8, 13, 14, 18, 11, 4, 17 };
		tree = new SortComparatorBSTImpl<Integer>(comp);
		for (int i: a) {
			tree.insert(i);
		}
		
		//System.out.println( Arrays.toString(tree.reverseOrder()) );
	}

	@Test
	public void reverseOrderTest() {

		tree = new SortComparatorBSTImpl<>(compPares);
		fill();
		
		//System.out.println(Arrays.toString(tree.order()));
		Integer[] expectedPar = { 69416, 31576, 654, 54, 6, 0, -30, 6887, 4623, 91, 77, 13, 5 };
		assertArrayEquals(expectedPar, tree.reverseOrder());

		tree = new SortComparatorBSTImpl<>(compImpar);
		fill();

		Integer[] expectedImpar = { 5, 13, 77, 91, 4623, 6887, -30, 0, 6, 54, 654, 31576, 69416 };
		assertArrayEquals(expectedImpar, tree.reverseOrder());

		tree = new SortComparatorBSTImpl<>(comp);
		fill();
		//System.out.println(Arrays.toString(tree.reverseOrder()));
	}

	@Test
	public void sortImparesMenores() {
		tree = new SortComparatorBSTImpl<>(compPares);
		Integer[] array = { 5, 3, 2, 0, 88, 96, 101, 1007 };
		Integer[] expected = { 3, 5, 101, 1007, 0, 2, 88, 96 };
		assertArrayEquals(expected, tree.sort(array));
	}

	@Test
	public void sortParesMenores() {

		tree = new SortComparatorBSTImpl<>(compPares);
		Integer[] array = { 5, 3, 2, 0, 88, 96, 101, 1007 };
		Integer[] expected = { 3, 5, 101, 1007, 0, 2, 88, 96 };
		assertArrayEquals(expected, tree.sort(array));
	}

}

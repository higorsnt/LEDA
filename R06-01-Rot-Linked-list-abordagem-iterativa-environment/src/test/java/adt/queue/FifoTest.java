package adt.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.queue.Queue;
import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class FifoTest {

	private Random randomer;

	private final int ELEMENTS_RANGE = 10;
	private final int STACK_SIZE = 5;
	private final int NUMBER_OF_TESTS = 1000000;
	private final boolean NEGATIVE_NUMBERS = true;
	private final boolean NULL_ELEMENTS = true;

	private Deque<Integer> stack;
	private Queue<Integer> myQueue;

	@Before
	public void setUp() {
		this.randomer = new Random();
		this.stack = new ArrayDeque<>();
		this.myQueue = new QueueDoubleLinkedListImpl<>(STACK_SIZE);
	}

	@Test
	public void start() {
		generalTest();
		brutalPushTest();
		brutalPopTest();
		intercalary();
	}

	private void generalTest() {
		for (int i = 0; i <= NUMBER_OF_TESTS; i++) {

			switch (randomer.nextInt(5)) {
			case 0:
				isEmptyTest();
				break;
			case 1:
				isFullTest();
				break;
			case 2:
				pushTest();
				break;
			case 3:
				popTest();
				break;
			case 4:
				topTest();
				break;
			default:
				break;

			}
		}
	}

	private void intercalary() {
		for (int i = 0; i <= STACK_SIZE * 3; i++) {
			if (randomer.nextBoolean()) {
				pushTest();
			}

			if (randomer.nextBoolean()) {
				popTest();
			}
		}
	}

	private void brutalPopTest() {
		for (int i = 0; i <= STACK_SIZE * 2; i++) {
			popTest();
		}
	}

	private void brutalPushTest() {
		for (int i = 0; i <= STACK_SIZE * 2; i++) {
			pushTest();
		}
	}

	private void topTest() {
		Integer element = stack.peekLast();
		Assert.assertEquals(element, myQueue.head());
	}

	private void isEmptyTest() {
		if (stack.isEmpty()) {
			if (!myQueue.isEmpty()) {
				Assert.fail("Deveria estar vazia.");
			}
		} else {
			if (myQueue.isEmpty()) {
				Assert.fail("Não Deveria estar vazia.");
			}
		}
	}

	private void isFullTest() {
		if (stack.size() == STACK_SIZE) {
			if (!myQueue.isFull()) {
				Assert.fail("Deveria estar cheia.");
			}
		} else {
			if (myQueue.isFull()) {
				Assert.fail("Não Deveria estar cheia.");
			}
		}

	}

	private void popTest() {
		if (stack.size() > 0) {
			Integer element = stack.removeLast();
			try {
				Assert.assertEquals(element, myQueue.dequeue());
			} catch (QueueUnderflowException e) {
				Assert.fail("Nao deveria estar vazia.");
			}
		} else {
			try {
				myQueue.dequeue();
				Assert.fail("Deveria estar vazia");
			} catch (QueueUnderflowException e) {
//				Assert.assertEquals("Stack is empty", e.getMessage());
			}
		}
	}

	private void pushTest() {
		int element = randomer.nextInt(ELEMENTS_RANGE);
		element = newValue(element);
		if (stack.size() < STACK_SIZE) {
			stack.addFirst(element);

			try {
				myQueue.enqueue(element);
			} catch (QueueOverflowException e) {
				Assert.fail("Nao deveria estar cheia.");
			}
		} else {

			try {
				myQueue.enqueue(element);
				Assert.fail("Deveria estar cheia");
			} catch (QueueOverflowException e) {
//				Assert.assertEquals("Stack is full", e.getMessage());
			}

		}
	}

	private int newValue(Integer element) {
		if (NEGATIVE_NUMBERS) {
			if (randomer.nextBoolean()) {
				element *= -1;
			}
		} else if (NULL_ELEMENTS) {
			if (randomer.nextBoolean()) {
				element = null;
			}
		}
		return element;
	}

}
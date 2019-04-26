package adt.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

	private Random randomer;

	private final int ELEMENTS_RANGE = 10;
	private final int STACK_SIZE = 5;
	private final int NUMBER_OF_TESTS = 1000000;
	private final boolean NEGATIVE_NUMBERS = true;
	private final boolean NULL_ELEMENTS = true;

	private Deque<Integer> stack;
	private Stack<Integer> myStack;

	@Before
	public void setUp() {
		this.randomer = new Random();
		this.stack = new ArrayDeque<>();
		this.myStack = new StackRecursiveDoubleLinkedListImpl<>(STACK_SIZE);
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
		Integer element = stack.peek();
		Assert.assertEquals(element, myStack.top());
	}

	private void isEmptyTest() {
		if (stack.isEmpty()) {
			if (!myStack.isEmpty()) {
				Assert.fail("Deveria estar vazia.");
			}
		} else {
			if (myStack.isEmpty()) {
				Assert.fail("Não Deveria estar vazia.");
			}
		}
	}

	private void isFullTest() {
		if (stack.size() == STACK_SIZE) {
			if (!myStack.isFull()) {
				Assert.fail("Deveria estar cheia.");
			}
		} else {
			if (myStack.isFull()) {
				Assert.fail("Não Deveria estar cheia.");
			}
		}

	}

	private void popTest() {
		if (stack.size() > 0) {
			Integer element = stack.removeFirst();
			try {
				Assert.assertEquals(element, myStack.pop());
			} catch (StackUnderflowException e) {
				Assert.fail("Nao deveria estar vazia.");
			}
		} else {
			try {
				myStack.pop();
				Assert.fail("Deveria estar vazia");
			} catch (StackUnderflowException e) {
				Assert.assertEquals("Stack is empty", e.getMessage());

			}

		}
	}

	private void pushTest() {
		int element = randomer.nextInt(ELEMENTS_RANGE);
		element = newValue(element);
		if (stack.size() < STACK_SIZE) {
			stack.addFirst(element);

			try {
				myStack.push(element);
			} catch (StackOverflowException e) {
				Assert.fail("Nao deveria estar cheia.");
			}
		} else {

			try {
				myStack.push(element);
				Assert.fail("Deveria estar cheia");
			} catch (StackOverflowException e) {
				Assert.assertEquals("Stack is full", e.getMessage());
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

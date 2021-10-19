package com.greatlearning.ga3.skyscraper.service;

import java.util.Stack;

public class SortStack {

	// Recursive Method to insert an element in sorted way
	private static void sortedInsert(Stack<Integer> sortedStack, int element) {
		// Base case: Either stack is empty or
		// new element is greater than top
		if (sortedStack.isEmpty() || element > sortedStack.peek()) {
			sortedStack.push(element);
			return;
		}

		// If top is greater, remove the top element from the stack
		int temp = sortedStack.pop();
		// call the method recursively
		sortedInsert(sortedStack, element);

		// Put back the top element on the stack
		// which was removed earlier
		sortedStack.push(temp);
	}

	// Method to sort stack
	public static void sortStack(Stack<Integer> sortedStack) {
		// If stack is not empty
		if (!sortedStack.isEmpty()) {
			// Remove the top item
			int x = sortedStack.pop();

			// Sort remaining stack
			sortStack(sortedStack);

			// Push the top item back in sorted stack
			sortedInsert(sortedStack, x);
		}
	}
}

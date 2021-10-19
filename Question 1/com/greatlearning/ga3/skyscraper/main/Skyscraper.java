package com.greatlearning.ga3.skyscraper.main;

import java.util.Stack;
import java.util.ListIterator;
import java.util.Scanner;
import com.greatlearning.ga3.skyscraper.service.SortStack;

public class Skyscraper {

	public Stack<Integer> stack, sortedStack, tempStack;
	private static int fl, topFloor, counter = 1;
	private static final Scanner floor = new Scanner(System.in);

	// This method will be called from
	// the driver class to construct the skyscraper
	public void constructSkyscraper() {
		System.out.print("Enter the total number of floors in the building: ");
		topFloor = floor.nextInt();
		System.out.print("\n");
		stack = new Stack<Integer>();
		sortedStack = new Stack<Integer>();

		for (int i = 0; i < topFloor; i++) {
			stack_push(stack);
		}
		System.out.print("\n");
		// This Method will stack the floors
		// from highest to lowest
		ListIterator<Integer> lt = stack.listIterator();
		while (lt.hasNext()) {
			sortedStack.push(lt.next());
		}
		SortStack.sortStack(sortedStack);
		// This Method will print the
		// order of the construction per day
		orderOfConstruction(stack, sortedStack);
		System.out.print("\n");
	}

	// Adding Floors to the Stack
	// Duplicate Floors are not allowed
	// floor greater than the top floor is an invalid floor
	// 0 floor is an invalid floor
	public void stack_push(Stack<Integer> stack) {
		System.out.println("Enter the floor constructed on day " + (counter));
		fl = floor.nextInt();
		if (fl > topFloor || fl == 0) {
			System.out.println(fl + " is not a valid floor topFloor");
			stack_push(stack);
		} else {
			if (stack.search(fl) == -1) {
				stack.push(fl);
				counter = counter + 1;
			} else {
				System.out.println(fl + " floor already exists");
				stack_push(stack);
			}
		}
	}

	// This method will be used to build the
	// day wise order of construction
	public void orderOfConstruction(Stack<Integer> s, Stack<Integer> ss) {

		System.out.println("The order of construction is as follows");
		tempStack = new Stack<Integer>();
		for (int i = 0; i < topFloor; i++) {
			System.out.println("\nDay " + (i + 1) + ": ");
			if (s.elementAt(i) != ss.peek()) {
				tempStack.push(s.elementAt(i));
				SortStack.sortStack(tempStack);
			} else {
				System.out.print(ss.pop() + " ");
				while (!tempStack.isEmpty() && ss.peek() == tempStack.peek()) {
					System.out.print(ss.pop() + " ");
					tempStack.pop();
				}
			}
		}
	}
}

package com.greatlearning.ga3.rst.driver;

import com.greatlearning.ga3.rst.main.*;

public class Driver {

	public static void main(String[] args) {
		SkewedTree st = new SkewedTree();
		st.node = new Node(50);
		st.node.left = new Node(30);
		st.node.right = new Node(60);
		st.node.left.left = new Node(10);
		st.node.left.right = new Node(40);
		st.node.right.left = new Node(55);

		//     50
		//     / \
		//   30   60
		//   /\   /
		//  10 40 55

		st.rightSkewed(st.node);
		st.traverseRightSkewed(st.headNode);

	}
}

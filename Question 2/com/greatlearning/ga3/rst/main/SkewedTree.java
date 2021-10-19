package com.greatlearning.ga3.rst.main;

public class SkewedTree {
	public  Node node;
	public  Node prevNode = null;
	public  Node headNode = null;
   
    // Creating skewed tree in
    // increasing order
    public void rightSkewed(Node root)
    {
       
        // Base Case
        if(root == null)
        {
            return;
        }
        
        rightSkewed(root.left);
        
        Node rightNode = root.right;
       
        // Condition to check if the root Node
        // of the skewed tree is not defined
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
        rightSkewed(rightNode);
    }
   
    // Right skewed tree traversal
    public void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);       
    }

}


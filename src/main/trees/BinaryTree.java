package main.trees;

import java.util.Stack;

// from: https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/

// Class containing left and right child of
// current node and key value
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Class to print the inorder traversal
class BinaryTree {
    Node root;
    void inorder() {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();
        Node curr = root;

        // Traverse the tree
        while (curr != null || s.size() > 0) {

            // Reach the left most Node of the
            // curr Node
            while (curr !=  null) {
                // Place pointer to a tree node on
                // the stack before traversing
                // the node's left subtree
                s.push(curr);
                curr = curr.left;
            }

            // Current points to Null, so set current
            // to the topmost element of the stack;
            // pop this element from the stack
            curr = s.pop();

            System.out.print(curr.data + " ");

            // we have visited the node and its
            // left subtree. Now, it's right
            // subtree's turn
            curr = curr.right;
        }
    }

    public static void main(String args[]) {
        // Creating a binary tree and entering
        // the nodes
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}


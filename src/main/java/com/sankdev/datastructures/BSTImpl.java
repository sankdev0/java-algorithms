package com.sankdev.datastructures;

class BSTImpl {
  //node class that defines BST node
  class Node {
    int key;
    Node left, right;

    public Node(int data){
      key = data;
      left = right = null;
    }
  }
  // BST root node
  Node root;

  // Constructor for BST =>initial empty tree
  BSTImpl(){
    root = null;
  }
  //delete a node from BST
  void deleteKey(int key) {
    root = delete_Recursive(root, key);
  }

  //recursive delete function
  Node delete_Recursive(Node root, int key)  {
    //tree is empty
    if (root == null)  return null;

    //traverse the tree
    if (key < root.key)     //traverse left subtree
      root.left = delete_Recursive(root.left, key);
    else if (key > root.key)  //traverse right subtree
      root.right = delete_Recursive(root.right, key);
    else  {
      // node contains only one child
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      // node has two children;
      //get inorder successor (min value in the right subtree)
      root.key = minValue(root.right);

      // Delete the inorder successor
      root.right = delete_Recursive(root.right, root.key);
    }
    return root;
  }

  int minValue(Node root)  {
    //initially minval = root
    int minval = root.key;
    //find minval
    while (root.left != null)  {
      minval = root.left.key;
      root = root.left;
    }
    return minval;
  }

  // insert a node in BST
  void insert(int key)  {
    root = insert_Recursive(root, key);
  }

  //recursive insert function
  Node insert_Recursive(Node root, int key) {
    //tree is empty
    if (root == null) {
      root = new Node(key);
      return root;
    }
    //traverse the tree
    if (key < root.key)     //insert in the left subtree
      root.left = insert_Recursive(root.left, key);
    else if (key > root.key)    //insert in the right subtree
      root.right = insert_Recursive(root.right, key);
    // return pointer
    return root;
  }

  // method for inorder traversal of BST
  void inorder() {
    inorder_Recursive(root);
  }

  // recursively traverse the BST
  void inorder_Recursive(Node root) {
    if (root != null) {
      inorder_Recursive(root.left);
      System.out.print(root.key + " ");
      inorder_Recursive(root.right);
    }
  }

  boolean search(int key)  {
    root = search_Recursive(root, key);
    if (root!= null)
      return true;
    else
      return false;
  }

  //recursive insert function
  Node search_Recursive(Node root, int key)  {
    // Base Cases: root is null or key is present at root
    if (root==null || root.key==key)
      return root;
    // val is greater than root's key
    if (root.key > key)
      return search_Recursive(root.left, key);
    // val is less than root's key
    return search_Recursive(root.right, key);
  }

  //PostOrder Traversal - Left:Right:rootNode (LRn)
  void postOrder(Node node)  {
    if (node == null)
      return;

    // first traverse left subtree recursively
    postOrder(node.left);

    // then traverse right subtree recursively
    postOrder(node.right);

    // now process root node
    System.out.print(node.key + " ");
  }
  // InOrder Traversal - Left:rootNode:Right (LnR)
  void inOrder(Node node)  {
    if (node == null)
      return;
    //first traverse left subtree recursively
    inOrder(node.left);

    //then go for root node
    System.out.print(node.key + " ");

    //next traverse right subtree recursively
    inOrder(node.right);
  }

  //PreOrder Traversal - rootNode:Left:Right (nLR)
  void preOrder(Node node)  {
    if (node == null)
      return;

    //first print root node first
    System.out.print(node.key + " ");
    // then traverse left subtree recursively
    preOrder(node.left);
    // next traverse right subtree recursively
    preOrder(node.right);
  }
  // Wrappers for recursive functions
  void postOrder_traversal()  {
    postOrder(root);  }
  void inOrder_traversal() {
    inOrder(root);   }
  void preOrder_traversal() {
    preOrder(root);  }
}
class Main{
  public static void main(String[] args)  {
    //create a BST object
    BSTImpl bst = new BSTImpl();
        /* BST tree example
              45
           /     \
          10      90
         /  \    /
        7   12  50   */
    //insert data into BST
    bst.insert(45);
    bst.insert(10);
    bst.insert(7);
    bst.insert(12);
    bst.insert(90);
    bst.insert(50);
    //print the BST
    System.out.println("The BST Created with input data(Left-root-right):");
    bst.inorder();

    //delete leaf node
    System.out.println("\nThe BST after Delete 12(leaf node):");
    bst.deleteKey(12);
    bst.inorder();
    //delete the node with one child
    System.out.println("\nThe BST after Delete 90 (node with 1 child):");
    bst.deleteKey(90);
    bst.inorder();

    //delete node with two children
    System.out.println("\nThe BST after Delete 45 (Node with two children):");
    bst.deleteKey(45);
    bst.inorder();
    //search a key in the BST
    boolean ret_val = bst.search (50);
    System.out.println("\nKey 50 found in BST:" + ret_val );
    ret_val = bst.search (12);
    System.out.println("\nKey 12 found in BST:" + ret_val );
    System.out.println();
    //PreOrder Traversal
    System.out.println("BST => PreOrder Traversal:");
    bst.preOrder_traversal();
    //InOrder Traversal
    System.out.println("\nBST => InOrder Traversal:");
    bst.inOrder_traversal();
    //PostOrder Traversal
    System.out.println("\nBST => PostOrder Traversal:");
    bst.postOrder_traversal();
  }
}

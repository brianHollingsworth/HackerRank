/**
 * You are given a pointer to the root of a binary tree. Print the top view of
 * the binary tree. You only have to complete the function.
 * For example:
 *
 *      3
 *    /   \
 *   5     2
 *  / \   / \
 * 1   4 6   7
 *  \       /
 *   9     8
 * Top View : 1 -> 5 -> 3 -> 2 -> 7
 * Input Format
 *
 * You are given a function,
 *
 * void top_view(node * root) {
 *
 * }
 * Output Format: Print the values on a single line separated by space.
 *
 * Sample Input
 *
 *      3
 *    /   \
 *   5     2
 *  / \   / \
 * 1   4 6   7
 *  \       /
 *   9     8
 * Sample Output
 *
 * 1 5 3 2 7
 */

/*
   struct node
   {
   int data;
   node* left;
   node* right;
   };

 */
#include <iostream>
using namespace std;

// Helper function for traversing left and printing the node data.
void Left(node *n) {
  // We first want to move as left as we can.
  if (n->left != NULL) {
    Left(n->left);
  }
  // Then, we want to start printing the nodes and work our way back.
  cout << n->data << " ";
}

// Helper function for printing the node data and traversing right.
void Right(node *n) {
  // We first want to print the node data since we won't be traversing backward.
  cout << n->data << " ";
  // After we print the node data, we will traverse to the next right node.
  if (n->right != NULL) {
    Right(n->right);
  }
}

// It's not the function naming style denoted in the Google C++ Style Guide, but
// we get "error: ‘top_view’ was not declared in this scope top_view(root);"
void top_view(node *root) {

  // 1.) Check if the current node is empty (i.e. null).
  if (root == NULL) {
    return;
  }

  // 2.) Since the top view of the tree is read left to right, we want to find
  //     the leftmost node and work back to the root.
  if (root->left != NULL) {
    Left(root->left);
  }

  // 3.) Print the root.
  cout << root->data << " ";

  // 4.) Now, we want to work our way to the right.
  if (root->right != NULL) {
    Right(root->right);
  }
}

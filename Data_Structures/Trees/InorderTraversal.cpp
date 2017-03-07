/**
 * Complete the inOrder function in your editor below, which has one parameter:
 * a pointer to the root of a binary tree. It must print the values in the
 * tree's inorder traversal as a single line of space-separated values.
 *
 * Input: Our hidden tester code passes the root node of a binary tree to your
 *        inOrder function.
 *
 * Output: Print the tree's inorder traversal as a single line of
 *         space-separated values.
 */

 /* you only have to complete the function given below.
Node is defined as

struct node
{
    int data;
    node* left;
    node* right;
};

*/
#include <iostream>
using namespace std;

void inOrder(node *root) {

   // 1.) Check if the current node is empty (i.e. null).
   if (root == NULL) {
      return;
   }

   // 2.) Traverse left subtree by recursively calling the inorder function.
   inOrder(root->left);

   // 3.) Display the data part of the root (or current node).
   cout << root->data << " ";

   // 4.) Traverse right subtree by recursively calling the inorder function.
   inOrder(root->right);
}

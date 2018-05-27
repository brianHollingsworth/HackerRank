/**
 * EvenTree.cpp
 *
 * You are given a tree (a simple connected graph with no cycles).
 * Find the maximum number of edges you can remove from the tree to get a forest
 * such that each connected component of the forest contains an even number of
 * nodes.
 *
 * Input Format: The first line of input contains two integers n and m, the
 *               number of nodes and edges. The next m lines contain two
 *               integers u(i) and v(i) which specify nodes connected by an edge
 *               of the tree. The root of the tree is node.
 *
 * Output Format: Print the number of removed edges.
 *
 * > 10 9
 * > 2 1
 * > 3 1
 * > 4 3
 * > 5 2
 * > 6 1
 * > 7 2
 * > 8 6
 * > 9 8
 * > 10 8
 *           1
 *         / | \
 *        /  |  \
 *       3   6   2
 *      /    |  / \
 *     4     8 7   5
 *          / \
 *         9  10
 */
#include <iostream>
#include <vector>

using namespace std;

struct node {
  int parent;
  int number_of_children = 0;
};

int main() {
  int n, m, u, v, removed_edges = 0;

  cin >> n >> m;

  vector<node> tree(n);

  // We want to keep track of the number of children each node has, because
  // nodes with an odd number of children are nodes that can be removed from
  // their parent to create an even forest. In the example above, nodes 3 and 6
  // have an odd number of children; thus, removing their edge to the root will
  // create forests of 2 and 4, respectively.
  for (int i = 0; i < m; i++) {
    cin >> u >> v;
    tree[u].parent = v;
    tree[v].number_of_children++;
  }

  // We're going to iterate from the leaf nodes to the root's children and use
  // the approach in the comments above. Every time we come across a node with
  // a single child, we will effectively "remove its edge" by simply
  // decrementing the number of children its parent has.
  for (int i = n; i > 1; i--) {
    if (tree[i].number_of_children % 2 != 0) {
      tree[tree[i].parent].number_of_children--;
      removed_edges++;
    }
  }

  cout << removed_edges;

  return 0;
}

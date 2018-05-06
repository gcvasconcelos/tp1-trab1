/**
 * @author gcvasconcelos
 * 
 * Data structure that is made of nodes. Each node has a value and 2 children, forming a kind of tree. 
 * The tree construction follow the rule: the left child is always smaller or equal to its parent and the right child is always bigger.
 */

abstract class BinaryTree[A <% Ordered[A]] {
  def insert(value: A): Unit // creates a node with value and insert node in the tree, following the binary tree rule
  def remove(value: A): Unit // remove the node from tree and keeps the binary tree rule true
  def find(value: A): Boolean // if value exists in tree, returns true
  def height(node: TreeNode[A]): Int // calculates the height of the tree, how deep is the tree
}
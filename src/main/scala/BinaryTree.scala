/**
 * 
 *
 * @author 
 */

trait BinaryTree {
    def insert(value: Int): Unit
    def remove(value: Int): Unit
    def find(value: Int): TreeNode
    def print(): Unit
}
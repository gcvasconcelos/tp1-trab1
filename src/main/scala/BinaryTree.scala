/**
 * 
 *
 * @author 
 */

abstract class BinaryTree[A <% Ordered[A]] {
    def insert(value: A): Unit
    def remove(value: A): Unit
    def find(value: A): Boolean
    def print(): Unit
}
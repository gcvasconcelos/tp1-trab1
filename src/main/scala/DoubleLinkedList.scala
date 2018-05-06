/**
 * 
 *
 * @author 
 */

trait DoubleLinkedList[A] {
    def size(): Int 
    def head(): A
    def insert(value: A, pos: Int): Unit
    def remove(pos: Int): Unit
    def print(): Unit
    def find(pos: Int): Node[A]
}	
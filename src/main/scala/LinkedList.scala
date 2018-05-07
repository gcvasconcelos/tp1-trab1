/**
 * @author gcvasconcelos
 * 
 * Mutable data structure that consist in nodes, witch each one contains a value and reference to the next node.
 */

trait LinkedList[A] {
  def size(): Int // returns the current size of the list
  def head(): A // returns the value of the first node
  def find(pos: Int): Node[A] // finds node by its position
  def insert(value: A, pos: Int): Unit // insert a node at a available position
  def remove(pos: Int): Unit // removes a node and link its next to its parent, to keep the list linked
  def print(): Unit // prints entire list
}
/**
 * @author gcvasconcelos
 * 
 * Data structure that you can only insert or delete itens in the top of the stack. 
 * Is considered LIFO (Last In First Out).
 */

trait Stack[A] {
  def size(): Int // returns current size of stack
  def print(): Unit // print elements of the stack
  def push(value: A): Unit // inserts elements on top of the stack
  def pop(): Unit // removes elements on the top of the stack
  def top(): A // returns element that is in the top
}
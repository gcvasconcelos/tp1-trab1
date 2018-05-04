/**
 * 
 *
 * @author gcvasconcelos
 */

trait Stack[A] {
    def size(): Int
    def print(): Unit
    def push(value: A): Unit 
    def pop(): Unit
    def top(): A
}
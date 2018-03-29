/**
 * 
 *
 * @author gcvasconcelos
 */

trait Stack {
    def size(): Int
    def print(): Unit
    def push(value: Int): Unit 
    def pop(): Unit
    def top(): Int
}
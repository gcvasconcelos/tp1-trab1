/**
 * 
 *
 * @author gcvasconcelos
 */

trait LinkedList {
    def size(): Int 
    def head(): Int
    def insert(value: Int, pos: Int): Unit
    def remove(pos: Int): Unit
    def print(): Unit
    def find(pos: Int): Node
}
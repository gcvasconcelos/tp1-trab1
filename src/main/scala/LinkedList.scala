/**
 * 
 *
 * @author gcvasconcelos
 */

trait LinkedList {
    def size(): Int    
    def insert(value: Int, pos: Int): Unit
    def remove(pos: Int): Int
    def print(): Unit
    def find(pos: Int): Node
}
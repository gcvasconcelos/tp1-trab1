/**
 * 
 *
 * @author gcvasconcelos
 */

trait LinkedList {
    def size(): Int    
    def insert(value: Int, pos: Int): Unit
    def remove(pos: Int): Int
    def findByValue(value: Int): Int
    def findByPosition(pos: Int): Int
}
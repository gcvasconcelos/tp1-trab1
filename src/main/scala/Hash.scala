/**
 * 
 *
 * @author gcvasconcelos
 */

trait Hash[A] {
    def size(): Int 
    def insert(key: Int, value: A): Unit
    def find(key: Int): A 
}
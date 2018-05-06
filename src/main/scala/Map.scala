/**
 * 
 *
 * @author gcvasconcelos
 */

trait Map[A,B] {
    def size(): Int
    def keys(): Array[A] 
    def values(): Array[B] 
    def find(key: A): MapNode[A,B] 
    def insert(key: A, value: B): Unit 
    def remove(key: A): MapNode[A,B] 
}
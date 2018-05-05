/**
 * 
 *
 * @author gcvasconcelos
 */

trait Heap[A] {
    def insert(value: A): Unit
    def delete(index: Int): Unit
    // def getMinValue(): A
}
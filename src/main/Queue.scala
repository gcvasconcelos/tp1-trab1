/**
 * 
 *
 * @author gcvasconcelos
 */

trait Queue {
    def size(): Int    
    def enqueue(value: Int): Unit // returns void
    def dequeue(): Int
}
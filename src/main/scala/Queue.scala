/**
 * @author carlossilvaa
 */

trait Queue[A] {
    def size(): Int    
    def enqueue(value: A): Unit // returns void
    def dequeue(): A
}
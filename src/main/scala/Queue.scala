/**
 * @author carlossilvaa
 *
 * class description
 */

trait Queue[A] {
    def size(): Int //
    def enqueue(value: A): Unit //
    def dequeue(): A //
}
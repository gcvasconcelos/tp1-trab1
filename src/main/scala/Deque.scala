/**
 * @author carlossilvaa
 *
 * a deque (double ended queue) is a type of queue to which we can access both extremities
 */

trait Deque[A] {
    def size(): Int    
    def push(value: A): Unit // insert element at back
    def unshift(value: A): Unit // insert element upfront
    def pop(): Unit // remove last element
	def shift(): Unit // remove first element
	def last(): A // examine last element
	def first(): A //examine first element
}
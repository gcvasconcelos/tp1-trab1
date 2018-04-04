/**
 * @author carlossilvaa
 *
 * a deque (double ended queue) is a type of queue to which we can access both extremities
 */

trait Deque {
    def size(): Int    
    def push(value: Int): Unit // insert element at back
    def unshift(value: Int): Unit // insert element upfront
    def pop(): Int // remove last element
	def shift(): Int // remove first element
	def last(): Int // examine last element
	def first(): Int //examine first element
}
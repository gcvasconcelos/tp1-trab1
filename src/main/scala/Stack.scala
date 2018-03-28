/**
 * 
 *
 * @author gcvasconcelos
 */

trait Stack {
    def size(): Int    
    def push(value: Int): Unit // returns void
    def pop(): Int
    def top(): Int
}
/**
 * 
 *
 * @author gcvasconcelos
 */

trait Set[A] {
    def size(): Int
    def elements(): Array[Option[A]] 
    def insert(value: Option[A]): Unit
    def remove(index: Int): Option[A] 
    def union(otherSet: SetImplementation[A]): SetImplementation[A]
    def intersection(otherSet: SetImplementation[A]): SetImplementation[A] 
    def difference(otherSet: SetImplementation[A]): SetImplementation[A]
}
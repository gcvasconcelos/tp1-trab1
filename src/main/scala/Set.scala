/**
 * @author gcvasconcelos
 * 
 * Stores values with no particular order, but with no duplicates
 */

trait Set[A] {
  def size(): Int // returns set immutable size
  def elements(): Array[Option[A]] // returns an array with all elements
  def insert(value: Option[A]): Unit // inserts a value in set, with no duplicates
  def remove(index: Int): Option[A] // returns the removed value, by its index
  def union(otherSet: SetImplementation[A]): SetImplementation[A] // performs de union between two sets and returns the result
  def intersection(otherSet: SetImplementation[A]): SetImplementation[A] // performs de intersection between two sets and returns the result
  def difference(otherSet: SetImplementation[A]): SetImplementation[A] // performs de difference between two sets and returns the result
}
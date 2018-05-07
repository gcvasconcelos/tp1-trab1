/**
 * @author gcvasconcelos
 * 
 * Data structure formed by key-value pair, with unique keys.
 */

trait Map[A,B] {
  def size(): Int // returns the immutable size of the map
  def keys(): Array[A]  // returns array of all keys of the map
  def values(): Array[B] // returns array of all values of the map 
  def find(key: A): MapNode[A,B] // gets a key-value pair by its key
  def insert(key: A, value: B): Unit // pushes a key-value pair on map
  def remove(key: A): MapNode[A,B] // removes and return a key-value pair by its key
  def updateValue(key: A, value: B): Unit // updates a value of a key-value pair
}
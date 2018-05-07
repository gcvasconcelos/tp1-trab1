/**
 * @author gcvasconcelos
 * 
 *  Consists in key-value pairs organized in a table. The postition in the table is defined by a hash function applied in the key.
 *  The method chosen to avoid collisions, that is two hash keys pointing to the same table position, is a simple linear probing.
 */

trait Hash[A] {
  def size(): Int // returns the immutable size of the hashing table
  def insert(key: Int, value: A): Unit // inserts key,value pair in caculated hash key adress
  def find(key: Int): A // gets a value in the table by its key
}
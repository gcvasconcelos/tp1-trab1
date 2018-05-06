/**
 * 
 *
 * @author gcvasconcelos
 */

trait Sorting[A] {
  def bubbleSort(array: Array[A]): Array[A]
  def insertionSort(array: Array[A]): Array[A]
  def selectionSort(array: Array[A]): Array[A]
}
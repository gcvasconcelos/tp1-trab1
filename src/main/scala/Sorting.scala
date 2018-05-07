/**
 * @author gcvasconcelos
 * 
 * Group of sort methods given an Array
 */

trait Sorting[A] {
  def bubbleSort(array: Array[A]): Array[A] // performs bubble sort and returns ordered array
  def insertionSort(array: Array[A]): Array[A] // performs insertion sort and returns ordered array
  def selectionSort(array: Array[A]): Array[A] // performs selection sort and returns ordered array
}
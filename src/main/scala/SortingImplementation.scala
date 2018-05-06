class SortingImplementation[A <% Ordered[A]] extends Sorting[A]{
  def bubbleSort(array: Array[A]): Array[A] = {
    var swaped: Boolean = false

    for (i <- 0 until array.length-1) {
      if (array(i+1) < array(i)) {
        var temp: A = array(i)
        array(i) = array(i+1)
        array(i+1) = temp
        swaped = true
      }
    }
    if (!swaped) {
      array
    }
    else {
      bubbleSort(array)
    }
  }

  def insertionSort(array: Array[A]): Array[A] = {
    for (i <- 1 until array.length) {
      var aux: A = array(i)
      var j: Int = i

      while (j > 0 && array(j-1) > aux) {
        array(j) = array(j-1)
        j = j -1
      }
      array(j) = aux
    }
    array
  }

  def selectionSort(array: Array[A]): Array[A] = {
    for (i <- 0 until array.length-1) {
      var minIndex: Int = i 
      for (j <- i+1 until array.length) {
        if (array(j) < array(minIndex)) {
          minIndex = j
        }
      }
      if (minIndex != i) {
        var temp: A = array(i)
        array(i) = array(minIndex)
        array(minIndex) = temp
      }
    }
    array
  }
}
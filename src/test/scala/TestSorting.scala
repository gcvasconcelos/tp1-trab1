import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestSorting extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Sorting"

  var sort: SortingImplementation[Int] = _
  var array: Array[Int] = _
	
	before {
		sort = new SortingImplementation[Int]
    array = Array(5,3,1,2,4)
	}

  it should "use bubble sort to sort an array" in {
    sort.bubbleSort(array) should be (Array(1,2,3,4,5))
	}
  it should "use insertion sort to sort an array" in {
    sort.insertionSort(array) should be (Array(1,2,3,4,5))
	}
  it should "use selection sort to sort an array" in {
    sort.selectionSort(array) should be (Array(1,2,3,4,5))
	}
}
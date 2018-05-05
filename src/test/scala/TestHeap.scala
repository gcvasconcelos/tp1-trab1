import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestHeap extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

	behavior of "A Heap"

	var heap: HeapImplementation[Int] = _
	
	before {
		heap = new HeapImplementation[Int]
	}

	it should "have size == 0 before any insertion" in {
		heap.size should be (0)
	}

	it should "have size increased by 1 after any insertion" in {
		heap.insert(111)
		
		heap.size should be (1)

		heap.insert(222)
		heap.insert(333)

		heap.size should be (3)
	}
}
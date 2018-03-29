import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestLinkedList extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

	behavior of "A LinkedList"

	var list: LinkedListImplementation = _
	
	before {
		list = new LinkedListImplementation
	}

	it should "have size == 0 before any insertion" in {
		list.size should be (0)
	}

	it should "have size increased by 1 after any insertion" in {
		list.insert(111 , 0)
		
		list.size should be (1)

		list.insert(222 , 1)
		list.insert(333 , 2)

		list.size should be (3)
	}

	it should "keep track of the inserted values by their postion number" in {
		list.insert(111 , 0)
		list.insert(222 , 1)
		list.insert(333 , 2)

		list.find(1).value should be (222)
	}

	it should "insert values in between previous inserted values" in {
		list.insert(111 , 0)
		list.insert(222 , 1)
		list.insert(333 , 1)

		list.find(2).value should be (222)
	}

	it should "throw InvalidArgument if an position lower than 0 and higher than the size is inserted" in {
		a [InvalidArgument] should be thrownBy {
			list.insert(111 , -1)
			list.remove(10)
    	} 
	}

	it should "change head when a value is inserted in first position" in {
		list.insert(111 , 0)
		list.insert(222 , 0)

		list.head should be (222)
	}
	
	it should "have size decreased by 1 after any deletion" in {
		list.insert(111 , 0)
		list.insert(222 , 1)
		list.insert(333 , 2)
		list.remove(1)

		list.size should be (2)
	}

	it should "change head when the value in the first position is removed" in {
		list.insert(111 , 0)
		list.insert(222 , 1)
		list.remove(0)

		list.head should be (222)
	}

	it should "keep track of the list after two sucessive deletions" in {
		list.insert(111 , 0)
		list.insert(222 , 1)
		list.insert(333 , 2)
		list.insert(444 , 3)
		list.remove(0)
		list.remove(0)

		list.print

		list.find(0).value should be (333)
		list.find(1).value should be (444)
	}
}

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestDoubleLinkedList extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

    behavior of "A DoubleLinkedList"

    var dll: DoubleLinkedListImplementation[Int] = _
    
    before {
        dll = new DoubleLinkedListImplementation[Int]
    }

    it should "have size == 0 before any insertion" in {
        dll.size should be (0)
    }

    it should "have size increased by 1 after any insertion" in {
        dll.add(111 , 0)
        
        dll.size should be (1)

        dll.add(222 , 1)
        dll.add(333 , 2)

        dll.size should be (3)
    }

    it should "keep track of the inserted values by their postion number" in {
        dll.add(111 , 0)
        dll.add(222 , 1)
        dll.add(333 , 2)

        dll.search(1).value should be (222)
    }

    it should "insert values in between previous inserted values" in {
        dll.add(111 , 0)
        dll.add(222 , 1)
        dll.add(333 , 1)

        dll.search(2).value should be (222)
    }

    it should "throw InvalidArgument if an position lower than 0 and higher than the size is inserted" in {
        a [InvalidArgument] should be thrownBy {
            dll.add(111 , -1)
            dll.delete(10)
        } 
    }

    it should "change head when a value is inserted in first position" in {
        dll.add(111 , 0)
        dll.add(222 , 0)

        dll.head should be (222)
    }
    
    it should "have size decreased by 1 after any deletion" in {
        dll.add(111 , 0)
        dll.add(222 , 1)
        dll.add(333 , 2)
        dll.delete(1)

        dll.size should be (2)
    }

    it should "change head when the value in the first position is removed" in {
        dll.add(111 , 0)
        dll.add(222 , 1)
        dll.delete(0)

        dll.head should be (222)
    }

    it should "keep track of the list after two sucessive deletions" in {
        dll.add(111 , 0)
        dll.add(222 , 1)
        dll.add(333 , 2)
        dll.add(444 , 3)
        dll.delete(0)
        dll.delete(0)

        dll.search(0).value should be (333)
        dll.search(1).value should be (444)
    }
}

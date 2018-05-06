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
        dll.insert(111 , 0)
        
        dll.size should be (1)

        dll.insert(222 , 1)
        dll.insert(333 , 2)

        dll.size should be (3)
    }

    it should "keep track of the inserted values by their postion number" in {
        dll.insert(111 , 0)
        dll.insert(222 , 1)
        dll.insert(333 , 2)

        dll.find(1).value should be (222)
    }

    it should "insert values in between previous inserted values" in {
        dll.insert(111 , 0)
        dll.insert(222 , 1)
        dll.insert(333 , 1)

        dll.find(2).value should be (222)
    }

    it should "throw InvalidArgument if an position lower than 0 and higher than the size is inserted" in {
        a [InvalidArgument] should be thrownBy {
            dll.insert(111 , -1)
            dll.remove(10)
        } 
    }

    it should "change head when a value is inserted in first position" in {
        dll.insert(111 , 0)
        dll.insert(222 , 0)

        dll.head should be (222)
    }
    
    it should "have size decreased by 1 after any deletion" in {
        dll.insert(111 , 0)
        dll.insert(222 , 1)
        dll.insert(333 , 2)
        dll.remove(1)

        dll.size should be (2)
    }

    it should "change head when the value in the first position is removed" in {
        dll.insert(111 , 0)
        dll.insert(222 , 1)
        dll.remove(0)

        dll.head should be (222)
    }

    it should "keep track of the list after two sucessive deletions" in {
        dll.insert(111 , 0)
        dll.insert(222 , 1)
        dll.insert(333 , 2)
        dll.insert(444 , 3)
        dll.remove(0)
        dll.remove(0)

        dll.find(0).value should be (333)
        dll.find(1).value should be (444)
    }
}

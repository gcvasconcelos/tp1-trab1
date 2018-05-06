import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestCircularLinkedList extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

    behavior of "A CircularLinkedList"

    var cll: CircularLinkedListImplementation[Int] = _
    
    before {
        cll = new CircularLinkedListImplementation[Int]
    }

    it should "have size == 0 before any insertion" in {
        cll.size should be (0)
    }

    it should "have size increased by 1 after any insertion" in {
        cll.insert(111 , 0)
        
        cll.size should be (1)

        cll.insert(222 , 1)
        cll.insert(333 , 2)

        cll.size should be (3)
    }

    it should "keep track of the inserted values by their postion number" in {
        cll.insert(111 , 0)
        cll.insert(222 , 1)
        cll.insert(333 , 2)

        cll.find(1).value should be (222)
    }

    it should "insert values in between previous inserted values" in {
        cll.insert(111 , 0)
        cll.insert(222 , 1)
        cll.insert(333 , 1)

        cll.find(2).value should be (222)
    }

    it should "throw InvalidArgument if an position lower than 0 and higher than the size is inserted" in {
        a [InvalidArgument] should be thrownBy {
            cll.insert(111 , -1)
            cll.remove(10)
        } 
    }

    it should "change head when a value is inserted in first position" in {
        cll.insert(111 , 0)
        cll.insert(222 , 0)

        cll.head should be (222)
    }
    
    it should "have size decreased by 1 after any deletion" in {
        cll.insert(111 , 0)
        cll.insert(222 , 1)
        cll.insert(333 , 2)
        cll.remove(1)

        cll.size should be (2)
    }

    it should "change head when the value in the first position is removed" in {
        cll.insert(111 , 0)
        cll.insert(222 , 1)
        cll.remove(0)

        cll.head should be (222)
    }

    it should "keep track of the list after two sucessive deletions" in {
        cll.insert(111 , 0)
        cll.insert(222 , 1)
        cll.insert(333 , 2)
        cll.insert(444 , 3)
        cll.remove(0)
        cll.remove(0)

        cll.find(0).value should be (333)
        cll.find(1).value should be (444)
    }
}

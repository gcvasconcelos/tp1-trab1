import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestDeque extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Deque"

  var deque: DequeImplementation[Int] = _
	
	before {
		deque = new DequeImplementation[Int]
	}

  it should "have size == 0 before any insertion" in {
		deque.size should be (0)
	}

	it should "have size increased by 1 after any insertion" in {
    deque.push(3)

		deque.size should be (1)

    deque.push(5)
    deque.push(7)

		deque.size should be (3)
  }

	it should "have size decreased by 1 after any deletion" in {
    deque.push(3)
    deque.push(5)
    deque.push(7)
    deque.push(11)
    deque.pop

		deque.size should be (3)

    deque.pop
    deque.pop

		deque.size should be (1)
  }

  it should "throw InvalidMethod if pop() is called in an empty queue " in {
		a [InvalidMethod] should be thrownBy {
      deque.pop	
    } 
	}

  it should "return first element when shift() is called" in {
    deque.push(3)
    deque.push(5)
    deque.push(7)

    deque.first should be (3)

    deque.shift

    deque.first should be (5)

    deque.unshift(11)
    
    deque.first should be (11) 

    deque.shift
    deque.shift

    deque.first should be (7)
  }
}
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestQueue extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Queue"

  var queue: QueueImplementation = _
	
	before {
		queue = new QueueImplementation
	}

    it should "have size == 0 before any insertion" in {
		queue.size should be (0)
	}

	it should "have size increased by 1 after any insertion" in {
        queue.enqueue(3)

		queue.size should be (1)

        queue.enqueue(5)
        queue.enqueue(7)

		queue.size should be (3)
    }

	it should "have size decreased by 1 after any deletion" in {
        queue.enqueue(3)
        queue.enqueue(5)
        queue.enqueue(7)
        queue.enqueue(11)
        queue.dequeue

		queue.size should be (3)

        queue.dequeue
        queue.dequeue

		queue.size should be (1)
    }

    it should "throw InvalidMethod if dequeue() is called in an empty queue " in {
		a [InvalidMethod] should be thrownBy {
            queue.dequeue	
    	} 
	}

    it should "return first element when dequeue() is called" in {
        queue.enqueue(3)
        queue.enqueue(5)
        queue.enqueue(7)

        queue.dequeue should be (3)

        queue.dequeue should be (5)

        queue.enqueue(11)
        
        queue.dequeue should be (7) 

        queue.dequeue should be (11)

    }
}
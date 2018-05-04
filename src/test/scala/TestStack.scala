import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestStack extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Stack"

  var stack: StackImplementation[Int] = _
	
	before {
		stack = new StackImplementation[Int]
	}

    it should "have size == 0 before any insertion" in {
		stack.size should be (0)
	}

	it should "have size increased by 1 after any insertion" in {
        stack.push(111)

		stack.size should be (1)

        stack.push(222)
        stack.push(333)

		stack.size should be (3)
    }

	it should "have size decreased by 1 after any deletion" in {
        stack.push(111)
        stack.push(222)
        stack.push(333)
        stack.push(444)
        stack.pop

		stack.size should be (3)

        stack.pop
        stack.pop

		stack.size should be (1)
    }

    it should "throw InvalidMethod if pop() is called in an empty stack " in {
		a [InvalidMethod] should be thrownBy {
            stack.pop	
    	} 
	}

    it should "return the last element when top() is called" in {
        stack.push(111)
        stack.push(222)
        stack.push(333)

        stack.top should be (333)

        stack.push(444)

        stack.top should be (444)
    }
}

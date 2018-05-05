import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestHash extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter{

	behavior of "A Hash"

	var table: HashImplementation[Int] = _
	
	before {
		table = new HashImplementation[Int]
	}

	it should "have immutable size" in {
		table.size should be (64)
	}

    it should "insert a node with key-value pair and keep size unchaged" in {
		table.insert(1, 111)

		table.size should be (64)
	}

	it should "find an element by its key" in {
		table.insert(1, 111)
		table.insert(2, 222)
		table.insert(3, 333)

        table.find(2) should be (222)
	}

	it should "solve hash key conflicts with linear probing" in {
		table.insert(1, 111)
		table.insert(101, 222)

        table.find(1) should be (111)
        table.find(101) should be (222)
	}

    it should "throw InvalidArgument when key was not found" in {
		a [InvalidArgument] should be thrownBy {
			table.insert(1, 111)
		    table.insert(2, 222)
		    table.find(3)
    	} 
	}
}

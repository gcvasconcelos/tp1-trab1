import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestSet extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Set"

  var set: SetImplementation[Int] = _
	
	before {
		set = new SetImplementation[Int](3)
	}

    it should "have immutable size" in {
		set.size should be (3)
	}

    it should "insert elements without duplicates" in {
		set.insert(Some(111))
		set.insert(Some(222))

        set.elements should be (Array(Some(111),Some(222),null))
	}

    it should "throw an error when set is full" in {
		a [InvalidArgument] should be thrownBy {
			set.insert(Some(111))
		    set.insert(Some(222))
		    set.insert(Some(333))
		    set.insert(Some(444))
    	} 
	}
   
    it should "remove itens by their index" in {
		set.insert(Some(111))
        set.insert(Some(222))
        set.insert(Some(333))
        set.remove(1)

        set.elements should be (Array(Some(111),null,Some(333)))
	}
    it should "throw an error when index of removed item is higher than its size" in {
		a [InvalidArgument] should be thrownBy {
			set.remove(3)
    	} 
	}

     it should "return the set with the union of two different sets" in {
        var otherSet = new SetImplementation[Int](2)
		set.insert(Some(111))
		set.insert(Some(222))
		set.insert(Some(333))

        otherSet.insert(Some(444))
        otherSet.insert(Some(555))

        set.union(otherSet).elements should be (Array(Some(111),Some(222),Some(333),Some(444),Some(555)))
	}

    it should "return the set with the intersection of two different sets" in {
        var otherSet = new SetImplementation[Int](2)
		set.insert(Some(111))
		set.insert(Some(222))
		set.insert(Some(333))

        otherSet.insert(Some(111))
        otherSet.insert(Some(333))

        set.intersection(otherSet).elements should be (Array(Some(111),Some(333),null))
	}

    it should "return the set with the difference of two different sets" in {
        var otherSet = new SetImplementation[Int](2)
		set.insert(Some(111))
		set.insert(Some(222))
		set.insert(Some(333))

        otherSet.insert(Some(111))
        otherSet.insert(Some(444))

        set.difference(otherSet).elements should be (Array(Some(222),Some(333)))
	}
}
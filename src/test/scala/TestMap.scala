import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestMap extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {
	
    behavior of "A Map"

    var map: MapImplementation[String, Int] = _
	
	before {
		map = new MapImplementation[String, Int](3)
	}

	it should "have immutable size" in {
		map.size should be (3)
	}

    it should "find element by its key" in {
		map.insert("a", 111)
		map.insert("b", 222)
		map.insert("c", 333)
		
        map.find("b").value should be (222)
	}

    it should "insert elements with unique key" in {
		map.insert("a", 111)
		map.insert("a", 222)

        map.find("a").value should be (111)
	}

    it should "delete elements by their key" in {
		map.insert("a", 111)
		map.insert("b", 222)
		map.insert("c", 333)

        map.remove("b").value should be (222)
		map.find("b") should be (null)
	}

    it should "return array of values and of keys of the map" in {
		map.insert("a", 111)
		map.insert("b", 222)
		map.insert("c", 333)

        map.keys should be (Array("a", "b", "c"))
        map.values should be (Array(111, 222, 333))
    }

	it should "update value of element accessing it by its key" in {
		map.insert("a", 111)
		map.insert("b", 222)
		map.insert("c", 333)

		map.updateValue("b", 666)
		map.find("b").value should be (666)
	}

}
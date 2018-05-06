import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestGraph extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

    behavior of "A Graph"

    var graph: GraphImplementation[Int] = _

    before {
        graph = new GraphImplementation[Int]
    }

    it should "be able to add nodes" in {

        graph.insert(2,1)
        graph.insert(3,2)
        graph.insert(5,3)
        graph.insert(7,3)
        graph.insert(11,2)
        graph.insert(13,1)
        
    }
    it should "be able to add edges" in {

        graph.addEdge(2,1)
        graph.addEdge(3,2)
        graph.addEdge(5,3)
        graph.addEdge(7,3)
        graph.addEdge(11,2)
        graph.addEdge(13,1)
        
    }
    

}  
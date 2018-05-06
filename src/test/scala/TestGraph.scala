import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestGraph extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

    behavior of "A Graph"

    var graph: br.unb.cic.ed.Graph = _

    before {
        graph = new br.unb.cic.ed.GraphImpl(4)
    }

    it should "be able to add edges" in {

        graph.insert(2,1)
        graph.insert(3,2)
        graph.insert(5,3)
        graph.insert(7,3)
        graph.insert(11,2)
        graph.insert(13,1)
        
    }

}  
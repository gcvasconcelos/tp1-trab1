class GraphImplementation[A] extends Graph[A] {
    case class GraphEdge(val destination: A)
    class GraphVert {
        val edgeList = new LinkedList[GraphEdge]()
    }

    val graph = Array.fill(A)(new GraphVert)

    def addEdge(source: A, destination: A): Unit = {
        val edge = GraphEdge(destination)
        graph(source).edgeList.insert(edge, size)
    }

    def insert(value: A): Unit = {
    	graph.fill(value)(new GraphVert)
    }
    def getNodes(): Array[A] = {
    	graph
    }

}

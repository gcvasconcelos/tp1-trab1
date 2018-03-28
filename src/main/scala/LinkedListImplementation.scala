case class Node(var value: Int, var next: Node)

class LinkedListImplementation extends LinkedList {
    private var _size: Int = 0
    private var head: Node = null

    def size(): Int = _size

    def find(pos: Int): Node = {
        var nodeTemp = head
        for (i <- 0 until pos ) {
            nodeTemp = nodeTemp.next
        }
        nodeTemp
    }

    def insert(value: Int, pos: Int): Unit = {
        var node = Node(value, null)
        if (pos >= 0 && pos <= _size){
            if (_size == 0) { 
                head = node 
            } else {
                var nodeTemp = find(pos-1)
                if (nodeTemp.next != null) {
                    node.next = nodeTemp.next
                }
                nodeTemp.next = node
            }
            _size = _size + 1
        } else {
            throw InvalidArgument()
        }
    }
    
    def remove(pos: Int): Int = {1}
    
    def print(): Unit = {}
}
case class Node(var value: Int, var next: Node)

class LinkedListImplementation extends LinkedList {
    private var _size: Int = 0
    private var _head: Node = null

    def size(): Int = _size
    def head(): Int = _head.value

    def find(pos: Int): Node = {
        var nodeTemp = _head
        if (pos >= 0 && pos <= _size) {
            for (i <- 0 until pos ) {
                nodeTemp = nodeTemp.next
            }
            nodeTemp
        } else {
            throw InvalidArgument()
        }
    }

    def insert(value: Int, pos: Int): Unit = {
        var node = Node(value, null)
        if (pos >= 0 && pos <= _size){
            if (_size == 0) { 
                _head = node 
            } else {
                if (pos == 0){
                    node.next = _head
                    _head = node
                }
                else {
                    var nodeTemp = find(pos-1)
                    if (nodeTemp.next != null) {
                        node.next = nodeTemp.next
                    }
                    nodeTemp.next = node
                }
            }
            _size = _size + 1
        } else {
            throw InvalidArgument()
        }
    }
    
    def remove(pos: Int): Unit = {
        if (pos >= 0 && pos <= _size){
            if (pos == 0) {
                _head = _head.next
            } else {
                var prevNode = find(pos-1)
                prevNode.next = prevNode.next.next
            }
            _size = _size - 1
        } else {
            throw InvalidArgument()
        }
    }
    
    def print(): Unit = {
        var nodeTemp = _head
        println("--------------")
        for (i <- 0 until _size) {
            println(s"${nodeTemp.value}")
            nodeTemp = nodeTemp.next
        }
        println("--------------")
    }
}
class Node[A](val value: A, var next: Node[A])

class LinkedListImplementation[A] extends LinkedList[A] {
    private var _size: Int = 0
    private var _head: Node[A] = _

    def size(): Int = _size
    def head(): A = _head.value

    def find(pos: Int): Node[A] = {
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

    def insert(value: A, pos: Int): Unit = {
        var node = new Node[A](value, null)
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
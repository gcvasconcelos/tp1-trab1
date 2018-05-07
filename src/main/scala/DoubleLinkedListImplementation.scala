class DllNode[A](val value: A, var next: DllNode[A], var prev: DllNode[A])

class DoubleLinkedListImplementation[A] extends LinkedListImplementation[A] {
	
    private var _size: Int = 0
    private var _head: DllNode[A] = _

    override def size(): Int = _size
    override def head(): A = _head.value

    def add(value: A, pos: Int): Unit = {
        var node = new DllNode[A](value, null, null)
        if (pos >= 0 && pos <= _size){
            if (_size == 0) { 
                _head = node 
            } else {
                if (pos == 0){
                    node.next = _head
                    node.next.prev = node
                    _head = node
                }
                else {
                    var prevNode = search(pos-1)
                	var nextNode = search(pos+1)
                    if (prevNode.next != null) {
                    	node.prev = prevNode
                    	prevNode.next = node
                        node.next = nextNode
                        nextNode.prev = node
                    }
                    node.prev = prevNode
                    prevNode.next = node
                }
            }
            _size = _size + 1
        } else {
            throw InvalidArgument()
        }
    }
    
    def delete(pos: Int): Unit = {
        if (pos >= 0 && pos <= _size){
            if (pos == 0) {
            	_head.next.prev = null
                _head = _head.next
            } else {
                var prevNode = search(pos-1)
                var nextNode = search(pos+1)
                prevNode.next = nextNode
            }
            _size = _size - 1
        } else {
            throw InvalidArgument()
        }
    }

    def search(pos: Int): DllNode[A] = {
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
}

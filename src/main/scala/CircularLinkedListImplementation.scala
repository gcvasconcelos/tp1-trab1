class CircularLinkedListImplementation[A] extends LinkedListImplementation[A] {
	class CllNode[A](val value: A, var next: CllNode[A], var prev: CllNode[A])
    private var _elements: LinkedList[A] = new LinkedListImplementation[A]
	
	private var _size: Int = 0
    private var _head: CllNode[A] = _

    override def size(): Int = _size
    override def head(): A = _head.value

    override def insert(value: A, pos: Int): Unit = {
        var node = new CllNode[A](value, null, null)
        if (pos >= 0 && pos <= _size){
            if (_size == 0) { 
                _head = node 
            } else {
                if (pos == 0){
                    node.next = _head
                    node.prev = _head
                    node.next.prev = node
                    node.next.next = node
                    _head = node
                }
                else {
                    var prevNode = find(pos-1)
                	var nextNode = find(pos+1)
                    node.prev = prevNode
                    prevNode.next = node
                    node.next = nextNode
                    nextNode.prev = node
                }
            }
            _size = _size + 1
        } else {
            throw InvalidArgument()
        }
    }
    
    override def remove(pos: Int): Unit = {
        if (pos >= 0 && pos <= _size){
            if (pos == 0) {
            	_head.next.prev = _head.prev
                _head.prev.next = _head.next
                _head = _head.next
            } else {
                var prevNode = find(pos-1)
                var nextNode = find(pos+1)
                prevNode.next = nextNode
                nextNode.prev = prevNode
            }
            _size = _size - 1
        } else {
            throw InvalidArgument()
        }
    }

    override def find(pos: Int): CllNode[A] = {
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

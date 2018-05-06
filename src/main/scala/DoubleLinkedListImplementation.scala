class Node[A](val value: A, var next: Node[A], var prev: Node[A])

class DoubleLinkedListImplementation[A] extends DoubleLinkedList[A] {
	private var _elements: LinkedList[A] = new LinkedListImplementation[A]
	
	def size(): Int = _elements.size
    def print(): Unit = _elements.print

    def insert(value: A, pos: Int): Unit = {
        var node = new Node[A](value, null, null)
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
                    var prevNode = find(pos-1)
                	var nextNode = find(pos+1)
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
    
    def remove(pos: Int): Unit = {
        if (pos >= 0 && pos <= _size){
            if (pos == 0) {
            	_head.next.prev = null
                _head = _head.next
            } else {
                var prevNode = find(pos-1)
                var nextNode = find(pos+1)
                prevNode.next = nextNode
            }
            _size = _size - 1
        } else {
            throw InvalidArgument()
        }
    }
}

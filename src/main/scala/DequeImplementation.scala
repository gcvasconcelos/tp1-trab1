class DequeImplementation extends Deque {
    private var _elements: LinkedList = new LinkedListImplementation 

    def size(): Int = _elements.size

    def push(value: Int): Unit = {
        _elements.insert(value, size)
    }

    def unshift(value: Int): Unit = {
        _elements.insert(value, 0)
    }

    def shift(): Unit = {
        if (size > 0) {
            _elements.remove(0)
        } else {
            throw InvalidMethod()
        }
    }
    
    def pop(): Unit = {
        if (size > 0) {
            _elements.remove(size-1)
        } else {
            throw InvalidMethod()
        }
    }

    def last(): Int = _elements.find(size-1)

    def first(): Int = _elements.find(0)
}
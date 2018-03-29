class StackImplementation extends Stack {
    private var _elements: LinkedList = new LinkedListImplementation 

    def size(): Int = _elements.size
    def print(): Unit = _elements.print

    def push(value: Int): Unit = {
        _elements.insert(value, size)
    }

    def pop(): Unit = {
        if (size > 0) {
		    _elements.remove(size-1)
        } else {
            throw InvalidMethod()
        }
    }

    def top(): Int = {
        _elements.find(size-1).value
    }
}
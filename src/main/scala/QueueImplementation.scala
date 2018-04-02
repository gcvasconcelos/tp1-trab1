class QueueImplementation extends Queue {
    private var _elements: LinkedList = new LinkedListImplementation 

    def size(): Int = _elements.size

    def enqueue(value: Int): Unit = {
        _elements.insert(value, size)
    }

    def dequeue(): Unit = {
        if (size > 0) {
		    _elements.remove(0)
        } else {
            throw InvalidMethod()
        }
    }

}
class QueueImplementation[A] extends Queue[A] {
    private var _elements: LinkedList[A] = new LinkedListImplementation[A]

    def size(): Int = _elements.size

    def enqueue(value: A): Unit = {
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
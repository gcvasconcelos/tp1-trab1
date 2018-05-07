class QueueImplementation[A] extends Queue[A] {
  private var _elements: LinkedList[A] = new LinkedListImplementation[A]
  private var number: A = _
  
  def size(): Int = _elements.size

  def enqueue(value: A): Unit = {
    _elements.insert(value, size)
  }

  def dequeue(): A = {
    if (size > 0) {
      number = _elements.find(0).value
      _elements.remove(0)
    } else {
      throw InvalidMethod()
    }
    number
  }
}
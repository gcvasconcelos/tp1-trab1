class DequeImplementation[A] extends Deque[A] {
  private var _elements: LinkedList[A] = new LinkedListImplementation[A]

  def size(): Int = _elements.size

  def push(value: A): Unit = {
    _elements.insert(value, size)
  }

  def unshift(value: A): Unit = {
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

  def last(): A = _elements.find(size-1).value

  def first(): A = _elements.find(0).value
}
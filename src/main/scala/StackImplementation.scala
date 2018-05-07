class StackImplementation[A] extends Stack[A] {
  private var _elements: LinkedList[A] = new LinkedListImplementation[A]

  def size(): Int = _elements.size

  def print(): Unit = _elements.print

  def push(value: A): Unit = {
    _elements.insert(value, size)
  }

  def pop(): Unit = {
    if (size > 0) {
    _elements.remove(size-1)
    } else {
        throw InvalidMethod()
    }
  }

  def top(): A = {
    _elements.find(size-1).value
  }
}
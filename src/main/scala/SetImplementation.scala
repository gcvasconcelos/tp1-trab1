class SetImplementation[A: Manifest](size: Int) extends Set[A] {
  var setArray = new Array[Option[A]](size)
  for (i <- 0 until size) {
      setArray(i) = null
  }

  def size(): Int = size

  def elements(): Array[Option[A]] = setArray

  def insert(value: Option[A]): Unit = {
    if (setArray(size-1) != null) {
      throw InvalidMethod()
    }
    for (i <- 0 until size) {
      if (value == setArray(i)) {
        return
      }
    }
    var i: Int = 0
    while (setArray(i) != null && i != size-1) {
      i = i + 1
    }
    setArray(i) = value
  }

  def remove(index: Int): Option[A] = {
    if (index >=  size) {
      throw InvalidArgument()
    }
    var value: Option[A] = setArray(index)
    setArray(index) = null
    value
  }

  def union(otherSet: SetImplementation[A]): SetImplementation[A] = {
    var resultSet = new SetImplementation[A](size+otherSet.size)
    var thisSetElements = elements
    var otherSetElements = otherSet.elements

    for (i <- 0 until size) {
      resultSet.insert(thisSetElements(i))
    }
    for (i <- size until resultSet.size) {
      resultSet.insert(otherSetElements(i-size))
    }
    resultSet
  }

  def intersection(otherSet: SetImplementation[A]): SetImplementation[A] = {
    var biggerSize: Int = 0
    if (size > otherSet.size) {
      biggerSize = size
    } else {
      biggerSize = otherSet.size
    }
    var resultSet = new SetImplementation[A](biggerSize)
    var thisSetElements = elements
    var otherSetElements = otherSet.elements

    for (i <- 0 until size) {
      for (j <- 0 until otherSet.size) {
        if (thisSetElements(i) == otherSetElements(j)) {
          resultSet.insert(thisSetElements(i))
        }
      }
    }
    resultSet
  }

  def difference(otherSet: SetImplementation[A]): SetImplementation[A] = {
    var resultSet = new SetImplementation[A](size)
    var thisSetElements = elements
    var otherSetElements = otherSet.elements

    resultSet.setArray = elements.diff(otherSetElements)
    resultSet
  }
}
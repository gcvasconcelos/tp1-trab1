class MapNode[A,B](var key: A = null, var value: B = null)

class MapImplementation[A: Manifest,B: Manifest](size: Int) extends Map[A,B] {
  var mapArray = new Array[MapNode[A,B]](size)

  def size(): Int = size

  def keys(): Array[A] = {
    var keysArray = new Array[A](size)
    for (i <- 0 until size) {
      keysArray(i) = mapArray(i).key
    }
    keysArray
  } 

  def values(): Array[B] = {
    var valuesArray = new Array[B](size)
    for (i <- 0 until size) {
      valuesArray(i) = mapArray(i).value
    }
    valuesArray
  }

  def find(key: A): MapNode[A,B] = {
    var foundElement: MapNode[A,B] = null
    for (i <- 0 until size) {
      if (mapArray(i) != null && mapArray(i).key == key) {
          foundElement = mapArray(i)
      }
    }
    foundElement
  }
  
  def insert(key: A, value: B): Unit = {
    if (mapArray(size-1) != null) {
      throw InvalidArgument()
    }
    if (find(key) != null) {
      return
    }
    var insertedNode = new MapNode(key, value)
    var i: Int = 0
    
    while (mapArray(i) != null && i != size-1) {
      i = i + 1
    }
    mapArray(i) = insertedNode
  }

  def remove(key: A): MapNode[A,B] = {
    var removedElement: MapNode[A,B] = null
    for (i <- 0 until size) {
      if (mapArray(i) != null && mapArray(i).key == key) {
        removedElement = mapArray(i)
        mapArray(i) = null
      }
    }
    removedElement
  }

  def updateValue(key: A, value: B): Unit = {
    for (i <- 0 until size) {
      if (mapArray(i) != null && mapArray(i).key == key) {
        mapArray(i).value = value
      }
    }
  }
}
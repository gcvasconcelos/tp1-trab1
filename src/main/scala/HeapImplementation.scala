import scala.collection.mutable.ListBuffer

class HeapImplementation[A] extends Heap[A] {
    private var heapArray = new ListBuffer[A]()

    def size(): Int = heapArray.size
    def parent(index: Int): Int = (index-1)/2
    def left(index: Int): Int = 2*index + 1
    def right(index: Int): Int = 2*index + 2

    def swap(index_a: Int, index_b: Int): Unit = {
        var temp = heapArray(index_a)
        heapArray.update(index_a, heapArray(index_b))
        heapArray.update(index_b, temp)
    }

    def bubbleUp(index: Int): Unit = {
        if (index != 0) {
            
        }
    }

    def insert(value: A): Unit = {        
        heapArray.append(value)
    }
    // def getMinValue(): A = {
    // }
}
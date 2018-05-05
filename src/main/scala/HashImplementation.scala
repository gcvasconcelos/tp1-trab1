class HashNode[A](val key: Int, var value: A)

class HashImplementation[A] extends Hash[A] {
    private val _size: Int = 64
    val hashTable = new Array[HashNode[A]](size)

    def size(): Int = _size

    def insert(key: Int, value: A): Unit = {
        var hashKey: Int = key % size
        while (hashTable(hashKey) != null && hashTable(hashKey).key != key) {
            hashKey = (hashKey + 1) % size
        }
        hashTable(hashKey) = new HashNode[A](key, value)
    }

    def find(key: Int): A = {
        var hashKey: Int = key % size
        while (hashTable(hashKey) != null && hashTable(hashKey).key != key) {
            hashKey = (hashKey + 1) % size
        }
        if (hashTable(hashKey) == null) {
            throw InvalidArgument("Not found")
        } else {
            hashTable(hashKey).value
        }
    }
}
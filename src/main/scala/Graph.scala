/**
 * 
 *
 * @author 
 */

trait Graph {
    def insert(value: A): Unit
    def addEdge(source: A, destination: A): Unit
    def getNodes(): Array[A]
}
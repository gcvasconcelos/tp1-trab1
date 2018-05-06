/**
 * 
 *
 * @author 
 */

trait Graph {
    def insert(value: A, destination: Int): Unit
    def remove(value: A): Unit
    def print(): Unit
    def getNodes(): Array[A]
    def getEdges(): Array[A]
}
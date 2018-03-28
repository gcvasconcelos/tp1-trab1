/**
 * 
 *
 * @author 
 */

trait Graph {
    def insert(value: Int, destination: Int): Unit
    def remove(value: Int): Unit
    def print(): Unit
    def getNodes(): Array[Int]
    def getEdges(): Array[Int]
}
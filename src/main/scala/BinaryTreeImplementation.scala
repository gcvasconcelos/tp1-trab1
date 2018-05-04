class TreeNode[A <% Ordered[A]](var value: A, var left: TreeNode[A] = null, var right: TreeNode[A] = null)

class BinaryTreeImplementation[A <% Ordered[A]] extends BinaryTree[A] {

    private var _root: TreeNode[A] = _

    def root(): TreeNode[A] = _root

    def height(node: TreeNode[A] = root): Int = {
        if (isEmpty(node)) {
            0
        } else {
            var leftHeight: Int = height(node.left)
            var rightHeight: Int = height(node.right)

            if (leftHeight > rightHeight) {
                leftHeight + 1
            } else {
                rightHeight + 1
            }
        }
    }

    def isEmpty(node: TreeNode[A]): Boolean = {
        if (node == null) {
            true
        } else {
            false
        }
    }

    def insert(value: A): Unit = {
        val newNode = new TreeNode[A](value)

        if (isEmpty(root)) {
            _root = newNode
        } else {
            var currentNode: TreeNode[A] = root
            var nextNode: TreeNode[A] = null
            var loop = true

            while (loop) {
                nextNode = currentNode
                if (value >= currentNode.value) {
                    currentNode = currentNode.right
                    if (isEmpty(currentNode)){
                        nextNode.right = newNode
                        loop = false
                    }
                } else {
                    currentNode = currentNode.left
                    if (isEmpty(currentNode)){
                        nextNode.left = newNode
                        loop = false
                    }
                }            
            }
        }
    }

    def find(value: A): Boolean = {
        var currentNode: TreeNode[A] = root
        var nodeFound: Boolean = false

        while (currentNode != null && nodeFound == false) {
            if (currentNode.value < value) {
                currentNode = currentNode.left
            } else if (currentNode.value > value) {
                currentNode = currentNode.right
            } else {
                nodeFound = true
            }
        }
        nodeFound
    }

    def remove(value: A): Unit = {
        
    }

    def print(): Unit = {}
}
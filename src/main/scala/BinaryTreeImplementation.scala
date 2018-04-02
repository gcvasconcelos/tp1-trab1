class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)

class BinaryTreeImplementation extends BinaryTree {
    private var _root: TreeNode = _

    def root(): TreeNode = _root

    def height(node: TreeNode = root): Int = {
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

    def isEmpty(node: TreeNode): Boolean = {
        if (node == null) {
            true
        } else {
            false
        }
    }

    def insert(value: Int): Unit = {
        val newNode = new TreeNode(value)

        if (isEmpty(root)) {
            _root = newNode
        } else {
            var currentNode: TreeNode = root
            var nextNode: TreeNode = null
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

    def find(value: Int): Boolean = {
        var currentNode: TreeNode = root
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

    def remove(value: Int): Unit = {
        
    }

    def print(): Unit = {}
}
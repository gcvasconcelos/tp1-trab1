class TreeNode[A <% Ordered[A]](var value: A, var left: TreeNode[A] = null, var right: TreeNode[A] = null) {
  def insert(inserted_value: A) {
    if(inserted_value.compareTo(value) <= 0) {
      if(left == null) {
        left = new TreeNode(inserted_value)
      }
      else {
        left.insert(inserted_value)
      }
    }
    else {
      if(right == null) {
        right = new TreeNode(inserted_value)
      }
      else {
        right.insert(inserted_value)
      }
    }
  }

  def find(find_value: A) : Boolean = {
    if(find_value.compareTo(value) == 0) {
      true
    }
    else if ((find_value.compareTo(value) <= 0) && left != null) {
      left.find(find_value)
    }
    else if (right != null) {
      right.find(find_value)
    }
    else {
      false 
    }
  }

  def remove(removed_value: A, parent: TreeNode[A] = null) {
    if(removed_value < value && left != null) {
      left.remove(removed_value, this)
    }
    else if (removed_value > value && right != null) {
      right.remove(removed_value, this)
    }
    else {
      if (left != null && right != null) {
        value = right.minValue()
        right.remove(value, this)
      } else if (parent.left == this) {
        if (left != null) {
          parent.left = left
        } else {
          parent.left = right
        }
      } else if (parent.right == this) {
        if(left != null) {
          parent.right = left
        } else {
          parent.right = right
        }
      }
    }
  }

  def minValue(): A = {
    if (left == null) { 
      value
    }
    else {
      left.minValue()
    }
  }
}

class BinaryTreeImplementation[A <% Ordered[A]] extends BinaryTree[A] {
  var root: TreeNode[A] = null
  
  def insert(value: A): Unit = {
    if (root == null) {
      root = new TreeNode(value)
    } else {
      root.insert(value)
    }
  }

  def remove(value: A): Unit = {
    if (root == null) {
      throw InvalidMethod()
    } else {
      root.remove(value)
    }
  }

  def find(value: A): Boolean = {
    if (root == null) {
      false
    } else {
      root.find(value)
    }
  }
  
  def height(node: TreeNode[A] = root): Int = {
    if (node ==  null) {
      0
    } else {
      var leftHeight: Int = height(node.left)
      var rightHeight: Int = height(node.right)

      if (leftHeight < rightHeight) {
        rightHeight + 1
      } else {
        leftHeight + 1
      }
    }
  }
}
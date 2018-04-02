import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestBinaryTree extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {
	
    behavior of "A BinaryTree"

    var tree: BinaryTreeImplementation = _
	
	before {
		tree = new BinaryTreeImplementation
	}

	it should "have be empty before any insertion" in {
		tree.isEmpty(tree.root) should be (true)
	}
	
	it should "set the root after first insertion" in {
		tree.insert(1)

		tree.root.value should be (1)
	}

	it should "insert node to the left if parent value is lower" in {
		tree.insert(2)
		tree.insert(1)

		tree.root.left.value should be (1)
	}
	it should "insert node to the right if parent value is higher or equal" in {
		tree.insert(1)
		tree.insert(2)

		tree.root.right.value should be (2)
	}

	it should "have height = 3 if 3 numbers in ascending order are inserted" in {
		tree.insert(1)
		tree.insert(2)
		tree.insert(3)

		tree.height() should be (3)
	}

	it should "have height = 2 if numbers 2,1,3 are inserted" in {
		tree.insert(2)
		tree.insert(1)
		tree.insert(3)

		tree.height() should be (2)
	}

	it should "return correct node when the method find is called" in {
		tree.insert(2)
		tree.insert(1)
		tree.insert(3)

		var node: TreeNode = tree.find(2)
		node.value should be (2) 
	}
}
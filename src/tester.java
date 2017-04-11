
public class tester {
	public static void main(String[] args){
		
		String seperatorOne = "==========================================================";
		String seperatorTwo = "----------------------------------------------------------";
		//Create and navigate the backPainTree
		System.out.println("So you have back pain?");
		System.out.println(seperatorTwo);
		BackPainTree pTree = new BackPainTree();
		pTree.navigate();
		System.out.println(seperatorOne);
		
		//Create and navigate the ikigaiTree
		System.out.println("The Japanese concept of ikigai means \"A reason for being\". Take the test and see if what you are doing right now is your ikigai.");
		System.out.println(seperatorTwo);
		ikigaiTree iTree = new ikigaiTree();
		iTree.navigate();
		
		//Testing the BalancedLinkedList class
		System.out.println(seperatorOne);
		System.out.println("Start by creating a tree that is imbalanced. Most of the nodes are on the left. Below is a \n "
				+ "pre order traversal. With a pre order traversal the root is always first. I will use this to show \n"
				+ "how the root changes after balancing");
		System.out.println(seperatorTwo);
		BinaryTree myBin = new BinaryTree();
		
		myBin.addNode(20, "Starting root");
		myBin.addNode(18, "one");
		myBin.addNode(22, "two");
		myBin.addNode(16, "three");
		myBin.addNode(17, "four");
		myBin.addNode(14, "five");
		myBin.addNode(15, "six");
		myBin.preOrderTraverseTree(myBin.root);
		
		System.out.println(seperatorTwo);
		System.out.println("Calling the balance method and traversing in pre-order to show balance");
		System.out.println(seperatorTwo);
		myBin.balanceTheTree();
		myBin.preOrderTraverseTree(myBin.root);
		
	}
}

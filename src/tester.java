
public class tester {
	public static void main(String[] args){
		
		String seperator = "==========================================================";
		/*
		//Create and navigate the backPainTree
		BackPainTree pTree = new BackPainTree();
		pTree.navigate();
		System.out.println(seperator);
		
		//Create and navigate the ikigaiTree
		ikigaiTree iTree = new ikigaiTree();
		iTree.navigate();
		
		//Testing the BalancedLinkedList class
		*/
		BinaryTree myBin = new BinaryTree();
		
		myBin.addNode(50, "Hallew");
		myBin.addNode(15, "goodbye");
		myBin.addNode(3, "GADGadg");
		myBin.addNode(43, "asgfgggg");
		myBin.addNode(24, "asgf");
		myBin.addNode(765, "agdojabnd");
		myBin.addNode(444, "gsdgsdfg");
		myBin.addNode(777, "asfhafhnfdgb");
		myBin.addNode(1, "sfghsfgsfdgsfbv");
		
		myBin.balanceTheTree();
		
		myBin.inOrderTraverseTree(myBin.root);
		
		
	}
}

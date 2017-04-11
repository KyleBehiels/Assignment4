import java.util.ArrayList;

import java.util.List;

/*
 * Because this question was more about the balancing and less about actually creating the tree,
 * I followed the following YouTube tutorial in order to create the tree. I did the balancing method(s) myself
 * however.
 * 
 * https://www.youtube.com/watch?v=M6lYob8STMI
 * 
 * I just figure I should give him credit for academic integrity and all that...
 */

public class BinaryTree {

	Node root;		//Root node of the tree
	
	ArrayList<Node> nodes = new ArrayList<Node>();		//ArrayList used to store the nodes for balancing
	
	int treeSize = 0;			//Amount of nodes in tree
	
	
	/*
	 * This method traverses the tree in order from least to greatest. It starts by traversing as far left as possible,
	 * printing the value that it finds there and then moving up a level, printing then traversing right if it can.
	 */
	public void inOrderTraverseTree(Node focusNode){		
		if(focusNode != null){								//If we are not past a leaf...
			inOrderTraverseTree(focusNode.leftChild);		//Call this method again and pass the left child to traverse left half first
			
			System.out.println(focusNode);					//Print the node
			
			inOrderTraverseTree(focusNode.rightChild);		//Start on any right children of current level
		}
	}
	
	/*
	 * This method starts at the root and traverses in the same way as the inOrderTraversal but instead prints the nodes as
	 * it hits them. Propagates down and left as far as possible before moving on.
	 */
	public void preOrderTraverseTree(Node focusNode){		
		if(focusNode != null){								//If we are not past a leaf...
			
			System.out.println(focusNode);					//Print the node
			
			preOrderTraverseTree(focusNode.leftChild);		//Call the method again to traverse the left children
			
			preOrderTraverseTree(focusNode.rightChild);		//Once the left-most leaf is reached, the recursive loop will complete
															//and the method will be called again on the rightChild
		}
	}
	
	/*
	 * Because balance is recursive I needed a separate method for building the arrays and calling balance. 
	 * Hence balanceTheTree.
	 */
	public void balanceTheTree(){
		
		buildArrays(root);
		currentIterations = 0;
		treeSize = nodes.size();
		root = balance(nodes);
	}
	
	/*
	 * The brute force method for balancing the linked tree. Starts by checking if the tree is empty (Root is null)
	 * if it is not, find the middle of the array and make that the newRootIndex (the variable name is a little 
	 * misleading, because the function is recursive newRootIndex simply points to the center of every iterations
	 * sub-array, not necessarily the root). After that, focusNode is created and set to the node nodes[newRootIndex]
	 * and focusNode.left and focusNode.right are assigned the node that is returned from this method when passed the 
	 * appropriate sub arrays of "nodes"
	 */
	int currentIterations = 0;
	public Node balance(List<Node> nodes){
		if(root == null){
			return null;
		}
		else{
			int newRootIndex;
			if(nodes.size()!=1){					//If the subArray is longer than one...
				newRootIndex = nodes.size()/2;		//Find the center position of nodes
			}
			else{									//Else it is a leaf
				newRootIndex = 0;
			}
			if(nodes.size() == 0){	
				
				return null;
			}
			
			/*
			 * If you are on a leaf and try to assign left and right children recursively, return null
			 */
			
			Node focusNode = nodes.get(newRootIndex);		//Set the focus node to the middle of nodes
			
			//Set the left child of focus node to the node returned from passing the left half of "nodes" into
			//this method recursively
			
			focusNode.leftChild = balance(new ArrayList<>(nodes.subList(0, newRootIndex)));		
			
			//Set the right child of focus node to the node returned from passing the right half of "nodes" into
			//this method recursively
			
			focusNode.rightChild = balance(new ArrayList<>(nodes.subList(newRootIndex+1, nodes.size())));
			return focusNode; //Return focus node so that it can be assigned
		}
		
	}
	
	/*
	 * buildArrays is the exact same as the inOrderTraversal I explained above but instead of printing the values it
	 * adds them to the nodes ArrayList
	 */
	public void buildArrays(Node focusNode){
		if(focusNode != null){
			buildArrays(focusNode.leftChild);
			
			nodes.add(focusNode);
			
			buildArrays(focusNode.rightChild);
		}
	}
	
	/*
	 * A method for finding and returning a node based on it's key
	 */
	public Node findNode(int key){
		Node focusNode = root;			//Start on the root of the tree
		
		while(focusNode.Key!=key){		//While we are on a node who's key is incorrect...
			if(key < focusNode.Key){	//If the key we are looking for is less than the key of the current node...
				focusNode = focusNode.leftChild;	//Navigate to the left or the values on the lesser half of the subtree.
			}
			else{
				focusNode = focusNode.rightChild;	//Else, move to the right or the values on the greater half of the subtree.
			}
			if(focusNode == null){		//If we finish traversing the tree and find nothing...
				return null;			//Return null to indicate that the key was not in the 
			}
		}
		return focusNode;			//Upon exiting the while loop we are on the node that matches our search. Return it.
		
	}
	
	/*
	 * Method for publicly adding a node to the tree
	 */
	public void addNode(int key, String name) {		//Method call takes parameters 'key' and 'name'
		Node newNode = new Node(key, name);			//Create the new node

		if (root == null) {							//If this is the first add...

			root = new Node(key, name);				//assign the new node to root

		} else {									//Otherwise...

			Node focusNode = root;					//Start determining where the new node goes by assigning our focus node
													//to root.
			Node parent;							//Create a blank node for storing the parent once we find it.

			while (true) {							//Create an infinite loop because we do not know how big the tree is...
				
				parent = focusNode;					//Assume the parent is the focus node and test...
				
				if (key < focusNode.Key) {			//If the key is less than the focus nodes key...
					
					focusNode = focusNode.leftChild;	//Traverse left
					
					if (focusNode == null) {			//if focusNode is null (parent = leaf)
						
						parent.leftChild = newNode;		//Set parent.left to the new node
						
						return;							//Exit the infinite loop
						
					}
				} else {							//If the new key is greater than the current focus nodes key...
					
					focusNode = focusNode.rightChild;	//Traverse right

					if (focusNode == null) {			//If focus node is null (Parent = leaf)
						
						parent.rightChild = newNode;	//Assign parent.right to the new node
						
						return;							//exit the infinite loop
					}
				}

			}

		}

	}

}
/*
 * Node class for storing and organizing the tree's data
 */
class Node {

	int Key;		//Key for determining the nodes position on the tree
	String name;	//Data stored in the tree (Limited to strings for simplicity)

	Node leftChild, rightChild;		//Left and right children in case this node is a branch

	Node(int key, String name) {	//Constructor for passing the key and name
		this.Key = key;
		this.name = name;
	}

	public String toString() {				//Basic toString for testing
		return name + " has key: " + Key;
	}
}
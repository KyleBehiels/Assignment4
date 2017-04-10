import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	Node root;
	
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> keys = new ArrayList<Integer>();
	
	

	public void inOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			
			System.out.println(focusNode);
			
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	public void preOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			
			System.out.println(focusNode);
			
			preOrderTraverseTree(focusNode.leftChild);
			
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void balanceTheTree(){
		root = balance(keys, names);
	}
	
	public Node balance(List<Integer> keyList, List<String> nameList){
		buildArrays(root);
		if(root == null){
			return null;
		}
		else{
			int newRootIndex = keyList.size()/2;
			Node focusNode = new Node(keyList.get(newRootIndex), nameList.get(newRootIndex));
			focusNode.leftChild = balance(keyList.subList(0, newRootIndex), nameList.subList(0, newRootIndex));
			focusNode.rightChild = balance(keyList.subList(newRootIndex+1, keyList.size()),nameList.subList(newRootIndex+1, nameList.size()));
			return focusNode;
		}
		
	}
	
	public void buildArrays(Node focusNode){
		if(focusNode != null){
			buildArrays(focusNode.leftChild);
			
			names.add(focusNode.name);
			keys.add(focusNode.Key);
			
			buildArrays(focusNode.rightChild);
		}
	}
	
	public Node findNode(int key){
		Node focusNode = root;
		
		while(focusNode.Key!=key){
			if(key < focusNode.Key){
				focusNode = focusNode.leftChild;
			}
			else{
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null){
				return null;
			}
		}
		return focusNode;
		
	}
	
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);

		if (root == null) {

			root = new Node(key, name);

		} else {

			Node focusNode = root;

			Node parent;

			while (true) {
				parent = focusNode;
				if (key < focusNode.Key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;

					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}

			}

		}

	}

}

class Node {

	int Key;
	String name;

	Node leftChild, rightChild;

	Node(int key, String name) {
		this.Key = key;
		this.name = name;
	}

	public String toString() {
		return name + " has key: " + Key;
	}
}
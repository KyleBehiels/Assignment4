import java.util.Scanner;

public class BackPainTree{
	static Node painTree;								//The Root node
	public void navigate(){
		init(); 										//Create the tree
		
		String choice;									//Variable for storing the users choice
		
		Node thisNode = painTree;						//thisNode holds the current node being transversed
		
		Scanner scan = new Scanner(System.in);			//Scanner for user input
		
		while(!thisNode.isLeaf){						//"Leaf" is defined as an end to the tree. While not at the end...
			
			System.out.println(thisNode.question);		//Print the question in that node to the user
			choice = scan.nextLine();					//Receive the users input
			
			switch(choice){								//Switch statement for determining what the user picked. Maybe should use a if-else
			case "y":
				thisNode = thisNode.yNode;				//If the user picks "y" set the current node to the yes branch of the node being transversed
				break;
			case "n":									
				thisNode = thisNode.nNode;				//Same as above but for the "n" and no branch
				break;
			}
		}
		System.out.println(thisNode.question);			//Once you reach a leaf, exit the while loop and print the answer
	}

	private static void init(){
		//Array for storing the questions so the tree instantiation would not be quite as awful
		String[] questions = {"Did the pain occur after a blow or Jolt?",
				"Do you have difficulty controlling your arms or legs?",
				"Do you have a fever?",
				"Emergency! You may have damaged your spinal cord!",
				"Do you have pain or numbness in one arm or leg?",
				"Do you have a sore throat or runny nose?",
				"Do you have persistent morning stiffness?",
				"You may have a serious muscle or nerve injury.",
				"You may have a sprain or strain.",
				"You may have a respiratory infection.",
				"See doctor to address symptoms.",
				"You may have an inflammation of the joints",
				"See doctor if pain persists."};
		
		//Tree instantiation, The tabbing indicates levels of the tree.
		/*
		 * 0 (y = 1, n = 2)
		 *     1 (y = 3, n = 4)
		 *         4(y = 7, n = 8)
		 *     2 (y = 5, n = 6)
		 *         5 (y = 9, n = 10)
		 *         6 (y = 11, n = 12)
		 *----------------------------------
		 *>> 3,7,8,9,10,11,12 are all leaves
		 *----------------------------------
		 */
		painTree = new Node(questions[0],
							new Node(questions[1],
									new Node(questions[3]),
									new Node(questions[4],
										new Node(questions[7]),
										new Node(questions[8]))),
							new Node(questions[2],
								new Node(questions[5],
									new Node(questions[9]), 
									new Node(questions[10])), 
								new Node(questions[6], 
									new Node(questions[11]),
									new Node(questions[12]))));     	
	}
	static class Node{
		Node nNode, yNode;						//Instantiate the two possible branches for each node
		String question;
		boolean isLeaf;
		//Constructor for a leaf (No Branches)
		public Node(String painQuestion){		//If this node is a leaf, only accept a string
			//This is a leaf
			question = painQuestion;
			isLeaf = true;						//Set the flag indicating a leaf
		}
		//Constructor for defining the branches of the current node
		public Node(String painQuestion, Node yesNode, Node noNode){		//If this node is a branch...
			nNode = noNode;						//Instantiate two new nodes
			yNode = yesNode;
			question = painQuestion;			//Set the question for this node
			isLeaf = false;						//Set the flag indicating a leaf to false
		}
	}	
}

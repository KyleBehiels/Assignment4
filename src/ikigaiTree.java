import java.util.Scanner;


public class ikigaiTree{
	static Node ikigaiNode;								//The Root node
	public void navigate(){
		System.out.println("The Japanese concept of ikigai means \"A reason for being\". Take the test and see if what you are doing right now is your ikigai.");
		init(); 										//Create the tree
		
		String choice;									//Variable for storing the users choice
		
		Node thisNode = ikigaiNode;						//thisNode holds the current node being transversed
		
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
		String[] questions = {"Do you love what you are doing?",	//0
				"Are you good at what you are doing?",	//1
				"Do you get paid to do it?",	//2
				"Is what you are doing needed in the world?", //3
				"You are a volunteer.",	//4
				"What you are doing is a profession.",	//5
				"You are comfortable but there is a feeling of emptyness.",	//6
				"Stop what you are doing.",	//7
				"Vocation.",	//8
				"You are excited and complacent but there is a sense of uncertainty.",	//9
				"What you are doing is a profession.",	//10
				"You have delight and fullness but no money.",	//11
				"You are satisfied but there is a feeling of uselessness",  //12
				"What you are doing is your purpose in life, or ikigai."};	//13
		
		
		ikigaiNode = new Node(questions[0], new Node(questions[1],new Node(questions[2],new Node(questions[3], new Node(questions[13]), new Node(questions[12])), new Node(questions[3], new Node(questions[11]), new Node(questions[5]))), new Node(questions[9])), new Node(questions[1], new Node(questions[2], new Node(questions[3], new Node(questions[6]), new Node(questions[5])),new Node(questions[7])),new Node(questions[8])));     	
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
package phoneBookBST;

public class Node {

	    public  Event data ;
	    public   Node  next;
	    public Node previous;
	    //we just add the above line bc in DDL we need a previous pointer unlike a single linkedList.

	    public Node() {
	        data = null;
	        next = null;
	        previous = null;
	    }

	    public Node(Event val) {
	        data = val;
	        next = null;
	        previous = null;
	    }



	}



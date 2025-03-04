package phoneBookBST;

public class DoubleLinkedList {
	 public Node head;
	 public Node current;

	    public DoubleLinkedList() {
	        head = current = null;
	    }

	public boolean empty() {
	        return head ==null;
	    }

	public boolean first() {
	    return current.previous==null; //finds if the current element is the first one we 
	}

	public boolean last() {
	    return current.next==null;
	}

	public void findFirst() {
	    current = head; //puts the current pointer on the first element aka the head
	}

	public void findNext() {
	    current = current.next;
	}

	public void findPrevious() {
	    current = current.previous;
	}

	public Event retrieve2() {
	    return current.data;
	}

	public void update(Event val) {
	current.data=val;
	}
	public void insert(Event val) {
	    Node tmp = new Node(val);
	    if(empty()) {
	        current = head = tmp;
	    }

	    else {
	        tmp.next=current.next;
	        tmp.previous=current;
	        if(current.next!=null)
	            current.next.previous=tmp;
	        current.next=tmp;
	        current = tmp;
	    }

	}

	public void remove() {
	    if(empty())
	        return;
	    if(head==current) {
	        head =head.next;
	        if(head!=null)
	            head.previous=null;
	    }

	    else {
	        current.previous.next=current.next;
	        if(current.next!=null)
	            current.next.previous=current.previous;
	    }
	    if(current.next==null)
	        current =head;
	    current=current.next;

	}

	public void findLast() {
	    while(current.next!=null)
	        current=current.next;
	}
	public void insert_in_order(Event val) {
	    current=head;
	    Node newNode = new Node(val);
	//empty
	    if(empty()) {
	        current=head= newNode;
	    }
	    //before head
	    else if( newNode.data.Title.compareToIgnoreCase(head.data.Title)<0) {
	         newNode.next= head;
	        head.previous= newNode;
	        head= newNode;
	        current= head;
	    }
	    else {
	        Node tmp=head;
	        Node tmpPre =null;
	        while(tmp!=null && newNode.data.Title.compareToIgnoreCase(tmp.data.Title)>0) {
	            tmpPre =tmp;
	            tmp=tmp.next;}
	        if(tmp==null) {
	            tmpPre.next=newNode;
	            newNode.previous=tmpPre;
	            tmp = newNode;
	        }
	        else {
	        tmp.previous=newNode;
	        tmpPre.next=newNode;
	        newNode.next=tmp;
	        newNode.previous=tmpPre;
	        tmpPre=tmpPre.next;
	        }}
	}
	public void scheduleAppointment(DoubleLinkedList appoitment, ContactBST<Contact> l,Event val) {
	     //checking if contact exist
	    if( !l.Search(val.CName)) {
	        System.out.println("contact doesn not exist");
	        return;}
	    else {
	      //checking for conflict
	        Node currentEvent = l.current.data.listOfEvents.head ;
	        while (currentEvent != null) {
	            if (currentEvent.data.DateAndTime.equals(val.DateAndTime)) {
	                System.out.println("there is conflict!");
	                return ;}
	            else
	            currentEvent = currentEvent.next;
	        }
	     //add appointment
	            l.current.data.listOfEvents.insert_in_order(val);
	            appoitment.insert_in_order(val);
	    }
	}
	public void scheduleEvent(DoubleLinkedList event, ContactBST<Contact> l,Event val) {
	    //splitting the string 
	    String[] namesList = val.CName.split(",");
	    //loop till the end of contacts names
	    for(String name : namesList) {
	        //checking if contact exist
	        if(!l.Search(name))
	            {System.out.println("contact doesn not exist");
	        return;}
	        //check if there is conflict 
	        else {
	            Node currentEvent = l.current.data.listOfEvents.head ;
	            while (currentEvent != null) {
	                if (currentEvent.data.DateAndTime.equals(val.DateAndTime)) {
	                    System.out.println("there is conflict!");
	                    return ;}
	                else
	                currentEvent = currentEvent.next;}}
	        //adding to each contact event list
	        l.current.data.listOfEvents.insert_in_order(val);
	        }
	//adding to the general list
	event.insert_in_order(val);
	}
	public void searchEventOrAppoitmentByTitle(DoubleLinkedList list, String val) {
        boolean flag = false;
        //loop
        list.findFirst();
        while(!list.last()) {
            if(retrieve2().Title.equalsIgnoreCase(val))
            {System.out.println("event found");
            System.out.println(list.retrieve2().toString());
            flag =true;
            }
            //else flag =false;
            list.findNext();
        }
        //check last event
        if(list.retrieve2().Title.equalsIgnoreCase(val)) {
            if(flag==false) {System.out.println("event found");}
            System.out.println(list.retrieve2().toString());
            flag =true;}

        else if(flag==false)
            System.out.println("event not found!");

    }
	public void searchEventOrAppoitmentByContact(DoubleLinkedList list,String contact) {
	    boolean flag = false;
	    list.findFirst();
	    while(!list.last()) {
	    if(list.retrieve2().CName.equalsIgnoreCase(contact)) {
	        System.out.println("event found");
	        System.out.println(list.retrieve2().toString());
	        flag=true;}
	    list.findNext();
	}
	if(list.retrieve2().CName.equalsIgnoreCase(contact)) {
	    System.out.println(list.retrieve2().toString());
	    flag =true;}
	else if(flag==false) System.out.println("event not found!");

	    }
	public void printAllEventsOrAppoitments(DoubleLinkedList list) {
	    list.findFirst();
	    while(!list.last()) {
	        System.out.println(list.retrieve2().toString());
	        list.findNext();
	    }
	    System.out.println(list.retrieve2().toString());
	}

	public void removeAppoitment(String ContactName) {
        this.findFirst();
        while(!this.last()) {
            if(this.current.data.CName.equalsIgnoreCase(ContactName)&& !this.current.data.event) 
                this.remove();
            this.findNext();
        }
        if(this.retrieve2().CName.equalsIgnoreCase(ContactName)&& !this.current.data.event)
            this.remove();
    }
public void removeEvent(String ContactName) {
        int x;
        int y;
        this.findFirst();
        while(!this.last()) {
            if(this.current.data.CName.contains(ContactName) && this.current.data.event && this.current.data.CName.length()!=ContactName.length()) {
             x=this.current.data.CName.indexOf(ContactName);
            y=this.current.data.CName.lastIndexOf(ContactName, x);
            this.current.data.CName = this.current.data.CName.substring(0, x)+ this.current.data.CName.substring(y,this.current.data.CName.length() );
            this.findNext();
            }
            else
                if(this.current.data.CName.contains(ContactName) && this.current.data.event && this.current.data.CName.length()==ContactName.length()) {
                    this.remove();
                    this.findNext();
                }
        }


        if(this.current.data.CName.contains(ContactName) && this.current.data.event && this.current.data.CName.length()!=ContactName.length()) {
             x=this.current.data.CName.indexOf(ContactName);
            y=this.current.data.CName.lastIndexOf(ContactName, x);
            this.current.data.CName = this.current.data.CName.substring(0, x)+ this.current.data.CName.substring(y,this.current.data.CName.length() );

            }
            else
                if(this.current.data.CName.contains(ContactName) && this.current.data.event && this.current.data.CName.length()==ContactName.length()) {
                    this.remove();
                }

    }

}

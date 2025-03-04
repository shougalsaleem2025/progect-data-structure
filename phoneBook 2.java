package phoneBookBST;
import java.util.Scanner;


public class phoneBook {
	
    phoneBook p1 = new phoneBook();
   
	

	static String ContactName, phoneNumber, emailAddress, address, birthday, notes , Title, DateAndTime ,location ;
	private static Scanner input;
    static boolean event;

    
	static public void printByFirstName(String name, ContactBST<Contact> Contacts) {
	    Contacts.findRoot();
	    printByFirstNameRecursive(name, Contacts.current);
	}

	static private void printByFirstNameRecursive(String name, BSTNode<Contact> current) {
	    if (current != null) {
	        String fname = current.key.substring(0, current.key.indexOf(" "));

	        if (fname.equalsIgnoreCase(name)) {
	        	  System.out.print("Contact found !\n");
	            System.out.println(current.toString());
	        }

	        // Traverse left
	        printByFirstNameRecursive(name, current.left);

	        // Traverse right
	        printByFirstNameRecursive(name, current.right);
	    }
	}

	
 public static void main(String[] args) {
	

	 DoubleLinkedList list = new DoubleLinkedList();
     ContactBST<Contact> Contacts = new ContactBST<Contact>();
     Contact C ;
     Event e ;
     input = new Scanner(System.in);
     int choice , type ;
	
		
		
		System.out.println("Welcome to the BST Phonebook!\n");

		do{

			System.out.println("Please choose an option:");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("4. Schedule an event/appointment");
			System.out.println("5. Print event details");
			System.out.println("6. Print contacts by first name");
			System.out.println("7. Print all events alphabetically");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");

			choice = input.nextInt();

			switch (choice) {
			case 1:

				//ADD CONTACT

				System.out.println(" Enter the contact's name: ");
				ContactName=input.nextLine();
				ContactName=input.nextLine();
				System.out.println(" Enter the contact's phone number: ");
				phoneNumber=input.nextLine();
				//phoneNumber=input.nextLine();
				System.out.println("Enter the contact's email address: ");
				emailAddress=input.nextLine();
				//emailAddress=input.nextLine();
				System.out.println(" Enter the contact's address: ");
				address=input.nextLine();
				//address=input.nextLine();
				System.out.println(" Enter the contact's birthday:");
				birthday=input.nextLine();
				//birthday=input.nextLine();
				System.out.println("Enter any notes for the contact:");
				notes=input.nextLine();
				//1notes=input.nextLine();

				C = new Contact(ContactName , phoneNumber, emailAddress,address,birthday,notes ) ;
			if(	Contacts.addContact( ContactName , C ))
				System.out.println("Contact added successfully!");


				break;


			case 2:

				//SEARCH FOR CONTACT

				System.out.println("Enter search criteria:");
				System.out.println("1. Name");
				System.out.println("2. Phone Number");
				System.out.println("3. Email Address");
				System.out.println("4. Address");
				System.out.println("5. Birthday");

				System.out.println(" Enter your choice:");
				choice = input.nextInt();

				switch(choice)
				{


				case 1:
					
					System.out.println(" Enter the contact's name: ");
					ContactName=input.nextLine();
					ContactName=input.nextLine();
					Contacts.SearchforContactName(ContactName);
					
				 

					break;
				case 2:
					System.out.println(" Enter the contact's phone number: ");
					phoneNumber=input.nextLine();
					phoneNumber=input.nextLine();
					Contacts.SearchforContact1(phoneNumber);

					break;
				case 3:

					System.out.println("Enter the contact's email address: ");
					emailAddress=input.nextLine();
					emailAddress=input.nextLine();
					Contacts.SearchforContact2(emailAddress);
					break;
				case 4:
					System.out.println(" Enter the contact's address: ");
					address=input.nextLine();
					address=input.nextLine();
					Contacts.SearchforContact2(address);

					break;
				case 5:
					System.out.println(" Enter the contact's birthday:");
					birthday=input.nextLine();
					birthday=input.nextLine();
					Contacts.SearchforContact2(birthday);
					break;
				default:
					System.out.println("Invalid choice. Please choose a valid option.");
					break;

				}

				break;


			case 3:
				
			
				//DELETE CONTACT
				input.nextLine();
				System.out.println(" Enter the contact's name that you want to delete : ");
				ContactName=input.nextLine();

               if(Contacts.removeKey(ContactName )) 
                {
                    list.removeAppoitment(ContactName);
                    list.removeEvent(ContactName);
                    }

                else
            	System.out.println("Contact was NOT deleted"); 
				break;
				
                     


			case 4:

				//Schedule event 
				System.out.println("Enter type:");
				System.out.println("1. event");
				System.out.println("2. appointment");

				type = input.nextInt();
			
				
                if(type==1)
                    event=true;
                else
                    event = false;
                
				switch(type) {
				
				case 1:
					System.out.println("Enter event title :");
					Title = input.nextLine();
					Title = input.nextLine();

					System.out.println("Enter contact name separated by a comma:");
					ContactName = input.nextLine();
			

					System.out.println("Enter event date and time(MM/DD/YYYY HH:MM):");
					DateAndTime = input.nextLine();
			

					System.out.println("Enter event location:");
					location = input.nextLine();
				

					 e = new Event (Title ,DateAndTime, location ,ContactName,event);
                     list.scheduleEvent(list, Contacts, e);
                     System.out.println("Event scheduled successfully!");
					
					break;
					
				case 2:
					System.out.println("Enter appointment title :");
					Title = input.nextLine();
					Title = input.nextLine();

					System.out.println("Enter contact name separated by a comma:");
					ContactName = input.nextLine();
				

					System.out.println("Enter appointment date and time(MM/DD/YYYY HH:MM):");
					DateAndTime = input.nextLine();
			
					System.out.println("Enter appointment location:");
					location = input.nextLine();
				

					e = new Event (Title ,DateAndTime, location ,ContactName,event);
                    list.scheduleAppointment(list, Contacts, e);
                     System.out.println("Event scheduled successfully!");
                     
                     break;
				

				}
				
				break ;


			case 5:
                   // Print event details
				System.out.println("Enter search criteria:");
				System.out.println("1.Contact Name");
				System.out.println("2.event title ");

				System.out.println(" Enter your choice:");
				choice = input.nextInt();

				switch(choice) {


				case 1: 
					System.out.println("Enter contact name:");
					ContactName = input.nextLine();
					ContactName = input.nextLine();
					list.searchEventOrAppoitmentByContact(list, ContactName);					
					break;

				case 2:
					System.out.println(" Enter the event title :");
					Title=input.nextLine();
					Title=input.nextLine();
					list.searchEventOrAppoitmentByTitle(list, Title);				
				break;
					
				}

				break ;


			case 6:
				input.nextLine(); //Prince by first name 
				System.out.println("Enter the first name :");
				ContactName = input.nextLine(); 
				printByFirstName(ContactName , Contacts );
				break;

			case 7:
				// Print all events alphabetically 
				list.printAllEventsOrAppoitments(list);				
			     break;
				
			case 8:
				System.out.println("Goodbye!"); //Exiting the Phone book
				break;

				
			default:
				
				System.out.println("Invalid choice. Please choose a valid option.");
				break;
				
				} 

			
				
		
		}while (choice != 8) ;
	}
}

			
		
	


			
		
	

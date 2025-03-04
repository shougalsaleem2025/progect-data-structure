package phoneBookBST;


public class Contact implements Comparable <Contact>
 {
	
	
	public String ContactName;
	public String phoneNumber;
	public String emailAddress;
	public String address;
	public String birthday;
	public String notes;
    DoubleLinkedList listOfEvents = new DoubleLinkedList();

		
	
	public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
			String notes) {
		this.ContactName = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		
	}


public int compareTo(Contact contact2) {
		return this.ContactName.compareTo(contact2.ContactName);
	}


	@Override
	public String toString() {
		return "name=" + ContactName + "\nphoneNumber=" + phoneNumber + "\nemailAddress=" + emailAddress
				+ "\naddress=" + address + "\nbirthday=" + birthday + "\nnotes=" + notes +"\n" ;
	}


}




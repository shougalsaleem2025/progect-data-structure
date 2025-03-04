package phoneBookBST;

public class ContactBST <T>  {
	BSTNode<Contact> root, current;
	
	/** Creates a new instance of BST */
	public ContactBST() {
	root = current = null;
	}
	
	public boolean empty() {
	return root == null;
	}
	
	public boolean full() {
	return false;
	} 
	
	public Contact retrieve () {
	return current.data;
	}
	
	public Contact retrieve2 (BSTNode<Contact> root) {
		return root.data;
		}
	
	public void findRoot() {
		current= root ;
	}
		
	public boolean Search(String key) {
		BSTNode<Contact> p = root ,q = root;
		
	    // Check if the BST is empty. If it's empty, return false since the key cannot be found.
		if(empty())
		return false;
		
	    // Traverse the BST to find the key.
		while(p != null) {
		q = p;
		if(p.key.compareToIgnoreCase(key)==0) {
		current = p;
		return true;
		}
		
		else if(key.compareToIgnoreCase(p.key)< 0) {
		p = p.left;}
		else 
		p = p.right;
		
		}
		current = q;
		return false;
		}
	
	
	
	
	public boolean addContact(String k, Contact val) {
		
		BSTNode<Contact> p, q = current;
		
	    // Check if the key already exists in the BST by calling the 'Search' method.
		if(Search(k)) {
		current = q; 
		System.out.println(" Couldn't add Because there is a Contact with the same al name already exist in the BST.");
		return false; // key already in the BST
		}
		
		
		if (checkPhoneNumberExists( root , val)) {
	        current = q;
			System.out.println(" Couldn't add Because there is a Contact with the same phone number already exist in the BST.");
	        return false; // Contact with the same phone number already in the BST.
	    }
		
		p = new BSTNode<Contact>(k, val);
		if (empty()) {
		root = current = p;
		return true;
		}
		else {
		// current is pointing to parent of the new key
		
		if(k.compareToIgnoreCase(current.key)< 0) 
		current.left = p ; // If k < current.key, insert 'p' as the left child.
		else
		current.right = p;// If k > current.key, insert 'p' as the right child.
        }
		
		current = p; // Update 'current' to the newly inserted node.
		return true;
		}
		
	
	
	
	public boolean checkPhoneNumberExists(BSTNode<Contact> p ,  Contact val) {
	    if (p != null) {
	        // Traverse right subtree.
	        if (checkPhoneNumberExists(p.right, val))
	            return true;

	        // Check if the current node has the same phone number.
	        if (p.data.phoneNumber.equals(val.phoneNumber)   ) {
	            return true; // Contact with the same phone number already exists.
	        }


	        // Traverse left subtree.
	        return checkPhoneNumberExists(p.left, val);
	    }
	    return false; // Contact with the given phone number not found in the BST.
	}


	
	
	public void SearchforContactName(String str) {
		if(empty())   // Check if the BST is empty
			System.out.println(" BST is empty");

		else {
			if (Search(str)) {  // If the contact is found, print the detail
				  System.out.print("Contact found !\n");
			System.out.println(retrieve ());
			}
			else
				System.out.println("can not find this contact");	
		}
	}
	
	
	
	//Public method that helps call the private recursive method 
	public void SearchforContact1(String str) {
		
		SearchphoneNumber( root ,  str) ;
	}
	
	
	private void  SearchphoneNumber( BSTNode<Contact> root , String str) {
	    if (root != null) {
	    	
	    	SearchphoneNumber(root.left , str); 	// Recursive search through the BST

	        
	        if(root.data.phoneNumber.equals(str)) {
	        	  System.out.print("Contact found !\n");
	              System.out.print(retrieve2(root));
	            
	              }
	        
	        SearchphoneNumber(root.right, str);
	    }
	}
	
	
	//Public method that helps call the private recursive method 
	public void SearchforContact2(String str) {
		
		Search_Email_address_birthday( root ,  str) ;
	}
	
	
	// Search for a contact by email address, address, or birthday in the BST
	private void  Search_Email_address_birthday( BSTNode<Contact> root , String str) {
	    if (root != null) {
	    	Search_Email_address_birthday(root.left , str);// Recursive search through the BST
	        
	        // If any of the specified fields match, print the contact details
	        if(root.data.emailAddress.equalsIgnoreCase(str) || root.data.address.equalsIgnoreCase(str) || root.data.birthday.equalsIgnoreCase(str)) {
	        	
	        	   System.out.print("Contact found !\n");
	              System.out.print(retrieve2(root));
	              }
	        
	        
	        Search_Email_address_birthday(root.right, str);
	    }
	}

	
	public boolean removeKey(String k) {
		String k1 = k;
		BSTNode<Contact> p = this.root;
		BSTNode<Contact> q = null; // Parent of p
		while (p != null) {
		if (k1.compareToIgnoreCase(p.key)<1) {
		q = p;
		p = p.left;
		} else if (k1.compareToIgnoreCase(p.key)>1) {
		q = p;
		p = p.right;
		} else { // Found the key, Check the three cases
		if ((p.left != null) && (p.right != null)) {
		// Case 3: search for min in the right subtree
		BSTNode<Contact> min = p.right;
		q = p;
		while (min.left != null) {
		q = min;
		min = min.left;
		}
		p.key = min.key;
		p.data = min.data;
		k1 = min.key;
		p = min;
		}// Now fall back to either case 1 or 2
		// The subtree rooted at p will change here
		if (p.left != null) // One child
		p = p.left;
		else // One or no children
		p = p.right;
		if (q == null)//No parent for p, root must change
		root = p;
		else
		if (k1.compareToIgnoreCase(q.key)<1)
		q.left = p;
		else
		q.right = p;
		current = root;
		return true;
		}
		}
		return false; // Not found 
		}
		
		

	
}//class
		
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
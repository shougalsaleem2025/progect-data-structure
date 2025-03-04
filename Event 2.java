package phoneBookBST;

public class Event {

	     public  String Title ;
	     public  String DateAndTime ;
	     public  String location ;
	     public  String CName;
	     public  boolean event ;
	     

	     
	     
	     
		public Event(String title, String dateAndTime, String location, String contactName, boolean event) {
			super();
			Title = title;
			DateAndTime = dateAndTime;
			this.location = location;
			this.CName = contactName;
			this.event = event;
			
		}



		@Override
		public String toString() {
			return "EventTitle=" + Title + "\nContact Name=" + CName + "\nEvent date and time(MM/DD/YYYY HH:MM) =" + DateAndTime
					+ "\nEvent location=" + location ;
				
		}


	   

	
}


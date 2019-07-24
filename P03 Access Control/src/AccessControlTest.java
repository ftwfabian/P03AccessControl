
public class AccessControlTest {
	public static void main(String[] args) {
		  int fails = 0;
		  if (!testLogin1()) {
		    System.out.println("testLogin1 [bad username] failed");
		    fails++;
		  }
		  
		  if(!testAddUser1()) {
			  System.out.println("testAddUser1 failed");
			  fails++;
		  } 
		  
		  /*if (!testLogin2()) {
		    System.out.println("testLogin2 [good login] failed");
		    fails++;
		  }
		  if (!testLogin3()) {
		    System.out.println("testLogin1 [bad username with default password] failed");
		    fails++;
		  } */
		  
		  if (fails == 0)
		    System.out.println("All tests passed!");
		} 
	
	public static boolean testLogin1() {
		 AccessControl ac = new AccessControl(); // It doesn't look like we use ac, but we need 
		                                         //users initialized
		  String user = "probablyNotInTheSystem1234";
		  String pw = "password";
		  return !ac.isValidLogin(user, pw); // isValidLogin should return false
		  
	}
	
	public static boolean testAddUser1() {
		  AccessControl ac = new AccessControl();
		  String user = "alexi";
		  boolean addUserReport = ac.addUser(user);
		  if (addUserReport)
		    return false; // addUserReport should be false
		  // Make sure user wasn't added anyway
		  return !ac.isValidLogin(user, "changeme");
	} 


}

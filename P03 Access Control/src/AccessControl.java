import java.util.ArrayList;
import java.util.Scanner;
public class AccessControl {
	
	Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<User> users;
	private User currentUser; // Who is currently logged in, if anyone?
	private static final String DEFAULT_PASSWORD = "changeme";
	
	public AccessControl() {
		if(currentUser!=null && currentUser.getIsAdmin()) {
			currentUser = null;
			users.add(new User("admin","root",true));
		}
	}
		                 // Default password given to
		                 //new users or when we reset a user's password.
	 // A no-parameter constructor
	public static void main(String[]args) {
		AccessControl ac = new AccessControl();
		  // If we have any persistent information to lead
		  // this is where we load it.
		  Scanner userIn = new Scanner(System.in);
		  ac.loginScreen(userIn);
	} // A STATIC method that creates a new AccessControl object
	            // An implementation for this method is provided below
	
	
	public boolean isValidLogin(String username, String password) {
		
		if(currentUser != null && currentUser.getUsername().equals(username) &&
				currentUser.isValidLogin(password)) {
			return true;
		}
		
		return false;
	} // Report whether a
	            // given username/password pair is a valid login
	
	public void logout() {
		currentUser = null;
	} // Log out the current user
	
	public void changePassword(String newPassword) {
		currentUser.setPassword(newPassword);
	} // Change the current user's password
	
	public boolean addUser(String username) {
		if(currentUser!=null && currentUser.getIsAdmin()) {
			users.add(new User(username,DEFAULT_PASSWORD,false));
			return true;
		}
		return false;
	} // Create a new user (non-admin)
	
	public boolean addUser(String username, boolean isAdmin) {
		if(currentUser!=null && currentUser.getIsAdmin()) {
			users.add(new User(username,DEFAULT_PASSWORD,isAdmin));
			return true;
		}
		return false;
	} // Create a new user
	            // and specify their admin status
	
	public boolean removeUser(String username) { //remove a user
		for(int i  = 0; i< users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
					users.remove(i);
					return true;
			}
			
		}
		return false;
	} 
	
	public boolean giveAdmin(String username) {
		if(currentUser.getIsAdmin()) {
			for(int i  = 0; i< users.size(); i++) {
				if(users.get(i).getUsername().equals(username)) {
					users.get(i).setIsAdmin(true);
					return true;
				}
			}
			
		}
		return false;
	} // Give a user admin power
	
	public boolean takeAdmin(String username) {
		if(currentUser.getIsAdmin()) {
			for(int i  = 0; i< users.size(); i++) {
				if(users.get(i).getUsername().equals(username)) {
					users.get(i).setIsAdmin(false);
					return true;
				}
			}
			
		}
		return false;
	} // Remove a user's admin power
	
	public boolean resetPassword(String username) {
		for(int i  = 0; i< users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
					users.get(i).setPassword(DEFAULT_PASSWORD);
					return true;
			}
			
		}
		return false;
	} // Reset a user's password
	
	
	public void setCurrentUser(String username){
		for(int i  = 0; i< users.size(); i++) {
			if(users.get(i).getUsername().equals(username))
					currentUser = users.get(i);
		}
	} // A mutator you can use to write tests
                        // without simulating user input
	
	
	
	public void loginScreen(Scanner userInputScanner) {
		while(true) {
			System.out.println("----------Hello, Welcome to the Login Screen-----------");
			System.out.print("-----Please enter your Username: ");
			String username = userInputScanner.nextLine();
			System.out.print("\n-----Please enter your Password: ");
			String password = userInputScanner.nextLine();
			System.out.println("\nThank you, please wait while we process this commmand");
			if(isValidLogin(username,password))
				sessionScreen(username, userInputScanner); 
			else System.out.println("Sorry, that login info is not valid...");
		}
	}
	
	public void sessionScreen(String username, Scanner userInputScanner) {
		setCurrentUser(username);
		System.out.println("-Would you like to [C]hange Password\nOR");
		System.out.println("-[L]ogout");
		if(currentUser.getIsAdmin()) {
			System.out.println("OR\n-[Add] a User\nOR");
			System.out.println("-[Remove] a User\nOR");
			System.out.println("-[Give] a User Admin Permissions\nOR");
			System.out.println("-[Take] a User's Admin Permissions Away\nOR");
			System.out.println("-[Reset] a User's Password");
		}
		String userInput = userInputScanner.nextLine();
		if(userInput.equalsIgnoreCase("c")) {
			System.out.print("Enter your new password: ");
			String newPassword = userInputScanner.nextLine();
			changePassword(newPassword);
			System.out.println("\n-Password Changed");
		} else if(userInput.equalsIgnoreCase("l")) 
			System.out.println("Logging out...\nLogged Out");
		else if(userInput.equalsIgnoreCase("add")){
			System.out.println("What do you want the new username to be?");
			String newUser = scanner.nextLine();
			addUser(newUser);
		}
				
			
		}
			
		

	}





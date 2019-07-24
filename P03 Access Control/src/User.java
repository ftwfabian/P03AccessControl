
public class User {
	private final String USERNAME; // The user's name
	private String password; // The user's password
	private boolean isAdmin; // Whether or not the user has Admin powers
	 
	public User(String username, String password, boolean isAdmin) {
		USERNAME = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	        // Creates a new user with the given password and admin status
	public boolean isValidLogin(String password) {
		return this.password.equals(password);
	} // Report whether the password is correct
	
	public String getUsername() {
		return USERNAME;
	} // Return the user's name
	
	public boolean getIsAdmin() {
		return isAdmin;
	} // Report whether the user is an admin
	
	public void setPassword(String password) {
		this.password = password;
	} // Set the new password
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	} // Set the new admin status


}

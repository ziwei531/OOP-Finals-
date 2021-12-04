package SystemUsers;

public class Admin extends RegisteredUsers {
	private boolean isAdmin = true;
	
	public Admin() {};
	
	public Admin(String loginID, String password, String name) {
		super(loginID, password, name);
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}	

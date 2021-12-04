package SystemUsers;

public class RegisteredUsers {
	public String loginID;
	public String password;
	public String name;
	
	//default constructor
	RegisteredUsers() {};
	
	//overloaded constructor
	RegisteredUsers(String loginID, String password, String name) {
		this.loginID = loginID;
		this.password = password;
		this.name = name;
		
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

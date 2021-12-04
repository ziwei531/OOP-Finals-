package SystemUsers;

public class Seller extends RegisteredUsers {
	
	private boolean isSeller = true;
	
	public Seller() {};
	
	public Seller(String loginID, String password, String name) {
		super(loginID, password, name);
	}

	public boolean isSeller() {
		return isSeller;
	}

	public void setSeller(boolean isSeller) {
		this.isSeller = isSeller;
	}
	
	
}

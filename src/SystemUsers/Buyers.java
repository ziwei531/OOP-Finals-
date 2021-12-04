package SystemUsers;
import java.util.Arrays;

public class Buyers extends RegisteredUsers {
	private boolean isBuyer;
	private double totalDue;
	private double totalBought;
	private String[] booksBoughtArr; //a list of books bought
	
	public Buyers() {};
	
	public Buyers(String loginID, String password, String name) {
		super(loginID, password, name);
	}

	public boolean isBuyer() {
		return isBuyer;
	}

	public void setBuyer(boolean isBuyer) {
		this.isBuyer = isBuyer;
	}

	public double getTotalBought() {
		return totalBought;
	}

	public void setTotalBought(double totalBought) {
		this.totalBought = totalBought;
	}

	public String[] getBooksBoughtArr() {
		return booksBoughtArr;
	}

	public void setBooksBoughtArr(String[] booksBoughtArr) {
		this.booksBoughtArr = booksBoughtArr;
	}

	public double getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}

	@Override
	public String toString() {
		return "\nCustomer's name: " + super.name +
				"\nBooks bought (Includes Duplicates): " + (this.booksBoughtArr != null ? Arrays.toString(this.booksBoughtArr) : "No books have been purchased yet.") + 
				"\nTotal paid: " + this.totalDue; 
	};
	
	
	
}

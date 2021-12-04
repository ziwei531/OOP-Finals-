
//Books can be grouped based on the Book ID, price, title, quantity

//Total Quantity: 
//Sold: xx
//Still Selling: xx

public class Books {
	private int bookID;
	private double price;
	private String title;
	private int totalQuantity;
	private int totalSold;
	private int stillSelling = 0;
	
	public Books() {};
	
	public Books(int bookID, String title, double price, int totalQuantity) {
		this.bookID = bookID;
		this.price = price;
		this.title = title;
		this.totalQuantity = totalQuantity;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	};
	
	
	public int getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(int totalSold) {
		this.totalSold = totalSold;
	}

	public int getStillSelling() {
		return stillSelling;
	}

	public void setStillSelling(int stillSelling) {
		this.stillSelling = stillSelling;
	}

	@Override
	public String toString() {
		return "Book ID: " + bookID + "\n" + 
				"Book's title: " + title + "\n" + 
				"Price: " + price + "\n" + 
				"Total Sold: " + totalSold + "\n" + 
				"Still in Stock: " + (stillSelling + totalQuantity - totalSold) + "\n" +
				"Total Quantity: " + totalQuantity + "\n";
	};
	
}

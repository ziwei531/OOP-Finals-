//Online Book Store done by
//0342855 Whoong Zi Wei
import java.util.InputMismatchException;
import java.util.Scanner;

import SystemUsers.Admin;
import SystemUsers.Buyers;
import SystemUsers.RegisteredUsers;
import SystemUsers.Seller;

public class Main {
	
	//creating sample userProfiles for admins, buyers, and sellers
	
	//all of them will have password as "abcd" in order to make it easier for me to test the program
	static Admin admin1 = new Admin("admin", "abcd", "Zi Wei");
	static Admin admin2 = new Admin("admin2", "abcd", "Kyle");
	static Admin admin3 = new Admin("admin3", "abcd", "David");
	static Admin admin4 = new Admin("admin4", "abcd", "Harry");
	
	static Seller seller1 = new Seller("seller1", "abcd", "Alice");
	static Seller seller2 = new Seller("seller2", "abcd", "Albert");
	
	static Buyers buyer1 = new Buyers("buyer1", "abcd", "Susan");
	static Buyers buyer2 = new Buyers("buyer2", "abcd", "Wilbert");
	static Buyers buyer3 = new Buyers("buyer3", "abcd", "Jack");
	
	
	//polymorphism. get them all into one array.
	static RegisteredUsers[] allUserProfiles = {admin1, admin2, admin3, admin4, seller1, seller2, buyer1, buyer2, buyer3};
	
	//arrays of user profiles
	static Admin[] admins = {admin1, admin2, admin3, admin4};
	static Seller[] sellers = {seller1, seller2};
	static Buyers[] buyers = {buyer1, buyer2, buyer3};	
	
	//create sample books 
	static Books book1 = new Books(1, "Alice's Adventures in Wonderland", 29.99, 100);
	static Books book2 = new Books(2, "To Kill a Mockingbird", 59.99, 90);
	static Books book3 = new Books(3, "The Great Gatsby", 29.99, 80);
	static Books book4 = new Books(4, "Harry Potter", 39.99, 70);
	static Books book5 = new Books(5, "Charlotte's Web", 29.99, 60);
	
	//arrays of books
	static Books[] bookArr = {book1, book2, book3, book4, book5};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		userLogin(in);
	}
	
	public static void userLogin(Scanner in) {
		
		int loginOption = -1;
		String loginID;
		String password;
		
		do {
			try {
				System.out.println("Welcome to ABC Online Book Store! Please login to our system.");
				System.out.println("1. Admin");
				System.out.println("2. Seller");
				System.out.println("3. Buyer");
				
				System.out.println("\nInput 1 to login as admin, 2 as Seller, or 3 as Buyer.");
				System.out.print("Please enter your option: ");
				loginOption = in.nextInt();
				
				in.nextLine();
				
				boolean isLoggedIn = false;
				
				do {
					switch (loginOption) {
					case 1:
						System.out.print("\nPlease enter your admin ID: ");
						loginID = in.nextLine();
						System.out.print("\nPlease enter your admin password: ");
						password = in.nextLine();
						
						boolean isValidAdmin = false;
						Admin validAdmin = new Admin();
						
						for (Admin e: admins) {
							if (loginID.equals(e.getLoginID()) && password.equals(e.getPassword())) {
								isValidAdmin = true;
								validAdmin = e;
								break;
							}
						}
						
						if (!isValidAdmin) {
							System.out.println("Login Unsucessful. Please try again.");
						}
						else {
							adminMenu(validAdmin, in);
							isLoggedIn = true;
						}
						
						break;
					case 2:
						System.out.print("Please enter your seller ID: ");
						loginID = in.nextLine();
						System.out.print("Please enter your seller password: ");
						password = in.nextLine();
						
						Seller validSeller = new Seller();
						boolean isValidSeller = false;
						
						for (Seller e: sellers) {
							if (loginID.equals(e.getLoginID()) && password.equals(e.getPassword())) {
								isValidSeller = true;
								validSeller = e;
								break;
							}
						}
						
						if (!isValidSeller) {
							System.out.println("Login Unsucessful. Please try again.");
						}
						else {
							sellerMenu(validSeller, in);
							isLoggedIn = true;
						}
						
						break;
					case 3:
						System.out.print("Please enter your buyer ID: ");
						loginID = in.nextLine();
						System.out.print("Please enter your buyer password: ");
						password = in.nextLine();
						
						
						Buyers validBuyer = new Buyers();
						boolean isValidBuyer = false;
						
						for (Buyers e: buyers) {
							if (loginID.equals(e.getLoginID()) && password.equals(e.getPassword())) {
								isValidBuyer = true;
								validBuyer = e;
								break;
							}

						}
						
						if (!isValidBuyer) {
							System.out.println("Login Unsucessful. Please try again.");
						}
						else {
							buyerMenu(validBuyer, in);
							isLoggedIn = true;
						}
						break;
					default:
						System.out.println();
						System.out.println("You did not enter a valid input. Please enter a value between 1-3\n");
						userLogin(in);
						break;
					}
				} while (!isLoggedIn);
			}
			catch (InputMismatchException e) {
				System.out.println("\nYou did not enter a numeric value! Please try again.\n");
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println("A general error has occured. Here is the error message: \n" + e);
			}
			
		} while (loginOption < 1 || loginOption > 3);
	}
	
	//admin Menu
	public static void adminMenu(Admin admin, Scanner in) { 
		
		int userIn = -1;
		
		do {
			try {
				System.out.println("\nWelcome back Admin!");
				System.out.println("You are logged in as: " + admin.getName() + "\n");
				
				System.out.println("1. Add new buyer/seller/admin");
				System.out.println("2. Delete existing buyer/seller/admin");
				System.out.println("3. View all available user profiles within this system");
				System.out.println("4. View and/or edit current existing stocks of books within the system");
				System.out.println("5. Exit the Program.");
				
				System.out.print("Enter an option: ");
				userIn = in.nextInt();
				
				switch (userIn) {
					case 1:
						addNewUsers(admin, in);
						break;
					case 2:
						deleteUsers(admin, in);
						break;
					case 3:
						viewAllUserProfiles(admin, in);
						break;
					case 4:
						viewOrEdit(admin, in);
						break;
					case 5:
						System.out.println("Logging off. Goodbye " + admin.getName() + "." + "\n");
						userLogin(in);
						break;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("\nYou did not enter a numeric value! Please try again.\n");
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println("A general error has occured. Here is the error message: \n" + e);
			}
			
		} while (userIn < 1 || userIn > 3);

	}
	
	//view all user profiles
	public static void viewAllUserProfiles(Admin admin, Scanner in) {
		
		System.out.println();
		for (int i = 0; i < allUserProfiles.length; i++) {
			System.out.println( i+1 + ". Login ID: " + allUserProfiles[i].getLoginID() + " | User's Name: " + allUserProfiles[i].getName() + " | User's Password: " + allUserProfiles[i].getPassword());
		}
		
		System.out.println("\nTotal Profiles existing within this system: " + allUserProfiles.length);
		
		adminMenu(admin, in);
		
	}
	
	//add new users for admin
	public static void addNewUsers(Admin admin, Scanner in) {
		String tempName;
		String tempPassword;
		String tempLoginID;
		String userType = "";
		int userChoice;
		
		
		while (true) {
			try {
				System.out.println("\nIs this user an admin, buyer, or seller?");
				System.out.println("1. Admin");
				System.out.println("2. Buyer");
				System.out.println("3. Seller");
				
				System.out.print("Enter your option: ");
				userChoice = in.nextInt();
				
				switch (userChoice) {
					case 1:
						userType = "Admin";
						break;
					case 2: 
						userType = "Buyer";
						break;
					case 3:
						userType = "Seller";
						break;
				}
				
				in.nextLine();
				System.out.println("Please enter a new login ID for this user: ");
				tempLoginID = in.nextLine();
				
				System.out.println("Please enter a new name for this user");
				tempName = in.nextLine();
				
				System.out.println("Please enter a new password for this user");
				tempPassword = in.nextLine();
				
				if (userType.equals("Admin")) {
					//array is mutable. hence, this is possible.
					admins = newAdmin(tempLoginID, tempPassword, tempName);
					System.out.println("\nSuccessfully added this new Admin profile! Here is a preview: ");
					
					for (Admin a: admins) {
						if (a.getLoginID() == tempLoginID) {
							System.out.println("Admin's name: " + a.getName());
							System.out.println("Admin's Login ID: " + a.getLoginID());
							System.out.println("Admin's Password: " + a.getPassword());
						}
					}
					
					adminMenu(admin, in);
					break;
					
				}
				else if (userType.equals("Buyer")) {
					buyers = newBuyer(tempLoginID, tempPassword, tempName);
					
					System.out.println("Successfully added this new Buyer profile! Here is a preview: ");
					
					for (Buyers b: buyers) {
						if (b.getLoginID() == tempLoginID) {
							System.out.println("Buyer's name: " + b.getName());
							System.out.println("Buyer's Login ID: " + b.getLoginID());
							System.out.println("Buyer's Password: " + b.getPassword());
						}
					}
					
					adminMenu(admin, in);
					break;
				}
				else if (userType.equals("Seller")) {
					sellers = newSeller(tempLoginID, tempPassword, tempName);
					
					System.out.println("Successfully added this new Seller profile! Here is a preview: ");
					
					for (Seller b: sellers) {
						if (b.getLoginID() == tempLoginID) {
							System.out.println("Seller's name: " + b.getName());
							System.out.println("Seller's Login ID: " + b.getLoginID());
							System.out.println("Seller's Password: " + b.getPassword());
						}
					}
					
					adminMenu(admin, in);
					break;
				}
				
			}
			catch (InputMismatchException e) {
				System.out.println("\nYou did not enter a numeric value! Please try again.\n");
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println("A general error has occured. Here is the error message: \n" + e);
			}	
		} 
	}
	
	//new added Admin array
	public static Admin[] newAdmin(String loginID, String password, String name) {
		Admin addedAdmin = new Admin(loginID, password, name);

		Admin[] newAdminArr = new Admin[admins.length + 1];
		
		for (int i = 0; i < admins.length; i++) {
			newAdminArr[i] = admins[i]; //add preexisting elements into the new array
			newAdminArr[admins.length] = addedAdmin;
		}

		return newAdminArr;
	}
	
	///new added Buyer array
	public static Buyers[] newBuyer(String loginID, String password, String name) {
		Buyers addedBuyer = new Buyers(loginID, password, name);
		
		Buyers[] newBuyerArr = new Buyers[buyers.length + 1];
		
		for (int i = 0; i < buyers.length; i++) {
			newBuyerArr[i] = buyers[i]; 
			newBuyerArr[buyers.length] = addedBuyer;
		}
		
		return newBuyerArr;
	}
	
	
	//new added Seller array
	public static Seller[] newSeller(String loginID, String password, String name) {
		Seller addedSeller = new Seller(loginID, password, name);
		
		Seller[] newSellerArr = new Seller[buyers.length + 1];
		
		for (int i = 0; i < sellers.length; i++) {
			newSellerArr[i] = sellers[i]; 
			newSellerArr[sellers.length] = addedSeller;
		}
		
		return newSellerArr;
	}
	
	//delete users for admin
	public static void deleteUsers(Admin admin, Scanner in) {
		int userIn = -1;

		do {
			try {
				System.out.println("\nWhich user profile are you trying to delete from?");
				System.out.println("1. Admin");
				System.out.println("2. Buyer");
				System.out.println("3. Seller");
				
				System.out.print("\nEnter your option: ");
				userIn = in.nextInt();
				
				int profileToDelete;

				switch (userIn) {
					case 1:
						System.out.println("Here are the admin profiles currently available in the system.");
						for (int i = 0; i < admins.length; i++) {
							System.out.println( i + ". " + admins[i].getLoginID());
						}
						
						System.out.print("Please input the numeric number corresponding to the unique ID of the profile that you wish to delete: ");
						profileToDelete = in.nextInt();

						Admin[] newAdminArr = new Admin[admins.length - 1];
						
						for (int i = 0, j = 0; i < admins.length; i++) {
							if (admins[profileToDelete].getLoginID().equals(admins[i].getLoginID())) {
								continue;
							}
							newAdminArr[j++] = admins[i];	
						}
						
						admins = newAdminArr;
						
						System.out.println("Sucessfully Deleted!");
						
						adminMenu(admin, in);

						break;
					case 2:
						System.out.println("Here are the buyer profiles currently available in the system.");
						for (int i = 0; i < buyers.length; i++) {
							System.out.println( i + ". "+ buyers[i].getLoginID());
						}
						
						System.out.print("Please input the numeric number corresponding to the unique ID of the profile that you wish to delete: ");
						profileToDelete = in.nextInt();
						
						Buyers[] newBuyerArr = new Buyers[buyers.length - 1];
						
						for (int i = 0, j = 0; i < buyers.length; i++) {
							if (buyers[profileToDelete].getLoginID().equals(buyers[i].getLoginID())) {
								continue;
							}
							newBuyerArr[j++] = buyers[i];	
						}
						
						buyers = newBuyerArr;
						
						System.out.println("Sucessfully Deleted!");
						
						adminMenu(admin, in);
						break;
					case 3:
						System.out.println("Here are the seller profiles currently available in the system.");
						for (int i = 0; i < sellers.length; i++) {
							System.out.println( i + ". "+ sellers[i].getLoginID());
						}
						
						System.out.print("Please input the numeric number corresponding to the unique ID of the profile that you wish to delete: ");
						profileToDelete = in.nextInt();
						
						Seller[] newSellerArr = new Seller[sellers.length - 1];
						
						for (int i = 0, j = 0; i < sellers.length; i++) {
							if (sellers[profileToDelete].getLoginID().equals(sellers[i].getLoginID())) {
								continue;
							}
							newSellerArr[j++] = sellers[i];	
						}
						
						sellers = newSellerArr;
						
						System.out.println("Sucessfully Deleted!");
						
						adminMenu(admin, in);
						break;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("\nYou did not enter a numeric value! Please try again.\n");
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println("\nA general error has occured. Here is the error message: \n" + e);
			}	
		} while (userIn < 1 || userIn > 3);

	}
	
	//view and/or edit menu for admin
	public static void viewOrEdit(Admin admin, Scanner in) {
		bookCatalogue();
		
		int userIn = -1;
		int userChoice;
		
		do {
			System.out.println("Do you wish to edit one of the books available?");
			System.out.println("1. Yes");
			System.out.println("2. No. Exit Back to Main Menu");
			System.out.print("Enter an Option: ");
			userIn = in.nextInt();
			
			boolean isValid = false;
			
				
				switch (userIn) {
				
				case 1:
					do {
						System.out.println("\nEnter the book ID that you wish to edit on");
						System.out.print("Enter your option: ");
						userChoice = in.nextInt();
						
						for (Books b: bookArr) {
							if (b.getBookID() == userChoice) {
								isValid = true;
							}
						}
						
						if (isValid) {
							editMenu(admin, in , userChoice);
							break;
						}
						else {
							System.out.println("\nThere does not exist such book within the system. Please try again.");
						}
					} while (!isValid);
					break;
				case 2:
					adminMenu(admin, in);
					break;
				}
			
		} while (userIn < 1 || userIn > 2);
	}
	
	public static void editMenu(Admin admin, Scanner in, int userInput) {

		int userIn = -1;
		String newBookName;
		double newPrice;
		int newQty;
		
		do {
			System.out.println("\nWhich of this do you wish to edit for Book ID: " + userInput + "?");
			System.out.println("1. Book Title");
			System.out.println("2. Price");
			System.out.println("3. Quantity in Stock");
			
			System.out.print("Enter an Option: ");
			userIn = in.nextInt();
			
			switch (userIn) {
				case 1:
					in.nextLine();
					System.out.println("What is the new title for this book?");
					System.out.print("Enter an option: ");
					newBookName = in.nextLine();
					
					for (Books b: bookArr) {
						if (b.getBookID() == userInput) {
							b.setTitle(newBookName);
						}
					}
					
					System.out.println("\nSucessfully edited! Here's a preview: ");
					for (Books b: bookArr) {
						if (b.getBookID() == userInput) {
							System.out.println(b);
						}
					}
					
					adminMenu(admin, in);
					break;
				case 2:
					System.out.println("What is the new price for this book?");
					System.out.print("Enter an option: ");
					newPrice = in.nextDouble();
					
					for (Books b: bookArr) {
						if (b.getBookID() == userInput) {
							b.setPrice(newPrice);
						}
					}
					
					System.out.println("\nSucessfully edited! Here's a preview: ");
					for (Books b: bookArr) {
						if (b.getBookID() == userInput) {
							System.out.println(b);
						}
					}
					
					adminMenu(admin, in);
					break;
					
				case 3:
					System.out.println("What is the new quantity in stock for this book?");
					System.out.print("Enter an option: ");
					newQty = in.nextInt();
					
					
					for (Books b: bookArr) {
						if (b.getBookID() == userInput) {
							b.setTotalQuantity(newQty);
						}
					}
					
					System.out.println("\nSucessfully edited! Here's a preview: ");
					for (Books b: bookArr) {
						if (b.getBookID() == userInput) {
							System.out.println(b);
						}
					}
					
					adminMenu(admin, in);
					
					break;
			}
		} while (userIn < 1 || userIn > 3);
	}

	//buyer menu
	public static void buyerMenu(Buyers buyer, Scanner in) { 
		int userIn = -1;
		do {
			try {
				System.out.println("\nWelcome back " + buyer.getName() + "!" + "\n");
				System.out.println("What would you like to do?");
				System.out.println("1. Browse Current Book Catalogues");
				System.out.println("2. View Purchase History");
				System.out.println("3. Exit the store.");
				
				System.out.print("\nEnter your option: ");
				userIn = in.nextInt();
				
				
				switch(userIn) {
					case 1: 
						bookCatalogue();
						
						System.out.println("Do you wish to start purchasing books?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						
						userIn = in.nextInt();
						
						if (userIn == 1) {
							purchaseMenu(buyer, in);
							break;
						}
						else if (userIn == 2){
							buyerMenu(buyer, in);
						}
						else {
							System.out.println("You did not enter a valid input. Please try again.");
						}
						break;
					case 2:
						System.out.println(buyer);
						in.nextLine();
						buyerMenu(buyer, in);
						break;
					case 3:
						System.out.println("Thank you for shopping with us and have a nice day " + buyer.getName() + "!" + "\n");
						userLogin(in);
						in.nextLine();
						break;

				}
			}
			catch (InputMismatchException e) {
				System.out.println("\nYou did not enter a numeric value! Please try again.\n");
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println("A general error has occured. Here is the error message: \n" + e);
			}
		} while (userIn < 1 || userIn > 2);
	}
	
	//purhasing menu
	public static void purchaseMenu(Buyers buyer, Scanner in) {
		
		int userIn = -1;
		int maxBooks = -1;
		int bookChoiceID;
		int bookQty;
		
		do {
			try {
				bookCatalogue();
				System.out.println("How many books do you wish to buy?");
				maxBooks = in.nextInt();
//				
				String tempBooks[] = new String[maxBooks];

				for (int i = 0; i < tempBooks.length; i++) {
					System.out.println("Please enter the Book's ID that you wish to buy.");
					System.out.print("Enter your option: ");
					bookChoiceID = in.nextInt();
					
					System.out.println("How many do you wish to buy from this book?");
					System.out.print("Enter your option: ");
					bookQty = in.nextInt();
					
					for (Books b: bookArr) {
						if (b.getBookID() == bookChoiceID) {
							tempBooks[i] = b.getTitle(); //add to the titles that this customer has purchased
							b.setTotalSold(bookQty + b.getTotalSold()); //total quantity sold as a result
							buyer.setTotalDue( (bookQty * b.getPrice()) + b.getPrice());
						}
					}
				}
				
				buyer.setTotalBought(maxBooks + buyer.getTotalBought());
				
				if (buyer.getBooksBoughtArr() == null) {
					buyer.setBooksBoughtArr(tempBooks);
				} 
				else  {
					
					int tLen = tempBooks.length;
					int bLen = buyer.getBooksBoughtArr().length;
					
					String[] newArr = new String[tLen + bLen];
					System.arraycopy(tempBooks, 0, newArr, 0, tLen);
					System.arraycopy(buyer.getBooksBoughtArr(), 0, newArr, tLen, bLen);
					
					buyer.setBooksBoughtArr(newArr);
				}
				
				System.out.println("\nSucessfully purchased! Here is a preview of your purchase");
				System.out.println(buyer);
				
				int continueInput = -1;
				do {
					try {
						System.out.println("Do you wish to purchase more?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.print("Enter an option: ");
						continueInput = in.nextInt();
						
						switch (continueInput) {
							case 1:
								purchaseMenu(buyer, in);
								break;
							case 2:
								buyerMenu(buyer, in);
								break;
							default:
								System.out.println("You did not enter a valid input! Please try again.");
								break;
						}
					}
					catch (InputMismatchException e) {
						System.out.println("\nYou did not enter a numeric value! Please try again.\n");
						in.nextLine();
					}
					catch (Exception e) {
						System.out.println("A general error has occured. Here is the error message: \n" + e);
					}
				} while (continueInput > 2 || continueInput < 1);
			}
			catch (InputMismatchException e) {
				System.out.println("\nYou did not enter a numeric value! Please try again.\n");
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println("A general error has occured. Here is the error message: \n" + e);
			}
		} while (userIn != 0);
	}
	
	//book catalogue menu
	public static void bookCatalogue() {
		System.out.println(); // \n
		
		for (Books b: bookArr) {
			System.out.println(b);
		}
		
	}
	
	//seller menu
	public static void sellerMenu(Seller seller, Scanner in) {
		int userIn = -1;
		int goBackMenu = -1;
		
		do {
			try {
				System.out.println("\nWelcome to the Seller Menu.");
				System.out.println("You are now logged in as: " + seller.getName() + "\n");
				
				System.out.println("1. View Customer's Purchase History");
				System.out.println("2. Check Current Stocks");
				System.out.println("3. Exit from this this menu");
				
				System.out.print("\nWhat would you like to do? Please enter an option: ");
				userIn = in.nextInt();
				
				switch (userIn) {
					case 1:
						System.out.println("\nHere are all the customers' purchase history");
						for (Buyers b: buyers) {
							System.out.println(b);
						}
						System.out.println("\n");
						in.nextLine();
						
						do {
							System.out.print("Input 0 to go back to the seller menu: ");
							goBackMenu = in.nextInt();
							
							switch (goBackMenu) {
								case 0:
									sellerMenu(seller, in);
									break;
								default:
									System.out.println("Please enter 0 to exit back to the seller menu");
									break;
							}
						}
						while (goBackMenu != 0);

					case 2:
						bookCatalogue();
						
						System.out.println("\n");
						in.nextLine();
						
						do {
							System.out.print("Input 0 to go back to the seller menu: ");
							goBackMenu = in.nextInt();
							
							switch (goBackMenu) {
								case 0:
									sellerMenu(seller, in);
									break;
								default:
									System.out.println("Please enter 0 to exit back to the seller menu");
									break;
							}
						}
						while (goBackMenu != 0);
						break;
					case 3:
						System.out.println("\nLogging off. Good bye " + seller.getName() + "\n");
						userLogin(in);
						in.nextLine();
						break;
					default:
						System.out.println("\nYou did not enter a valid input! Please try again.");
						break;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("\nYou did not enter a numeric value! Please try again.\n");
				in.nextLine();
			}
			catch (Exception e) {
				System.out.println("A general error has occured. Here is the error message: \n" + e);
			}
		} while(userIn < 1 || userIn > 4);
	}
}

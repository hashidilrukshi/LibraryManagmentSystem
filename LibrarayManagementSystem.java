import java.util.Scanner;
import java.util.ArrayList;



class LibrarayManagementSystem{
	public static void main(String[] args){
		Library li = new Library(); 
		Scanner scanner = new Scanner(System.in); 
		int choice; 

		do{
	
            		System.out.println("01--Add new book");
            		System.out.println("02--Display available books");
            		System.out.println("03--Borrow a book");
            		System.out.println("04--Return a book");
            		System.out.println("05--Exit");
            		System.out.println("\n");
			
			
			System.out.print("Enter your choice :");
            		choice = Integer.parseInt(scanner.nextLine());

			


			switch(choice){
				case 1:
					System.out.println("Book Details"); 

					System.out.print("Title : ");
					String title = scanner.nextLine();

					System.out.print("Authour Name : ");
					String author = scanner.nextLine();
		
					System.out.print("ISBN Number : ");
					String ISBN = scanner.nextLine();
	
					Book books = new Book(title, author, ISBN);
					li.addBook(books);


					break;	

				case 2:
					
					li.displayAvailable(); 
					System.out.println("\n");
					break;

				case 3:
					System.out.print("Borrow a book : "); 
					String ISBNborrowBook = scanner.nextLine();

					if(li.borrowBook(ISBNborrowBook)){
			                        System.out.println("\n");
						System.out.println("Successfully borrowed....");  
                                                System.out.println("\n");
					}
					else{
                                                System.out.println("\n");
						System.out.println("Not available now...."); 
                                                System.out.println("\n"); 
					}

					System.out.println("\n");
		
					break;

				case 4:
					System.out.print("Enter ISBN Number for return Book: "); 
					String ISBNreturnBook = scanner.nextLine();

					if(li.returnBook(ISBNreturnBook)){
                                                System.out.println("\n");
						System.out.println("Successfully returned........."); 
                                                System.out.println("\n");
					}
					else{
                                                System.out.println("\n");
						System.out.println("Invalid ISBN number, Sorry Pleace check........."); 
                                                System.out.println("\n"); 
					}

					break;

				case 5:
					System.out.println("Exit..............Thank You...........Bye!");
					break;

				default:
					System.out.println("Invalid choice");
				}
			}while(choice !=5);

	}
}

class Book{
	private String title;   
	private String author;
	private String ISBN;
	private boolean available;
	
	public Book(String title, String author, String ISBN){ 
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.available = true;
	}

	public String gettitle(){   
		return title;
	}

	public String getauthor(){   
		return author;
	}

	public String getISBN(){     
		return ISBN;
	}

	public boolean isAvailable(){  
		return available;
	}

	public void setAvailable(boolean available){  
		this.available = available;
	}

	public String toString(){       
		return String.format("| %-20s | %-30s | %-20s | %-20s " , "BOOK",title,author,ISBN);
	}

}




class FictionBook extends Book{
	public FictionBook(String title, String author, String ISBN){  
		super(title, author, ISBN);
	}
}


class NonFictionBook extends Book{
	public NonFictionBook(String title, String author, String ISBN){  
		super(title, author, ISBN);
	}
}




class Library{
	private ArrayList<Book> books = new ArrayList<>();  

	
	public Library(){

		Book Book1 = new FictionBook("Jane Eyre", "Charlotte Bronte", "788990988");
		Book Book2 = new FictionBook("Moby Dick", "Herman Melville", "788990100");
		Book Book3 = new FictionBook("On the Road", "Jack Kerouac", "788990970");
		Book Book4 = new NonFictionBook("Robinson Crusoe", "Daniel Defoe", "788990980");
		Book Book5 = new NonFictionBook("The Curiosity", "Stephen P. Kiernan", "788990927");
                Book Book6 = new FictionBook("English Grammar in USE", "Raymond Murphy", "788990654");
		Book Book7 = new FictionBook("Refactoring", "Martin Fowler", "788990986");
		Book Book8 = new FictionBook("On the Road", "Jack Kerouac", "788990970");
		Book Book9 = new NonFictionBook("Clean Code", "Robert C. Martin", "788990310");
		Book Book10 = new NonFictionBook("The Color Purple", "Alice Walker", "788990567");


		books.add(Book1);
		books.add(Book2);
		books.add(Book3);
		books.add(Book4);
		books.add(Book5);
                books.add(Book6);
		books.add(Book7);
		books.add(Book8);
		books.add(Book9);
		books.add(Book10);
	}

	public void addBook(Book book){   
		books.add(book);
	}

	public void displayAvailable(){  
		System.out.println("Now Available Books"); 
		System.out.println("\n"); 
		for (int i=0; i<books.size(); i++){
			Book book = books.get(i);
			if (book.isAvailable()){
				System.out.println(book);
			}
		}
	}

	public boolean borrowBook(String ISBN){  
		for(int i=0; i<books.size(); i++){
			Book book = books.get(i);
			if (book.getISBN().equals(ISBN) && book.isAvailable()){  
				book.setAvailable(false);
				return true;
			}
		}
		return false;
	}

	public boolean returnBook(String ISBN){  
		for (int i=0; i<books.size(); i++){
			Book book = books.get(i);
			if (book.getISBN().equals(ISBN) && !book.isAvailable()){  
				book.setAvailable(true);
				return true;
			}
		}
		return false;
	}
}

class User{
	private int id;  

	private ArrayList<String> borrowBooks = new ArrayList<>();  

	public int getid(){  
		return id;
	}

	public ArrayList<String> getBorrowBooks(){  
		return borrowBooks;
	}

	public void borrowBook(String ISBN){  
		borrowBooks.add(ISBN);
	}

	
	public void returnBook(String ISBN){  
		borrowBooks.remove(ISBN);
	}
}




				
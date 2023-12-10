package Intern;
import java.util.HashMap;
import java.util.Scanner;
public class OnlineBookStore_simulation {
	HashMap<Integer,String> cart=new HashMap<>();

String[] Book=new String[]{"1984","To Kill a Mockingbird","The Great Gatsby","One Hundred Years of Solitude","Pride and Prejudice","The Catcher in the Rye","The Lord of the Rings","Harry Potter and the Sorcerer's Stone" ,"The Chronicles of Narnia: The Lion, the Witch, and the Wardrobe" ,"Brave New World"};
String[] Author=new String[]{"George Orwell","Harper Lee"," F. Scott Fitzgerald","Gabriel García Márquez","Jane Austen","J.D. Salinger"," J.R.R. Tolkien","J.K. Rowling","C.S. Lewis","Aldous Huxley"};

public void getUser()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Username:");
	String u_name=sc.nextLine();
	System.out.println("Enter Password:");
	String pass_key=sc.nextLine();
}
public void display()
{
	for (int i=0; i<Book.length; i++)
	{
		System.out.println(i+":"+Book[i]+" by "+Author[i]);
		}
}
public void writeReview()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Write a review");
	String rev=sc.nextLine();
}
public void addBook(int id)
{
	cart.put(1,Book[id]);
	System.out.println("Book in cart:"+cart.values());
}
public void bill()
{
	int c = 0;
	for(String value: cart.values()) 
	{
		c++;
	}
	if(c==0)
		{
		System.out.println("Your Cart is Empty");
		}
	int pay = c * 500;
	System.out.println("Final price is= " + pay);
}
public void find(String name)
{
	for(int i=0;i<Book.length;i++)
	{
		if(name.equals(Book[i]))
		{
			System.out.println("Book Found");
			break;
			}
		}
	System.out.println("Book is not available");
}
public static void main(String[] args)
{
	OnlineBookStore_simulation u1=new OnlineBookStore_simulation();
	Scanner sc=new Scanner(System.in);
	u1.getUser();

	System.out.println("Logged In");
	int option=0;
	while(option<5) 
	{
		System.out.println("\n1.View Books\n2.Add to Cart\n3.CheckAvailability\n4.Bill\n5.Exit");
		option=sc.nextInt();
		if (option == 1)
		{
			u1.display();
			} 
		else if (option == 2)
		{
			System.out.println("Enter id");
			int bid = sc.nextInt();
			u1.addBook(bid);
			}
		else if(option==3)
		{
			new Thread (() -> u1.find("To Kill a Mockingbird")).start();
			new Thread(() -> u1.find("Pride and Prejudice")).start();
			}
		else if (option == 4)
		{
			u1.bill();
		}
	}
}
}

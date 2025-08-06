package aaa;
import java.util.Scanner;
public class transaction {
String status;
String trnsDate;
int trnsAmount;
public void input(Scanner s,String status)
{
	System.out.println("Enter transaction amount : ");
	trnsAmount=s.nextInt();
	System.out.println("Enter transaction date : ");
	trnsDate=s.next();
	this.status=status;
}
public void display()
{
	System.out.println("Transaction status is : "+status
			+"\nTransaction amount is : "+trnsAmount
			+"\nTransaction date is : "+trnsDate);
}
}

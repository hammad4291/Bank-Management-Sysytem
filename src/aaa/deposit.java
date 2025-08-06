package aaa;

import java.util.Scanner;

public class deposit {
int depAmt;
String depDate;
deposit next;
public void input(int amt , String date)
{
	depAmt=amt;
	depDate=date;
}
public void display()
{
	System.out.println("Deposit amount is : "+depAmt
			+"\nDeposit date is : "+depDate);
}

}

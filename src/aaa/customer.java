package aaa;

import java.util.Scanner;

public class customer {
	String cusName;
	int savings;
	String actNum;
	customer next;
	transaction[] no = new transaction[10];
	customer()
	{
	for(int i=0 ; i<10 ; i++)
	{
	no[i]= new transaction();
	}
	}
	public void input(Scanner s)
	{
		System.out.println("Enter customer name :");
		cusName=s.next();
		System.out.println("Enter saving of customer : ");
		savings=s.nextInt();
		System.out.println("Enter customer account number : ");
		actNum=s.next();
	}
	public void display()
	{
		System.out.println("Customer name is : "+cusName
				+"\nCustomer ballance is : "+savings
				+"\nCustomer account no is : "+actNum);
	}
////////////////////////////////////////////////////////
int c=0,d=0,f=0;
public String getTransferDate()
{
	String d =no[--c].trnsDate;
	c++;
	return d;
}
public int trans(Scanner s,String sta)
{
if(c==d && f==1)
{
no[c].input(s,sta);
int amt=0;
if(savings>no[c].trnsAmount)
{	
savings=savings-no[c].trnsAmount;
amt=no[c].trnsAmount;
c++;
}
else
{
	System.out.println("Ballance is less than transfer amount!");
}
return amt;
}
else
{
no[c].input(s,sta);
int amt=0;
if(savings>no[c].trnsAmount)
{	
savings=savings-no[c].trnsAmount;
amt=no[c].trnsAmount;
c++;
}
else
{
	System.out.println("Ballance is less than transfer amount!");
}
if(c==10)
{
c=0;
f=1;
}
return amt;
}
}
public void displayTransactions() {
if(f==0) {
if(c==0) 
System.out.println("No transactions!");
else {
for(int i=d;i<c;i++) 
no[i].display();
} 
}
else
{
for(int i=d;i<10;i++) 
no[i].display();
for(int i=0;i<c;i++) 
no[i].display();
}
}
public void displayTransactionsDate(Scanner s) {
	System.out.println("Enter date :");
	String date=s.next();
if(f==0) {
if(c==0) 
System.out.println("No transactions!");
else {
for(int i=d;i<c;i++)
	if(no[i].trnsDate.equals(date))
	{
		no[i].display();
	}
} 
}
else
{
for(int i=d;i<10;i++) 
	if(no[i].trnsDate.equals(date))
	{
		no[i].display();
	}
for(int i=0;i<c;i++) 
	if(no[i].trnsDate.equals(date))
	{
		no[i].display();
	}
}
}

public void displayTransactionsTransfer(Scanner s) {

if(f==0) {
if(c==0) 
System.out.println("No transactions!");
else {
for(int i=d;i<c;i++)
	if(no[i].status.equals("transfer"))
	{
		no[i].display();
	}
} 
}
else
{
for(int i=d;i<10;i++) 
	if(no[i].status.equals("transfer"))
	{
		no[i].display();
	}
for(int i=0;i<c;i++) 
	if(no[i].status.equals("transfer"))
	{
		no[i].display();
	}
}
}
public void displayTransactionsWithdraw(Scanner s) {

if(f==0) {
if(c==0) 
System.out.println("No transactions!");
else {
for(int i=d;i<c;i++)
	if(no[i].status.equals("withdraw"))
	{
		no[i].display();
	}
} 
}
else
{
for(int i=d;i<10;i++) 
	if(no[i].status.equals("withdraw"))
	{
		no[i].display();
	}
for(int i=0;i<c;i++) 
	if(no[i].status.equals("transfer"))
	{
		no[i].display();
	}
}
}

public void displayPrevious()
{
	no[--c].display();
	c++;
}

deposit start;

public void deposit(int amt , String date)
{
	deposit b = new deposit();
	b.input(amt,date);
	b.next=start;
	start=b;
	savings=savings+b.depAmt;
}

public void displayAllDep() {
	if(start==null)
	{
		System.out.println("Empty List!");
	}
	else {
		deposit t =start;
		while(t!=null)
		{
			t.display();
			t=t.next;
		}
	}
}
public void displayByDate(Scanner s)
{
	if(start==null)
	{
		System.out.println("Empty List!");
	}
	else {
		System.out.println("Enter date : ");
		String date=s.next();
		deposit t =start;
		while(t!=null)
		{
			if(t.depDate.equals(date))
			{
				t.display();
				break;
			}
			t=t.next;
		}
	}
}
public void displayTopDep()
{
	if(start==null)
	{
		System.out.println("Empty List!");
	}
	else {
		start.display();
	}
}
}//class

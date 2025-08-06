package aaa;

import java.util.Scanner;

public class customer_LL {
customer cusStart;
public void push(Scanner obj)
{
	customer b = new customer();
	b.input(obj);
	b.next=cusStart;
	cusStart=b;
}
public void Remove(String act) {
    if (cusStart == null) {
        System.out.println("Empty List!");
    }
    else if (cusStart.actNum.equals(act)) 
    {
        cusStart = cusStart.next;
    } 
    else 
    {
        customer last = cusStart;
        customer first = cusStart.next;
        while (first != null && first.actNum.equals(act)) {
            last = last.next;
            first = first.next;
        }
        if (first != null) {
            last.next = first.next;
        } else {
            System.out.println("Account not found!");
        }
    }
}

public void displayAll() {
	if(cusStart==null)
	{
		System.out.println("Empty List!");
	}
	else {
		customer t =cusStart;
		while(t!=null)
		{
			t.display();
			t=t.next;
		}
	}
}
public void displayTop()
{
	if(cusStart==null)
	{
		System.out.println("Empty List!");
	}
	else {
		cusStart.display();
	}
}
public void transactions(Scanner s,String sta)
{
	System.out.println("Enter account number : ");
	String actFrom=s.next();
	if(cusStart==null)
	{
		System.out.println("Empty List!");
	}
	else 
	{
		if(sta.equals("transfer")) {
		System.out.println("Enter account number you want to transfer amount : ");
		String actTo=s.next();
		customer temp =cusStart;
		customer to=null;
		customer from=null;
		int f=0,t=0;
		while(temp!=null)
		{
			if(temp.actNum.equals(actFrom)&& f==0)
			{
				from=temp;
				f++;
			}
			if(temp.actNum.equals(actTo)&& t==0)
			{
				to=temp;
				t++;
			}
			temp=temp.next;
		}
		if(f==0&&t==0)
		{
			System.out.println("Both account no's are invalid!");
		}
		else if(f==1&&t==0)
		{
			System.out.println("Transfer to account no is invalid!");
		}
		else if(f==0 && t==1)
		{
			System.out.println("Transfer from account no is invalid!");
		}
		else if(f==1 && t==1)
		{
			int amt=0;
			amt =from.trans(s, sta);
			to.savings=to.savings+amt;
			if(amt!=0)
			to.deposit(amt,from.getTransferDate());
		}
		}
		else
		{
			customer t = cusStart;
			while(t!=null)
			{
				if(t.actNum.equals(actFrom))
				{
					t.trans(s,sta);
					break;
				}
				t=t.next;
			}
			if(t==null)
			{
				System.out.println("Invalid account no");
			}
		}
	}
}
public void SearchCus(Scanner s,int c)
{
	if(cusStart==null)
	{
		System.out.println("No customers added : ");
	}
	else 
	{
		System.out.println("Enter account number : ");
		String act=s.next();
		customer t =cusStart;
		while(t!=null)
		{
			if(t.actNum.equals(act))
			{
				switch(c)
				{
				case 1:
				t.displayTransactions();
				break;
				case 2:
					t.displayTransactionsDate(s);
					break;
				case 3:
					t.displayTransactionsTransfer(s);
					break;
				case 4:
					t.displayTransactionsWithdraw(s);
					break;
				case 5:
					t.displayAllDep();
					break;
				case 6:
					t.displayTopDep();
					break;
				case 7:
					t.displayByDate(s);
					break;
				case 8:
					t.displayPrevious();
					break;
				case 9:
					t.display();
					break;
				}
				break;
			}
			t=t.next;
		}
		if(t==null)
		{
			System.out.println("Invalid account no :");
		}
	}

}
//////////////////////////////
public void depAmt(int amt,String date ,Scanner s)
{
	if(cusStart==null)
	{
		System.out.println("NO deposits!");
	}
	else {
		System.out.println("Enter account no : ");
		String antno=s.next();
		customer t =cusStart;
		while(t!=null)
		{
			if(t.actNum.equals(antno))
			{
				t.deposit(amt,date);
				break;
			}
			t=t.next;
		}
		if(t==null)
		{
			System.out.println("Invalid account number!");
		}
	}
}
}//class

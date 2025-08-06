package aaa;
import java.util.Scanner;
public class MainClass {
public static int menu(Scanner s)
{
	int r;
	do {
		System.out.println("1 :: Enter a Customer : "
				+ "\n2 :: Remove Customer : "
				+ "\n3 :: Deposit Amount : "
				+ "\n4 :: Withdraw Amount : "
				+ "\n5 :: Transfer Amount : "
				+ "\n6 :: Show transaction history  : "
				+ "\n7 :: Show transaction by Date : "
				+ "\n8 :: Show transfer History : "
				+ "\n9 :: Show withdraw history : "
				+ "\n10 :: Show Deposit History : "
				+ "\n11 :: Show previous deposit : "
				+ "\n12 :: Show deposit by date : "
				+ "\n13 :: Show previous transaction : "
				+ "\n14 :: Show all Customers : "
				+ "\n15 :: Show customer by Account no : "
				+ "\n16 :: Display recently added customer : ");
		r=s.nextInt();
	}while(r!=1 && r!=2 && r!=3 && r!=4 && r!=5 && r!=6 && r!=7 && r!=8 && r!=9 && r!=10 && r!=11 && r!=12 && r!=13 && r!=14 && r!=15 && r!=16);
	return r;
}

public static void main(String [] args)
{
	Scanner obj = new Scanner(System.in);
	
	customer_LL cus = new customer_LL();
	
	do {
		int ch = menu(obj);
		switch(ch)
		{
		case 1:
			cus.push(obj);
			break;
		case 2:
			System.out.println("Enter the account number of customer : ");
			String act=obj.next();
			cus.Remove(act);
			break;
		case 3:
			System.out.println("Enter deposit amount :");
			int amt=obj.nextInt();
			System.out.println("Enter deposit date : ");
			String date=obj.next();
			cus.depAmt(amt,date,obj);
			break;
		case 4:
			cus.transactions(obj, "withdraw");
			break;
		case 5:
			cus.transactions(obj, "transfer");
			break;
		case 6:
			cus.SearchCus(obj,1);//Show transaction history
			break;
		case 7:
			cus.SearchCus(obj,2);//Show transaction by Date
			break;
		case 8:
			cus.SearchCus(obj,3);//Show transfer History
			break;
		case 9:
			cus.SearchCus(obj,4);//Show withdraw history
			break;
		case 10:
			cus.SearchCus(obj,5);//Show Deposit History
			break;
		case 11:
			cus.SearchCus(obj,6);//Show previous deposit
			break;
		case 12:
			cus.SearchCus(obj,7);//Show deposit by date
			break;
		case 13:
			cus.SearchCus(obj,8);//Show previous transaction
			break;
		case 14:
			cus.displayAll();
			break;
		case 15:
			cus.SearchCus(obj,9);//Show customer by Account no
			break;
		case 16:
			cus.displayTop();
			break;
		}
	}while(true);
}

}//class

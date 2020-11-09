package bookstore;

import java.util.Scanner;

public class ImpUtility {

	public static void main(String[] args) {
		int qte;
		int unitPrice;
		Scanner sq = new Scanner(System.in);
		System.out.println("enter the quantity");
		qte = sq.nextInt();
		System.out.println("enter the unit price");
		unitPrice = sq.nextInt();
		Utility u = new Utility();
		System.out.println("Total price = " + u.calculateTotalPrice(qte, unitPrice));
	}

}

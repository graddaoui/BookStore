package step1;

import java.util.Scanner;

public class UtilityImplementation {
	private static Scanner sq;

	public static void main(String[] args) {
		int qte;
		double unitPrice;
		double prixTotal;
		sq = new Scanner(System.in);
		System.out.println("enter the quantity");
		qte = sq.nextInt();
		System.out.println("enter the unit price");
		unitPrice = sq.nextDouble();
		Utility u = new Utility();
		prixTotal = u.calculateTotalPrice(qte, unitPrice);
		System.out.println("Total price = " + prixTotal);
	}
}

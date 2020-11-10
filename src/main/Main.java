package main;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import dao.DaoBook;
import entities.Book;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) throws SQLException {

		// * * * Connexion * * *

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookStore", "root", "12345");
			System.out.println("Vous �tes connect� !");
		}

		catch (SQLException e) {
			throw new Error("Hmm.. il'ya un probl�me de connexion ! ", e);
		}

		Statement stmt = conn.createStatement();
		DaoBook daoBook = new DaoBook(stmt);
		sc = new Scanner(System.in);
		int choix;

		System.out.println("1 : Ajouter un nouveau livre.");
		System.out.println("2 : Afficher la liste des livres.");
		System.out.println("0 : Quitter.");

		System.out.println("Donner votre choix");
		choix = sc.nextInt();

		while (choix != 0) {
			switch (choix) {

			case 1:
				System.out.println("Donner le titre du livre : ");
				String title = sc.nextLine();
				System.out.println("Donner le prix du livre");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.println("Donner le nom de l'auteur du livre : ");
				String author = sc.nextLine();
				System.out.println("Donner la date de sortie du livre : ");
				String date = sc.nextLine();

				Book book = new Book();
				book.setAuthor(author);
				book.setDate(Date.valueOf(date));
				book.setPrice(price);
				book.setTitle(title);

				daoBook.addBook(book);
				System.out.println("Vous avez ajouter en succ�es un nouveau livre.");

				break;

			case 2:
				System.out.println("La liste des livres : ");
				List<Book> listOfBooks = daoBook.listBook();
				listOfBooks.forEach((b) -> System.out.println(b));
				break;
			default:
				System.out.println("Choix invalide");

			}
			
			System.out.println("Voulez vous continuez ? Si oui : tapez 1 pour ajouter, 2 pour afficher, sinon tapez 0 pour quitter!");
			choix = sc.nextInt();
			sc.nextLine();
		}
		
		System.out.println("Merci d'utiliser notre programme ! ");
		conn.close();
		System.out.println("All copyrights reserved to NRG Team");

	}

}

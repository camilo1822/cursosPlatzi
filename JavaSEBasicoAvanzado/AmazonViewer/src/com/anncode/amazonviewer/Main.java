package com.anncode.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import com.anncode.amazonviewer.model.Book;
import com.anncode.amazonviewer.model.Chapter;
import com.anncode.amazonviewer.model.Magazine;
import com.anncode.amazonviewer.model.Movie;
import com.anncode.amazonviewer.model.Serie;
import com.anncode.makereport.Report;
import com.anncode.util.AmazonUtil;

/**
 * <h1>Amazon viewer</h1> Programa para visualizar contenido, y generar
 * reportes.
 * <p>
 * Tomado del curso avanzado de JAVA SE de platzi.
 * 
 * @author CAMILO
 * @version 1.0.0
 * @since 2019
 *
 */
public class Main {

	public static void main(String[] args) {
		// Film es abstracta entonces no la puedo instanciar dierctamente, puedo
		// intanciarla de una clase que la herede
		// Ejemplo de polimorfismo
		/*
		 * Film film = new Movie("", "", "", 1, (short) 1999); film.view(); Film film2 =
		 * new Chapter("", "", "", 1, (short) 1999, 1, new Serie("", "", "", 1, 25));
		 * film2.view();
		 */
		showMenu();

	}

	public static void showMenu() {
		int exit = 0;
		do {

			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");
			System.out.println("Selecciona el número de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");

			// Leer la respuesta del usuario
			int response = AmazonUtil.validateUserResponseMenu(0, 6);

			switch (response) {
			case 0:
				// salir
				exit = 0;
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				exit = 1;
				break;
			case 6:
				// Date date = new Date();
				makeReport(new Date());
				exit = 1;
				break;

			default:
				System.out.println();
				System.out.println("....¡¡Selecciona una opción!!....");
				System.out.println();
				exit = 1;
				break;
			}

		} while (exit != 0);
	}

	static ArrayList<Movie> movies = new ArrayList<>();

	public static void showMovies() {
		movies = Movie.makeMoviesList();
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();

			// Genra entero unico inicializamos en 1
			AtomicInteger atomicInteger = new AtomicInteger(1);
			// reemplazar foreaach con lambdas
			movies.forEach(m -> System.out
					.println(atomicInteger.getAndIncrement() + ". " + m.getTitle() + " Visto: " + m.isViewed()));

//			for (int i = 0; i < movies.size(); i++) { // 1. Movie 1
//				System.out.println(i + 1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
//			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, movies.size());

			if (response == 0) {
				exit = 0;
				showMenu();
				break;
			}
			if (response > 0) {
				Movie movieSelected = movies.get(response - 1);
				movieSelected.view();
//				movieSelected.setViewed(true);
//				Date dateI = movieSelected.startToSee(new Date());
//
//				for (int i = 0; i < 100000; i++) {
//					System.out.println("..........");
//				}
//
//				// Termine de verla
//				movieSelected.stopToSee(dateI, new Date());
//				System.out.println();
//				System.out.println("Viste: " + movieSelected);
//				System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");
			}

		} while (exit != 0);

	}

	static ArrayList<Serie> series = Serie.makeSeriesList();

	public static void showSeries() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();

			for (int i = 0; i < series.size(); i++) { // 1. Serie 1
				System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, series.size());

			if (response == 0) {
				exit = 0;
				showMenu();
			}

			if (response > 0) {
				showChapters(series.get(response - 1).getChapters());
			}

		} while (exit != 0);
	}

	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();

			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { // 1. Chapter 1
				System.out.println(i + 1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: "
						+ chaptersOfSerieSelected.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());

			if (response == 0) {
				exit = 0;
			}

			if (response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
				chapterSelected.view();
//				chapterSelected.setViewed(true);
//				Date dateI = chapterSelected.startToSee(new Date());
//
//				for (int i = 0; i < 100000; i++) {
//					System.out.println("..........");
//				}
//
//				// Termine de verla
//				chapterSelected.stopToSee(dateI, new Date());
//				System.out.println();
//				System.out.println("Viste: " + chapterSelected);
//				System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
			}
		} while (exit != 0);
	}

	static ArrayList<Book> books = Book.makeBookList();

	public static void showBooks() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();

			for (int i = 0; i < books.size(); i++) { // 1. Book 1
				System.out.println(i + 1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).isReaded());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, books.size());

			if (response == 0) {
				exit = 0;
				showMenu();
			}

			if (response > 0) {
				Book bookSelected = books.get(response - 1);
				bookSelected.view();
//				bookSelected.setReaded(true);
//				Date dateI = bookSelected.startToSee(new Date());
//
//				for (int i = 0; i < 100000; i++) {
//					System.out.println("..........");
//				}
//
//				// Termine de verla
//				bookSelected.stopToSee(dateI, new Date());
//				System.out.println();
//				System.out.println("Leíste: " + bookSelected);
//				System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");
			}

		} while (exit != 0);
	}

	public static void showMagazines() {
		ArrayList<Magazine> magazines = Magazine.makeMagazineList();
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
			AtomicInteger atomicInteger = new AtomicInteger(1);
			magazines.forEach(mg -> System.out.println(atomicInteger.getAndDecrement() + ". " + mg.getTitle()));

//			for (int i = 0; i < magazines.size(); i++) { // 1. Book 1
//				System.out.println(i + 1 + ". " + magazines.get(i).getTitle());
//			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, 0);

			if (response == 0) {
				exit = 0;
				showMenu();
			}

		} while (exit != 0);
	}

	public static void makeReport() {

		Report report = new Report();
		report.setNameFile("reporte");
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		// String contentReport = "";
		StringBuilder contentReport = new StringBuilder();

		// Usamos el filter como un IF
		movies.stream().filter(m -> m.getIsViewed()).forEach(m -> contentReport.append(m.toString() + "\n"));

//		for (Movie movie : movies) {
//			if (movie.getIsViewed()) {
//				contentReport += movie.toString() + "\n";
//
//			}
//		}

		//Predicate<Serie> seriesViewed = s -> s.getIsViewed();
		//Consumer<Serie> serieEach = m -> contentReport.append(m.toString() + "\n");
		Consumer<Serie> serieEach = s -> {
			ArrayList<Chapter> chapters = s.getChapters();
			chapters.stream().filter(c -> c.getIsViewed()).forEach(c -> contentReport.append(c.toString() + "\n"));
		};
		series.stream().forEach(serieEach);
		
//		for (Serie serie : series) {
//			ArrayList<Chapter> chapters = serie.getChapters();
//			for (Chapter chapter : chapters) {
//				if (chapter.getIsViewed()) {
//					contentReport.append(chapter.toString() + "\n");
//
//				}
//			}
//		}

		books.stream().filter(b -> b.getIsReaded()).forEach(b -> contentReport.append(b.toString() + "\n"));
		
//		for (Book book : books) {
//			if (book.getIsReaded()) {
//
//			}
//		}

		report.setContent(contentReport.toString());
		report.makeReport();
		System.out.println("Reporte Generado");
		System.out.println();
	}

	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
		String dateString = df.format(date);
		Report report = new Report();

		report.setNameFile("reporte" + dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");

		SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
		dateString = dfNameDays.format(date);
		String contentReport = "Date: " + dateString + "\n\n\n";

		ArrayList<Movie> moviesDay = Movie.makeMoviesListByDay();
		for (Movie movie : moviesDay) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";

			}
		}

		for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					contentReport += chapter.toString() + "\n";

				}
			}
		}

		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport += book.toString() + "\n";

			}
		}
		report.setContent(contentReport);
		report.makeReport();

		System.out.println("Reporte Generado");
		System.out.println();
	}

}

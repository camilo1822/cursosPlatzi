package com.anncode.amazonviewer.model;

import java.util.ArrayList;

/**
 * Hereda de {@link Film}
 * 
 * @author CAMILO
 * @version 1.0.0
 * @since 2019
 *
 */
public class Serie extends Film {

	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;

	/**
	 * Constructor para crear una serie
	 * 
	 * @param title
	 * @param genre
	 * @param creator
	 * @param duration
	 * @param sessionQuantity
	 */
	public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
		super(title, genre, creator, duration);
		// TODO Auto-generated constructor stub
		this.sessionQuantity = sessionQuantity;
	}

	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n :: SERIE ::" + "\n Title: " + getTitle() + "\n Genero: " + getGenre() + "\n Year: " + getYear()
				+ "\n Creator: " + getCreator() + "\n Duration: " + getDuration();
	}

	public static ArrayList<Serie> makeSeriesList() {
		ArrayList<Serie> series = new ArrayList();

		for (int i = 1; i <= 5; i++) {
			Serie serie = new Serie("Serie " + i, "genero " + i, "creador " + i, 1200, 5);
			serie.setChapters(Chapter.makeChaptersList(serie));
			series.add(serie);

		}

		return series;
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
	}

}

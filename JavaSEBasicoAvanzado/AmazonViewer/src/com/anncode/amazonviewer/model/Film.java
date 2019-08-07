package com.anncode.amazonviewer.model;

/**
 * <h1>Film</h1> Film es una clase padre abstracta
 * <p>
 * Como es abstracta no pueden crearse intancias. Contiene el metodo abstracto
 * {@code view()} es obligatorio implementarlo.
 * 
 * @author CAMILO
 * @version 1.0.0
 * @since 2019
 *
 */
public abstract class Film {

	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;

	public Film() {
	}

	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String isViewed() {
		String visto = "";
		if (viewed == true) {
			visto = "Si";
		} else {
			visto = "No";
		}

		return visto;
	}

	public boolean getIsViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	/**
	 * {@code view()} es un metodo abstracto obligatorio de implementar.
	 */
	public abstract void view();

}

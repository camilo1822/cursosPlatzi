package com.anncode.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.anncode.amazonviewer.db.DataBase.*;

import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;
import com.anncode.util.AmazonUtil;

public interface MovieDAO extends IDBConnection {

	default Movie setMovieViwed(Movie movie) {

		try (Connection connection = connectToDB()) {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + TVIEWED + " (" + TVIEWED_ID_MATERIAL + "," + TVIEWED_ID_ELEMENT + ","
					+ TVIEWED_ID_USER + "," + TVIEWED_DATE + ")" + " VALUES(" + ID_MATERIALS[0] + "," + movie.getId()
					+ "," + TUSER_IDEUSUARIO + ",\""+AmazonUtil.getCurrentDate() + "\")";
			System.out.println(query);
			if (statement.executeUpdate(query) > 0) {
				System.out.println("Se marcó en visto");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return movie;
	}

	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList<>();
		try (Connection connection = connectToDB()) {
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(rs.getString(TMOVIE_TITLE), rs.getString(TMOVIE_GENRE),
						rs.getString(TMOVIE_CREATOR), Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(
						getMovieViewed(preparedStatement, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return movies;
	}

	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWED + " WHERE " + TVIEWED_ID_MATERIAL + "= ?" + " AND "
				+ TVIEWED_ID_ELEMENT + "= ?" + " AND " + TVIEWED_ID_USER + "= ?";
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_MATERIALS[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDEUSUARIO);
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return viewed;
	}
	
	private boolean getMovieViewedByDay(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWED + " WHERE " + TVIEWED_ID_MATERIAL + "= ?" + " AND "
				+ TVIEWED_ID_ELEMENT + "= ?" + " AND " + TVIEWED_ID_USER + "= ?" +" AND " + TVIEWED_DATE +"=\""+AmazonUtil.getCurrentDate()+"\"";
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ID_MATERIALS[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, TUSER_IDEUSUARIO);
			System.out.println(query);
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return viewed;
	}
	
	default ArrayList<Movie> readByDay() {
		ArrayList<Movie> movies = new ArrayList<>();
		try (Connection connection = connectToDB()) {
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(rs.getString(TMOVIE_TITLE), rs.getString(TMOVIE_GENRE),
						rs.getString(TMOVIE_CREATOR), Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(
						getMovieViewedByDay(preparedStatement, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return movies;
	}

}

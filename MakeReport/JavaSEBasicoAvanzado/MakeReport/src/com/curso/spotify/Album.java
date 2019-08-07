package com.curso.spotify;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private String singer;
	private List<Song> songs;

	static class Song {

		private String name;
		private String duration;

		static void playAlbum(List<Song> songs) {
			for(Song song : songs) {
				System.out.println("Estas ecuchando: " + song.getName());
			}
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	public static void main(String... args) {
		
		Album album = new Album();
		album.setSinger("Metallica");
		List<Song> songList = new ArrayList<>();
		Album.Song song;
		song = new Album.Song();
		song.setDuration("2:00");
		song.setName("Enter Sandman");
		songList.add(song);
		song = new Album.Song();
		song.setDuration("3:20");
		song.setName("One");
		songList.add(song);
		album.setSongs(songList);
		Song.playAlbum(songList);
		
	}

}

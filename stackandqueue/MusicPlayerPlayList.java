package stackandqueue;

import java.util.LinkedList;
import java.util.ListIterator;

class Song {
	private String title;
	private String artist;

	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return title + " by " + artist;
	}
}

public class MusicPlayerPlayList {
	private LinkedList<Song> playlist;
	private ListIterator<Song> iterator;
	private Song currentSong;

	public MusicPlayerPlayList() {
		playlist = new LinkedList<>();
		iterator = playlist.listIterator();
	}

	public void addSong(String title, String artist) {
		Song newSong = new Song(title, artist);
		iterator.add(newSong);
		if (currentSong != null && iterator.previousIndex() > 0) {
			iterator.previous();
		}
	}

	public void addSongAtPosition(String title, String artist, int position) {
		ListIterator<Song> tempIterator = playlist.listIterator(position);
		tempIterator.add(new Song(title, artist));
	}

	public void removeCurrentSong() {
		if (currentSong != null) {
			iterator.remove();
			if (iterator.hasNext()) {
				currentSong = iterator.next();
			} else if (iterator.hasPrevious()) {
				currentSong = iterator.previous();
				iterator.next(); 
			} else {
				currentSong = null;
			}
		}
	}

	public void playNext() {
		if (iterator.hasNext()) {
			currentSong = iterator.next();
		} else {
			System.out.println("You are at the end of the playlist.");
		}
	}

	public void playPrevious() {
		if (iterator.hasPrevious()) {
			currentSong = iterator.previous();
		} else {
			System.out.println("You are at the start of the playlist.");
		}
	}

	public void showPlaylist() {
		System.out.println("Playlist:");
		for (Song song : playlist) {
			System.out.println(song);
		}
	}

	public void showCurrentSong() {
		if (currentSong != null) {
			System.out.println("Currently playing: " + currentSong);
		} else {
			System.out.println("No song is currently playing.");
		}
	}

	public static void main(String[] args) {
		MusicPlayerPlayList musicPlayer = new MusicPlayerPlayList();

		musicPlayer.addSong("Song 1", "Artist 1");
		musicPlayer.addSong("Song 2", "Artist 2");
		musicPlayer.addSong("Song 3", "Artist 3");

		musicPlayer.playNext();
		musicPlayer.showCurrentSong();

		musicPlayer.addSongAtPosition("Song 4", "Artist 4", 1);

		musicPlayer.showPlaylist();

		musicPlayer.removeCurrentSong();
		musicPlayer.showCurrentSong();

		musicPlayer.playNext();
		musicPlayer.showCurrentSong();

		musicPlayer.showPlaylist();
	}
}

import java.util.Arrays;

class Playlist {
private final String[] songs;
private int count;

public Playlist(int capacity) {
    songs = new String[capacity];
    count = 0;
}

public void addSong(String song) {
    if (count < songs.length) {
        songs[count] = song;
        count++;
    }
}

public String[] getSongs() {
    return Arrays.copyOf(songs, count);
}

public int getSongCount() {
    return count;
}

}

public class PlaylistMain {
public static void main(String[] args) {
Playlist p = new Playlist(10);

    p.addSong("Song A");
    p.addSong("Song B");

    String[] copy = p.getSongs();

    System.out.println("Songs: " + Arrays.toString(copy));
    System.out.println("Song Count: " + p.getSongCount());

    copy[0] = "Hacked";

    System.out.println("Modified Copy: " + Arrays.toString(copy));
    System.out.println("Original Playlist: " + Arrays.toString(p.getSongs()));
}

}
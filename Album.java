import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String albumName;
    String artist;
    ArrayList<Song> songs;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Song findSong(String title)
    {
        for(Song s1 : songs)
        {
            if(s1.title.equals(title))
            {
                return s1;
            }
        }
        return null;
    }

    public void addSong(Song song)
    {
        if(findSong(song.title)==null)
        {
            songs.add(song);
        }
        else
        {
            System.out.println("Song already exists in the Album");
        }
    }
    public void addSong(String title, double duration)
    {
        if(findSong(title)==null)
        {
            Song s1 = new Song(title,duration);
            songs.add(s1);
//            return true;
        }
        else
        {
            System.out.println("Song already exists in the Album");
//            return false;
        }
    }

    public boolean addToPlaylist(int trackNo, LinkedList<Song> playList)
    {
        if(songs.size()<trackNo-1 )
        {
            System.out.println("Given trackNo doesn't exist in the album");
            return false;
        }
        else
        {
            Song newSong=songs.get(trackNo-1);
            playList.add(newSong);
            System.out.println("Song of given trackNo has been added the playlist");
            return true;
        }
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList)
    {
        if(findSong(title)==null)
        {
            System.out.println("Given title doesn't exist in the album");
            return false;
        }
        else
        {
            Song s = findSong(title);
            playList.add(s);
//            System.out.println("Song of given title has been added the playlist");
            return true;
        }
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String args[])
    {
        Album album = new Album("RRR","M.M Keeravani");
        album.addSong("RRR Theme",4.2);
        album.addSong("Komuram Bheemudo",4.7);
        album.addSong("Dosti",3.9);
        albums.add(album);

        album = new Album("BRAHMASTRA","Pritam");
        album.addSong("Deva Deva",4.3);
        album.addSong("Kesariya",3.8);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlaylist("Dosti",playList_1);
        albums.get(0).addToPlaylist("RRR Theme",playList_1);
        albums.get(1).addToPlaylist("Deva Deva",playList_1);
        albums.get(1).addToPlaylist("Kesariya",playList_1);

        play(playList_1);
    }
    public static void play(LinkedList<Song> playList_1)
    {
        Scanner sc = new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;

        ListIterator<Song> list = playList_1.listIterator();

        if(playList_1.size()>0)
        {
            printMenu();
//              System.out.println("Empty PlayList");
        }
        else
        {
            System.out.println("Empty PlayList");
        }
        while(!quit)
        {
            int action=sc.nextInt();
            switch (action){
                case 0:
                    System.out.println("Thanks For Listening to our Playlist!");
                    quit=true;
                    break;
                case 1:
                    System.out.println("Now playing the First " +list.next().toString());
                    break;
                case 2:
                    if(!forward)
                    {
                        if(list.hasNext())
                        {
                            System.out.println("Playing the next"+list.next().toString());
                        }
                        forward=true;
                    }
                    if(list.hasNext())
                    {
                        System.out.println("Now Playing "+list.next().toString());
                    }
                    else{
                        System.out.println("The last Song of the playlist is playing");
                        forward=false;
                    }

                    break;
                case 3:
                    if(forward)
                    {
                        if(list.hasPrevious()) {
                            list.previous();
                        }
                        forward=false;
                    }
                    if(list.hasPrevious())
                    {
                        System.out.println("Playing the previous "+list.previous().toString());
                    }
                    else
                    {
                        System.out.println("You are at the First Song of the PlayList ");
                        forward=false;
                    }
                    break;
                case 4:
                    if(!forward)
                    {
                        System.out.println("Repeating the "+list.next().toString());
                        forward=false;
                    }
                    else
                    {
                        System.out.println("Repeating the "+list.previous().toString());
                        forward=true;
                    }
                    break;
                case 5:
                    printSongs(playList_1);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    if(playList_1.size()>0)
                    {
                        list.remove();
                    }
                    if(list.hasNext())
                    {
                        System.out.println("Now Playing "+list.next().toString());
                    }
                    else if(list.hasPrevious())
                    {
                        System.out.println("Now Playing "+list.previous().toString());
                    }
                    break;
            }

        }
    }
    public static void printSongs(LinkedList<Song> playList)
    {
        ListIterator<Song> listIterator=playList.listIterator();
        while(listIterator.hasNext())
        {
            System.out.println(listIterator.next().toString());
        }
    }
    private static void printMenu()
    {
        System.out.println("Available Options:\nSelect from the below options:");
        System.out.println("0 - to quit\n" + "1- to Start the playlist\n"+"2 - to play next song\n" + "3 - to play previous song\n" + "4- to replay current song\n" + "5 - list of all songs\n" + "6 - to print all available options\n" + "7 - to delete current song\n");
    }
}

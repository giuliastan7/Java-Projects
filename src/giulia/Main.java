package giulia;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args)
    {

        Album album1 = new Album("Album1", "Lady Gaga");
        album1.addSong("Bad Romance", 2.5);
        album1.addSong("Telephone", 3.5);
        album1.addSong("Alejandro", 4.6);
        albums.add(album1);

        Album album2 = new Album("Album2", "Dan Balan");
        album2.addSong("Crazy Loop", 2.2);
        album2.addSong("Chica Bomb", 3.8);
        album2.addSong("Lendo Calendo", 5.5);
        albums.add(album2);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Bad Romance", playList_1);
        albums.get(0).addToPlayList("Telephone", playList_1);
        albums.get(1).addToPlayList("Crazy Loop", playList_1);
        albums.get(1).addToPlayList("Chica Bomb", playList_1);
        albums.get(1).addToPlayList("Lendo Calendo", playList_1);

        play(playList_1);
    }
    private static void play(LinkedList<Song> playList)
    {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size()==0)
        {
            System.out.println("They playlist is empty (no songs)");
        }
        else
        {
            System.out.println("Now playing " + listIterator.next().toString);
            printMenu();
        }
        while(!quit)
        {
            int action = sc.nextInt();
            sc.nextLine();
            switch(action) {
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    forward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing" + listIterator.next().toString());
                    }else{
                        System.out.println("There is no song available; the end of the list has been reached");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward= false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now the song " + listIterator.previous().toString() + "is playing");
                    }else{
                        System.out.println("We are at the first song from the playlist");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now the song " + listIterator.previous().toString() + "is playing");
                            forward = false;
                        } else {
                            System.out.println("We are at the first song from the playlist");
                        }
                    }else{
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now the song " + listIterator.next().toString() + "is playing");
                            forward=true;
                        }else{
                            System.out.println("We have reached to the end of the list ");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now the song " + listIterator.next().toString() + "is playing");
                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("Now the song " + listIterator.previous().toString() + "is playing");
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("You want to quit the playlist");
                    quit = true;
                    break;

            }
        }


    }

    private static void printMenu()
    {
        System.out.println("You can choose from the following options : \n press :");
        System.out.println(
                "1 - to play next song \n"+
                        "2 - to play previous song\n " +
                        "3 - to replay the current song \n" +
                        "4 - list of all songs \n"+
                        "5 - print all available options \n"+
                        "6-  delete current song \n"+
                        "0- stop application (quit the music player)");
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }
}



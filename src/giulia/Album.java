package giulia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name_album;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name_album, String artist) {
        this.name_album = name_album;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){

    };

    public Song findSong(String name){
        for (Song checkedSong : songs) {
            if (checkedSong.getName().equals(name)) return checkedSong;
        }
            return null;
        }



    public boolean addSong(String name, double duration){
        if(findSong(name)==null)
        {
            songs.add(new Song(name,duration));
            System.out.println(name+ "Succesfully added in your music album");
            return true;
        }
        else{
            System.out.println("The song with the name" + name + " already exists in the album");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList)
    {
        int index= trackNumber - 1;
        if(index>0  && index <=this.songs.size())
        {
            PlayList.add(this.songs.get(index));
            return true;
        }
        //System.out.println("There is no song with the tracknumber"+ trackNumber);
        return false;
    }

    public boolean addToPlayList(String name, LinkedList<Song> PlayList)
    {
        for (Song checkedSong : this.songs)
        {
            if(checkedSong.getName().equals(name))
            {
                PlayList.add(checkedSong);
                return true;
            }
        }
       // System.out.println("There is no such a song with the name " + name + "in the album");
        return false;
    }

}

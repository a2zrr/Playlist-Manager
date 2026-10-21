package com.playlismanager;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private String name;
    private List<Song> songs;


    

    public Playlist(String name) {
        StringNonull(name);
        StringNoblank(name);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void rename(String newName){
        StringNonull(newName);
        StringNoblank(newName);
        this.name=newName;
    }


    public void addSong(Song song){
        Objects.requireNonNull(song, "song must be not null");
        songs.add(song);
    }

    public void insert(int index, Song song){
         Objects.requireNonNull(song, "must be not null");
         if (!(0 <= index && index <= songs.size())) {
            throw new IndexOutOfBoundsException();
         }
         songs.add(index,song);
    }

    public void removeAt(int index){
        if (!(0 <= index && index <= songs.size())) {
            throw new IndexOutOfBoundsException();
        }
        songs.remove(index);
        
    }

    public void remove(Song song){
        Objects.requireNonNull(song, "song must be not null");

        for(Song s : songs){
            if (s.equals(song)) {
                songs.remove(s);
                return ;
            }
        }
    }

    public Song getSong(int index){
        if (!(0 <= index && index <= songs.size())) {
            throw new IndexOutOfBoundsException();
        }

        return songs.get(index);
    }

    public int getSize(){
        return songs.size() ;
    }

    public boolean contains(Song song){
        Objects.requireNonNull(song, "song must be not null");
        for(Song s:songs){
            if (s.equals(song)) {
                return true;
            }
        }
        return false;
    }

    public void sortByTitle(){

    }

    public void shuffle(){
    }

    public int totalDurationSeconds(){
        int totalDurationSeconds=0;
        for(Song s:songs){
            totalDurationSeconds +=s.durationSeconds();
        }
        return totalDurationSeconds;
    }



    public List<Song> getSongs() {
        return List.copyOf(songs);
    }

    //snapshot();





    public void StringNonull(String string){
        Objects.requireNonNull(string, " must be not null");
    }
    public void StringNoblank(String string){
        if (string.isBlank()) {
            throw new IllegalArgumentException(string+" must be not blank");
        }
    }



    
    
}

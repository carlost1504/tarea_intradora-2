
package model;

import java.util.Arrays;

public class PlayList {
    private String name;
    private int duration;
    private String[] genre;
    private Song[] song;
    public final int MAX_SONGS=30;
    
    /**
     * name:PlayList
     * description:builder for inicalite the atrivute
     * escription:@param name 
     */
    public PlayList(String name) {
        this.name = name;
        duration=0;
        genre=new String[6];
        song=new Song[MAX_SONGS];
    }
    
    /**
     * name:addSongPLaylist
     * description: the method is modify atrivite the type to playlist
     * @param songs 
     */
    public void addSongPLaylist(Song songs){
        boolean exit=false;
        for(int i=0;i<song.length&&exit;i++){
            if (song[i]==null){
                song[i]=songs;
                exit=true;
            }
        }  
    }
    
    /**
     * name:durationOfSong
     * description: the method is the calculate durarion in seconds
     * @return 
     */
    public int durationOfSong(){
        int counter=0;
        for(int i=0;i<song.length;i++){
            counter+= song[i].getDuration();
        }
        return duration;
    }
    
    /**
     * name:categorySong
     * description: asignation to the category song
     * @return 
     */
    public String categorySong(){
        String text="";
        for(int i=0;i<song.length;i++){
            text=(text+", "+song[i].getGenre());
        }
        return text;
    }
    /**
     * name:getSong
     * @return 
     */
    public Song[] getSong() {
        return song;
    }

    /**
     * name:setSong
     * @param song 
     */
    public void setSong(Song[] song) {
        this.song = song;
    }
    
    /**
     * name:getName
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * name:setName
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * name:getDuration
     * @return 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * name:setDuration
     * @param duration 
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * name:getGenre
     * @return 
     */
    public String[] getGenre() {
        return genre;
    }

    /**
     * name:setGenre
     * @param genre 
     */
    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    /**
     * name:toString
     * @return 
     */
    @Override
    public String toString() {
        return "************PlayList***********" 
             + "** name= " + name
             + "** duration= " + duration
             + "** genre= " + categorySong()
             + "*******************************";
    }
    
}

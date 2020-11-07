
package model;

import java.util.Arrays;


public class Song {
    private String title;
    private String releaseDate;
    private String artistName;
    private int duration;
    private Genre genre;
    private String typePLayList;
    
    /**
     * name:Song
     * description:builder for inicalite the atrivute
     * @param title
     * @param releaseDate
     * @param artistName
     * @param duration
     * @param songGenre 
     */
    public Song(String title, String releaseDate, String artistName, int duration,int songGenre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artistName = artistName;
        this.duration = duration;
        typePLayList="  ";
        genre=Genre.nothing;
        if(songGenre==1){
            genre=Genre.CLASSICAL;
        }
        if(songGenre==2){
            genre=Genre.HIPHOP;
        }
        if(songGenre==3){
            genre=Genre.METAL;
        }
        if(songGenre==4){
            genre=Genre.REGGAE;
        }
        if(songGenre==5){
            genre=Genre.ROCK;
        }
        if(songGenre==6){
            genre=Genre.SALSA;
        }
    }

    /**
     * name:getTitle
     * @return 
     */
    public String getTitle() {
        return title;
    }

    /**
     * name:setTitle
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * name:getReleaseDate
     * @return 
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * name:setReleaseDate
     * @param releaseDate 
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * name:getArtistName
     * @return 
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * name:setArtistName
     * @param artistName 
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * name:setArtistName
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
    public Genre getGenre() {
        return genre;
    }
    
    /**
     * name:setGenre
     * @param genre 
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * name:getTypePLayList
     * @return 
     */
    public String getTypePLayList() {
        return typePLayList;
    }

    /**
     * name:setTypePLayList
     * @param typePLayList 
     */
    public void setTypePLayList(String typePLayList) {
        this.typePLayList = typePLayList;
    }

    /**
     * name:toString
     * descriotion:get the into the class
     * @return 
     */
    @Override
    public String toString() {
        return "************Song***********"
             + "** title= " + title
             + "** releaseDate= " + releaseDate 
             + "** artistName= " + artistName 
             + "** duration= " + duration 
             + "** genre= " + genre 
             + "** typePLayList= " + typePLayList 
             + "***************************";
    }
    

    


    
    
}

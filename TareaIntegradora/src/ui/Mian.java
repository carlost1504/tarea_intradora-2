package ui;
import model.*;
import java.util.*;

public class Mian {
    public Scanner SN=new Scanner(System.in);
    public MCS mcs=new MCS();
    public static void main(String[] args) {
        
    }
    /**
     * name:mainMenu
     * description:this method is the menu and controller of the whole program
     */
    public void mainMenu(){
        //MCS
        System.out.println("welcome to MCS");
        System.out.println("1. create user \n 2. create song \n 3. create playList \n 4. view users \n 5. view pool Song \n 6. add song to playlist \n 7. view inf to playlist");
        int action1=SN.nextInt();
        SN.nextLine();
        switch(action1){
            case 1:
                addUser();
            break;
            case 2:
                addSong();
            break;
            case 3:
                System.out.println("what kind of playlist do you want");
                System.out.println("1. private \n 2. public \n 3. shared");
                int tipPLayList=SN.nextInt();
                SN.nextLine();
                switch(tipPLayList){
                    case 1:
                        addPlayList_Pri();
                    break;
                    case 2:
                        addPlaylist_Shared();
                    break;
                    case 3:
                        addPlaylist_Public();
                }
            break;
            case 4:
                viewUser();
            break;
            case 5:
                viewPoolSong();
            break;
            case 6:
                addSongToPlaylist();
            break;
            case 7:
                viewIntoPlaylist();
            break;
        }  
    }
    /**
     * name:addUser
     * description: ask and send the information user
     */
    public void addUser(){
        System.out.println("enter name");
        String UserName=SN.nextLine();
        System.out.println("enter password");
        String password=SN.nextLine();
        System.out.println("enter the age");
        int age=SN.nextInt();
        SN.nextLine();
        mcs.createUser(UserName, password, age);
    }
    /**
     * name:addSong
     * description: ask and send the information song
     */
    public void addSong(){
        System.out.println("enter title");
        String title=SN.nextLine();
        System.out.println("enter release Date");
        String releaseDate=SN.nextLine();
        System.out.println("enter artist Name");
        String artistName=SN.nextLine();
        System.out.println("enter duration");
        int duration=SN.nextInt();
        SN.nextLine();
        System.out.println("enter the song Genre \n 1. ROCK,\n" +
        "   2. HIPHOP,\n" +
        "   3. CLASSICAL,\n" +
        "   4. REGGAE,\n" +
        "   5. SALSA,\n" +
        "   6. METAL,");
        int songGenre=SN.nextInt();
        System.out.println("enter name");
        String UserName1=SN.nextLine();
        System.out.println("enter password");
        String password1=SN.nextLine();
        boolean addSong= mcs.addSong(title, releaseDate, artistName, duration, songGenre, UserName1, password1);
        if(addSong==true){
            System.out.println("correct add the song");
        }
    }
    
    /**
     * name:addPlayList_Pri
     * description:ask and send the information add playlist private
     */
    public void addPlayList_Pri(){
        System.out.println("enter user Name");
        String UserName=SN.nextLine();
        System.out.println("enter password");
        String password=SN.nextLine();
        System.out.println("enter title the PlayList");
        String title=SN.nextLine();
        boolean RightAdd= mcs.createPlayList(UserName, password, title);
        if(RightAdd==true){
            System.out.println("correct add the Playlist");
        }
    }
    /**
     * Name: addPlaylist_Pu
     * description:max user for Playlist shared is 4
     */
    public void addPlaylist_Shared(){//createPlayList(String title,String[] userName, String[] password)
        int max_user=4;
        String[] UserName=new String[max_user];
        String[] password=new String[max_user];
        
        for(int i=0;i<UserName.length;i++){
            System.out.println("enter user Name");
            UserName[i]=SN.nextLine();
            System.out.println("enter password");
            password[i]=SN.nextLine();
        }
        System.out.println("enter title the PlayList");
        String title=SN.nextLine();
        boolean RightAdd=mcs.createPlayList(title, UserName, password);
        if(RightAdd==true){
            System.out.println("correct add the Playlist");
        }
    }
    /**
     * name:addPlaylist_Public
     * descrition:ask and send the information add playlist 
     */
    public void addPlaylist_Public(){
        System.out.println("enter the name Playlist");
        String name=SN.nextLine();
        boolean RightAdd= mcs.createPlayList(name);
        if(RightAdd==true){
            System.out.println("correct add the Playlist");
        }
    }
    
    /**
     * name:addSongToPlaylist
     * description:add Song To Playlist 
     */
    public void addSongToPlaylist(){//addSongToPlayList(String titleSong,String titlePlaylist,String user,String password)
        System.out.println("what is tipe the playlist \n 1.private 2.Shared 3.public");
        int tipe=SN.nextInt();
        SN.nextLine();
        switch(tipe){
            case 1:
                System.out.println("what is the title of song");
                String titleSong=SN.nextLine();
                System.out.println("what is the title of Playlist");
                String titlePlaylist=SN.nextLine();
                System.out.println("what is the user");
                String user=SN.nextLine();
                System.out.println("whay is the password");
                String password=SN.nextLine();
                mcs.addSongToPlayList(titleSong, titlePlaylist, user, password);
            break;
            case 2:
                System.out.println("what is the title of song");
                String titleSong1=SN.nextLine();
                System.out.println("what is the title of Playlist");
                String titlePlaylist1=SN.nextLine();
                System.out.println("what is the user");
                String user1=SN.nextLine();
                System.out.println("whay is the password");
                String password1=SN.nextLine();
                mcs.addSongToPlayList(titleSong1, titlePlaylist1, user1, password1);
            break;
            case 3://String titleSong,String titlePlaylist
                System.out.println("what is the title of song");
                String titleSong2=SN.nextLine();
                System.out.println("what is the title of Playlist");
                String titlePlaylist2=SN.nextLine();
                mcs.addSongToPlayList(titleSong2, titlePlaylist2);
            break;
        }   
    }
    /**
     * name:viewUser
     * description: view the total into the user 
     */
    public void viewUser(){
        String text=mcs.viewUser();
    }
    /**
     * name:viewPoolSong
     * description:view the total into the Song
     */
    public void viewPoolSong(){
        String text=mcs.viewPoolSong();
    }
    /**
     * name:viewIntoPlaylist
     * description:view the total into the playlist
     */
    public void viewIntoPlaylist(){
        String text=mcs.viewIntoPlaylist();
    }
    
    
}

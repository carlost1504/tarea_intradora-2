package model;

public class MCS {
    public final int MAX_USERS=10;
    public final int MAX_SONGS=30;
    public final int MAX_PLAYLIST=20;
    
    
    User[] user=new User[MAX_USERS];
    Song[] music=new Song[MAX_SONGS];
    PlayList[] list=new PlayList[MAX_PLAYLIST];

    /**
     * name:MCS
     */
    public MCS() {
    }

    /**
     * name:tellSong
     * description:tell the song for user
     * @return 
     */
    public int tellSong(){
        int tell=0;
        boolean exit=false;
        for(int i=0;i<user.length&&exit;i++){
            if(user[i]==null){
                exit=true;
            }
            tell+=user[i].getCounter_song();
        }
        return tell;
    }
    
    /**
     * name:createUser
     * description:create new user
     * @param userName
     * @param password
     * @param age
     * @return 
     */
    public boolean createUser(String userName, String password, int age){
        boolean create =false;
        for(int i=0;i<user.length;i++){
            if(user[i]==null){
                user[i]=new User(userName, password, age);
                create=true;
            }
        }
        return create;
    }
    
    /**
     * name:addSong
     * description: the method add the song to pool  music and the validation for add the song
     * @param title
     * @param releaseDate
     * @param artistName
     * @param duration
     * @param songGenre
     * @param userName
     * @param password
     * @return 
     */
    public boolean addSong(String title, String releaseDate, String artistName, int duration,int songGenre,String userName, String password){
        boolean addmusic=false;
        boolean exit=false;
        for(int y=0;y<user.length;y++){
            int count=user[y].getCounter_song();
            if(userName.equals(user[y].getUserName())&&password.equals(user[y].getPassword())&&tellSong()<=MAX_SONGS){
                count++;
                for(int i=0;i<music.length&&exit;i++){
                    if(music[i]==null){
                        music[i]=new Song(title, releaseDate, artistName, duration,songGenre);
                        user[y].setCounter_song(count);
                        addmusic=true;
                        exit=true;
                    }
                }
            }
        }
        return addmusic;
    }
    
    /**
     * name:createPlayList
     * description:create new playlist type private 
     * @param userName
     * @param password
     * @param title
     * @return 
     */
    public boolean createPlayList(String userName, String password, String title){
        boolean add_playlist=false;
        for(int y=0;y<user.length;y++){
            if(userName.equals(user[y].getUserName())&&password.equals(user[y].getPassword())){
                for(int i=0;i<list.length;i++){
                    if(list[i]==null){
                        list[i]=new PrivatePL(userName,password,title);
                        add_playlist=true;
                    }
                }
            }
        }
        return add_playlist;
    }
    
    /**
     * name: createPlayList
     * description:create new playlist type shared
     * @param title
     * @param userName
     * @param password
     * @return 
     */
    public boolean createPlayList(String title,String[] userName, String[] password){
        boolean add_playlist=false;
        for(int y=0;y<user.length;y++){
            if(userName[y].equals(user[y].getUserName())&&password[y].equals(user[y].getPassword())){
                for(int i=0;i<list.length;i++){
                    if(list[i]==null){
                        list[i]=new SharedPL(userName, password,  title);
                        add_playlist=true;
                    }
                }
            }
        }
        return add_playlist;
    }
    
    /**
     * name: createPlayList
     * description:create new playlist type public
     * @param title
     * @return 
     */
    public boolean createPlayList(String title){
        boolean add_playlist=false;
        for(int i=0;i<list.length&&add_playlist;i++){
            if(list[i]==null){
                list[i]=new PlayList(title);
                add_playlist=true;
            }
        }
        return add_playlist;
    }
    
    /**
     * name:addSongToPlayList
     * description: add the song to playlist private and shared
     * @param titleSong
     * @param titlePlaylist
     * @param user
     * @param password
     * @return 
     */
    public boolean addSongToPlayList(String titleSong,String titlePlaylist,String user,String password){
        boolean addSong=false;
        for(int i=0;i<music.length&&addSong;i++){
            if(music[i].getTitle().equalsIgnoreCase(titleSong)){
                for(int y=0;y<list.length&&addSong;i++){
                    if(list[y].getName().equalsIgnoreCase(titlePlaylist)){
                        if(list[y] instanceof PrivatePL){
                            PrivatePL pl_1=(PrivatePL)list[y];
                            if(pl_1.getPassword().equals(password)&&pl_1.getUserName().equals(user)){
                                music[i].setTypePLayList(titlePlaylist);
                                addSong=true;
                                list[y].addSongPLaylist(music[i]);
                            }
                        }
                        if(list[i] instanceof SharedPL){
                            SharedPL pl_2=(SharedPL)list[y];
                            String[] Password=pl_2.getPassword();
                            String[] User=pl_2.getUserName();
                            for(int p=0;p<Password.length&&addSong;p++){
                                if(Password[p].equals(password)&&User[p].equals(user)){
                                    music[i].setTypePLayList(titlePlaylist);
                                    addSong=true;
                                    list[y].addSongPLaylist(music[i]);
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        return addSong;
    }
    
    /**
     * name:addSongToPlayList
     * description:add the song to playlist type public 
     * @param titleSong
     * @param titlePlaylist
     * @return 
     */
    public boolean addSongToPlayList(String titleSong,String titlePlaylist){
        boolean addSong=false;
        for(int i=0;i<music.length&&addSong;i++){
            if(music[i].getTitle().equalsIgnoreCase(titleSong)){
                for(int y=0;y<list.length&&addSong;y++){
                    if(list[y].getName().equalsIgnoreCase(titlePlaylist)){
                        music[i].setTypePLayList(titlePlaylist);
                        list[y].addSongPLaylist(music[i]);
                        addSong=true;
                    }
                }
            }
        }
        return addSong;
    }
    
    /**
     * name:takeSongToPlayList
     * description:remove song from playlist for type private and shared
     * @param titleSong
     * @param titlePlaylist
     * @param user
     * @param password
     * @return 
     */
    public boolean takeSongToPlayList(String titleSong,String titlePlaylist,String user,String password){
        boolean addSong=false;
        for(int i=0;i<music.length&&addSong;i++){
            if(music[i].getTitle().equalsIgnoreCase(titleSong)){
                for(int y=0;y<list.length&&addSong;i++){
                    if(list[y].getName().equalsIgnoreCase(titlePlaylist)){
                        if(list[y] instanceof PrivatePL){
                            PrivatePL pl_1=(PrivatePL)list[y];
                            if(pl_1.getPassword().equals(password)&&pl_1.getUserName().equals(user)){
                                music[i].setTypePLayList("  ");
                                addSong=true;
                            }
                        }
                        if(list[i] instanceof SharedPL){
                            SharedPL pl_2=(SharedPL)list[y];
                            String[] Password=pl_2.getPassword();
                            String[] User=pl_2.getUserName();
                            for(int p=0;p<Password.length&&addSong;p++){
                                if(Password[p].equals(password)&&User[p].equals(user)){
                                    music[i].setTypePLayList("  ");
                                    addSong=true;
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        return addSong;
    }
    
    /**
     * name: takeSongToPlayList
     * description:remove song from playlist for type public
     * description:
     * @param titleSong
     * @param titlePlaylist
     * @return 
     */
    public boolean takeSongToPlayList(String titleSong,String titlePlaylist){
        boolean addSong=false;
        for(int i=0;i<music.length&&addSong;i++){
            if(music[i].getTitle().equalsIgnoreCase(titleSong)){
                for(int y=0;y<list.length&&addSong;i++){
                    if(list[y].getName().equalsIgnoreCase(titlePlaylist)){
                        music[i].setTypePLayList("   ");
                        addSong=true;
                    }
                }
            }
        }
        return addSong;
    }
    
    /**
     * name:deletesong
     * description: delete song the poolsong
     * @param titleSong
     * @param User
     * @return 
     */
    public boolean deletesong(String titleSong,String User){
        boolean delate=false;
        for(int i=0;i<music.length&&delate;i++){
            if(music[i].getTitle().equalsIgnoreCase(titleSong)){
                for(int y=0;y<user.length;y++){
                    if(user[y].getUserName().equals(User)&&(user[y].assignCategory()==Category.MILD_CONTRIBUTOR||user[y].assignCategory()==Category.STAR_CONTRIBUTOR)){
                        music[i]=null;
                    }
                }
            }
        }
        return delate;
    }
    /**
     * name:viewUser
     * description:get into de total user 
     * @return 
     */
    public String viewUser(){
        String text="";
        for(int i=0;i<user.length;i++){
            if(user[i]!=null)
            text=text+"\n"+ user[i].toString()+"\n";
        }
        return text;
    }
    
    /**
     * name:viewPoolSong
     * description: get the total into for song
     * @return 
     */
    public String viewPoolSong(){
        String text="";
        for(int i=0;i<music.length;i++){
            if(music[i]!=null)
            text=text+"\n"+ music[i].toString()+"\n";
        }
        return text;
    }
    
    /**
     * name:viewIntoPlaylist
     * description:get into the total 
     * @return 
     */
    public String viewIntoPlaylist(){
        String text="";
        for(int i=0;i<list.length;i++){
            if(list[i]!=null)
            text=text+"\n"+ list[i].toString()+"\n";
        }
        return text;
    }
    
    
    
}

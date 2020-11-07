package model;

public class User {
    public final int MAXPL=5;
    private String userName;
    private String password;
    private int age;
    private int counter_song;
    private Category Ct=Category.NEWBIE;

    /**
     * name: User
     * description: builder for inicalite the atrivute
     * @param userName
     * @param password
     * @param age 
     */
    public User(String userName, String password, int age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        counter_song=0;
    }
 
    /**
     * name:getCounter_song
     * @return 
     */
    public int getCounter_song() {
        return counter_song;
    }

    /**
     *name: setCounter_song
     * @param counter_song 
     */
    public void setCounter_song(int counter_song) {
        this.counter_song = counter_song;
    }

    /**
     * name:assignCategory}
     * description:this method assigns the user category
     * @return 
     */
    public Category assignCategory(){
        if(counter_song<=3){
            Ct=Category.NEWBIE;
        }
        if(counter_song>3 ||counter_song<=10){
            Ct=Category.LITTLE_CONTRIBUTTOR;
        }
        if(counter_song>10 ||counter_song<=30){
            Ct=Category.MILD_CONTRIBUTOR;
        }
        if(counter_song>30){
            Ct=Category.STAR_CONTRIBUTOR;
        }
        return Ct;
    }
    
    /**
     * name:getUserName
     * @return 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * name:setUserName
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * name:getPassword
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * name:setPassword
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * name:getAge
     * @return 
     */
    public int getAge() {
        return age;
    }

    /**
     * name:setAge
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * name:toString
     * description:get the into to class
     * @return 
     */
    @Override
    public String toString() {
        return "******User******\n" 
             + "** user Name=" + userName
             + "** password=" + password
             + "** age=" + age
             + "** counter_song=" + counter_song
             + "** Category=" + Ct 
             +"*****************";
    }

    
    
    
}

package model;

import java.util.Arrays;

public class SharedPL extends PlayList{
    public int QUANTITYUSER=4;
    private String[] userName;
    private String[] password;
    
    /**
     * name:SharedPL
     * description:builder for inicalite the atrivute
     * @param userName
     * @param password
     * @param name 
     */
    public SharedPL(String[] userName, String[] password, String name) {
        super(name);
        this.userName = userName;
        this.password = password;
    }

    /**
     * name:getUserName
     * @return 
     */
    public String[] getUserName() {
        return userName;
    }

    /**
     * name:setUserName
     * @param userName 
     */
    public void setUserName(String[] userName) {
        this.userName = userName;
    }

    /**
     * name:getPassword
     * @return 
     */
    public String[] getPassword() {
        return password;
    }

    /**
     * name:setPassword
     * @param password 
     */
    public void setPassword(String[] password) {
        this.password = password;
    }

    /**
     * name:toString
     * descriotion:get the into the class
     * @return 
     */
    @Override
    public String toString() {
        return super.toString()+"SharedPL{" + "userName=" + Arrays.toString(userName) + ", password=" + Arrays.toString(password) + '}';
    }
    
    
}


package model;

public class PrivatePL extends PlayList {
    private String userName;
    private String password;

    /**
     * name:PrivatePL
     * description:builder for inicalite the atrivute
     * @param userName
     * @param password
     * @param name 
     */
    public PrivatePL(String userName, String password, String name) {
        super(name);
        this.userName = userName;
        this.password = password;
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
     * name:toString
     * des
     * @return 
     */
    @Override
    public String toString() {
        return  super.toString()+"PrivatePL{" + "userName=" + userName + ", password=" + password + '}';
    }
    
    

    
    
}

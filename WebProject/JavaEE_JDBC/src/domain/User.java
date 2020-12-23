package domain;

/**
 * @ClassName User
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/25 15:45
 * @Version 1.0
 **/
public class User {
    private String uname;
    private String upassword;

    public User(){

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUpassword() {
        return upassword;
    }
}

package bean;

/**
 * 用户注册信息
 * <p>
 * Created by Yohann on 2016/8/11.
 */
public class UserLoginData {
    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
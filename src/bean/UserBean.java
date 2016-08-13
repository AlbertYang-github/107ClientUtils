package bean;

/**
 * Created by Yohann on 2016/8/12.
 */
public class UserBean {
    //用户id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //获得星的数量
    private Integer star;
    //用户参与表名
    private String userEvents;
    //用户足迹表名
    private String userTrack;

    public void setUserEvents(String userEvents) {
        this.userEvents = userEvents;
    }

    public void setUserTrack(String userTrack) {
        this.userTrack = userTrack;
    }

    public String getUserEvents() {
        return userEvents;
    }

    public String getUserTrack() {
        return userTrack;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getStar() {
        return star;
    }
}

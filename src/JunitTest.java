import org.junit.Test;
import utils.StringUtils;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Yohann on 2016/8/11.
 */
public class JunitTest {
    @Test
    public void register() {
        try {
            //连接到服务器
            LoginUtils loginUtils = new LoginUtils();
            //注册
            String s = loginUtils.register(Constants.REGISTER, "yanghuan", "123");
            System.out.println("注册返回数据：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            LoginUtils loginUtils = new LoginUtils();
            String s = loginUtils.login(Constants.LOGIN, "yanghuan", "123");
            System.out.println("登陆返回数据：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addEvent() {
        try {
            EventUpLoadUtils eventUpLoadUtils = new EventUpLoadUtils();
            boolean result = eventUpLoadUtils.uploadText(Constants.ADD_EVENT,
                    "中北大学",
                    "胜利桥东",
                    23.234344,
                    45.454334,
                    12.232334,
                    23.345454,
                    new String[]{"拥堵", "事故", "警察"},
                    "中北大学到胜利桥东严重堵车",
                    "主要是由于滨河东路施工引起的",
                    new String[]{"voice1.mp3", "voice2.mp3"},
                    new String[]{"pic1.jpg", "pic2.jpg"},
                    new String[]{"video2.mp4", "video2.mp4"},
                    new Timestamp(System.currentTimeMillis()));
            System.out.println("添加的返回结果：" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStringUtils() {
        String s = StringUtils.getStringFromArray(new String[]{"拥堵", "事故", "警察"});
        System.out.println(s);
    }
}


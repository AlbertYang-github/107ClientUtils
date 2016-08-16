package test;

import constants.Constants;
import myutils.StreamUtils;
import org.junit.Test;
import myutils.StringUtils;
import utils.EventUpLoadUtils;
import utils.LoginUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

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
            String s = loginUtils.register(Constants.REGISTER, "yohann", "321");
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

            ArrayList<byte[]> list = new ArrayList<>();
            list.add(StreamUtils.getBytes("F:/pic1.jpg"));
            list.add(StreamUtils.getBytes("F:/pic2.jpg"));
            list.add(StreamUtils.getBytes("F:/pic3.jpg"));

            EventUpLoadUtils eventUpLoadUtils = new EventUpLoadUtils();
            boolean result = eventUpLoadUtils.uploadEvent(Constants.ADD_EVENT,
                    "中北大学",
                    "胜利桥东",
                    23.234344,
                    45.454334,
                    12.232334,
                    23.345454,
                    new String[]{"拥堵"},
                    "中北大学到胜利桥东严重堵车",
                    "主要是由于滨河东路施工引起的",
                    "voice.mp3",
                    new String[]{"pic1.jpg", "pic2.jpg", "pic3.jpg"},
                    "video.mp4",
                    new Timestamp(System.currentTimeMillis()),
                    StreamUtils.getBytes("F:/voice.mp3"),
                    list,
                    StreamUtils.getBytes("F:/video.avi"));

            System.out.println("添加的返回结果：" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStringUtils() {
        int[] arr = null;
        System.out.println("arr[0] = " + arr[0]);
    }
}


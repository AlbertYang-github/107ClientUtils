package test;

import constants.Variable;
import org.junit.Test;
import utils.EventUpLoadUtils;
import utils.LoginUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yohann on 2016/8/11.
 */
public class JunitTest {

    private String result;

    @Test
    public void register() {
        try {
            //连接到服务器
            LoginUtils loginUtils = new LoginUtils();
            //注册
            String s = loginUtils.register("yang", "321");
            System.out.println("注册返回数据：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            LoginUtils loginUtils = new LoginUtils();
            String s = loginUtils.login("yang", "321");
            System.out.println("登陆返回数据：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addEvent() throws IOException {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("当前进度：" + Variable.progress + "%");
                    try {
                        Thread.sleep(1 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Variable.progress == 100) {
                        break;
                    }
                }
            }
        }.start();

        EventUpLoadUtils eventUpLoadUtils = new EventUpLoadUtils();
        result = eventUpLoadUtils.uploadEvent(
                "中北大学",
                "胜利桥东",
                23.234344,
                45.454334,
                12.232334,
                23.345454,
                new String[]{"拥堵", "车祸"},
                "中北大学到胜利桥东严重堵车",
                "主要是由于滨河东路施工引起的",
                System.currentTimeMillis(),
                new File("F:/EventBinNew"));
        System.out.println("添加的返回结果：" + result);
    }
}



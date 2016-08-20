package test;

import com.google.gson.Gson;
import constants.Variable;
import org.junit.Test;
import utils.EventUpUtils;
import utils.LoginUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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
            String s = loginUtils.register("heihei", "321");
            System.out.println("注册返回数据：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            LoginUtils loginUtils = new LoginUtils();
            String s = loginUtils.login("heihei", "321");
            System.out.println("登陆返回数据：" + s);



            Gson gson = new Gson();
            Map map = gson.fromJson(s, Map.class);

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

        EventUpUtils eventUpLoadUtils = new EventUpUtils();
        result = eventUpLoadUtils.uploadText(
                "中北大学",
                "胜利桥东",
                23.234344,
                45.454334,
                12.232334,
                23.345454,
                new String[]{"拥堵", "车祸"},
                "中北大学到胜利桥东严重堵车",
                "主要是由于滨河东路施工引起的",
                System.currentTimeMillis());
        System.out.println("添加的返回结果：" + result);

        boolean b = eventUpLoadUtils.uploadBinary(new File("F:/EventBin"));

        System.out.println(b);
    }

//    @Test
//    public void recePush() throws IOException {
//        //建立Push连接
//        boolean res = PushUtils.connect();
//        if (res == true) {
//            StringUtils.print("连接成功");
//        } else {
//            StringUtils.print("连接失败");
//        }
//    }
}



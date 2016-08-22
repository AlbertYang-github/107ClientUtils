package test;

import bean.EventBean;
import bean.PathBean;
import constants.Variable;
import myutils.StringUtils;
import org.junit.Test;
import utils.EventGetUtils;
import utils.LoginUtils;
import utils.PathLoadUtils;
import utils.RootEventUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

        RootEventUtils eventUpLoadUtils = new RootEventUtils();
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

        boolean b = eventUpLoadUtils.uploadBinary(new File("F:" + File.separator + "event"));

        System.out.println(b);
    }

    @Test
    public void getEventText() throws IOException {
        EventGetUtils eventGetUtils = new EventGetUtils();
        ArrayList<EventBean> beanList = eventGetUtils.getText();
        for (int i = 0; i < beanList.size(); i++) {
            EventBean eventBean = beanList.get(i);
            Integer id = eventBean.getId();
            System.out.println(id);
        }
    }

    @Test
    public void remove() throws IOException {
        RootEventUtils utils = new RootEventUtils();
        boolean res = utils.remove(171);
        System.out.println(res);
    }

    @Test
    public void loadPath() throws IOException {
        PathBean pathBean = new PathLoadUtils().load(186);
        String videoPath = pathBean.getVideoPath();
        StringUtils.print(videoPath);
    }
}



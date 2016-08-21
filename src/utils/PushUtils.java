package utils;

import bean.EventBean;
import com.google.gson.Gson;
import constants.Constants;
import constants.Variable;
import myutils.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 建立推送连接的工具类 (登录或注册成功后调用)
 * <p>
 * 所有的推送数据都存放在Variable.dataList
 * <p>
 * Created by Yohann on 2016/8/19.
 */
public class PushUtils {
    public static boolean pushStatus;

    /**
     * 建立推送连接
     *
     * @return
     * @throws IOException
     */
    public static void open() {
        Socket socket = null;
        InputStream in = null;

        pushStatus = true;

        while (pushStatus) {
            try {
                socket = new Socket(Constants.HOST, Constants.PORT_PUSH);
                in = socket.getInputStream();
                String data = StreamUtils.readString(in);
                if (pushStatus) {
                    //将数据存放在List集合中
                    Gson gson = new Gson();
                    EventBean eventBean = gson.fromJson(data, EventBean.class);

//                    if (Flag.ishome) {
                        //在主界面调用绘制路线的方法
                        String startLocation = eventBean.getStartLocation();
                        String endLocation = eventBean.getEndLocation();
                        Double startLongitude = eventBean.getStartLongitude();
                        Double endLongitude = eventBean.getEndLongitude();
                        Double startLatitude = eventBean.getStartLatitude();
                        Double endLatitude = eventBean.getEndLatitude();
                        String eventLabels = eventBean.getEventLabels();
                        String eventTitle = eventBean.getEventTitle();
                        String eventDesc = eventBean.getEventDesc();
                        Long startTime = eventBean.getStartTime();
//                        showEvent();
//                    } else {
                        //不在主界面，保存数据
                        Variable.dataList.add(eventBean);
//                    }

                    //5s后再次建立推送连接
                    Thread.sleep(5 * 1000);
                } else {
                    //如果关闭了连接，跳出循环，丢弃推送到的数据
                    in.close();
                    socket.close();
                    break;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 关闭推送连接
     */
    public static void close() {
        pushStatus = false;
    }
}

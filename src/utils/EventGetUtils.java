package utils;

import bean.EventBean;
import com.google.gson.Gson;
import constants.Constants;
import myutils.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 向服务器请求事件信息
 * <p>
 * 使用时间：
 * 1.注册或登录成功后
 * 2.手动刷新时
 * <p>
 * <p>
 * Created by Yohann on 2016/8/19.
 */
public class EventGetUtils {
    private Socket socketJson;
    private Gson gson;

    /**
     * 构造方法中创建Socket连接
     *
     * @throws IOException
     */
    public EventGetUtils() throws IOException {
        socketJson = new Socket(Constants.HOST, Constants.PORT_BASIC);
        gson = new Gson();
    }

    /**
     * 请求文本信息 (可能有多个事件信息)
     *
     * @return EventBean (包含该事件的全部文本信息)
     */
    public ArrayList<EventBean> getText() throws IOException {
        //创建 header + json
        String header = Constants.TYPE_JSON + Constants.GET_EVENT_TEXT;

        //写入输出流，发送给服务器
        OutputStream out = socketJson.getOutputStream();
        StreamUtils.writeString(out, header);
        socketJson.shutdownOutput();

        //获取响应数据
        InputStream in = socketJson.getInputStream();
        String data = StreamUtils.readString(in);

        ArrayList<String> jsonList = gson.fromJson(data, ArrayList.class);
        ArrayList<EventBean> beanList = new ArrayList<>();
        for (int i = 0; i < jsonList.size(); i++) {
            String evetJson = jsonList.get(i);
            EventBean eventBean = gson.fromJson(evetJson, EventBean.class);
            beanList.add(eventBean);
        }

        return beanList;
    }
}

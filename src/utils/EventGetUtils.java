package utils;

import bean.EventBean;
import com.google.gson.Gson;
import constants.Constants;
import myutils.StreamUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

/**
 * 向服务器请求事件信息
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
     * 请求文本信息
     *
     * @param id 事件id
     * @return Json串 (包含该事件的全部文本信息)
     */
//    public String getText(int id) throws IOException {
//        //创建 header + json
//        String header = Constants.TYPE_JSON + Constants.GET_EVENT_TEXT;
//        EventBean eventBean = new EventBean();
//        eventBean.setId(id);
//        String json = gson.toJson(eventBean);
//        String req = header + json;
//
//        //写入输出流，发送给服务器
//        OutputStream out = socketJson.getOutputStream();
//        StreamUtils.writeString(out, req);
//        socketJson.shutdownOutput();
//    }
}

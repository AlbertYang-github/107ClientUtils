package utils;

import bean.EventBean;
import com.google.gson.Gson;
import constants.Constants;
import myutils.StreamUtils;
import myutils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 事件工具类
 * <p>
 * 向服务器上传事件
 * <p>
 * uploadText：上传文本信息
 * uploadBinary：上传二进制文件 (后台进行，显示进度)
 * <p>
 * Created by Yohann on 2016/8/12.
 */
public class EventUpUtils {

    private Socket socketJson;
    private Socket socketByte;
    private Gson gson;

    /**
     * 构造方法中创建Socket连接
     *
     * @throws IOException
     */
    public EventUpUtils() throws IOException {
        gson = new Gson();
    }

    /**
     * 上传时间到服务器
     *
     * @param startLocation  起始地名
     * @param endLocation    结束地名
     * @param startLongitude 起始经度
     * @param endLongitude   结束经度
     * @param startLatitude  起始纬度
     * @param endLatitude    结束纬度
     * @param eventLabels    事件标签 (多个标签写法例如："拥堵||事故||警察") 100
     * @param eventTitle     事件标题 300
     * @param eventDesc      事件描述 1000
     * @param startTime      开始时间 类型为Long
     * @return 上传成功返回Json串，否则返回 "error"
     */
    public String uploadText(String startLocation,
                             String endLocation,
                             Double startLongitude,
                             Double endLongitude,
                             Double startLatitude,
                             Double endLatitude,
                             String[] eventLabels,
                             String eventTitle,
                             String eventDesc,
                             Long startTime) throws IOException {

        //建立socket连接
        socketJson = new Socket(Constants.HOST, Constants.PORT_BASIC);
        socketJson.setSoTimeout(10 * 1000);

        //读取到输入流的返回信息
        String result = null;

        //将数组转换为以&连接的字符串
        String labels = StringUtils.getStringFromArray(eventLabels);

        if (socketJson != null) {

            //创建事件模型
            EventBean eventBean = new EventBean();
            eventBean.setStartLocation(startLocation);
            eventBean.setEndLocation(endLocation);
            eventBean.setStartLongitude(startLongitude);
            eventBean.setEndLongitude(endLongitude);
            eventBean.setStartLatitude(startLatitude);
            eventBean.setEndLatitude(endLatitude);
            eventBean.setEventLabels(labels);
            eventBean.setEventTitle(eventTitle);
            eventBean.setEventDesc(eventDesc);
            eventBean.setStartTime(startTime);

            //创建head + Json串
            String eventData = gson.toJson(eventBean);
            eventData = Constants.TYPE_JSON + Constants.ADD_EVENT_TEXT + eventData;

            //写入输出流，发送给服务器
            OutputStream out = socketJson.getOutputStream();
            StreamUtils.writeString(out, eventData);
            socketJson.shutdownOutput();

            //读取输入流，获取执行结果
            InputStream in = socketJson.getInputStream();
            result = StreamUtils.readString(in);

            //关闭流和socket
            out.close();
            in.close();
            StreamUtils.close();
            socketJson.close();
        }

        return result;
    }

    /**
     * 上传二进制文件
     *
     * @param dir 事件媒体文件所在的目录File
     * @return
     */
    public boolean uploadBinary(File dir) throws IOException {
        //建立第二次的连接
        socketByte = new Socket(Constants.HOST, Constants.PORT_BASIC);
        socketByte.setSoTimeout(10 * 1000);
        OutputStream out = socketByte.getOutputStream();

        //写入头信息
        byte[] header = (Constants.TYPE_BYTE + Constants.ADD_EVENT_BIN).getBytes();
        out.write(header);
        out.flush();

        //压缩文件目录
        StreamUtils.compressDir(dir, out);
        socketByte.shutdownOutput();

        //上传结果
        InputStream in = socketByte.getInputStream();
        String result = StreamUtils.readString(in);

        in.close();
        out.close();
        socketByte.close();

        if ("1".equals(result)) {
            return true;
        } else {
            return false;
        }
    }
}

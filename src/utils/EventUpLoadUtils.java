package utils;

import bean.BinaryBean;
import bean.EventBean;
import com.google.gson.Gson;
import constants.Constants;
import myutils.StreamUtils;
import myutils.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 事件工具类
 * <p>
 * 1.向服务器上传事件
 * 2.从服务器获取事件
 * <p>
 * Created by Yohann on 2016/8/12.
 */
public class EventUpLoadUtils {

    private Socket socketJson;
    private Socket socketObj;
    private Gson gson;

    /**
     * 构造方法中创建Socket连接
     *
     * @throws IOException
     */
    public EventUpLoadUtils() throws IOException {
        socketJson = new Socket(Constants.HOST, Constants.PORT_JSON);
        gson = new Gson();
    }

    /**
     * 上传时间到服务器
     *
     * @param header         消息头 (参考常量类Constants)
     * @param startLocation  起始地名 100
     * @param endLocation    结束地名 100
     * @param startLongitude 起始经度
     * @param endLongitude   结束经度
     * @param startLatitude  起始纬度
     * @param endLatitude    结束纬度
     * @param eventLabels    事件标签 (多个标签写法例如："拥堵&事故&警察") 100
     * @param eventTitle     事件标题 300
     * @param eventDesc      事件描述 1000
     * @param eventVoice     语音文件名(包括后缀) 100
     * @param eventPic       图片文件名(包括后缀) (一个或一个以上) 100
     * @param eventVideo     视频文件名(包括后缀) 100
     * @param startTime      开始时间 类型为Timestamp
     * @param voiceBin       语音字节数组流
     * @param picBin         图片字节数组流
     * @param videoBin       视频字节数组流
     * @return
     */
    public boolean uploadEvent(String header,
                               String startLocation,
                               String endLocation,
                               Double startLongitude,
                               Double endLongitude,
                               Double startLatitude,
                               Double endLatitude,
                               String[] eventLabels,
                               String eventTitle,
                               String eventDesc,
                               String eventVoice,
                               String[] eventPic,
                               String eventVideo,
                               Timestamp startTime,
                               byte[] voiceBin,
                               ArrayList<byte[]> picBin,
                               byte[] videoBin) throws IOException {
        boolean db = false;
        boolean loc = false;

        //上传文本内容
        db = uploadText(header,
                startLocation,
                endLocation,
                startLongitude,
                endLongitude,
                startLatitude,
                endLatitude,
                eventLabels,
                eventTitle,
                eventDesc,
                eventVoice,
                eventPic,
                eventVideo,
                startTime);

        //上传二进制内容
        if (eventVoice == null && eventPic == null && eventVideo == null) {
            //没有二进制文件可上传
        } else {
            loc = uploadBinary(eventVoice, eventPic, eventVideo, voiceBin, picBin, videoBin);
        }

        //两者都成功才返回true
        if (db == true && loc == true) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 向服务器上传事件文本信息
     *
     * @param header
     * @param startLocation
     * @param endLocation
     * @param startLongitude
     * @param endLongitude
     * @param startLatitude
     * @param endLatitude
     * @param eventLabels
     * @param eventTitle
     * @param eventDesc
     * @param eventVoice
     * @param eventPic
     * @param eventVideo
     * @param startTime
     * @return
     * @throws IOException
     */
    public boolean uploadText(String header,
                              String startLocation,
                              String endLocation,
                              Double startLongitude,
                              Double endLongitude,
                              Double startLatitude,
                              Double endLatitude,
                              String[] eventLabels,
                              String eventTitle,
                              String eventDesc,
                              String eventVoice,
                              String[] eventPic,
                              String eventVideo,
                              Timestamp startTime) throws IOException {

        //读取到输入流的返回信息
        String result = null;

        //将数组转换为以&连接的字符串
        String labels = StringUtils.getStringFromArray(eventLabels);
        String picture = StringUtils.getStringFromArray(eventPic);

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
            eventBean.setVoice(eventVoice);
            eventBean.setPicture(picture);
            eventBean.setVideo(eventVideo);
            eventBean.setStartTime(startTime);

            //创建head + Json串
            String eventData = gson.toJson(eventBean);
            eventData = header + eventData;

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

        if ("1".equals(result)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 上传二进制文件
     *
     * @return
     */
    public boolean uploadBinary(String eventVoice,
                                String[] eventPic,
                                String eventVideo,
                                byte[] voiceBin,
                                ArrayList<byte[]> picBin,
                                byte[] videoBin) throws IOException {

        //建立20001端口的连接
        socketObj = new Socket(Constants.HOST, Constants.PORT_OBJ);

        String result = null;
        OutputStream out = null;
        ObjectOutputStream objectOut = null;
        InputStream in = null;
        try {
            //创建新的Socket连接
            out = socketObj.getOutputStream();
            objectOut = new ObjectOutputStream(out);

            BinaryBean binaryBean = new BinaryBean();
            //添加头信息
            binaryBean.setHeader(Constants.ADD_BIN);

            //语音文件
            binaryBean.setVoiceBinName(eventVoice);
            binaryBean.setVoiceStream(voiceBin);

            if (eventPic != null) {
                //第一张图片
                binaryBean.setPicBinName1(eventPic[0]);
                binaryBean.setPicStream1(picBin.get(0));

                //第二张图片
                binaryBean.setPicBinName2(eventPic[1]);
                binaryBean.setPicStream2(picBin.get(1));

                //第三张图片
                binaryBean.setPicBinName3(eventPic[2]);
                binaryBean.setPicStream3(picBin.get(2));
            } else {
                binaryBean.setPicStream1(null);
                binaryBean.setPicStream2(null);
                binaryBean.setPicStream3(null);
            }

            //视频文件
            binaryBean.setVideoBinName(eventVideo);
            binaryBean.setVideoStream(videoBin);

            //将对象写入流中
            objectOut.writeObject(binaryBean);
            objectOut.flush();
            socketObj.shutdownOutput();

            //读取输入流，获取执行结果
//            in = socketObj.getInputStream();
//            result = StreamUtils.readString(in);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOut.close();
                out.close();
//                in.close();
                socketObj.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if ("1".equals(result)) {
            return true;
        } else {
            return false;
        }
    }
}

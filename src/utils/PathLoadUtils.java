package utils;

import bean.PathBean;
import bean.UserBean;
import com.google.gson.Gson;
import constants.Constants;
import myutils.StreamUtils;
import myutils.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 在进入路况的详情页面时，使用此类获取服务器中媒体文件的地址
 * <p>
 * 使用时间：进入路况的详情页面时
 * <p>
 * Created by Yohann on 2016/8/22.
 */
public class PathLoadUtils {
    private Socket socket;
    private Gson gson;

    /**
     * 构造方法中创建Socket连接对象
     *
     * @throws IOException
     */
    public PathLoadUtils() throws IOException {
        socket = new Socket(Constants.HOST, Constants.PORT_BASIC);
        gson = new Gson();
    }

    /**
     * 获取在线加载媒体文件的路径
     *
     * @return
     */
    public PathBean load(int id) throws IOException {
        //返回的信息
        PathBean pathbeanBack = null;

        if (socket != null) {

            //创建对象模型
            PathBean pathBean = new PathBean();
            pathBean.setId(id);

            //创建head + Json串
            String data = gson.toJson(pathBean);
            data = Constants.TYPE_JSON + Constants.GET_LOAD_PATH + data;

            //写入输出流
            OutputStream out = socket.getOutputStream();
            StreamUtils.writeString(out, data);
            socket.shutdownOutput();

            //获取输入流
            InputStream in = socket.getInputStream();
            String path = StreamUtils.readString(in);

            StringUtils.print(path);

            pathbeanBack = gson.fromJson(path, PathBean.class);

            //关闭流和socket
            out.close();
            in.close();
            StreamUtils.close();
            socket.close();
        }
        return pathbeanBack;
    }
}

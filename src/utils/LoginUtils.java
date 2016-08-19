package utils;

import bean.UserBean;
import com.google.gson.Gson;
import constants.Constants;
import myutils.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 登录工具类
 * <p>
 * <p>
 * 使用说明：每一次使用此类中的方法时，都需要实例化一次
 * <p>
 * Created by Yohann on 2016/8/11.
 */
public class LoginUtils {

    private Socket socket;
    private Gson gson;

    /**
     * 构造方法中创建Socket连接对象
     *
     * @throws IOException
     */
    public LoginUtils() throws IOException {
        socket = new Socket(Constants.HOST, Constants.PORT_JSON);
        gson = new Gson();
    }

    /**
     * 注册
     * <p>
     * 如果注册成功，返回用户个人的具体信息 (Json格式字符串)
     * 如果注册失败，返回字符串"error"
     *
     * @return
     */
    public String register(String username, String password) throws IOException {

        //返回的信息
        String userMsg = null;

        if (socket != null) {

            //创建注册信息对象
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);

            //创建head + Json串
            String regData = gson.toJson(userBean);
            regData = Constants.TYPE_JSON + Constants.REGISTER + regData;

            //写入输出流
            OutputStream out = socket.getOutputStream();
            StreamUtils.writeString(out, regData);
            socket.shutdownOutput();

            //获取输入流
            InputStream in = socket.getInputStream();
            userMsg = StreamUtils.readString(in);

            //关闭流和socket
            out.close();
            in.close();
            StreamUtils.close();
            socket.close();
        }
        return userMsg;
    }


    /**
     * 登录
     * <p>
     * 使用说明：与注册相同
     *
     * @return
     */
    public String login(String username, String password) throws IOException {

        //返回的信息
        String userMsg = null;

        if (socket != null) {

            //创建注册信息对象
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);

            //创建head + Json串
            String regData = gson.toJson(userBean);
            regData = Constants.TYPE_JSON + Constants.LOGIN + regData;

            //写入输出流
            OutputStream out = socket.getOutputStream();
            StreamUtils.writeString(out, regData);
            socket.shutdownOutput();

            //获取输入流
            InputStream in = socket.getInputStream();
            userMsg = StreamUtils.readString(in);

            //关闭流和socket
            out.close();
            in.close();
            StreamUtils.close();
            socket.close();
        }
        return userMsg;
    }
}

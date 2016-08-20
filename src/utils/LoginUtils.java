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

    private Socket socketReg;
    private Socket socketLogin;
    private Gson gson;

    /**
     * 构造方法中创建Socket连接对象
     *
     * @throws IOException
     */
    public LoginUtils() throws IOException {
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

        //创建连接
        socketReg = new Socket(Constants.HOST, Constants.PORT_BASIC);

        //返回的信息
        String userMsg = null;

        if (socketReg != null) {

            //创建注册信息对象
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);

            //创建head + Json串
            String regData = gson.toJson(userBean);
            regData = Constants.TYPE_JSON + Constants.REGISTER + regData;

            //写入输出流
            OutputStream out = socketReg.getOutputStream();
            StreamUtils.writeString(out, regData);
            socketReg.shutdownOutput();

            //获取输入流
            InputStream in = socketReg.getInputStream();
            userMsg = StreamUtils.readString(in);

            //关闭流和socket
            out.close();
            in.close();
            StreamUtils.close();
            socketReg.close();
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

        //创建连接
        socketLogin = new Socket(Constants.HOST, Constants.PORT_BASIC);

        //返回的信息
        String userMsg = null;

        if (socketLogin != null) {

            //创建注册信息对象
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);

            //创建head + Json串
            String regData = gson.toJson(userBean);
            regData = Constants.TYPE_JSON + Constants.LOGIN + regData;

            //写入输出流
            OutputStream out = socketLogin.getOutputStream();
            StreamUtils.writeString(out, regData);
            socketLogin.shutdownOutput();

            //获取输入流
            InputStream in = socketLogin.getInputStream();
            userMsg = StreamUtils.readString(in);

            //关闭流和socket
            out.close();
            in.close();
            StreamUtils.close();
            socketLogin.close();
        }
        return userMsg;
    }
}

import bean.UserLoginData;
import bean.UserRegData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

/**
 * 登录工具类
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
        socket = new Socket(Constants.HOST, Constants.PORT);
        gson = new Gson();
    }

    /**
     * 注册
     *
     * @return
     */
    public boolean register(String head, String username, String password) throws IOException {
        if (socket != null) {

            //创建注册信息对象
            UserRegData userRegData = new UserRegData();
            userRegData.setUsername(username);
            userRegData.setPassword(password);

            //创建head + Json串
            String regData = gson.toJson(userRegData);
            regData = head + regData;

            //写入输出流
            OutputStream out = socket.getOutputStream();
            StreamUtils.writeString(out, regData);
            socket.shutdownOutput();

            //获取输入流
            InputStream in = socket.getInputStream();
            String result = StreamUtils.readString(in);

            //解析result (Json串)
            Map<String, Boolean> jResult = gson.fromJson(result, new TypeToken<Map<String, Boolean>>() {
            }.getType());

            System.out.println("result = " + result);

            //关闭流和socket
            StreamUtils.close();
            socket.close();

            return jResult.get("result");
        }
        return false;
    }


    /**
     * 登录
     *
     * @return
     */
    public boolean login(String head, String username, String password) throws IOException {
        if (socket != null) {

            //创建注册信息对象
            UserLoginData userLoginData = new UserLoginData();
            userLoginData.setUsername(username);
            userLoginData.setPassword(password);

            //创建head + Json串
            String loginData = gson.toJson(userLoginData);
            loginData = head + loginData;

            //写入输出流
            OutputStream out = socket.getOutputStream();
            StreamUtils.writeString(out, loginData);
            socket.shutdownOutput();

            //获取输入流
            InputStream in = socket.getInputStream();
            String result = StreamUtils.readString(in);

            //解析result (Json串)
            Map<String, Boolean> jResult = gson.fromJson(result, new TypeToken<Map<String, Boolean>>() {
            }.getType());

            System.out.println("result = " + result);

            //关闭流和socket
            StreamUtils.close();
            socket.close();

            return jResult.get("result");
        }
        return false;
    }
}

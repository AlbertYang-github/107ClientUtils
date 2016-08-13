import org.junit.Test;

import java.io.IOException;

/**
 * Created by Yohann on 2016/8/11.
 */
public class JunitTest {
    @Test
    public void register() {
        try {
            //连接到服务器
            LoginUtils loginUtils = new LoginUtils();
            //注册
            String s = loginUtils.register(Constants.REGISTER, "yanghuan", "123");
            System.out.println("注册结果：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            LoginUtils loginUtils = new LoginUtils();
            String s = loginUtils.login(Constants.LOGIN, "yanghuan", "123");
            System.out.println("登陆结果：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


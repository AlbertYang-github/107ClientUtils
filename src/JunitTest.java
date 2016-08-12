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
            loginUtils.register(Constants.REGISTER, "杨欢", "abc123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            LoginUtils loginUtils = new LoginUtils();
            loginUtils.login(Constants.LOGIN, "yanghuan", "abc123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


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
            loginUtils.register(1, "yanghuan3", "abc123");
            loginUtils.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


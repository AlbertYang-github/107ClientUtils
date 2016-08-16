package constants;

/**
 * Created by Yohann on 2016/8/11.
 */
public class Constants {

    /**
     * 主机地址
     */
//    public static final String HOST = "123.206.8.57";   //服务器
    public static final String HOST = "10.130.134.9";   //本台电脑

    /**
     * 主机端口号(传输Json数据)
     */
    public static final int PORT_JSON = 20000;

    /**
     * 主机端口号(传输Java对象)
     */
    public static final int PORT_OBJ = 20001;

    /**
     * 注册
     */
    public static final String REGISTER = "001";

    /**
     * 登录
     */
    public static final String LOGIN = "002";

    /**
     * 添加标记
     */
    public static final String ADD_EVENT = "003";

    /**
     * 获取标记
     */
    public static final String GET_EVENT = "004";

    /**
     * 上传二进制媒体文件
     */
    public static final String ADD_BIN = "005";
}

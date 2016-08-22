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
    public static final int PORT_BASIC = 20000;

    /**
     * 用户推送消息的端口
     */
    public static final int PORT_PUSH = 20001;

    /**
     * Json数据类型
     */
    public static final String TYPE_JSON = "json";

    /**
     * Byte数据类型
     */
    public static final String TYPE_BYTE = "byte";

    /**
     * 注册
     */
    public static final String REGISTER = "001";

    /**
     * 登录
     */
    public static final String LOGIN = "002";

    /**
     * 添加事件的文本信息
     */
    public static final String ADD_EVENT_TEXT = "003";

    /**
     * 添加事件的二进制文件
     */
    public static final String ADD_EVENT_BIN = "004";

    /**
     * 请求事件文本信息
     */
    public static final String GET_EVENT_TEXT = "005";

    /**
     * 删除信息
     */
    public static final String REMOVE_EVENT = "006";

    /**
     * 获取在线加载媒体文件的路径
     */
    public static final String GET_LOAD_PATH = "007";
}

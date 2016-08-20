package constants;

import bean.EventBean;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Yohann on 2016/8/19.
 */
public class Variable {
    /**
     * 上传媒体文件的进度
     */
    public static long UpLength = 0;

    /**
     * 上传媒体文件的总长度
     */
    public static long length = 0;

    /**
     * 上传媒体文件的百分比
     */
    public static int progress = 0;

    /**
     * 收到的推送数据
     */
    public static ArrayList<EventBean> dataList = new ArrayList<>();
}

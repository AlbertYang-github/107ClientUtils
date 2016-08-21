package constants;

import bean.EventBean;

import java.util.ArrayList;

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
     * 从服务器获取的到事件的基本信息 (包括推送和请求数据, 注意使用过的数据删除掉, 避免不必要的操作)
     */
    public static ArrayList<EventBean> dataList = new ArrayList<>();
}

import bean.EventBean;
import com.google.gson.Gson;
import com.sun.xml.internal.fastinfoset.stax.events.EventBase;

import java.io.IOException;
import java.net.Socket;
import java.sql.Timestamp;

/**
 * 事件工具类
 * <p>
 * 1.向服务器上传事件
 * 2.从服务器获取事件
 * <p>
 * Created by Yohann on 2016/8/12.
 */
public class EventUtils {

    private Socket socket;
    private Gson gson;

    /**
     * 构造方法中创建Socket连接
     *
     * @throws IOException
     */
    public EventUtils() throws IOException {
        socket = new Socket(Constants.HOST, Constants.PORT);
        gson = new Gson();
    }

    /**
     * 上传文本类型的事件信息
     *
     * @return
     */
    public boolean uploadText(Integer id,
                              String startLocation,
                              String endLocation,
                              Double startLongitude,
                              Double endLongitude,
                              Double startLatitude,
                              Double endLatitude,
                              String eventType,
                              String eventTitle,
                              String eventDesc,
                              Timestamp startTime) {
        boolean result = false;

        //创建事件模型
        EventBean eventBean = new EventBean();
        eventBean.setId(id);
        eventBean.setStartLocation(startLocation);
        eventBean.setEndLocation(endLocation);
        eventBean.setStartLongitude(startLongitude);
        eventBean.setEndLongitude(endLongitude);
        eventBean.setStartLatitude(startLatitude);
        eventBean.setEndLatitude(endLatitude);
        eventBean.setEventType(eventType);
        eventBean.setEventTitle(eventTitle);
        eventBean.setEventDesc(eventDesc);
        eventBean.setStartTime(startTime);

        return result;
    }

    /**
     * 上传媒体事件信息
     *
     * @return
     */
    public boolean uploadMedia() {
        boolean result = false;

        return result;
    }
}

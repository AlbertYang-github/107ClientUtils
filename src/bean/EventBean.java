package bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Yohann on 2016/8/12.
 */
public class EventBean {
    //事件id
    private Integer id;
    //起始地点名
    private String startLocation;
    //结束地点名
    private String endLocation;
    //起始地点经度
    private Double startLongitude;
    //结束地点经度
    private Double endLongitude;
    //起始地点纬度
    private Double startLatitude;
    //结束地点纬度
    private Double endLatitude;
    //事件类型
    private String eventType;
    //事件标题
    private String eventTitle;
    //事件描述
    private String eventDesc;
    //起始时间
    private Timestamp startTime;
    //结束时间
    private Timestamp endTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setStartLongitude(Double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public void setEndLongitude(Double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public void setStartLatitude(Double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public void setEndLatitude(Double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public Double getStartLongitude() {
        return startLongitude;
    }

    public Double getEndLongitude() {
        return endLongitude;
    }

    public Double getStartLatitude() {
        return startLatitude;
    }

    public Double getEndLatitude() {
        return endLatitude;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }
}
package bean;

import java.sql.Timestamp;

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
    private String eventLabels;
    //事件标题
    private String eventTitle;
    //事件描述
    private String eventDesc;
    //语音文件名
    private String voice;
    //语音文件路径
    private String voicePath;
    //图片文件名
    private String picture;
    //图片文件路径
    private String picPath;
    //视频文件名
    private String video;
    //视频文件路径
    private String videoPath;
    //起始时间
    private Long startTime;
    //结束时间
    private Long endTime;

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

    public void setEventLabels(String eventLabels) {
        this.eventLabels = eventLabels;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Long endTime) {
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

    public String getEventLabels() {
        return eventLabels;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public String getVoice() {
        return voice;
    }

    public String getPicture() {
        return picture;
    }

    public String getVideo() {
        return video;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public String getPicPath() {
        return picPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }
}
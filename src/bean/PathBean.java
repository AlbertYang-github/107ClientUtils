package bean;

/**
 * Web服务器中的资源路径
 * <p>
 * Created by Yohann on 2016/8/22.
 */
public class PathBean {
    private Integer id;
    private String voicePath;
    private String picPath1;
    private String picPath2;
    private String picPath3;
    private String videoPath;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public void setPicPath1(String picPath1) {
        this.picPath1 = picPath1;
    }

    public void setPicPath2(String picPath2) {
        this.picPath2 = picPath2;
    }

    public void setPicPath3(String picPath3) {
        this.picPath3 = picPath3;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Integer getId() {
        return id;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public String getPicPath1() {
        return picPath1;
    }

    public String getPicPath2() {
        return picPath2;
    }

    public String getPicPath3() {
        return picPath3;
    }

    public String getVideoPath() {
        return videoPath;
    }
}

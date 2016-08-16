package bean;

import java.io.Serializable;

/**
 * 传输对象模型
 * <p>
 * Created by Yohann on 2016/8/14.
 */
public class BinaryBean implements Serializable {
    private String header;

    private String voiceBinName;
    private String picBinName1;
    private String picBinName2;
    private String picBinName3;
    private String videoBinName;
    private byte[] voiceStream;
    private byte[] picStream1;
    private byte[] picStream2;
    private byte[] picStream3;
    private byte[] videoStream;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setVoiceBinName(String voiceBinName) {
        this.voiceBinName = voiceBinName;
    }

    public void setPicBinName1(String picBinName1) {
        this.picBinName1 = picBinName1;
    }

    public void setPicBinName2(String picBinName2) {
        this.picBinName2 = picBinName2;
    }

    public void setPicBinName3(String picBinName3) {
        this.picBinName3 = picBinName3;
    }

    public void setVideoBinName(String videoBinName) {
        this.videoBinName = videoBinName;
    }

    public void setVoiceStream(byte[] voiceStream) {
        this.voiceStream = voiceStream;
    }

    public void setPicStream1(byte[] picStream1) {
        this.picStream1 = picStream1;
    }

    public void setPicStream2(byte[] picStream2) {
        this.picStream2 = picStream2;
    }

    public void setPicStream3(byte[] picStream3) {
        this.picStream3 = picStream3;
    }

    public void setVideoStream(byte[] videoStream) {
        this.videoStream = videoStream;
    }

    public String getHeader() {
        return header;
    }

    public String getVoiceBinName() {
        return voiceBinName;
    }

    public String getPicBinName1() {
        return picBinName1;
    }

    public String getPicBinName2() {
        return picBinName2;
    }

    public String getPicBinName3() {
        return picBinName3;
    }

    public String getVideoBinName() {
        return videoBinName;
    }

    public byte[] getVoiceStream() {
        return voiceStream;
    }

    public byte[] getPicStream1() {
        return picStream1;
    }

    public byte[] getPicStream2() {
        return picStream2;
    }

    public byte[] getPicStream3() {
        return picStream3;
    }

    public byte[] getVideoStream() {
        return videoStream;
    }
}

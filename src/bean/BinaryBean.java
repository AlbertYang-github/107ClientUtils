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
    private byte[] voiceBytes;
    private byte[] picBytes1;
    private byte[] picBytes2;
    private byte[] picBytes3;
    private byte[] videoBytes;

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

    public void setVoiceBytes(byte[] voiceBytes) {
        this.voiceBytes = voiceBytes;
    }

    public void setPicBytes1(byte[] picBytes1) {
        this.picBytes1 = picBytes1;
    }

    public void setPicBytes2(byte[] picBytes2) {
        this.picBytes2 = picBytes2;
    }

    public void setPicBytes3(byte[] picBytes3) {
        this.picBytes3 = picBytes3;
    }

    public void setVideoBytes(byte[] videoBytes) {
        this.videoBytes = videoBytes;
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

    public byte[] getVoiceBytes() {
        return voiceBytes;
    }

    public byte[] getPicBytes1() {
        return picBytes1;
    }

    public byte[] getPicBytes2() {
        return picBytes2;
    }

    public byte[] getPicBytes3() {
        return picBytes3;
    }

    public byte[] getVideoBytes() {
        return videoBytes;
    }
}

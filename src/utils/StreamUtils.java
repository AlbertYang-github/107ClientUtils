package utils;

import java.io.*;

/**
 * 流解析工具
 * <p>
 * Created by Yohann on 2016/8/11.
 */
public class StreamUtils {

    private static InputStreamReader inReader;

    /**
     * 从流中获取字符串
     *
     * @param in InputSream
     * @return String
     */
    public static String readString(InputStream in) throws UnsupportedEncodingException {
        inReader = new InputStreamReader(in, "UTF-8");
        StringBuilder strBuilder = new StringBuilder();
        char[] buffer = new char[20];
        int len = 0;
        try {
            while((len = inReader.read(buffer)) != -1) {
                strBuilder.append(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuilder.toString();
    }

    /**
     * 将字符数据写入流中
     *
     * @param out
     * @param data
     * @throws IOException
     */
    public static void writeString(OutputStream out, String data) throws IOException {
        out.write(data.getBytes("UTF-8"));
        out.flush();
    }

    public static void close() throws IOException {
        inReader.close();
    }
}

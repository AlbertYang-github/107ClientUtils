import java.io.*;

/**
 * 流处理工具
 * <p>
 * Created by Yohann on 2016/8/11.
 */
public class StreamUtils {
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

    /**
     * 从流中获取字符串
     *
     * @param in InputSream
     * @return String
     */
    public static String readString(InputStream in) throws UnsupportedEncodingException {
        InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
        StringBuilder strBuilder = new StringBuilder();
        char[] buffer = new char[20];
        int len = 0;
        try {
            while((len = inReader.read(buffer)) != -1) {
                strBuilder.append(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strBuilder.toString();
    }
}

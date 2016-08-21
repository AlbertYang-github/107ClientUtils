package myutils;

import constants.Variable;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 流解析工具
 * <p>
 * Created by Yohann on 2016/8/11.
 */
public class StreamUtils {

    private static InputStreamReader inReader;

    //字符缓冲区大小
    private static final int BUFFER_CHAR = 100;
    //字节缓冲区大小
    private static final int BUFFER_BYTE = 1024 * 500;

    /**
     * 从流中获取字符串
     *
     * @param in InputSream
     * @return String
     */
    public static String readString(InputStream in) throws UnsupportedEncodingException {
        inReader = new InputStreamReader(in, "UTF-8");
        StringBuilder strBuilder = new StringBuilder();
        char[] buffer = new char[BUFFER_CHAR];
        int len = 0;
        try {
            while ((len = inReader.read(buffer)) != -1) {
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

    public static byte[] getBytes(String filePath) {
        File file = new File(filePath);
        FileInputStream fileIn = null;
        byte[] bytes = null;
        try {
            fileIn = new FileInputStream(file);
            int len = (int) file.length();
            bytes = new byte[len];
            fileIn.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bytes;
    }

    /**
     * 压缩目录
     *
     * @param dir
     * @throws IOException
     */
    public static void compressDir(File dir, OutputStream out) throws IOException {
        ZipOutputStream zos = null;
        BufferedInputStream bis = null;
        FileInputStream fis = null;

        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }

        //获取目录下的所有文件
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("指定的不是目录");
        } else {
            zos = new ZipOutputStream(out);
            bis = null;

            //计算文件总长度
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                Variable.length += file.length();
            }

            for (int i = 0; i < files.length; i++) {
                //压缩一个文件
                File file = files[i];
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                ZipEntry entry = new ZipEntry(file.getName());
                zos.putNextEntry(entry);
                int len = 0;
                byte[] buf = new byte[BUFFER_BYTE];
                while ((len = bis.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                    zos.flush();
                    //更新上传进度
                    Variable.UpLength += len;
                    if (Variable.UpLength < Variable.length) {
                        Variable.progress = (int) ((Variable.UpLength * 100) / Variable.length);
                    }
                }
                bis.close();
                fis.close();
            }
        }
    }

    /**
     * 解压缩目录
     *
     * @param desDir
     * @param in
     * @throws IOException
     */
    public static void decompress(File desDir, InputStream in) throws IOException {
        if (!desDir.exists()) {
            desDir.mkdirs();
        }

        BufferedOutputStream bos = null;
        ZipInputStream zis = new ZipInputStream(in);
        ZipEntry entry = null;

        while ((entry = zis.getNextEntry()) != null) {
            String path = desDir + File.separator + entry.getName();
            File file = new File(path);
            bos = new BufferedOutputStream(
                    new FileOutputStream(file));
            int len = 0;
            byte[] buf = new byte[BUFFER_BYTE];
            while ((len = zis.read(buf)) != -1) {
                bos.write(buf, 0, len);
                bos.flush();
            }
        }

        bos.close();
        zis.close();
    }
}

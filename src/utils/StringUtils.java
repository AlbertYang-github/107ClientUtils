package utils;

/**
 * Created by Yohann on 2016/8/14.
 */
public class StringUtils {

    /**
     * 将数组元素转换为"xxx&xxx&xxx"这种格式的字符串
     *
     * @param arr
     * @return
     */
    public static String getStringFromArray(String[] arr) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                strBuilder.append(arr[i] + "&");
            } else {
                strBuilder.append(arr[i]);
            }
        }
        return strBuilder.toString();
    }

    /**
     * 将"xxx&xxx&xxx"这种格式的字符串转换为String[]
     *
     * @param str
     * @return
     */
    public static String[] getArrayFromString(String str) {
        String[] arr = str.split("&");
        return arr;
    }
}
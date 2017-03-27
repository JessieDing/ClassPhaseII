package d0327;

/**
 * Created by Administrator on 2017/3/27.
 */
public class MaxStringTest {

    public static void main(String[] args) {
        String str1 = "abcd123x3xxy7opz";
        String str2 = "abc123x3xzy77opwc";
        System.out.println(getMaxIdenticalString(str1,str2));

    }

    static String getMaxIdenticalString(String str1, String str2) {
        String maxString = str1.length() >= str2.length() ? str1 : str2;
        String minString = str1.length() < str2.length() ? str1 : str2;
        int[][] matrix = new int[maxString.length()][maxString.length()];

        //矩阵：maxString行；minString列。不等为0，相等为1，则相等字符串所形成的矩阵的对角线为数字1序列。
        for (int i = 0; i < maxString.length(); i++) {
            char c1 = maxString.charAt(i);
            for (int j = 0; j < minString.length(); j++) {
                char c2 = minString.charAt(j);
                if (c1 == c2) {
                    if (i > 0 && j > 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        int endIndex = -1;//最长子字符串末尾对应下标
        int max = 0;//代表最长子字符串的矩阵的对角线长度
        for (int i = 0; i < maxString.length(); i++) {
            for (int j = 0; j < maxString.length(); j++) {
                int number = matrix[i][j];
                if (number > max) {
                    max = number;
                    endIndex = i;
                }
            }
        }

        //取出最长子字符串
        String result = "";
        for (int i = 0; i < max; i++) {
            result = maxString.charAt(endIndex) + result;
            endIndex--;  //
        }

        return result;
    }
    }


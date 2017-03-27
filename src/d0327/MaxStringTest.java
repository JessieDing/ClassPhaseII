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

        //����maxString�У�minString�С�����Ϊ0�����Ϊ1��������ַ������γɵľ���ĶԽ���Ϊ����1���С�
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

        int endIndex = -1;//����ַ���ĩβ��Ӧ�±�
        int max = 0;//��������ַ����ľ���ĶԽ��߳���
        for (int i = 0; i < maxString.length(); i++) {
            for (int j = 0; j < maxString.length(); j++) {
                int number = matrix[i][j];
                if (number > max) {
                    max = number;
                    endIndex = i;
                }
            }
        }

        //ȡ������ַ���
        String result = "";
        for (int i = 0; i < max; i++) {
            result = maxString.charAt(endIndex) + result;
            endIndex--;  //
        }

        return result;
    }
    }


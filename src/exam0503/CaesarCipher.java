package exam0503;

/**
 * Created by dell on 2017/5/3.
 */
public class CaesarCipher {
    public static void main(String[] args) {
//        String plain = "abcdef";
//        String key = "123";
        String plain = "abcwdcfop";
        String key = "1237";
        String text = encrypt(plain, key);
        System.out.println("Cipher text: " + text);
    }

    public static String encrypt(String plain, String key) {
        StringBuffer cipherText = new StringBuffer();
        char[] arrStr = plain.toCharArray();
        char[] arrKey = key.toCharArray();
        int n = 0;

        for (int i = 0; i < arrStr.length; i++) {
            int a = arrStr[i];
            int b = arrKey[n];
            char c = (char) (a - b);
            cipherText.append(c);
            n++;
            if (n == arrKey.length) {
                n = 0;
            }
        }
        return cipherText.toString();
    }
}

package d0327;

/**
 * Created by Administrator on 2017/3/29.
 */
public class MyStringTest {
    public static void main(String[] args) {
        MyString string1 = new MyString("abc13abc222345abc5abc4abc0".toCharArray());
        MyString str2 = new MyString("abc".toCharArray());
        MyString str3 = new MyString("x".toCharArray());

        System.out.println(string1.replaceAll(str2, str3).toString());

    }
}

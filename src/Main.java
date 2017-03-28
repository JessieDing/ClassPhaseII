import d0327.MyString;


public class Main {

    public static void main(String[] args) {
        MyString string1 = new MyString("abc13abc222345abc5abc4abc0".toCharArray());
        MyString str2 = new MyString("abc".toCharArray());
        MyString str3 = new MyString("x".toCharArray());

        System.out.println(string1.replaceAll(str2, str3).toString());

    }
}
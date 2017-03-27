package d0327;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public class MyString {
    private char[] data;

    public MyString() {
        data = new char[1024];
    }

    public MyString(char[] arr) {
        // this.data = arr;
        // String
        data = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
    }

    public MyString(MyString str) { // copy constructor拷贝构造
        data = new char[str.getData().length];

        for (int i = 0; i < str.getData().length; i++) {
            data[i] = str.getData()[i];
        }
    }

    // 查找某个字符第一次出现的位置
    public int indexOf(char c) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) {
                return i;
            }
        }
        return -1;// 没查找到
    }

    /// 查找某个字符串第一次出现的位置
    public int indexOf(MyString str) {
        for (int i = 0; i < data.length; i++) {
            char[] strArr = str.getData();
            if (data[i] == strArr[0]) {
                return i;
            }
        }
        return -1;
    }

    // 取子字符串
    public MyString subString(int start, int end) {
        if (start >= end) {
            System.out.println("输入错误");
            return this;
        }
        if (end >= data.length) {
            System.out.println("超出长度");
            return this;
        }

        int length = end - start;
        char[] newString = new char[length];
        int j = 0;
        for (int i = start; i < start + length; i++) {
            newString[j] = data[i];
            j++;
        }
        return new MyString(newString);
    }

    // ReplaceAll方法
    public MyString replaceAll(MyString oldString, MyString newString) {
        int old_cnt = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == oldString.data[0]) {
                old_cnt++;
            }
        }

        // 最后拿到的新MyString的字符数组，及其长度
        int lens = data.length + (newString.length() - oldString.length()) * old_cnt;
        char[] newData = new char[lens];

        // for (int i = 0; i < data.length; i++) {
        int i = 0;
        int j = 0;

        while (j < old_cnt) {
            while (i < data.length) {
                int newStartPos = 0;
                int startPos = i;// startPos 原数组
                int endPos = i + oldString.length() - 1;
                // char[] tmp = new char[oldString.length()];
                // while (j < oldString.length()) {
                // tmp[j] = data[startPos];
                // j++;
                // startPos++;
                // }

                // 拿出原data中与old等长的一段数组进行比较
                char[] originShort = new char[oldString.length()];
                originShort = Arrays.copyOfRange(data, startPos, endPos + 1);// 注意边界
                // System.arraycopy(data, startPos, originShort, 0,
                // oldString.length());

                if (isEqual(oldString.getData(), originShort)) {
                    System.arraycopy(newString.getData(), 0, newData, startPos + j, newString.length());
                    i = i + (oldString.length());
                    break;
                } else {

                    System.arraycopy(data, i, newData, newStartPos + newString.length(), 1);
                    // System.arraycopy(data, startPos, newData, startPos + j,
                    // newString.length());
                    newData[i + j] = data[i];// ????newData位置
                }

                i++;
            }

            j++;
        }

        return new MyString(newData);
    }

    public MyString replace(MyString oldString, MyString newString) {
        int startIndex = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == oldString.data[0] && data.length - i >= oldString.length()) {
                int count = 0;
                for (int j = 0; j < oldString.length(); j++) {
                    if (data[i + j] == oldString.data[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == oldString.length()) {
                    startIndex = i; // old在原数组中的起始位置下标
                    break;
                }
            }
        }
        if (startIndex > -1) {
            char[] newData = new char[newString.length() - oldString.length() + data.length];// 替换后，数组长度
            System.arraycopy(data, 0, newData, 0, startIndex);
            System.arraycopy(newString.data, 0, newData, startIndex, newString.length());// copy长度为new的长度
            System.arraycopy(data, startIndex + oldString.length(), newData, startIndex + newString.length(),
                    data.length - startIndex - oldString.length());
            return new MyString(newData);
        } else {
            return this;
        }
    }

    public int length() {
        return getData().length;
    }

    public boolean isSubset(char[] originCharArr, char[] changableArr) {
        char[] tmp = new char[changableArr.length];
        for (int i = 0; i < originCharArr.length; i++) {
            if (changableArr[0] == originCharArr[i] && (originCharArr.length - i) >= changableArr.length) {
                System.arraycopy(originCharArr, i, tmp, 0, changableArr.length);
                break;
            }
        }
        boolean flag = true;
        for (int j = 0; j < changableArr.length; j++) {
            if (changableArr[j] != tmp[j]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);

    }

    public boolean isEqual(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] != b[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}


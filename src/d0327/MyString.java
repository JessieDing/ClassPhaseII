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

    public MyString(MyString str) { // copy constructor��������
        data = new char[str.getData().length];

        for (int i = 0; i < str.getData().length; i++) {
            data[i] = str.getData()[i];
        }
    }

    // ����ĳ���ַ���һ�γ��ֵ�λ��
    public int indexOf(char c) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) {
                return i;
            }
        }
        return -1;// û���ҵ�
    }

    /// ����ĳ���ַ�����һ�γ��ֵ�λ��
    public int indexOf(MyString str) {
        for (int i = 0; i < data.length; i++) {
            char[] strArr = str.getData();
            if (data[i] == strArr[0]) {
                return i;
            }
        }
        return -1;
    }

    // ȡ���ַ���
    public MyString subString(int start, int end) {
        if (start >= end) {
            System.out.println("�������");
            return this;
        }
        if (end >= data.length) {
            System.out.println("��������");
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

    // ReplaceAll����
    public MyString replaceAll(MyString oldString, MyString newString) {
        int old_cnt = 0;//oldString��ԭ�����г��ֵĴ���
        for (int i = 0; i < data.length; i++) {
            if (data[i] == oldString.data[0]) {
                old_cnt++;
            }
        }

        // ����õ�����MyString���ַ����飬���䳤��
        int lens = data.length + (newString.length() - oldString.length()) * old_cnt;
        char[] newData = new char[lens];
        int increment = Math.abs(newString.length() - oldString.length());//����������ֵ�������滻�ַ������滻�ַ����ĳ��Ȳ�


        int i = 0;
        int j = 0;

        while (j <= (old_cnt * increment)) {
            while (i < data.length) {

                int startPos = i;// startPos ԭ����
                int endPos = i + oldString.length() - 1;

                // �ó�ԭdata����old�ȳ���һ��������бȽ�
                char[] originShort;
                originShort = Arrays.copyOfRange(data, startPos, endPos + 1);// ע��߽�

                //�滻�������
                if (newData.length == data.length) {
                    if (isEqual(oldString.getData(), originShort)) {
                        System.arraycopy(newString.getData(), 0, newData, startPos, newString.length());
                        i = i + (oldString.length());
                        break;
                    } else {
                        System.arraycopy(data, i, newData, startPos, 1);
                    }
                    //�滻�ַ�����new�����ȴ��ڱ��滻�ַ�����old������
                } else if (newData.length > data.length) {
                    if (isEqual(oldString.getData(), originShort)) {
                        System.arraycopy(newString.getData(), 0, newData, startPos + j, newString.length());
                        i = i + (oldString.length());
                        break;
                    } else {
                        System.arraycopy(data, i, newData, startPos + j, 1);
                    }
                } else {
                    //�滻�ַ�����new������С�ڱ��滻�ַ�����old������
                    if (isEqual(oldString.getData(), originShort)) {
                        System.arraycopy(newString.getData(), 0, newData, startPos - j, newString.length());
                        i = i + (oldString.length());
                        break;
                    } else {
                        System.arraycopy(data, i, newData, startPos - j, 1);
                    }
                }
                i++;
            }
            j += increment;
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
                    startIndex = i; // old��ԭ�����е���ʼλ���±�
                    break;
                }
            }
        }
        if (startIndex > -1) {
            char[] newData = new char[newString.length() - oldString.length() + data.length];// �滻�����鳤��
            System.arraycopy(data, 0, newData, 0, startIndex);
            System.arraycopy(newString.data, 0, newData, startIndex, newString.length());// copy����Ϊnew�ĳ���
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
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}


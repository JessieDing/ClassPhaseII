package d0327;

/**
 * Created by Administrator on 2017/3/27.
 */
public class RandomNumber {
    public static void main(String[] args) {
        int lens = 10;
        int count = 0;

        int[] arr = new int[lens];
        for (int i = 0; i < lens; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < lens; i++) {
            int next = (int) (Math.random() * i);
            count++;
            int temp = arr[i];
            arr[i] = arr[next]; //���������,��������±��Ӧ��Ԫ����ֵ������������ŵ�iλ��
            arr[next] = temp;
        }

        int[] newArr = new int[lens];
        for (int i : arr) {//���������
            newArr[i] = i;//�������
        }

        for (int i : newArr) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(count);
    }
}

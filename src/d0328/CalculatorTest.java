package d0328;

import java.util.Scanner;

/**
 * Created by Jessie on 2017/3/28.
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("����������A");
        double numA = scanner.nextDouble();
        System.out.println("����������B");
        double numB = scanner.nextDouble();
        System.out.println("������һ���������+-*/��");
        String operate = scanner.next();
        //����ģʽ
        OperationFactory oFactory = new OperationFactory();
        Operation operation = oFactory.createOperation(operate);
        double result = operation.calculate(numA, numB);
        System.out.println("������Ϊ��" + result);

    }
}

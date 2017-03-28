package d0328;

import java.util.Scanner;

/**
 * Created by Jessie on 2017/3/28.
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A");
        double numA = scanner.nextDouble();
        System.out.println("请输入数字B");
        double numB = scanner.nextDouble();
        System.out.println("请输入一个运算符（+-*/）");
        String operate = scanner.next();
        //工厂模式
        OperationFactory oFactory = new OperationFactory();
        Operation operation = oFactory.createOperation(operate);
        double result = operation.calculate(numA, numB);
        System.out.println("运算结果为：" + result);

    }
}

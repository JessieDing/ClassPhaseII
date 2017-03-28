package d0328;

import java.util.Scanner;

/**
 * Created by Jessie on 2017/3/28.
 */
public class OperationFactory {


    public Operation createOperation(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationMinus();
                break;
            case "*":
                operation = new OperationMulti();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                operation = new OperationAdd();
        }

        return operation;
    }

}

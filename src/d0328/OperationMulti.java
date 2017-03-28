package d0328;

/**
 * Created by Jessie on 2017/3/28.
 */
public class OperationMulti extends Operation {
    private double numberA;
    private double numberB;

    @Override
    public double calculate(double a, double b) {
        double result;
        result = a * b;
        return result;
    }

    @Override
    public double getNumberA() {
        return numberA;
    }

    @Override
    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    @Override
    public double getNumberB() {
        return numberB;
    }

    @Override
    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}

package d0328;

/**
 * Created by Jessie on 2017/3/28.
 */
public abstract class Operation {
    private double numberA;
    private double numberB;

    public abstract double calculate(double a, double b);


    public Operation() {
    }

    public Operation(double numberA, double numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}

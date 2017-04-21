package homework0419;

/**
 * Created by dell on 2017/4/21.
 */
public class Payment {
    //付款人名称，付款人账户，付款金额，收款人名称，收款人账户
    private String payerName;
    private String payerAcct;
    private double payAmt;
    private String payeeName;
    private String payeeAcct;
    private double fee;

    public Payment() {
    }

    public Payment(String payerName, String payerAcct, double payAmt, String payeeName, String payeeAcct) {
        this.payerName = payerName;
        this.payerAcct = payerAcct;
        this.payAmt = payAmt;
        this.payeeName = payeeName;
        this.payeeAcct = payeeAcct;
    }

    public void calcFee() {
        fee = payAmt * 0.05;
        if ((fee - 50) >= 0.00001) {
            fee = 50.00;
        }
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerAcct() {
        return payerAcct;
    }

    public void setPayerAcct(String payerAcct) {
        this.payerAcct = payerAcct;
    }

    public double getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(double payAmt) {
        this.payAmt = payAmt;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeAcct() {
        return payeeAcct;
    }

    public void setPayeeAcct(String payeeAcct) {
        this.payeeAcct = payeeAcct;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}

package d0419;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2017/4/19.
 */
public class Fund {
    String fundId; //基金编号
    String custName;//客户姓名
    String fundAccNo;//基金账号
    int applyAmt;//份额
    double nav;//净值
    double applyBal;//申购金额
    double chargeFee;//手续费
    Date discountDate;//赎回折扣期

    public Fund() {
    }

    public Fund(String fundId, String custName, String fundAccNo, int applyAmt, double nav) {
        this.fundId = fundId;
        this.custName = custName;
        this.fundAccNo = fundAccNo;
        this.applyAmt = applyAmt;
        this.nav = nav;
    }


    public void calcChargeFee() {
        if (applyBal < 0.00001) {//位计算申购金额
            calcApplyFee();
        }
        chargeFee = applyBal * 0.01;
        if ((chargeFee - 20.00) < 0.00001) {//手续费最低20
            chargeFee = 20.00;
        }
    }

    /*
    * 计算赎回折扣日期
    * */
    public void calcDiscountDate() {
        Date today = new Date();//申购日期为当天
        long l = today.getTime();
        l += (10 * 24 * 3600 * 1000);//加十天赎回折扣期
        today.setTime(l);
        setDiscountDate(today);
    }

    /*
    * 计算申购费用
    * */
    public void calcApplyFee() {
        applyBal = applyAmt * nav;
    }


    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getFundAccNo() {
        return fundAccNo;
    }

    public void setFundAccNo(String fundAccNo) {
        this.fundAccNo = fundAccNo;
    }

    public int getApplyAmt() {
        return applyAmt;
    }

    public void setApplyAmt(int applyAmt) {
        this.applyAmt = applyAmt;
    }

    public double getNav() {
        return nav;
    }

    public void setNav(double nav) {
        this.nav = nav;
    }

    public double getApplyBal() {
        return applyBal;
    }

    public void setApplyBal(double applyBal) {
        this.applyBal = applyBal;
    }

    public double getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(double chargeFee) {
        this.chargeFee = chargeFee;
    }

    public Date getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(Date discountDate) {
        this.discountDate = discountDate;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("######0.00"); //对小数进行格式化
        String strChargeFee = decimalFormat.format(chargeFee);
        String strApplyFee = decimalFormat.format(applyBal);

        SimpleDateFormat mdf = new SimpleDateFormat("yyyy/MM/dd");//对日期进行格式化
        String strDiscountDate = mdf.format(discountDate);

        return
                fundId + "," + custName + "," + fundAccNo + "," + applyAmt + "," + nav + "," + strApplyFee + "," + strChargeFee + "," + strDiscountDate;
    }
}

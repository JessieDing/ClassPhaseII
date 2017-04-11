package homework0407;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/11.
 */
public class FundRevised {
    String fundId;
    String custName;
    String fundAccNo;
    int applyAmt;
    double nav;
    double applyBal;
    double chargeFee;
    Date discountDate;

    public FundRevised() {
    }

    public FundRevised(String fundId, String custName, String fundAccNo, int applyAmt, double nav) {
        this.fundId = fundId;
        this.custName = custName;
        this.fundAccNo = fundAccNo;
        this.applyAmt = applyAmt;
        this.nav = nav;
    }


    public void calcChargeFee() {
        if (applyBal < 0.00001) {//λ�����깺���
            calcApplyFee();
        }
        chargeFee = applyBal * 0.01;
        if ((chargeFee - 20.00) < 0.00001) {//���������20
            chargeFee = 20.00;
        }
    }

    /*
    * ��������ۿ�����
    * */
    public void calcDiscountDate() {
        Date today = new Date();//�깺����Ϊ����
        long l = today.getTime();
        l += (24 * 3600 * 1000);//��ʮ������ۿ���
        today.setTime(l);
        setDiscountDate(today);
    }

    /*
    * �����깺����
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
        DecimalFormat decimalFormat = new DecimalFormat("######0.00"); //��С�����и�ʽ��
        String strChargeFee = decimalFormat.format(chargeFee);
        String strApplyFee = decimalFormat.format(applyBal);

        SimpleDateFormat mdf = new SimpleDateFormat("yyyy/MM/dd");//�����ڽ��и�ʽ��
        String strDiscountDate = mdf.format(discountDate);

        return
                fundId + "," + custName + "," + fundAccNo + "," + applyAmt + "," + nav + "," + strApplyFee + "," + strChargeFee + "," + strDiscountDate;
    }
}

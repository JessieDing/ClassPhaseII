package exam0503.TransXML;

import java.util.Date;

/**
 * Created by dell on 2017/5/3.
 */
public class Fund {
        //基金编号号，客户姓名，基金账号，申购份额，净值，手续费，申购日期
        private String fundId;
        private String custName;
        private String fundAccNo;
        private int applyAmt;
        private double fundNav;
        private double chargeAmt;
        private Date applyDate;

        public Fund() {
        }

        public Fund(String fundId, String custName, String fundAccNo, int applyAmt, double fundNav, double chargeAmt, Date applyDate) {
            this.fundId = fundId;
            this.custName = custName;
            this.fundAccNo = fundAccNo;
            this.applyAmt = applyAmt;
            this.fundNav = fundNav;
            this.chargeAmt = chargeAmt;
            this.applyDate = applyDate;
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

        public double getFundNav() {
            return fundNav;
        }

        public void setFundNav(double fundNav) {
            this.fundNav = fundNav;
        }

        public double getChargeAmt() {
            return chargeAmt;
        }

        public void setChargeAmt(double chargeAmt) {
            this.chargeAmt = chargeAmt;
        }

        public Date getApplyDate() {
            return applyDate;
        }

        public void setApplyDate(Date applyDate) {
            this.applyDate = applyDate;
        }
}

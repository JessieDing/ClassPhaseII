package homework0407;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Funds {
    private List<Fund> fundList;
}

public class Fund {  //原子性
    private String fundName;  //基金名
    private String name;  //客户姓名
    private String fundAcnt;  //基金账号
    private int shares;  //份额
    private double netValue;  //基金净值
    private String filePath;
    private List<Fund> fundList;//fundList不应放入Fund类中

    public Fund() {
        filePath = "e:" + File.separator + "fund_import.txt";
        fundList = new ArrayList<Fund>();
    }

    public Fund(String fundName, String name, String fundAcnt, int shares, double netValue) {
        this.fundName = fundName;
        this.name = name;
        this.fundAcnt = fundAcnt;
        this.shares = shares;
        this.netValue = netValue;
    }

    //拿到基金文件导入的信息
    public List<Fund> readFundFile() {
        File file = new File(filePath);
        String[] arrTmp;
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufReader = new BufferedReader(isr);
            String fileInfo;

            while ((fileInfo = bufReader.readLine()) != null) {
                arrTmp = fileInfo.split("[,，]");
                Fund fund = createFund(arrTmp);
                fundList.add(fund);
            }
            bufReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fundList;
    }

    public Fund createFund(String[] fundInfo) {

        String fundName = new String(fundInfo[0]);  //基金名
        String name = new String(fundInfo[1]);  //客户姓名
        String fundAcnt = new String(fundInfo[2]);  //基金账号
        int shares = Integer.parseInt(fundInfo[3]);  //份额
        double netValue = Double.parseDouble(fundInfo[4]);  //基金净值
        return new Fund(fundName, name, fundAcnt, shares, netValue);
    }

    //计算手续费
    public double calcFee(String fundAcnt, int shares, double netValue) {
        double fee;
        double tmp = (shares * netValue) * 0.01;
        if (tmp < 20) {  //浮点数如何比较？
            fee = 20.00;
        } else {
            fee = tmp;
        }
        System.out.println("基金账户"+fundAcnt+"手续费为："+ fee);
        return fee;
    }

    public void writeToFile() {

    }


    //计算应交割资金
    public double calcDeliveryAmt(int shares, double netValue, double fee) {
        double amount = 0.00;
        amount = (shares * netValue) + fee;
        return amount;
    }


    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFundAcnt() {
        return fundAcnt;
    }

    public void setFundAcnt(String fundAcnt) {
        this.fundAcnt = fundAcnt;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getNetValue() {
        return netValue;
    }

    public void setNetValue(double netValue) {
        this.netValue = netValue;
    }

    public List<Fund> getFundList() {
        return fundList;
    }

    public void setFundList(List<Fund> fundList) {
        this.fundList = fundList;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "fundName='" + fundName + '\'' +
                ", name='" + name + '\'' +
                ", fundAcnt='" + fundAcnt + '\'' +
                ", shares=" + shares +
                ", netValue=" + netValue +
                '}';
    }
}

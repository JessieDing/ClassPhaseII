package homework0407;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Fund {
    private String fundName;  //基金名
    private String name;  //客户姓名
    private String fundAcnt;  //基金账号
    private int shares;  //份额
    private double netValue;  //基金净值
    String filePath;

    public Fund() {
    }

    public Fund(String fundName, String name, String fundAcnt, int shares, double netValue,String filePath) {
        this.fundName = fundName;
        this.name = name;
        this.fundAcnt = fundAcnt;
        this.shares = shares;
        this.netValue = netValue;
        filePath = "src"+ File.separator+"homework0407"+File.separator+"fund_import.txt";//相对路径？
    }


    public static void calcDeliveryAmt(){}

    public int loadFundFile()throws Exception{
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr =  new InputStreamReader(fis,"UTF-8");
        BufferedReader bufReader = new BufferedReader(isr);
        String fileInfo;
        while((fileInfo=bufReader.readLine())!=null){
            String[] arrTmp = fileInfo.split("[,，]");
            Fund fund = createFund(arrTmp);
        }



        return 0;
    }


    public Fund createFund(String[] fundInfo){

        return new Fund();
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
}

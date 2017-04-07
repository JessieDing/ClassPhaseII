package homework0407;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Fund {
    private String fundName;  //������
    private String name;  //�ͻ�����
    private String fundAcnt;  //�����˺�
    private int shares;  //�ݶ�
    private double netValue;  //����ֵ
    String filePath;

    public Fund() {
    }

    public Fund(String fundName, String name, String fundAcnt, int shares, double netValue,String filePath) {
        this.fundName = fundName;
        this.name = name;
        this.fundAcnt = fundAcnt;
        this.shares = shares;
        this.netValue = netValue;
        filePath = "src"+ File.separator+"homework0407"+File.separator+"fund_import.txt";//���·����
    }


    public static void calcDeliveryAmt(){}

    public int loadFundFile()throws Exception{
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr =  new InputStreamReader(fis,"UTF-8");
        BufferedReader bufReader = new BufferedReader(isr);
        String fileInfo;
        while((fileInfo=bufReader.readLine())!=null){
            String[] arrTmp = fileInfo.split("[,��]");
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

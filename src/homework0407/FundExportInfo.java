package homework0407;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundExportInfo {
    private String fundName;
    private String name;
    private String fundAcnt;
    private int shares;
    private double netValue;
    private double fee;
    private double deliverrAmt;
    private String date;
    //    String exportFilePath;
//    List<Fund> fundList;
    List<FundExportInfo> fundInfoList;

    public FundExportInfo() {
        this.fundInfoList = new ArrayList<>();
    }

    public FundExportInfo(String fundName, String name, String fundAcnt, int shares, double netValue, double fee, double deliverrAmt, String date) {
        this.fundName = fundName;
        this.name = name;
        this.fundAcnt = fundAcnt;
        this.shares = shares;
        this.netValue = netValue;
        this.fee = fee;
        this.deliverrAmt = deliverrAmt;
        this.date = date;
    }

    //输出的信息
    public List<FundExportInfo> getExportFileList(List<Fund> fundFileList) {

        for (Fund f : fundFileList) {
            String fundName = f.getFundName();
            String name = f.getName();
            String fundAcnt = f.getFundAcnt();
            int shares = f.getShares();
            double netValue = f.getNetValue();
            double fee = f.calcFee(fundAcnt,shares, netValue);
            double deliverrAmt = f.calcDeliveryAmt(shares, netValue, fee);
            Date date = new Date();
            SimpleDateFormat mdf = new SimpleDateFormat("yyyy/MM/dd");

            FundExportInfo info = new FundExportInfo(fundName, name, fundAcnt, shares, netValue, fee, deliverrAmt, mdf.format(date));
            fundInfoList.add(info);
        }
        return fundInfoList;
    }

    //将输出信息写入txt
    public static void write(String filePath, List<FundExportInfo> infoList) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
            PrintWriter printWriter = new PrintWriter(writer,false);
            for (FundExportInfo info : infoList) {
                String string = info.toFileString();
                printWriter.println(string);
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //输出信息格式
    public String toFileString() {
        return fundName + "," + name + "," + fundAcnt + "," + shares + "," + netValue + "," + fee + "," + deliverrAmt + "," + date;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getDeliverrAmt() {
        return deliverrAmt;
    }

    public void setDeliverrAmt(double deliverrAmt) {
        this.deliverrAmt = deliverrAmt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<FundExportInfo> getFundInfoList() {
        return fundInfoList;
    }

    public void setFundInfoList(List<FundExportInfo> fundInfoList) {
        this.fundInfoList = fundInfoList;
    }
}

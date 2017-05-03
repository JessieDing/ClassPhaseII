package exam0503.TransXML;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DingJie on 2017/5/3.
 */
public class TxtToXml {

    public static void main(String[] args) {
        List<Fund> fundList = readFile("src/exam0503/TransXML/fund.txt");
        try {
            writeXML("D:/TransDetail.xml", fundList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Fund> readFile(String filePath) {
        InputStream is = null;
        BufferedReader reader = null;
        List<Fund> fundList = new ArrayList<>();
        try {
            is = new FileInputStream(filePath);
            reader = new BufferedReader(new InputStreamReader(is));
            String tmpString = null;
            while ((tmpString = reader.readLine()) != null) {
                String str = tmpString;
                Fund fund = new Fund();
                insertToFund(tmpString, fund);
                fundList.add(fund);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fundList;
    }

    public static void insertToFund(String str, Fund fund) {
        String[] msgArr = str.split(",");

        String fundId = msgArr[0];
        String custName = msgArr[1];
        String fundAccNo = msgArr[2];
        int applyAmt = Integer.valueOf(msgArr[3]);
        double fundNav = Double.parseDouble(msgArr[4]);
        double chargeAmt = Double.parseDouble(msgArr[5]);
        String strDate = msgArr[6];

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date applyDate = null;
        try {
            applyDate = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fund.setFundId(fundId);
        fund.setCustName(custName);
        fund.setFundAccNo(fundAccNo);
        fund.setApplyAmt(applyAmt);
        fund.setFundNav(fundNav);
        fund.setChargeAmt(chargeAmt);
        fund.setApplyDate(applyDate);
    }

    private static void writeXML(String filePath, List<Fund> fundList) throws Exception {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("xml");
        for (Fund fund : fundList) {
            Element TransDetail = root.addElement("TransDetail");
            Element FundId = TransDetail.addElement("FundId");
            FundId.addText(fund.getFundId());
            Element CustName = TransDetail.addElement("CustName");
            CustName.addText(fund.getCustName());
            Element FundAccNo = TransDetail.addElement("FundAccNo");
            FundAccNo.addText(fund.getFundAccNo());
            Element ApplyAmt = TransDetail.addElement("ApplyAmt");
            ApplyAmt.addText(String.valueOf(fund.getApplyAmt()));
            Element FundNav = TransDetail.addElement("FundNav");
            FundNav.addText(String.valueOf(fund.getFundNav()));
            Element ChargeAmt = TransDetail.addElement("ChargeAmt");
            ChargeAmt.addText(String.valueOf(fund.getChargeAmt()));

            Element ApplyDate = TransDetail.addElement("ApplyDate");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ApplyDate.addText(format.format(fund.getApplyDate()));
        }
        XMLWriter writer = new XMLWriter();
        FileOutputStream fos = new FileOutputStream(filePath);
        writer.setOutputStream(fos);
        writer.write(doc);
        System.out.println("Received successfully.");
        writer.close();
    }
}



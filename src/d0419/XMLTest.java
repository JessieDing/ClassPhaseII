package d0419;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/4/19.
 */
public class XMLTest {
    public static void main(String[] args) {
        /*
        * List<Fund> fundList = new ArrayList<>();
        Fund fund1 = new Fund("003003", "张三", "A0001", 10000, 1.12);
        Fund fund2 = new Fund("003003", "李四", "A0002", 1000, 1.12);
        Fund fund3 = new Fund("003003", "王五", "A0003", 12000, 1.12);
        fundList.add(fund1);
        fundList.add(fund2);
        fundList.add(fund3);
        * */
        try {
//            testReadXml("src/d0419/Funds.xml");
//            testWriteXml("src/d0419/fund.xml", fundList);
            testWriteXml_2("src/d0419/fund.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<Fund> getAllAccts() {
        Fund f1 = new Fund();
        f1.setFundId("00010001");
        f1.setCustName("张三");
        f1.setFundAccNo("A0001");
        f1.setApplyAmt(1000);
        f1.setNav(1.12);
        f1.calcApplyFee();
        f1.calcChargeFee();

        Fund f2 = new Fund();
        f2.setFundId("00020002");
        f2.setCustName("李四");
        f2.setFundAccNo("A0001");
        f2.setApplyAmt(10000);
        f2.setNav(1.12);
        f2.calcApplyFee();
        f2.calcChargeFee();

        Fund f3 = new Fund();
        f3.setFundId("00030003");
        f3.setCustName("王五");
        f3.setFundAccNo("A0001");
        f3.setApplyAmt(5000);
        f3.setNav(1.12);
        f3.calcApplyFee();
        f3.calcChargeFee();

        List<Fund> funds = new ArrayList<>();
        funds.add(f1);
        funds.add(f2);
        funds.add(f3);
        return funds;
    }

    public static void testReadXml(String filePath) {
        SAXReader reader = new SAXReader();
        File f = new File(filePath);
        Document doc = null;
        try {
            doc = reader.read(f);
            Element root = doc.getRootElement();  //获取文档根元素
            List<Element> funds = root.elements("fund"); //取得所有name为acct子节点
            for (Element e : funds) {
                System.out.println(e.element("fundId").getName() + ", " //元素名称
                        + e.element("fundId").getText());  //元素值
                System.out.println(e.element("custName").getName() + ", "
                        + e.element("custName").getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    //
    public static void testWriteXml_2(String filePath) throws Exception {
        Document doc = DocumentHelper.createDocument();//创建文档对象
        Element root = doc.addElement("funds"); //添加根元素
        List<Fund> funds = getAllAccts();
        for (Fund f : funds) {
            Element fund = root.addElement("fund");//添加fund子元素
            Element fundId = fund.addElement("fundId");
            fundId.addText(f.getFundId());

            Element custName = fund.addElement("custName");
            custName.addText(f.getCustName());

            Element fundAccNo = fund.addElement("fundAccNo");
            fundAccNo.addText(f.getFundAccNo());

            Element applyAmt = fund.addElement("applyAmt");
            applyAmt.addText(Integer.toString(f.getApplyAmt()));

            Element nav = fund.addElement("nav");
            nav.addText(Double.toString(f.getNav()));

            Element applyFee = fund.addElement("applyFee");
            applyFee.addText(Double.toString(f.getApplyBal()));

            Element chargeFee = fund.addElement("chargeFee");
            chargeFee.addText(Double.toString(f.getChargeFee()));
        }
        // 写出
        XMLWriter writer = new XMLWriter();
        FileOutputStream fos = new FileOutputStream(filePath);
        writer.setOutputStream(fos);
        writer.write(doc);
        System.out.println("写文件成功");
        writer.close();
    }


    public static void testWriteXml(String filePath, List<Fund> fundList) throws Exception {
        Document doc = DocumentHelper.createDocument();//创建文档对象
        Element root = doc.addElement("funds"); //添加根元素
        for (Fund f : fundList) {
            Element fund = root.addElement("fund");//添加fund子元素
            Element fundId = fund.addElement("fundId");
            fundId.addText(f.getFundId());

            Element custName = fund.addElement("custName");
            custName.addText(f.getCustName());

        }

        /*
        * for (int i = 0; i < 3; i++) {
            Element acct = root.addElement("acct"); //添加acct子元素

            Element acct_no = acct.addElement("acct_no");
            acct_no.addText("622345123456789000" + i);

            Element acct_name = acct.addElement("acct_name");
            acct_name.addText("账户名" + i);

            Element acct_status = acct.addElement("acct_status");
            acct_status.addText("1");

            Element balance = acct.addElement("balance");
            balance.addText("" + (i * 1000));
        }
        * */

        // 写出
        XMLWriter writer = new XMLWriter();
        FileOutputStream fos = new FileOutputStream(filePath);
        writer.setOutputStream(fos);
        writer.write(doc);
        System.out.println("写文件成功！");
        writer.close();
    }
}



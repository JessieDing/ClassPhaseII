package d0419;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;
/**
 * Created by dell on 2017/4/19.
 */
public class XMLTest {
    public static void main(String[] args) {
        try {
            // testReadXml("D:" + File.separator + "acct.xml");
            // testReadXml("src" + File.separator + "XML2" + File.separator +
            // "acct.xml");
            testReadXml("src/XML2/acct.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testReadXml(String filePath) {
        SAXReader reader = new SAXReader();
        File f = new File(filePath);
        Document doc = null;
        try {
            doc = reader.read(f);
            Element root = doc.getRootElement();  //获取文档根元素
            List<Element> accts = root.elements("acct"); //取得所有name为acct子节点
            for (Element e : accts) {
                System.out.println(e.element("acct_no").getName() + ", " //元素名称
                        + e.element("acct_no").getText());  //元素值
                System.out.println(e.element("acct_name").getName() + ", "
                        + e.element("acct_name").getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public  static void testWriteXml(String filePath){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("accts");
        for (int i =0;i<3;i++){
            Element acct = root.addElement("acct");
            Element acct_info = acct.addElement("acct_no");
            acct_info.addText("622345678901234567"+i);
        }
    }
}


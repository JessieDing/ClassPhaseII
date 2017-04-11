package homework0407;

import java.io.*;
import java.util.List;

public class FundTest {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("e:" + File.separator + "fund_import.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream("e:" + File.separator + "fund_export.txt");
            PrintWriter pw = new PrintWriter(fos);

            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                String[] arr = tmp.split(",");
                String fundId = arr[0];
                String custName = arr[1];
                String fundAcctNo = arr[2];
                int applyAmt = Integer.parseInt(arr[3]);
                double nav = Double.parseDouble(arr[4]);

                FundRevised fund = new FundRevised(fundId, custName, fundAcctNo, applyAmt, nav);
                fund.calcApplyFee();
                fund.calcChargeFee();
                fund.calcDiscountDate();
                System.out.println(fund.toString());

                pw.println(fund.toString());
                pw.flush();
            }
            bufferedReader.close();
            fos.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         *
         String exportFilePath = "e:" + File.separator + "fund_export.txt";
         Fund fund = new Fund();
         List<Fund> fundFileList = fund.readFundFile();
         FundExportInfo exportInfo = new FundExportInfo();
         List<FundExportInfo> infoListExport = exportInfo.getExportFileList(fundFileList);
         exportInfo.write(exportFilePath, infoListExport);
         *
         */
    }
}

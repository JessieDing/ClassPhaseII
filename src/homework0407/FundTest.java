package homework0407;

import java.io.*;
import java.util.List;

/**
 * Created by Woody on 2017/4/7.
 */
public class FundTest {
    public static void main(String[] args) {
        String exportFilePath = "e:" + File.separator + "fund_export.txt";
        Fund fund = new Fund();
        List<Fund> fundFileList = fund.getFundFileInfo();
        FundExportInfo exportInfo = new FundExportInfo();
        List<FundExportInfo> infoListExport = exportInfo.getExportFileList(fundFileList);
        exportInfo.write(exportFilePath, infoListExport);
    }
}

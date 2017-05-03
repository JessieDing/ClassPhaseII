package exam0503.network;

/*
 * Created by dell on 2017/5/3.
 * 创建数据表，插入数据
*/

public class DataBase {
    public static void main(String[] args) {
        MySqlConnector connector = new MySqlConnector();
        prepDataBase(connector);
        System.out.println("Table created, data inserted.");
    }

    private static void prepDataBase(MySqlConnector dbhelper) {
        String createTable = createTable();
        dbhelper.doUpdate(createTable);
        String insertSQL1 = "INSERT INTO sys_info VALUES('HVPS','High Value Payment',CURDATE(),'0000',DATE_SUB(CURDATE(),INTERVAL -1 DAY))";
        dbhelper.doUpdate(insertSQL1);
        String insertSQL2 = "INSERT INTO sys_info VALUES('BEPS','Bulk Electronic Payment',CURDATE(),'0000',DATE_SUB(CURDATE(),INTERVAL -1 DAY))";
        dbhelper.doUpdate(insertSQL2);
    }
    public static String createTable() {
        StringBuffer strSQL = new StringBuffer();
        strSQL.append("CREATE TABLE SYS_INFO(");
        strSQL.append("Sys_no VARCHAR(4) NOT NULL PRIMARY KEY,");
        strSQL.append("Sys_name VARCHAR(32) NOT NULL,");
        strSQL.append("Sys_date DATE NOT NULL,");
        strSQL.append("Sys_status VARCHAR(4) NOT NULL,");
        strSQL.append("Next_work_date DATE NOT NULL)");
        return strSQL.toString();
    }
}

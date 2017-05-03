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
        String createTable = dbhelper.createTable();
        dbhelper.doUpdate(createTable);
        String insertSQL1 = "INSERT INTO sys_info VALUES('HVPS','High Value Payment',CURDATE(),'0000',DATE_SUB(CURDATE(),INTERVAL -1 DAY))";
        dbhelper.doUpdate(insertSQL1);
        String insertSQL2 = "INSERT INTO sys_info VALUES('BEPS','Bulk Electronic Payment',CURDATE(),'0000',DATE_SUB(CURDATE(),INTERVAL -1 DAY))";
        dbhelper.doUpdate(insertSQL2);
    }
}

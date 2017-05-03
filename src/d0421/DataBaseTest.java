package d0421;

import java.sql.*;

/**
 * Created by dell on 2017/4/21.
 */
public class DataBaseTest {
    public static void main(String[] args) {
        //使用DBOper
        DBOper dbOper = new DBOper();
        String strSQL1 = "select * from acct";
        String strSQL2 = "insertToFund into acct(AcctNo,AcctName,Status,balance) values('0007','Michael','1',2300.00F)";
        dbOper.doQuery(strSQL1);
        dbOper.doUpdate(strSQL2);

//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true";
//        String user = "root";
//        String password = "123456";
//        testInsert(driver, url, user, password);
//        testUpdate(driver, url, user, password);
//        testDelete(driver, url, user, password);
//        testQuery(driver, url, user, password);
    }

    public static void testQuery(String driver, String url, String user, String password) {
        Connection connection;
        Statement statement;

        try {
            Class.forName(driver); // 设置驱动

            // 创建数据库连接
            connection = DriverManager.getConnection(url, user, password);
            if (connection.isClosed()) { // 判断创建连接是否成功
                System.out.println("Connect to database fail.");
                return;
            } else {
                System.out.println("Connect to database success.");
            }
            //第二步：执行查询
            String strSQL = "select * from acct";
            statement = connection.createStatement();// 创建statement对象
            ResultSet rs = statement.executeQuery(strSQL); // 执行查询

            //第三步：输出查询结果
            String strAcctNo = "";
            String strAcctName = "";
            String strStatus = "";
            Float fBalance = 0.0000F;

            while (rs.next()) {
                strAcctNo = rs.getString("AcctNo");
                strAcctName = rs.getString("AcctName");
                strStatus = rs.getString("Status");
                fBalance = rs.getFloat("balance");

                System.out.println(strAcctNo + ", " + strAcctName + ", " + strStatus + ", " + fBalance);
            }
            rs.close();
            statement.close();

            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testInsert(String driver, String url, String user, String password) {
        Connection connection;
        PreparedStatement prepStatemnt;
        try {
            Class.forName(driver);//设置驱动

            //创建数据库连接
            connection = DriverManager.getConnection(url, user, password);

            if (connection.isClosed()) {
                System.out.println("Connect to database failed.");
                return;
            } else {
                System.out.println("Connect to database successfully.");
            }

            String strSQL1 = "insertToFund into acct(AcctNo,AcctName,Status,balance) values(?,?,?,?),(?,?,?,?)";
            prepStatemnt = (PreparedStatement) connection.prepareStatement(strSQL1);
            //参数赋值
            prepStatemnt.setString(1, "0002");
            prepStatemnt.setString(2, "Nancy");
            prepStatemnt.setString(3, "1");
            prepStatemnt.setFloat(4, 83000.00F);

            prepStatemnt.setString(5, "0006");
            prepStatemnt.setString(6, "Tony");
            prepStatemnt.setString(7, "1");
            prepStatemnt.setFloat(8, 3000.00F);

            int i = prepStatemnt.executeUpdate();//执行插入
            prepStatemnt.close();

            System.out.println(i + " line(s) effected.");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }


    public static void testUpdate(String driver, String url, String user, String password) {
        Connection connection;
        PreparedStatement prepStatemnt;
        try {
            Class.forName(driver);//设置驱动

            //创建数据库连接
            connection = DriverManager.getConnection(url, user, password);

            if (connection.isClosed()) {
                System.out.println("Connect to database failed.");
                return;
            } else {
                System.out.println("Connect to database successfully.");
            }

            String strSqlUpdate = "update acct set AcctName=?,Status=?,balance=? where AcctNo =0002";

            prepStatemnt = (PreparedStatement) connection.prepareStatement(strSqlUpdate);

            //参数赋值
            prepStatemnt.setString(1, "Leonard");
            prepStatemnt.setString(2, "0");
            prepStatemnt.setFloat(3, 12230.00F);

            int i = prepStatemnt.executeUpdate();//执行修改
            prepStatemnt.close();

            System.out.println(i + " line(s) effected.");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static void testDelete(String driver, String url, String user, String password) {
        Connection connection;
        PreparedStatement prepStatemnt;
        try {
            Class.forName(driver);//设置驱动

            //创建数据库连接
            connection = DriverManager.getConnection(url, user, password);

            if (connection.isClosed()) {
                System.out.println("Connect to database failed.");
                return;
            } else {
                System.out.println("Connect to database successfully.");
            }

            String strSqlDelete = "delete from acct where AcctNo = 0002";

            prepStatemnt = (PreparedStatement) connection.prepareStatement(strSqlDelete);


            int i = prepStatemnt.executeUpdate();//执行
            prepStatemnt.close();

            System.out.println(i + " line(s) effected.");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}

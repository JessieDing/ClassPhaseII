package exam0503.network;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by dell on 2017/5/3.
 */
public class MySqlConnector {
    private String driver;
    private String url;
    private String acct;
    private String pwd;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public MySqlConnector() {
        try {
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost/test?characterEncoding=utf8&useSSL=true";
            acct = "root";
            pwd = "123456";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, acct, pwd);
            if (connection == null) {
                System.err.println("connection failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doUpdate(String sql) {
        int ret = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ret = preparedStatement.executeUpdate();// 执行sql语句，并返回结果
//            System.out.println("Executed "+ret+" sql commands.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet doQuery(String strSQL) throws Exception {
        statement = connection.createStatement();// 创建一个表单
        resultSet = statement.executeQuery(strSQL);// 执行查询语句
        return resultSet;
    }

   public String createTable() {
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

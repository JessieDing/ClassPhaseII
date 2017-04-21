package d0421;

import sun.net.ConnectionResetException;

import java.sql.*;

/**
 * Created by dell on 2017/4/21.
 */
public class DBOper {
    private String mDriver;
    private String mUrl;
    private String mUser;
    private String mPassword;
    Connection connection;
    Statement statement;
    PreparedStatement prepStatement;

    public DBOper() {
        mDriver = "com.mysql.jdbc.Driver";
        mUrl = "jdbc:mysql://localhost/test";
        mUser = "root";
        mPassword = "123456";
    }

    public DBOper(String mDriver, String mUrl, String mUser, String mPassword) {
        this.mDriver = mDriver;
        this.mUrl = mUrl;
        this.mUser = mUser;
        this.mPassword = mPassword;
    }

    public int openConnection() {
        try {
            //设置驱动
            Class.forName(mDriver);
            //创建连接
            connection = DriverManager.getConnection(mUrl, mUser, mPassword);
            if (!connection.isClosed()) {
                System.out.println("Connect to database successfully.");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public void closeConnection() {
        try {
            if ((statement != null) && (!statement.isClosed())) {
                statement.close();
            }
            if ((prepStatement != null) && (!prepStatement.isClosed())) {
                prepStatement.close();
            }
            if ((connection != null) && (!connection.isClosed())) {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet doQuery(String strSQL) {
        try {
            statement = connection.createStatement();//创建statement对象
            ResultSet resultSet = statement.executeQuery(strSQL);//执行查询
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int doUpdate(String strSQL) {
        int ret = 0;
        try {
            prepStatement = (PreparedStatement) connection.prepareStatement(strSQL);
            ret = prepStatement.executeUpdate();//执行SQL语句
            System.out.println(ret + " line(s) effected.");
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}

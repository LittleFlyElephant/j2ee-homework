package dao.impl;

import dao.DAOHelper;
import util.Config;

import java.sql.*;

/**
 * Created by raychen on 2016/12/30.
 */
public class DAOHelperImpl implements DAOHelper {

    private static DAOHelperImpl impl = new DAOHelperImpl();
    private Connection connection = null;

    public static DAOHelperImpl getInstance(){
        return impl;
    }

    private DAOHelperImpl(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        String url="jdbc:mysql://localhost:3306/"+ Config.DB_NAME+"?useUnicode=true&characterEncoding=UTF-8";
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        try {
            connection = DriverManager.getConnection(url,Config.DB_USERNAME,Config.DB_PASSWORD);
            //创建一个Statement对象
            System.out.println("成功连接到数据库！");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void closeConnection(Connection con) {
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closePreparedStatement(PreparedStatement stmt) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closeResult(ResultSet result) {
        if (result != null){
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

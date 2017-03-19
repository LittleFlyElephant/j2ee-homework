package dao.impl;

import dao.DAOHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Created by raychen on 2016/12/30.
 */
public class DAOHelperImpl implements DAOHelper {

    private static DAOHelperImpl impl = new DAOHelperImpl();
    private Connection connection = null;

    private InitialContext jndiContext = null;
    private DataSource dataSource = null;

    public static DAOHelperImpl getInstance(){
        return impl;
    }

    private DAOHelperImpl(){
    }

    @Override
    public Connection getConnection() {
        try {
            final Hashtable properties = new Hashtable();
            properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            try {
                jndiContext = new InitialContext(properties);
                dataSource = (DataSource) jndiContext.lookup("java:/MySqlDS");
                if (dataSource==null)
                    System.out.println("datasource null");
            } catch (NamingException e) {
                e.printStackTrace();
            }
            connection = dataSource.getConnection();
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

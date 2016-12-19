/**
 * Created by raychen on 2016/11/8.
 */
package util;
import java.sql.*;


public class DBHelper {

    private Connection conn;
    private static String DBname = "j2eeDB1";
    private static String username = "test";
    private static String password = "chen123";
    private static DBHelper instance;

    private DBHelper(){
        connect();
    }

    public static DBHelper getInstance(){
        if (instance == null) instance = new DBHelper();
        return instance;
    }

    public void connect(){
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }

        String url="jdbc:mysql://localhost:3306/"+DBname+"?useUnicode=true&characterEncoding=UTF-8";    //JDBC的URL
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        try {
            this.conn = DriverManager.getConnection(url,username,password);
            //创建一个Statement对象
            System.out.println("成功连接到数据库！");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql){
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int update(String sql){
        int rs = -1;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            rs = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void disconnect(){
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBHelper helper = DBHelper.getInstance();
        ResultSet rs = helper.query("select * from tb_students");
        try {
            while (rs.next()){
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

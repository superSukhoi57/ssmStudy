

import java.sql.*;
import java.lang.Class;
import swing.information;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello world!");
        String url = "jdbc:mysql://localhost:3306/bookmanagesys";
        String username = "root";
        String password = "newbee";


        Class.forName("com.mysql.jdbc.Driver");//注册数据库驱动

        Connection conn = DriverManager.getConnection(url, username, password);//创建connection连接
        if (conn != null) {
            System.out.println("数据库连接成功！");
        }
        Statement stmt=conn.createStatement();
        String sql="select * from customer";
        ResultSet rs=stmt.executeQuery(sql);//执行查询，并把结果放在结果集rs里
        while(rs.next()){
            String str1=rs.getString(1);
            String str2=rs.getString(2);
            System.out.println(str1+" "+str2);
        }
        rs.close();
        stmt.close();
        conn.close();

        information.user="default";
        change test=new change();
        test.change();
        System.out.println(information.user);
    }
}
class change{
    public void change(){
        information.user="change";
    }
}
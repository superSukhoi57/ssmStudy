package database;

import swing.information;


import java.sql.*;
import swing.Book;

public class handle_response {

   static String url = "jdbc:mysql://localhost:3306/bookmanagesys";
   static String username = "root";
   static String dbpassword = "newbee";
    //是否存在该用户
    public  static boolean isExist_Customer(String user,String password) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("成功加载MySQL驱动-isExist_Customer");


            System.out.println("输入的用户名和密码："+user+" "+password);

            Connection conn = DriverManager.getConnection(url,username,dbpassword);

            if(conn!=null){
                System.out.println("成功连接到数据库-isExist_Customer");}

            Statement stmt = conn.createStatement(); //创建Statement对象

            String sql = "select * from customer";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象


            System.out.println("用户名"+"\t"+"\t"+"\t"+"密码");
            while (rs.next()){
                System.out.print(rs.getString(1) + "\t\t\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {

                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //是否存在该管理员
    public static boolean isExist_Manager(String user,String password) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Manager");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-isExist_Manager");

            String sql = "select * from Manager";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            System.out.println("manager用户名"+"\t"+"\t"+"\t"+"密码");
            while (rs.next()){
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println();
                if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    //注册新用户
    public static void regist_Customer(String user,String password) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Customer");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-regist_Customer");

            String sql = "insert into Customer values('"+user+"','"+password+"');";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //注册新管理员
    public static void regist_Manager(String user,String password) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-regist_Manager");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-regist_Manager");

            String sql = "insert into Manager values('"+user+"','"+password+"');";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //创建用户数据库的表格，用来储存借书的信息！！！！！
    public static void newCustomer(String user) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-newCustomer");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-newCustomer");

            String sql = "CREATE TABLE "+user+"Customer (number VARCHAR(255) primary key,classname VARCHAR(255),name VARCHAR(255),dateoff VARCHAR(255));";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //改变用户的密码
    public static void changePassword_Customer(String user,String password,String newPassword) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-changePassword");

            String sql = "update Customer set customer_password = '"+newPassword+"' where customer_user = '"+user+"';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //改变管理员的密码
    public static void changePassword_Manager(String user,String password,String newPassword) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-changePassword");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-changePassword");

            String sql = "update Manager set manager_password = '"+newPassword+"' where manager_user = '"+user+"';";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //查询个人图书信息
    public static void search_personal(String user) {
        information.bookarray.clear();
        try{

            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_personal");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-search_personal");

            String sql = "select * from "+user+"Customer;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                Book book = new Book();
                book.number = rs.getString(1);
                book.classname = rs.getString(2);
                book.name = rs.getString(3);
                book.dateoff = rs.getString(4);
                information.bookarray.add(book);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //查询某类图书信息
    public static void search_classname(String classname) {
        information.bookarray.clear();
        try{

            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_classname");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-search_classname");

            String sql = "select * from "+classname+"Book;";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                Book book = new Book();
                book.number = rs.getString(1);
                book.classnumber = rs.getString(2);
                book.name = rs.getString(3);
                book.classname = rs.getString(4);
                book.price = rs.getString(5);
                book.state = rs.getString(6);
                book.total = rs.getString(7);


                information.bookarray.add(book);
                System.out.println(rs.getString(3));
            }
            System.out.println("成功查询"+classname);

            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //是否存在该Table表
    public static boolean isExist_Table(String table) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-isExist_Table");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-isExist_Table");

            String sql = "show tables";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                if(table.equals(rs.getString(1))) {
                    return true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //查找书名
    public static String search_bookname(String classname,String number) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookname");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-search_bookname");

            String sql = "select * from "+classname+"book where number='"+number+"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                return rs.getString(3);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return "null";
    }

    //查找书籍状态
    public static String search_bookstate(String classname,String number) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookstate");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_bookstate");

            String sql = "select * from "+classname+"book where number='"+number+"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                return rs.getString(6);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return "null";
    }

    //查找书籍还书日期
    public static int search_bookdateoff(String classname,String number) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-search_bookdateoff");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库-search_bookdateoff");

            String sql = "select * from "+classname+"book where number='"+number+"';";    //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
                return Integer.parseInt(rs.getString(10));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public static void borrowBook_Insert(String classname,String number,String user,String dateoff) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-borrowBook_Insert");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-borrowBook_Insert");

            String sql = "insert into "+user+"Customer values('"+number+"','"+classname+"','"+search_bookname(classname, number)+"','"+dateoff+"');";    //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //还书更新用户的数据库信息
    public static void returnBook_Delete(String number,String user) {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动-returnBook_Delete");


            Connection conn;

            conn = DriverManager.getConnection(url,username,dbpassword);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(conn!=null)
                System.out.println("成功连接到数据库-returnBook_Delete");

            String sql = "delete from "+user+"Customer where number = '"+number+"';";  //要执行的SQL

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();

            stmts.close();
            stmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}



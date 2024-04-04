package swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//导入自己写的类

import swing.user.*;

import database.handle_response;

public class login extends JFrame implements ActionListener,KeyListener {
//这里要继承JFrame的方法才可以使用getContentPane();方法。！！！！/**/





    //主界面窗口
    public static JPanel contentPane;//登录的主界面！
    private static Container container;
    private JLabel label;
    private JTextField tf_user;
    private JTextField tf_password;
    private JLabel label_user;
    private JLabel label_password;

    private JButton btn_login;
    private JButton btn_register;
    private JButton btn_changePassword;

    //=========================================这里存放按钮跳转的界面=============================//
    static userpanel userJPanel; /*用户交互面板（customer使用的）,要在外面创建，不同函数
     才可以使用同一个，要是在函数里面创建，只是局部变量，在其他函数里面使用不了！！。*/
    public static BorrowBook borrowJPanel = new BorrowBook();
    public static ReturnBook returnJPanel = new ReturnBook();
    public static PersonalInformation personalJPanel = new PersonalInformation();
    public static BorrowBook_Information borrowInfoJPanel = new BorrowBook_Information();

    //========================================end of 存放的地方===============================//

    public void init() {

        //获取主界面容器
        container = getContentPane();

        //初始化主界面
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 1300, 1000);
        setResizable(false);




        contentPane = new JPanel();
        //contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        container.add(contentPane);
        contentPane.setLayout(null);






//==========================要在输入框里面加keylistener才可以监测在那里有没有按回车！！！=========================//
        //账号输入框
        tf_user = new JTextField();
        tf_user.setFont(new Font("宋体", Font.BOLD, 35));
        tf_user.setBounds(409, 300, 520, 75);
        contentPane.add(tf_user);
        tf_user.setColumns(10);
        tf_user.addKeyListener(this);

        //密码输入框
        tf_password = new JTextField();
        tf_password.setFont(new Font("宋体", Font.BOLD, 35));
        tf_password.setColumns(10);
        tf_password.setBounds(409, 417, 520, 74);
        contentPane.add(tf_password);
        tf_password.addKeyListener(this);


//=============================end of 输入框==============================================//


        //用户名标签
        label_user = new JLabel("用户名");
        label_user.setFont(new Font("宋体", Font.BOLD, 40));
        label_user.setForeground(Color.BLACK);
        label_user.setBounds(260, 321, 140, 45);
        label_user.setOpaque(true); // 设置为不透明
        label_user.setBackground(Color.GRAY); // 设置背景颜色为灰色
        contentPane.add(label_user);


        /*label_user.setBounds(289, 261, 116, 48);
      这一句设置了label_user在容器中的位置和大小。参数分别代表组件的x坐标、y坐标、宽度和高度。
(289, 261)是左上角的坐标，表示该组件距离容器左上角的距离。
(110, 45)表示组件的宽度为116像素，高度为48像素。*/

        //密码标签
        label_password = new JLabel("密码");
        label_password.setFont(new Font("宋体", Font.BOLD, 40));
        label_password.setForeground(Color.BLACK);
        label_password.setBounds(260, 430, 116, 48);
        label_password.setOpaque(true); // 设置为不透明
        label_password.setBackground(Color.GRAY); // 设置背景颜色为灰色
        contentPane.add(label_password);



        //登录按钮
        btn_login = new JButton("登录");
        btn_login.setBackground(Color.LIGHT_GRAY);
        btn_login.setFont(new Font("宋体", Font.BOLD, 35));
        btn_login.setBounds(409, 634, 170, 48);
        contentPane.add(btn_login);
        btn_login.addActionListener(this);
        btn_login.addKeyListener(this);


        //注册按钮
        btn_register = new JButton("注册");
        btn_register.setFont(new Font("宋体", Font.BOLD, 35));
        btn_register.setBackground(Color.LIGHT_GRAY);
        btn_register.setBounds(765, 634, 170, 48);
        contentPane.add(btn_register);
        btn_register.addActionListener(this);

        //修改密码按钮
        btn_changePassword = new JButton("修改密码");
        btn_changePassword.setFont(new Font("宋体", Font.BOLD, 30));
        btn_changePassword.setBackground(Color.LIGHT_GRAY);
        btn_changePassword.setBounds(1011, 430, 170, 48);
        contentPane.add(btn_changePassword);
        btn_changePassword.addActionListener(this);


        label = new JLabel("图书管理系统");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 70));
        label.setBounds(370, 69, 500, 120);
        contentPane.add(label);


//=============================background====设置背景图片========================================//

        // 加载背景图片
        ImageIcon backgroundImage = new ImageIcon("src/pictures/01.jpeg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1300, 1000); // 设置标签的位置和大小

        // 将背景标签添加到容器中
        contentPane.add(backgroundLabel);
//=============为什么把这段代码放在组件的前面会把组件覆盖，而放在后界却不会呢！难道。。是"栈"编排面板？？？？？？=====//
    }

    public static void main(String[] args) {
        login my=new login();
        my.init();
        my.setVisible(true);
    }

    //切换窗口函数
    //Main->User

    public static void MaintoUser(String name) {


            contentPane.setVisible(false);
            userJPanel.setVisible(true);
            container.add(userJPanel);


    }

    //User->Main
    public static void UsertoMain() {
        userJPanel.setVisible(false);
        contentPane.setVisible(true);
    }
    //User->Borrow
    public static void UsertoBorrow() {

        userJPanel.setVisible(false);
        borrowJPanel.setVisible(true);
        container.add(borrowJPanel);

    }
    //Borrow->User
    public static void BorrowtoUser() {
        borrowJPanel.setVisible(false);
        userJPanel.setVisible(true);
    }
    //User->Return
    public static void UsertoReturn() {

            userJPanel.setVisible(false);

        returnJPanel.setVisible(true);
        container.add(returnJPanel);



    }
    //Return->User
    public static void ReturentoUser() {
        returnJPanel.setVisible(false);
        userJPanel.setVisible(true);
    }

    //User->Personal
    public static void UsertoPersonal() {
           userJPanel.setVisible(false);

        personalJPanel.setVisible(true);
            container.add(personalJPanel);




    }
    public static void PersonaltoUser() {
        personalJPanel.setVisible(false);
        userJPanel.setVisible(true);
    }
    //Borrow->BorrowInfo
    public static void BorrowtoBorrowInfo() {

            borrowJPanel.setVisible(false);
        borrowInfoJPanel.setVisible(true);
            container.add(borrowInfoJPanel);





    }
    //BorrowInfo->Borrow
    public static void BorrowInfotoBorrow() {
        borrowInfoJPanel.setVisible(false);
        borrowJPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_login) {
            //点击登录按钮
            //判定用户名密码是否为空
            if (tf_user.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "用户名不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
            } else if (tf_password.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "密码不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
            }else {


                    //用户
                    System.out.println(tf_password+" "+tf_user);
                    boolean isExist = handle_response.isExist_Customer(tf_user.getText(), tf_password.getText());
                    if(isExist) {
                        JOptionPane.showMessageDialog(null, "欢迎使用", "用户登录成功", JOptionPane.OK_CANCEL_OPTION);
                        information.user = tf_user.getText();//先将名字存进javaBean里面，再创建图形界面，才可以把用户名显示在界面上。
                        userJPanel = new userpanel();

                       MaintoUser(tf_user.getText());
                    }else {
                        JOptionPane.showMessageDialog(null, "账号或密码错误", "用户登录失败", JOptionPane.ERROR_MESSAGE);
                    }

            }
        }else if(e.getSource() == btn_register) {
            //点击注册按钮
            //判定用户名密码是否为空
            if (tf_user.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "用户名不能为空", "注册失败", JOptionPane.ERROR_MESSAGE);
            } else if (tf_password.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "密码不能为空", "注册失败", JOptionPane.ERROR_MESSAGE);
            }else {


                    boolean isExist = handle_response.isExist_Customer(tf_user.getText(), tf_password.getText());
                    if(isExist) {
                        JOptionPane.showMessageDialog(null, "该用户已经存在", "用户注册失败", JOptionPane.ERROR_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null, "欢迎！", "用户注册成功", JOptionPane.OK_CANCEL_OPTION);
                        handle_response.regist_Customer(tf_user.getText(),  tf_password.getText());
                        handle_response.newCustomer(tf_user.getText());//创建个人信息表格，用来储存他的借书信息！！
                    }

            }
        }else if(e.getSource() == btn_changePassword) {
            if (tf_user.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "用户名不能为空", "修改失败", JOptionPane.ERROR_MESSAGE);
            } else if (tf_password.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "密码不能为空", "修改失败", JOptionPane.ERROR_MESSAGE);
            }else {


                    //用户
                    boolean isExist = handle_response.isExist_Customer(tf_user.getText(), tf_password.getText());
                    if(isExist) {
                        String newPassword = JOptionPane.showInputDialog("请输入新密码");
                        if (!newPassword.equals("")) {
                            handle_response.changePassword_Customer(tf_user.getText(), tf_password.getText(), newPassword);
                            JOptionPane.showMessageDialog(null, "欢迎使用", "修改密码成功", JOptionPane.OK_CANCEL_OPTION);
                        }else {
                            JOptionPane.showMessageDialog(null, "密码不能为空", "修改密码失败", JOptionPane.ERROR_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "请输入正确的用户名密码", "修改密码失败", JOptionPane.ERROR_MESSAGE);
                    }


            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_ENTER){// KeyEvent.VK_ENTER就是10!!!
            //回车登录
            //判定用户名密码是否为空
            if (tf_user.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "用户名不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
            } else if (tf_password.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "密码不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
            }else {

                    //用户
                    System.out.println(tf_password+" "+tf_user);
                    boolean isExist = handle_response.isExist_Customer(tf_user.getText(), tf_password.getText());
                    if(isExist) {
                        JOptionPane.showMessageDialog(null, "欢迎使用", "用户登录成功", JOptionPane.OK_CANCEL_OPTION);
                        information.user = tf_user.getText();//先将名字存进javaBean里面，再创建图形界面，才可以把用户名显示在界面上。
                        userJPanel = new userpanel();

                        MaintoUser(tf_user.getText());
                    }else {
                        JOptionPane.showMessageDialog(null, "账号或密码错误", "用户登录失败", JOptionPane.ERROR_MESSAGE);
                    }

                }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

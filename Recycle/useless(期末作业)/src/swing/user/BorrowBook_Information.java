package swing.user;


import javax.swing.JPanel;

import database.handle_response;
import swing.login;
import swing.information;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BorrowBook_Information extends JPanel implements ActionListener, KeyListener {
    private JButton back;
    private static JTextArea textArea;
    private static String info;
    private JTextField tf_number;
    private JLabel lb_number;
    private JButton btn_borrow;
    private JLabel lb_dateoff;
    private JTextField tf_dateoff;

    /**
     * Create the panel.
     */
    public BorrowBook_Information() {
        setBackground(new Color(152, 251, 152));
        setLayout(null);

        back = new JButton("上一步");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        //图书信息---文本区域
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setBounds(90, 142, 1111, 782);
        add(textArea);

        textArea.setEditable(false);

        //标签
        lb_number = new JLabel("图书编号");
        lb_number.setFont(new Font("宋体", Font.BOLD, 35));
        lb_number.setBounds(152, 39, 185, 55);
        add(lb_number);

        //图书编号输入框：
        tf_number = new JTextField();
        tf_number.setFont(new Font("宋体", Font.BOLD, 35));
        tf_number.setColumns(10);
        tf_number.setBounds(317, 29, 226, 75);
        add(tf_number);
        tf_number.addKeyListener(this);


        //借书按钮
        btn_borrow = new JButton("确定借书");
        btn_borrow.setFont(new Font("宋体", Font.BOLD, 35));
        btn_borrow.setBounds(926, 26, 251, 80);
        add(btn_borrow);
        btn_borrow.addActionListener(this);

        lb_dateoff = new JLabel("借书天数");
        lb_dateoff.setFont(new Font("宋体", Font.BOLD, 35));
        lb_dateoff.setBounds(575, 39, 185, 55);
        add(lb_dateoff);


        //借书天数输入框：
        tf_dateoff = new JTextField();
        tf_dateoff.setFont(new Font("宋体", Font.BOLD, 35));
        tf_dateoff.setColumns(10);
        tf_dateoff.setBounds(730, 29, 190, 75);
        add(tf_dateoff);
        tf_dateoff.addKeyListener(this);

        //info = "图书编号     分类编号     图书名称                分类名称      价格     状态\n";
        //setTextArea();

    }

    public static void setTextArea() {
        info = "图书编号     分类编号     图书名称                分类名称      价格     状态     \n";


        for(int i=0;i<information.bookarray.size();i++) {
            info = info+"  "+information.bookarray.get(i).number+"        ";
            info = info+information.bookarray.get(i).classnumber+"        ";
            info = info+information.bookarray.get(i).name;
            for(int j=0;j<(19-information.bookarray.get(i).name.length());j++) {
                info = info +" ";
            }
            info = info+"       "+information.bookarray.get(i).classname+"      ";
            info = info+information.bookarray.get(i).price+"     ";
            info = info+information.bookarray.get(i).state;
            for(int j=0;j<(9-information.bookarray.get(i).state.length());j++) {
                info = info +" ";
            }

            info=info+"\n";
        }
        textArea.setText(info);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == back) {
            //点击返回按钮
            login.BorrowInfotoBorrow();
        }if(e.getSource() == btn_borrow) {
            //点击借书按钮
            //先判定是否有此书
            if(handle_response.search_bookname(information.search_classname, tf_number.getText()).equals("null")) {
                JOptionPane.showMessageDialog(null, "输入借书信息有误", "借书失败", JOptionPane.ERROR_MESSAGE);
                tf_number.setText("");
                tf_dateoff.setText("");
            }else {
                //判定此书是否已被借出
                if(handle_response.search_bookstate(information.search_classname,  tf_number.getText()).equals("在馆")) {

                    handle_response.borrowBook_Insert(information.search_classname, tf_number.getText(), information.user, tf_dateoff.getText().toString());
                    tf_number.setText("");
                    tf_dateoff.setText("");
                    login.BorrowInfotoBorrow();
                    login.BorrowtoUser();
                }else {
                    JOptionPane.showMessageDialog(null, "该书已借出至："+handle_response.search_bookdateoff(information.search_classname, tf_number.getText()), "借书失败", JOptionPane.ERROR_MESSAGE);
                    tf_number.setText("");
                    tf_dateoff.setText("");
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==10){
                //点击借书按钮
                //先判定是否有此书
                if(handle_response.search_bookname(information.search_classname, tf_number.getText()).equals("null")) {
                    JOptionPane.showMessageDialog(null, "输入借书信息有误", "借书失败", JOptionPane.ERROR_MESSAGE);
                    tf_number.setText("");
                    tf_dateoff.setText("");
                }else {
                    //判定此书是否已被借出
                    if(handle_response.search_bookstate(information.search_classname,  tf_number.getText()).equals("在馆")) {

                        handle_response.borrowBook_Insert(information.search_classname, tf_number.getText(), information.user, tf_dateoff.getText().toString());
                        tf_number.setText("");
                        tf_dateoff.setText("");
                        login.BorrowInfotoBorrow();
                        login.BorrowtoUser();
                    }else {
                        JOptionPane.showMessageDialog(null, "该书已借出至："+handle_response.search_bookdateoff(information.search_classname, tf_number.getText()), "借书失败", JOptionPane.ERROR_MESSAGE);
                        tf_number.setText("");
                        tf_dateoff.setText("");
                    }
                }

            }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


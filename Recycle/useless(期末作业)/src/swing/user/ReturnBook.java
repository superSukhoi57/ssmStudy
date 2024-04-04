package swing.user;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import swing.information;
import database.handle_response;
import swing.login;

public class ReturnBook extends JPanel implements ActionListener{
    private JLabel label;
    private JButton back;
    private JTextField tf_classname;
    private JLabel lb_classname;
    private JButton btn_search;
    private JButton btn_return;
    private JLabel lb_classnumber;
    private JTextField tf_number;
    private JLabel lb_today;
    private JTextField tf_today;




    /**
     * Create the panel.
     */
    public ReturnBook() {
        setBackground(new Color(250, 250, 210));
        setLayout(null);

        back = new JButton("返回");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        label = new JLabel("还书系统");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 40));
        label.setBounds(529, 69, 294, 105);
        label.setOpaque(true); // 设置为不透明
        label.setBackground(Color.GRAY); // 设置背景颜色为灰色
        //label.setForeground(Color.BLACK); // 设置前景颜色为黑色
        add(label);

        lb_classname = new JLabel("书库类别名称");
        lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
        lb_classname.setBounds(240, 302, 260, 55);
        lb_classname.setOpaque(true); // 设置为不透明
        lb_classname.setBackground(Color.GRAY); // 设置背景颜色为白色
        add(lb_classname);

        tf_classname = new JTextField();
        tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
        tf_classname.setColumns(10);
        tf_classname.setBounds(503, 292, 526, 75);
        add(tf_classname);

        btn_return = new JButton("确定归还");
        btn_return.setFont(new Font("宋体", Font.BOLD, 35));
        btn_return.setBounds(557, 764, 251, 80);
        add(btn_return);
        btn_return.addActionListener(this);

        lb_classnumber = new JLabel("图书编号");
        lb_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
        lb_classnumber.setBounds(240, 454, 260, 55);
        lb_classnumber.setOpaque(true);
        lb_classnumber.setBackground(Color.GRAY);
        add(lb_classnumber);

        tf_number = new JTextField();
        tf_number.setFont(new Font("宋体", Font.BOLD, 35));
        tf_number.setColumns(10);
        tf_number.setBounds(503, 444, 526, 75);
        add(tf_number);


        //=============================background====设置背景图片========================================//

        // 加载背景图片
        ImageIcon backgroundImage = new ImageIcon("src/pictures/02.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1300, 1000); // 设置标签的位置和大小

        // 将背景标签添加到容器中
        add(backgroundLabel);//这里居然可以直接add，因为继承了JPanel！

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == back) {
            login.ReturentoUser();
        }else if(e.getSource() == btn_return) {

            String classname = tf_classname.getText();
            String number = tf_number.getText();


            handle_response.returnBook_Delete(number, information.user);

            tf_classname.setText("");
            tf_number.setText("");

            login.ReturentoUser();

        }
    }
}

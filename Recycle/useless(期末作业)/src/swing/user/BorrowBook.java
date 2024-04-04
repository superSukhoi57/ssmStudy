package swing.user;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import swing.login;
import database.handle_response;
import swing.information;

public class BorrowBook extends JPanel implements ActionListener, KeyListener {
    private JLabel label;
    private JButton back;
    private JTextField tf_classname;
    private JLabel lb_classname;
    private JButton btn_search;

    /**
     * Create the panel.
     */
    public BorrowBook() {
        setBackground(new Color(250, 250, 210));
        setLayout(null);

        back = new JButton("返回");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        label = new JLabel("图书库存状态查询");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 60));
        //label.setForeground(Color.WHITE);
        label.setBounds(320, 65, 600, 105);
        add(label);

        lb_classname = new JLabel("书库类别名称");
        lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
       //lb_classname.setForeground(Color.WHITE);
        lb_classname.setBounds(161, 330, 283, 55);
        add(lb_classname);

        tf_classname = new JTextField();
        tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
        tf_classname.setColumns(10);
        tf_classname.setBounds(382, 320, 540, 75);
        add(tf_classname);
        tf_classname.addKeyListener(this);

        btn_search = new JButton("查询");
        btn_search.setFont(new Font("宋体", Font.BOLD, 35));
        btn_search.setBounds(520, 650, 251, 80);
        add(btn_search);
        btn_search.addActionListener(this);
        btn_search.addKeyListener(this);

        //=============================background====设置背景图片========================================//

        // 加载背景图片
        ImageIcon backgroundImage = new ImageIcon("src/pictures/03.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 167, 1300, 1000); // 设置标签的位置和大小

        // 将背景标签添加到容器中
        add(backgroundLabel);//这里居然可以直接add，因为继承了JPanel！

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == back) {
            login.BorrowtoUser();
        }else if(e.getSource() == btn_search) {

            String classname = tf_classname.getText();
            information.search_classname = classname;

            //查询该类图书信息
            if(handle_response.isExist_Table(classname+"book")) {
                handle_response.search_classname(tf_classname.getText());
                BorrowBook_Information.setTextArea();
                login.BorrowtoBorrowInfo();
                //BorrowBook_Information.setTextArea();
                tf_classname.setText("");
            }else {
                JOptionPane.showMessageDialog(null, "不存在该类别", "查询失败", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==10){
                String classname = tf_classname.getText();
                information.search_classname = classname;

                //查询该类图书信息
                if(handle_response.isExist_Table(classname+"book")) {
                    handle_response.search_classname(tf_classname.getText());
                    BorrowBook_Information.setTextArea();
                    login.BorrowtoBorrowInfo();
                    //BorrowBook_Information.setTextArea();
                    tf_classname.setText("");
                }else {
                    JOptionPane.showMessageDialog(null, "不存在该类别", "查询失败", JOptionPane.ERROR_MESSAGE);
                }
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

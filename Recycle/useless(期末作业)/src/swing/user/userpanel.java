package swing.user;




import javax.swing.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import database.handle_response;
import swing.information;
import swing.login;


public class /**/userpanel extends JPanel implements ActionListener, KeyListener {


    public String username;
    private JButton back;
    private JLabel label;
    private static JLabel lb_user;
    private JButton btn_return;
    private JButton btn_borrow;

    private JButton btn_personal;

    private JLabel illustrate;

    public userpanel(){

        //setBackground(new Color(0, 191, 255));
        setLayout(null);

        back = new JButton("退出");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);
        back.addKeyListener(this);

        label = new JLabel("管理系统用户界面");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 60));
        label.setOpaque(true); // 设置为不透明
        label.setBackground(Color.orange); // 设置背景颜色为灰色
        label.setBounds(350, 47, 500, 105);
        add(label);

        lb_user = new JLabel("当前用户："+information.user);
        lb_user.setHorizontalAlignment(SwingConstants.CENTER);
        lb_user.setFont(new Font("宋体", Font.BOLD, 28));
        lb_user.setOpaque(true); // 设置为不透明
        lb_user.setBackground(Color.WHITE);
        lb_user.setBounds(944, 0, 356, 56);
        add(lb_user);

        btn_borrow = new JButton("借书");
        btn_borrow.setFont(new Font("宋体", Font.BOLD, 40));
        btn_borrow.setBounds(100, 233, 300, 505);
        add(btn_borrow);
        btn_borrow.addActionListener(this);
        btn_borrow.addKeyListener(this);

        btn_return = new JButton("还书");
        btn_return.setFont(new Font("宋体", Font.BOLD, 40));
        btn_return.setBounds(500, 233, 300, 505);
        add(btn_return);
        btn_return.addActionListener(this);
        btn_return.addKeyListener(this);


        btn_personal = new JButton("个人信息");
        btn_personal.setFont(new Font("宋体", Font.BOLD, 40));
        btn_personal.setBounds(900, 233, 300, 505);
        add(btn_personal);
        btn_personal.addActionListener(this);
        btn_personal.addKeyListener(this);


        //说明
        illustrate = new JLabel("可以通过键盘操作，删除为返回，1是借书，2是还书，3是个人信息");
        illustrate.setHorizontalAlignment(SwingConstants.CENTER);
        illustrate.setFont(new Font("宋体", Font.BOLD, 20));
        illustrate.setForeground(Color.red);
        illustrate.setBounds(50, 800, 900, 100);
        add(illustrate);

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
        //返回登录横界面！！
        if(e.getSource() == back) {
            login.UsertoMain();
        }else if(e.getSource() == btn_borrow){
            login.UsertoBorrow();
        }else if(e.getSource() == btn_return) {
            login.UsertoReturn();
        }
        else if(e.getSource() == btn_personal) {
            handle_response.search_personal(information.user);
            swing.user.PersonalInformation.setTextArea();
            login.UsertoPersonal();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==8){
            //返回键
            login.UsertoMain();
        }else if(e.getKeyCode()==49){
            //1,借书
            login.UsertoBorrow();
        } else if (e.getKeyCode()==50) {
            //2，还书
            login.UsertoReturn();
        }else if(e.getKeyCode()==51){
            //3,个人信息
            handle_response.search_personal(information.user);
            swing.user.PersonalInformation.setTextArea();
            login.UsertoPersonal();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package swing.user;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import swing.information;

import javax.swing.JTextArea;
import swing.login;

public class PersonalInformation extends JPanel implements ActionListener{
    private JButton back;
    private static JTextArea textArea;
    private JLabel label;
    private static String info;

    /**
    创建面板！
     */
    public PersonalInformation() {
        setBackground(new Color(127, 255, 212));
        setLayout(null);

        back = new JButton("返回");
        back.setFont(new Font("宋体", Font.PLAIN, 26));
        back.setBounds(0, 0, 115, 82);
        add(back);
        back.addActionListener(this);

        label = new JLabel("个人信息");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 40));
        label.setBounds(530, 20, 294, 105);
        add(label);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setEditable(false);
        textArea.setBounds(111, 125, 1050, 782);
        add(textArea);

        info = "图书编号           分类名称            图书名称            还书期限\n";

    }

    public static void setTextArea() {
        info = "图书编号              分类名称                图书名称                            还书期限\n";

        System.out.println("查到的书本数量"+information.bookarray.size());
        for(int i=0;i<information.bookarray.size();i++) {
            info = info+"  "+information.bookarray.get(i).number+"                 ";
            info = info+information.bookarray.get(i).classname;
            for(int j=0;j<(24-information.bookarray.get(i).classname.length());j++) {
                info = info +" ";
            }
            info = info+information.bookarray.get(i).name;
            for(int j=0;j<(30-information.bookarray.get(i).name.length());j++) {
                info = info +" ";
            }
            info = info+"      "+information.bookarray.get(i).dateoff+"        \n";
        }
        textArea.setText(info);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            login.PersonaltoUser();
        }
    }
}

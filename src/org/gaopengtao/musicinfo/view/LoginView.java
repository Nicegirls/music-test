package org.gaopengtao.musicinfo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.gaopengtao.musicinfo.entity.Admin;
import org.gaopengtao.musicinfo.service.AdminService;
import org.gaopengtao.musicinfo.service.Impl.AdminServiceImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView extends JFrame {

	private JPanel cp;
	private JTextField ms_name;
	private JPasswordField ms_psw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setResizable(false);
		setFont(new Font("微软雅黑", Font.PLAIN, 20));
		setForeground(new Color(255, 0, 0));
		setBackground(new Color(255, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\picture\\\u56FE\u7247.jpg"));
		setTitle("\u97F3\u4E50\u4FE1\u606F\u7BA1\u7406\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 368);
		setLocationRelativeTo(null);
		cp = new JPanel();
		cp.setBackground(Color.LIGHT_GRAY);
		cp.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cp);
		cp.setLayout(null);

		ms_name = new JTextField();
		ms_name.setBackground(Color.WHITE);
		ms_name.setBounds(173, 167, 147, 21);
		cp.add(ms_name);
		ms_name.setColumns(10);

		JLabel label = new JLabel("\u8D26\u6237");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBackground(new Color(106, 90, 205));
		label.setBounds(87, 166, 54, 18);
		cp.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		label_1.setBounds(87, 207, 54, 18);
		cp.add(label_1);

		JLabel infoShow = new JLabel("");
		infoShow.setBackground(Color.RED);
		infoShow.setForeground(Color.RED);
		infoShow.setBounds(173, 239, 147, 18);
		cp.add(infoShow);

		ms_psw = new JPasswordField();
		ms_psw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String name = ms_name.getText().trim();
					String psw = new String(ms_psw.getPassword()).trim();
					if ("".equals(name) || "".equals(psw))
						infoShow.setText("帐户名不能为空");
					else {
						AdminService asd = new AdminServiceImpl();
						boolean a = asd.login(new Admin(name, psw));
						if (a) {
							setVisible(false);
							new UserView(true).setVisible(true);
						} else
							infoShow.setText("账户或者密码错误");
					}
				}
			}
		});
		ms_psw.setBackground(Color.WHITE);
		ms_psw.setBounds(173, 208, 147, 21);
		cp.add(ms_psw);

		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = ms_name.getText().trim();
				String psw = new String(ms_psw.getPassword()).trim();
				if ("".equals(name) || "".equals(psw))
					infoShow.setText("帐户名不能为空");
				else {
					AdminService asd = new AdminServiceImpl();
					boolean a = asd.login(new Admin(name, psw));
					if (a) {
						setVisible(false);
						new UserView(true).setVisible(true);
					} else
						infoShow.setText("登录失败");
				}
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBounds(113, 267, 93, 23);
		cp.add(button);

		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = ms_name.getText();
				String psw = ms_psw.getPassword().toString().trim();
				if ("".equals(name) || "".equals(psw)) JOptionPane.showMessageDialog(null, "用户名，密码不能为空！");
				else{
					AdminService admin = new AdminServiceImpl();
					boolean a = admin.register(new Admin());
					if(a) JOptionPane.showMessageDialog(null, "注册成功！");
					else JOptionPane.showMessageDialog(null, "注册失败！");
				}
			}
		});
		button_1.setBounds(227, 267, 93, 23);
		cp.add(button_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\picture\\IMG_1477.PNG"));
		label_2.setBounds(0, 0, 504, 165);
		cp.add(label_2);

		JButton btnNewButton = new JButton("\u6E38\u5BA2\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new UserView(false).setVisible(true);

			}
		});
		btnNewButton.setBounds(411, 305, 93, 34);
		cp.add(btnNewButton);

	}
}

package org.gaopengtao.musicinfo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.entity.Music;
import org.gaopengtao.musicinfo.entity.MusicInfo;
import org.gaopengtao.musicinfo.entity.SingerInfo;
import org.gaopengtao.musicinfo.service.CatalogService;
import org.gaopengtao.musicinfo.service.MusicInfoService;
import org.gaopengtao.musicinfo.service.SingerInfoService;
import org.gaopengtao.musicinfo.service.Impl.CatalogServiceImpl;
import org.gaopengtao.musicinfo.service.Impl.MusicInfoServiceImpl;
import org.gaopengtao.musicinfo.service.Impl.SingerInfoServiceImpl;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Scrollbar;
import java.awt.Toolkit;

import javax.swing.JScrollBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserView extends JFrame {

	private JPanel contentPane;
	private JTextField ms_msname;
	private JTable table;
	private boolean vister = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public List<Vector> selectMusicBycata(CataLog cata) {
		CatalogService catalogService = new CatalogServiceImpl();
		List<Vector> lv = catalogService.selectMusic(cata);
		return lv;
	}

	/**
	 * 建立线程播放音乐
	 * 
	 * @param mname
	 */
	Player player = null;
	private JTable sm_table;
	private JTextField sm_id;
	private JTextField sm_cname;
	private JTextField sm_sname;
	private JTextField sm_des;
	private JTextField sm_mname;
	private JTextField sm_cid;
	private JTextField sm_sid;
	private JTextField jf_time;

	public void playMusic(String mname) {
		String path = "music/" + mname + ".mp3";
		new Thread() {
			public void run() {
				BufferedInputStream buffer;
				try {
					buffer = new BufferedInputStream(new FileInputStream(path));
					player = new Player(buffer);
					player.play();
				} catch (FileNotFoundException | JavaLayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}.start();
	}

	public void fillTable(List<Vector> lv, JTable table) {
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		tm.setRowCount(0);// 清空上次表中遗留的数据
		for (Vector v : lv) {
			tm.addRow(v);
		}
	}

	/**
	 * Create the frame.
	 */
	public UserView(boolean b) {
		this.vister = b;

		setTitle("Welcome to my music ku");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 516);

		// int w = (Toolkit.getDefaultToolkit().getScreenSize().width - width) /
		// 2;
		// int h = (Toolkit.getDefaultToolkit().getScreenSize().height - height)
		// / 2;
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel1 = new JPanel();
		panel1.setForeground(Color.WHITE);
		panel1.setBackground(Color.WHITE);

		JLayeredPane lp = new JLayeredPane();
		contentPane.add(lp, "name_226614965024467");

		JPanel panel2 = new JPanel();
		panel2.setToolTipText("");
		panel2.setBounds(0, 0, 693, 479);
		lp.add(panel2);
		panel2.setLayout(null);

		JButton btnNewButton_11 = new JButton("\u66F2\u5E93\u6DFB\u52A0");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vister) {
//					MusicInfoService musicInfoService = new MusicInfoServiceImpl();
//					List<Vector> lv = musicInfoService.selectAllMusic();
//					fillTable(lv, sm_table);
					panel1.setVisible(true);
					lp.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "注册后才能激活此功能！");
				}
			}
		});
		btnNewButton_11.setBounds(10, 100, 93, 23);
		panel2.add(btnNewButton_11);

		JButton btnNewButton_6 = new JButton("\u67E5\u8BE2\u97F3\u4E50");
		btnNewButton_6.setBounds(10, 50, 93, 23);
		panel2.add(btnNewButton_6);

		JButton btnNewButton_10 = new JButton("\u97F3\u4E50\u64AD\u653E");

		btnNewButton_10.setBounds(10, 150, 93, 23);
		panel2.add(btnNewButton_10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 683, 469);
		panel2.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(0, 0, 691, 480);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon("D:\\picture\\TIM\u56FE\u724720180727150533.png"));

		jf_time = new JTextField();
		jf_time.setBounds(0, 445, 131, 21);
		panel2.add(jf_time);
		jf_time.setColumns(10);

		Thread t = new Thread(new Runnable() {
			public void run() {
				while (true) {
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					String time = sdf.format(new Date());
					jf_time.setText(time);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();

		contentPane.add(panel1, "name_146864450377927");
		panel1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 55, 664, 115);
		panel1.add(scrollPane_1);

		sm_table = new JTable();
		sm_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CatalogService catalogService = new CatalogServiceImpl();
				int row = sm_table.getSelectedRow();
				sm_id.setText(sm_table.getValueAt(row, 0) + "");
				sm_mname.setText(sm_table.getValueAt(row, 1) + "");
				sm_sname.setText(sm_table.getValueAt(row, 2) + "");
				sm_cname.setText(sm_table.getValueAt(row, 3) + "");
				sm_des.setText(sm_table.getValueAt(row, 4) + "");

			}
		});
		sm_table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "\u6B4C\u66F2ID", "\u6B4C\u540D", "\u6B4C\u624B", "\u66F2\u98CE", "\u4E13\u8F91" }));
		sm_table.getColumnModel().getColumn(0).setPreferredWidth(55);
		sm_table.getColumnModel().getColumn(1).setPreferredWidth(155);
		sm_table.getColumnModel().getColumn(2).setPreferredWidth(55);
		sm_table.getColumnModel().getColumn(3).setPreferredWidth(55);
		scrollPane_1.setViewportView(sm_table);

		JLabel lblNewLabel = new JLabel("\u6B4C\u66F2ID");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(10, 180, 54, 15);
		panel1.add(lblNewLabel);

		JLabel label = new JLabel("\u66F2\u98CE");
		label.setBounds(10, 205, 54, 15);
		panel1.add(label);

		JLabel label_1 = new JLabel("\u6B4C\u624B");
		label_1.setBounds(10, 237, 54, 15);
		panel1.add(label_1);

		JLabel lblNewLabel_2 = new JLabel("\u4E13\u8F91");
		lblNewLabel_2.setBounds(10, 262, 54, 15);
		panel1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u6B4C\u540D");
		lblNewLabel_3.setBounds(10, 287, 54, 15);
		panel1.add(lblNewLabel_3);

		JLabel Mshow = new JLabel("");
		Mshow.setBackground(Color.WHITE);
		Mshow.setFont(new Font("华文隶书", Font.PLAIN, 20));
		Mshow.setForeground(Color.RED);
		Mshow.setBounds(149, 262, 277, 32);
		panel1.add(Mshow);

		sm_id = new JTextField();
		sm_id.setBounds(54, 180, 40, 21);
		panel1.add(sm_id);
		sm_id.setColumns(10);

		sm_cname = new JTextField();
		sm_cname.setBounds(54, 205, 49, 21);
		panel1.add(sm_cname);
		sm_cname.setColumns(10);

		sm_sname = new JTextField();
		sm_sname.setBounds(54, 234, 60, 21);
		panel1.add(sm_sname);
		sm_sname.setColumns(10);

		sm_des = new JTextField();
		sm_des.setBounds(54, 259, 72, 21);
		panel1.add(sm_des);
		sm_des.setColumns(10);

		sm_mname = new JTextField();
		sm_mname.setBounds(54, 284, 85, 21);
		panel1.add(sm_mname);
		sm_mname.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u6B4C\u624BID");
		lblNewLabel_4.setBounds(152, 237, 54, 15);
		panel1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u66F2\u98CEID");
		lblNewLabel_5.setBounds(152, 208, 54, 15);
		panel1.add(lblNewLabel_5);

		sm_cid = new JTextField();
		sm_cid.setBounds(194, 202, 66, 21);
		panel1.add(sm_cid);
		sm_cid.setColumns(10);

		sm_sid = new JTextField();
		sm_sid.setBounds(194, 234, 66, 21);
		panel1.add(sm_sid);
		sm_sid.setColumns(10);

		JButton btnNewButton_8 = new JButton("\u4FEE\u6539\u66F2\u98CE");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = sm_cname.getText().trim();
				String value = sm_cid.getText().trim();
				if ("".equals(cname) || "".equals(value))
					Mshow.setText("曲风名或者ID不能为空");
				else if (cname.length() > 10 || value.length() > 4)
					Mshow.setText("字符超过限制！");
				else {
					try {
						int i = Integer.valueOf(value).intValue();
						CatalogService catalog = new CatalogServiceImpl();
						boolean survice = catalog.isCataid(new CataLog(i));
						if (survice) {
							boolean b = catalog.updateCatalog(new CataLog(i, cname));
							if (b)
								Mshow.setText("修改成功成功");
							else
								Mshow.setText("修改失败");
						} else
							Mshow.setText("曲风id不存在");
					} catch (NumberFormatException e1) {
						Mshow.setText("曲风ID必须为数字");
					}
				}
			}
		});

		btnNewButton_8.setBounds(336, 204, 93, 23);
		panel1.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("\u5220\u9664\u66F2\u98CE");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = sm_cname.getText().trim();
				if ("".equals(cname))
					Mshow.setText("曲风名不能为空");
				else if (cname.length() > 10)
					Mshow.setText("字符超过限制！");
				else {
					CatalogService catalog = new CatalogServiceImpl();
					boolean s = catalog.isCname(new CataLog(cname));
					if (s) {
						boolean b = catalog.detelCatalog(new CataLog(cname));
						if (b)
							Mshow.setText("删除成功");
						else
							Mshow.setText("删除失败");
					} else
						Mshow.setText("曲风不存在");
				}
			}
		});

		btnNewButton_9.setBounds(455, 205, 93, 23);
		panel1.add(btnNewButton_9);

		JButton btnNewButton_12 = new JButton("\u6DFB\u52A0\u66F2\u98CE");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = sm_cname.getText().trim();
				String value = sm_cid.getText().trim();
				if ("".equals(cname) || "".equals(value))
					Mshow.setText("曲风或者ID不能为空");
				else if (cname.length() > 10 || value.length() > 4)
					Mshow.setText("字符超过限制！");
				else {
					CatalogService catalogService = new CatalogServiceImpl();
					int i = 0;
					try {
						i = Integer.valueOf(value).intValue();
						boolean s = catalogService.isCataid(new CataLog(i));
						if (s)
							Mshow.setText("曲风id已经存在");
						else {
							boolean m = catalogService.isCname(new CataLog(cname));
							if(m) Mshow.setText("曲风已经存在");
							else{
								boolean b = catalogService.addCatalog(new CataLog(i, cname));
								if (b)
									Mshow.setText("添加成功");
								else
									Mshow.setText("添加失败");
							}
						}
					} catch (NumberFormatException e1) {
						Mshow.setText("曲风ID必须为数字！");
					}
				}
			}
		});

		btnNewButton_12.setBounds(561, 205, 93, 23);
		panel1.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("\u4FEE\u6539\u6B4C\u624B");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sname = sm_sname.getText().trim();
				String value = sm_sid.getText().trim();
				if ("".equals(sname) || "".equals(value))
					Mshow.setText("歌手或者歌手ID不能为空！");
				else if (sname.length() > 10 || value.length() > 4)
					Mshow.setText("字符超过限制！");
				else {
					try {
						SingerInfoService singerInfo = new SingerInfoServiceImpl();
						int i = Integer.valueOf(value).intValue();
						boolean s = singerInfo.isSinger(new SingerInfo(i));
						if (s == false)
							Mshow.setText("歌手ID不存在！");
						else {
							boolean b = singerInfo.upDateSinger(new SingerInfo(i, sname));
							if (b)
								Mshow.setText("修改成功！");
							else
								Mshow.setText("修改失败！");
						}
					} catch (NumberFormatException e1) {
						Mshow.setText("歌手ID必须为数字！");
					}
				}
			}
		});
		btnNewButton_13.setBounds(336, 233, 93, 23);
		panel1.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("\u5220\u9664\u6B4C\u624B");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sname = sm_sname.getText().trim();
				// String value = sm_sid.getText().trim();
				if ("".equals(sname))
					Mshow.setText("歌手不能为空!");
				else if (sname.length() > 10)
					Mshow.setText("字符超过限制！");
				else {
					SingerInfoService singerInfo = new SingerInfoServiceImpl();
					// int i = Integer.valueOf(value).intValue();
					boolean s = singerInfo.isSinger(new SingerInfo(sname));
					if (s == false)
						Mshow.setText("歌手不存在!");
					else {
						boolean b = singerInfo.deteleSinger(new SingerInfo(sname));
						if (b)
							Mshow.setText("删除成功!");
						else
							Mshow.setText("删除失败!");

					}
				}
			}
		});

		btnNewButton_14.setBounds(455, 233, 93, 23);
		panel1.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("\u6DFB\u52A0\u6B4C\u624B");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sname = sm_sname.getText().trim();
				String value = sm_sid.getText().trim();
				if (("".equals(value)) || ("".equals(sname)))
					Mshow.setText("歌手和歌手ID不能为空!");
				else if (sname.length() > 15 || value.length() > 4)
					Mshow.setText("字符超过限制");
				else {
					try {
						int i = Integer.valueOf(value).intValue();
						SingerInfoService singerInfoService = new SingerInfoServiceImpl();
						boolean s = singerInfoService.isSinger(new SingerInfo(i));
						if (s)
							Mshow.setText("歌手ID已经存在!");
						else {
							boolean b = singerInfoService.addSinger(new SingerInfo(i, sname));
							if (b)
								Mshow.setText("添加成功!");
							else
								Mshow.setText("添加失败！");
						}
					} catch (NumberFormatException e1) {
						Mshow.setText("歌手ID必须为数字！ ");
					}
				}
			}
		});

		btnNewButton_15.setBounds(561, 233, 93, 23);
		panel1.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("\u4FEE\u6539\u6B4C\u66F2");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = sm_id.getText().trim();
				String cname = sm_cname.getText().trim();
				String mname = sm_mname.getText().trim();
				String sname = sm_sname.getText().trim();
				String des = sm_des.getText().trim();
				if ("".equals(value))
					Mshow.setText("歌曲ID不能为空！");
				else if (value.length() > 4 || cname.length() > 20 || mname.length() > 20|| sname.length() > 20
						|| des.length() > 20)
					Mshow.setText("字符数超过限制！");
				else {
					try {
						int i = Integer.valueOf(value).intValue();
						SingerInfoService singerInfoService = new SingerInfoServiceImpl();
						boolean m = singerInfoService.isSingerByname(new SingerInfo(sname));
						if (m == false)
							Mshow.setText("歌手不存在！");
						else {
							CatalogService catalog = new CatalogServiceImpl();
							boolean n = catalog.isCname(new CataLog(cname));
							if (n) {
								MusicInfoService musicInfo = new MusicInfoServiceImpl();
								boolean b = musicInfo.updateMusic(new Music(i, mname, sname, cname, des));
								if (b)
									Mshow.setText("修改成功！");
								else
									Mshow.setText("修改失败！");
							} else
								Mshow.setText("曲风不存在！");
						}
					} catch (NumberFormatException e1) {
						Mshow.setText("歌曲ID必须为数字！");
					}
				}
			}
		});
		btnNewButton_16.setBounds(54, 328, 93, 23);
		panel1.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("\u5220\u9664\u6B4C\u66F2");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = sm_id.getText().trim();
				if (value == null || "".equals(value))
					Mshow.setText("歌曲ID不能为空！");
				else if (value.length() > 4)
					Mshow.setText("字符数超过限制！");
				else {
					try {
						int i = Integer.valueOf(value).intValue();
						MusicInfoService musicInfo = new MusicInfoServiceImpl();
						boolean a = musicInfo.deletMusic(new MusicInfo(i));
						if (a)
							Mshow.setText("删除成功");
						else
							Mshow.setText("删除失败");
					} catch (NumberFormatException e1) {
						Mshow.setText("歌曲ID必须为数字");
					}
				}
			}
		});

		btnNewButton_17.setBounds(54, 361, 93, 23);
		panel1.add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("\u6DFB\u52A0\u6B4C\u66F2");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mname = sm_mname.getText().trim();
				String mdec = sm_des.getText().trim();
				String sname = sm_sname.getText().trim();
				String cname = sm_cname.getText().trim();
				String value = sm_id.getText().trim();
				// int i = Integer.valueOf(sm_cid.getText()).intValue();
				// int m = Integer.valueOf(sm_sid.getText()).intValue();
				if ("".equals(value) || "".equals(mdec) || "".equals(mname) || "".equals(sname) || "".equals(cname))
					Mshow.setText("歌曲ID,歌名,专辑,歌手名，曲风任何一个不能为空！");
				else if (mname.length() > 20 || sname.length() > 20 || cname.length() > 10 || value.length() > 4)
					Mshow.setText("输入超过最大字符限制！");
				else {
					int idvalue;
					try {
						idvalue = Integer.valueOf(value).intValue();
						MusicInfoService music = new MusicInfoServiceImpl();
						String info = music.addMusicInfo(new Music(idvalue, mname, sname, cname, mdec));
						Mshow.setText(info);
					} catch (NumberFormatException e1) {
						Mshow.setText("歌曲ID必须为数字!");
					}
					// MusicInfoService mf = new MusicInfoServiceImpl();
					// boolean s = mf.isMusicid(new Music(idvalue));
					// if(s) Mshow.setText("歌曲ID已经存在!");
					// else{
					// SingerInfoService singer = new SingerInfoServiceImpl();
					// boolean m = singer.isSingerByname(new SingerInfo(sname));
					// if(m==false) Mshow.setText("歌手不存在!");
					// else{
					// CatalogService catalog = new CatalogServiceImpl();
					// boolean n = catalog.isCname(new CataLog(cname));
					// if(n==false) Mshow.setText("曲风不存在");
					// else{
					// boolean b = mf.addMusic(new
					// Music(idvalue,mname,sname,cname,mdec));
					// if(b) Mshow.setText("添加成功!");
					// else Mshow.setText("添加失败!");
					// }
					// }
					// }

				}
			}
		});

		btnNewButton_18.setBounds(54, 394, 93, 23);
		panel1.add(btnNewButton_18);

		JButton btnNewButton_19 = new JButton("\u56DE\u53BB\u770B\u5C0F\u59D0\u59D0");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				lp.setVisible(true);
			}
		});

		btnNewButton_19.setBounds(539, 434, 115, 23);
		panel1.add(btnNewButton_19);

		JLabel id_show = new JLabel("\u8BF7\u586B\u5199\u6570\u5B57");
		id_show.setForeground(Color.RED);
		id_show.setBounds(104, 180, 79, 15);
		panel1.add(id_show);

		JLabel lblNewLabel_7 = new JLabel("\u8BF7\u586B\u5199\u6570\u5B57");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(270, 205, 72, 15);
		panel1.add(lblNewLabel_7);

		JLabel lblNewLabel_9 = new JLabel("\u8BF7\u586B\u5199\u6570\u5B57");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(270, 237, 72, 15);
		panel1.add(lblNewLabel_9);

		JButton btnNewButton_20 = new JButton("\u91CD\u7F6E");

		btnNewButton_20.setBounds(426, 434, 93, 23);
		panel1.add(btnNewButton_20);
		
		JComboBox cataBox = new JComboBox();
		cataBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CatalogService catalog = new CatalogServiceImpl();
				String cname = null;;
				try {
					cname = cataBox.getSelectedItem().toString();
				} catch (Exception e1) {
					
				}
				List<Vector> lv = catalog.selectMusic(new CataLog(cname));
				fillTable(lv, sm_table);
			}
		});
		cataBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CatalogService catalog = new CatalogServiceImpl();
				Set set = catalog.allCatalog();
				cataBox.removeAllItems();
				for(Object cata:set){
					cataBox.addItem(cata);
				}
//				String cname = cataBox.getSelectedItem().toString();
//				List<Vector> lv = catalog.selectMusic(new CataLog(cname));
//				fillTable(lv, sm_table);
			}
		});
		cataBox.setModel(new DefaultComboBoxModel(new String[] {"--\u66F2\u98CE--"}));
		cataBox.setBounds(15, 24, 79, 21);
		panel1.add(cataBox);
		
		JComboBox singerBox = new JComboBox();
		singerBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SingerInfoService singerinfo = new SingerInfoServiceImpl();
				Set set = singerinfo.allSinger();
				singerBox.removeAllItems();
				for(Object obj:set){
					singerBox.addItem(obj);
				}
			}
		});
		
		singerBox.setModel(new DefaultComboBoxModel(new String[] {"--\u6B4C\u624B--"}));
		singerBox.setBounds(127, 24, 85, 21);
		panel1.add(singerBox);

		JPanel panel = new JPanel();
		contentPane.add(panel, "name_325737730961672");
		panel.setForeground(Color.WHITE);
		panel.setToolTipText("\r\n");
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		ms_msname = new JTextField();
		ms_msname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					MusicInfoService musicInfoService = new MusicInfoServiceImpl();
					String msname = ms_msname.getText();
					List<Vector> lv = musicInfoService.selectMusic(msname);
					fillTable(lv, table);
				}
			}
		});
		ms_msname.setBounds(152, 47, 373, 30);
		panel.add(ms_msname);
		ms_msname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u6B4C\u540D\u6216\u8005\u6B4C\u624B");
		lblNewLabel_1.setFont(new Font("华文彩云", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(152, 22, 291, 24);
		panel.add(lblNewLabel_1);

		JButton ms_slllllllname = new JButton("\u641C\u7D22");
		ms_slllllllname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicInfoService musicInfoService = new MusicInfoServiceImpl();
				String msname = ms_msname.getText().trim();
				List<Vector> lv = null;
				if (msname != null) {
					lv = musicInfoService.selectMusic(msname);
					fillTable(lv, table);
				} else {
					lv = musicInfoService.selectAllMusic();
					fillTable(lv, table);
				}
			}
		});
		ms_slllllllname.setBackground(Color.BLACK);
		ms_slllllllname.setForeground(Color.BLUE);
		ms_slllllllname.setFont(new Font("华文行楷", Font.PLAIN, 20));
		ms_slllllllname.setBounds(565, 46, 93, 31);
		panel.add(ms_slllllllname);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 389, 664, 78);
		panel.add(scrollPane);
		scrollPane.setEnabled(false);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(Color.CYAN);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] { { "", "", "", "", "" }, { "", "", "", "", "" },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, },
				new String[] { "\u6B4C\u66F2ID", "\u6B4C\u540D", "\u6B4C\u624B", "\u66F2\u79CD", "\u4E13\u8F91" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(255);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				String mname = table.getValueAt(i, 1).toString();
				if (player != null) {
					player.close();
					player = null;
				} else {
					playMusic(mname);
				}
			}
		});

		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sm_id.setText("");
				sm_mname.setText("");
				sm_sname.setText("");
				sm_cname.setText("");
				sm_des.setText("");
				sm_cid.setText("");
				sm_id.setText("");
				sm_sid.setText("");
			}
		});

		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lp.setVisible(false);
				panel.setVisible(true);
			}
		});

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 0, 680, 467);
		panel.add(panel3);
		panel3.setLayout(null);
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setBounds(10, 47, 137, 31);
		panel3.add(btnNewButton_7);

		btnNewButton_7.setIcon(new ImageIcon("D:\\picture\\TIM\u56FE\u724720180727154557.png"));

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(0, 0, 670, 467);
		panel3.add(lblNewLabel_10);
		lblNewLabel_10.setIcon(new ImageIcon("D:\\picture\\TIM\u56FE\u724720180728174409.png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lp.setVisible(true);
				panel.setVisible(false);
			}
		});
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lp.setVisible(false);
				panel.setVisible(true);
			}
		});

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.UserType;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;

public class MainFrm extends JFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenu studentMenu ;
	private JMenuItem addStudentMenuItem;
	private JMenuItem manageStudentMenuItem;
	private JMenu classMenu;
	private JMenuItem addClassMenuItem;
	private JMenuItem manageClassMenuItem;
	private JMenu teacherMenu;
	private JMenuItem addTeacherMenuItem;
	private JMenuItem manageTeacherMenuItem;

	public MainFrm(UserType userType,Object userObject) {
		this.userType=userType;
		this.userObject=userObject;
		setTitle("学生信息系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 571);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu systemSettingMenu = new JMenu("系统设置");
		systemSettingMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/系统设置.png")));
		menuBar.add(systemSettingMenu);
		
		JMenuItem changePasswordMenuItem = new JMenuItem("修改密码");
		//创建一个修改密码的监听器
		changePasswordMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPasswordAwt();
			}
		});
		changePasswordMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/修改密码.png")));
		systemSettingMenu.add(changePasswordMenuItem);
		
		JMenuItem exitSystemMenuItem = new JMenuItem("退出系统");
		//创建一个退出系统监听器
		exitSystemMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitSystemAwt(e);
			}
		});
		
		exitSystemMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/退出.png")));
		systemSettingMenu.add(exitSystemMenuItem);
		
		studentMenu = new JMenu("学生管理");
		studentMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/学生管理.png")));
		menuBar.add(studentMenu);
		
		addStudentMenuItem = new JMenuItem("学生添加");
		//创建一个学生添加的监听器
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentAwt(e);
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加.png")));
		studentMenu.add(addStudentMenuItem);
		
		manageStudentMenuItem = new JMenuItem("学生列表");
		//创建一个学生列表的监听器
		manageStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageStudentAwt(e);
			}
		});
		manageStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/用户列表.png")));
		studentMenu.add(manageStudentMenuItem);
		
		classMenu = new JMenu("班级管理");
		classMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/班级管理.png")));
		menuBar.add(classMenu);
		
		addClassMenuItem = new JMenuItem("班级添加");
		//创建一个班级添加的监听器
		addClassMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentClassAwt(e);
			}
		});
		addClassMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加.png")));
		classMenu.add(addClassMenuItem);
		
		manageClassMenuItem = new JMenuItem("班级列表");
		//创建一个班级列表的监听器
		manageClassMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageClassAwt(e);
			}
		});
		manageClassMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/班级列表.png")));
		classMenu.add(manageClassMenuItem);
		
		teacherMenu = new JMenu("教师管理");
		teacherMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/老师.png")));
		menuBar.add(teacherMenu);
		
		addTeacherMenuItem = new JMenuItem("添加教师");
		//创建一个添加教师的监听器
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeacherAwt(e);
			}
		});
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/添加.png")));
		teacherMenu.add(addTeacherMenuItem);
		
		manageTeacherMenuItem = new JMenuItem("教师列表");
		//创建一个教师列表的监听器
		manageTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageTeacherAwt(e);
			}
		});
		manageTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/用户列表.png")));
		teacherMenu.add(manageTeacherMenuItem);
		
		JMenu helpMenu = new JMenu("帮助");
		helpMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/帮助.png")));
		menuBar.add(helpMenu);
		
		JMenuItem aboutUsMenuItem = new JMenuItem("关于我们");
		aboutUsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUsAwt(ae);
			}
		});
		aboutUsMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/关于我们.png")));
		helpMenu.add(aboutUsMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 128, 128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setAuthority();
	}

	//权限管理
	private void setAuthority() {
		if("学生".equals(userType.getName())) {
			addStudentMenuItem.setEnabled(false);
			classMenu.setEnabled(false);
			teacherMenu.setEnabled(false);
		}
		if("老师".equals(userType.getName())) {
			classMenu.setEnabled(false);
			addTeacherMenuItem.setEnabled(false);
		}	
	}
	
	//修改密码的事件监听方法
	protected void editPasswordAwt() {
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}
	
	//退出系统的事件监听方法
	protected void exitSystemAwt(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出吗？")==JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}

	//添加学生的事件监听方法
	protected void addStudentAwt(ActionEvent e) {
		AddStudentFrm addStudentFrm = new AddStudentFrm();
		addStudentFrm.setVisible(true);
		desktopPane.add(addStudentFrm);
	}
	
	//学生列表的事件监听方法
	protected void manageStudentAwt(ActionEvent e) {
		ManageStudentFrm studentManageFrm = new ManageStudentFrm();
		studentManageFrm.setVisible(true);
		desktopPane.add(studentManageFrm);
	}
	
	//添加班级的事件监听方法
	protected void addStudentClassAwt(ActionEvent e) {
		AddStudentClassFrm studentClassAddFrm = new AddStudentClassFrm();
		studentClassAddFrm.setVisible(true);
		desktopPane.add(studentClassAddFrm);
	}
	
	//班级列表的事件监听方法
	protected void manageClassAwt(ActionEvent e) {
		ManageClassFrm classManageFrm = new ManageClassFrm();
		classManageFrm.setVisible(true);
		desktopPane.add(classManageFrm);
	}
	
	//添加学生的事件监听方法
	protected void addTeacherAwt(ActionEvent e) {
		AddTeacherFrm addTeacherFrm = new AddTeacherFrm();
		addTeacherFrm.setVisible(true);
		desktopPane.add(addTeacherFrm);
	}
	
	//教师列表的事件监听方法
	protected void manageTeacherAwt(ActionEvent e) {
		ManageTeacherFrm manageTeacherFrm = new ManageTeacherFrm();
		manageTeacherFrm.setVisible(true);
		desktopPane.add(manageTeacherFrm);
	}

	//关于我们的事件监听方法
	protected void aboutUsAwt(ActionEvent ae) {
		String info="系统名称：NNNU学生信息管理系统\n";
		info +="系统构建者：卢家业小组\n";
		info +="小组成员：卢家业，吴灿，李国栋，农小豪，丘昌鑫，韦栎文\n";
		info +="系统构建日期：2022年10月2号\n";
		info +="联系方式：17677373673";			
		JOptionPane.showMessageDialog(this, info);
	}
}

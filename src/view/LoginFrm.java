package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import dao.Admindao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Student;
import model.Teacher;
import model.UserType;
import util.StringUtil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame {
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JComboBox userTypeComboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrm() {
		setTitle("登陆界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel titleLabel = new JLabel("学生信息系统登陆界面");
		titleLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/nnnu校徽.png")));

		titleLabel.setBounds(76, 0, 265, 78);
		titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JLabel userNameLabel = new JLabel("用户名：");
		userNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userNameLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/用户名.png")));
		userNameLabel.setBounds(76, 86, 90, 16);
		contentPane.setLayout(null);//setLayout是对当前组件设置为流式布局
		contentPane.add(titleLabel);
		contentPane.add(userNameLabel);

		JLabel passwordLabel = new JLabel("密  码：");
		passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		passwordLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/密码.png")));
		passwordLabel.setBounds(76, 145, 83, 16);
		contentPane.add(passwordLabel);
		
		JLabel userTypeLabel = new JLabel("用户类型");
		userTypeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userTypeLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userType.png")));
		userTypeLabel.setBounds(76, 205, 83, 15);
		contentPane.add(userTypeLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(159, 86, 182, 21);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(159, 145, 182, 21);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN,UserType.TEACHER,UserType.STUDENT}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userTypeComboBox.setBounds(159, 201, 182, 23);
		contentPane.add(userTypeComboBox);
		
		JButton loginButton = new JButton("登入");
		//创建一个登入按钮的监听器
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/登录.png")));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 15)); 
		loginButton.setBounds(76, 246, 90, 23);
		contentPane.add(loginButton);
		
		JButton resetButton = new JButton("重置");
		//创建一个重置按钮的监听器
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/重置.png")));
		resetButton.setBounds(244, 246, 97, 23);
		contentPane.add(resetButton);
	}

	//登入按钮的事件监听方法
	protected void loginAct(ActionEvent ae) {
		//通过getText()方法获取用户输入的用户名和密码
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		//判断用户输入是否为空
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this,"用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this,"密码不能为空！");
			return;
		}
		if("系统管理员".equals(selectedItem.getName())) {
			//系统管理员登录
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			Admindao admindao = new Admindao();
			Admin admin = admindao.login(adminTmp);
			admindao.closeDao();//用完数据库就关掉，释放资源
			if(admin==null){
				JOptionPane.showMessageDialog(this,"用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this,"欢迎"+selectedItem.getName()+":"+admin.getName()+"登入本系统！");
			this.dispose();//登入成功后隐藏登入界面
			new MainFrm(selectedItem,admin).setVisible(true);
		}
		else if("老师".equals(selectedItem.getName())) {
			//教师登录
			//学生登录
			Teacher teacher=null;
			Teacher teacherTmp = new Teacher();
			teacherTmp.setName(userName);
			teacherTmp.setPassword(password);
			TeacherDao teacherDao = new TeacherDao();
			teacher = teacherDao.login(teacherTmp);
			teacherDao.closeDao();//用完数据库就关掉，释放资源
			if(teacher==null){
				JOptionPane.showMessageDialog(this,"用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this,"欢迎"+selectedItem.getName()+":"+teacher.getName()+"登入本系统！");
			this.dispose();//登入成功后隐藏登入界面
			new MainFrm(selectedItem,teacher).setVisible(true);
			
		}
		else {
			//学生登录
			Student student=null;
			Student studentTmp = new Student();
			studentTmp.setName(userName);
			studentTmp.setPassword(password);
			StudentDao studentDao = new StudentDao();
			student = studentDao.login(studentTmp);
			studentDao.closeDao();//用完数据库就关掉，释放资源
			if(student==null){
				JOptionPane.showMessageDialog(this,"用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this,"欢迎"+selectedItem.getName()+":"+student.getName()+"登入本系统！");
			this.dispose();//登入成功后隐藏登入界面
			new MainFrm(selectedItem,student).setVisible(true);
		}
	}

	//重置按钮的事件监听方法
	protected void  restValue(ActionEvent ae) {
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}
package view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import dao.TeacherDao;
import model.Teacher;
import util.StringUtil;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeacherFrm extends JInternalFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherAgeTextField;
	private JTextField teacherPasswordTextField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton manRadioButton;
	private JRadioButton girlRadioButton;

	public AddTeacherFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("添加教师");
		setBounds(100, 100, 412, 300);
		
		JLabel lblNewLabel = new JLabel("教师姓名：");
		lblNewLabel.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/老师.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("教师性别：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/性别.png")));
		
		manRadioButton = new JRadioButton("男");
		manRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		manRadioButton.setSelected(true);
		
		girlRadioButton = new JRadioButton("女");
		girlRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(manRadioButton); 
		sexButtonGroup.add(girlRadioButton);
		
		JLabel lblNewLabel_2 = new JLabel("教师职称：");
		lblNewLabel_2.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/职称评定.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("教师年龄：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/年龄.png")));
		
		JLabel lblNewLabel_4 = new JLabel("教师密码：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_4.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/密码.png")));
		
		JButton submitButton = new JButton("添加");
		//创建一个添加教师添加按钮的监听器
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeaacherAct(e);
			}
		});
		submitButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/确认.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("重置");
		//创建一个添加教师重置按钮的监听器
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});
		resetButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/重置.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(10);
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setColumns(10);
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setColumns(10);
		
		teacherPasswordTextField = new JTextField();
		teacherPasswordTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(manRadioButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(girlRadioButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addComponent(teacherNameTextField, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(teacherPasswordTextField))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(teacherAgeTextField)
									.addComponent(teacherTitleTextField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))))
					.addGap(163))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(manRadioButton)
						.addComponent(girlRadioButton)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(teacherPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);

	}

	//添加教师添加按钮的监听方法
	protected void addTeaacherAct(ActionEvent e) {
		String teacherName = teacherNameTextField.getText().toString();
		String teahcerSex = manRadioButton.isSelected()?manRadioButton.getText().toString():girlRadioButton.getText().toString();
		String teacherTitle = teacherTitleTextField.getText().toString();
		String teacherPassword= teacherPasswordTextField.getText().toString();
		int teacherAge=0;
		if(StringUtil.isEmpty(teacherName)) {
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)) {
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)) {
			JOptionPane.showMessageDialog(this, "教师密码必须填写！");
			return;
		}
		try {
			teacherAge = Integer.parseInt(teacherAgeTextField.getText().toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setName(teacherName);
		teacher.setSex(teahcerSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.addTeahcer(teacher)) {
			JOptionPane.showMessageDialog(this, "教师添加成功!");
		}else {
			JOptionPane.showMessageDialog(this, "教师添加失败!");
		}
		reset(e);
		
		
	}

	//添加教师重置按钮的监听方法
	protected void reset(ActionEvent e) {
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherPasswordTextField.setText("");
		teacherAgeTextField.setText("");
		manRadioButton.setSelected(true);
	}
}

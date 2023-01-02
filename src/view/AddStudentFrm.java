package view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import dao.ClassDao;
import dao.StudentDao;
import model.Student;
import model.StudentClass;
import util.StringUtil;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddStudentFrm extends JInternalFrame {
	private JTextField studentNameTextField;
	private JTextField loginPasswordTextField;
	private ButtonGroup sexButtonGroup;
	private JComboBox studentClassComboBox;
	private JRadioButton manRadioButton;
	private JRadioButton girlRadioButton;
	private JRadioButton secrectRadioButton;

	public AddStudentFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("添加学生");
		setBounds(100, 100, 436, 310);
		
		JLabel studentNameLabel = new JLabel("学生姓名：");
		studentNameLabel.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/学生管理.png")));
		studentNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel studentClasssLabel = new JLabel("所属班级：");
		studentClasssLabel.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/班级名称.png")));
		studentClasssLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		studentClassComboBox = new JComboBox();
		
		JLabel loginPasswordLabel = new JLabel("登录密码：");
		loginPasswordLabel.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/密码.png")));
		loginPasswordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel studentSexLabel = new JLabel("学生性别：");
		studentSexLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		studentSexLabel.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/性别.png")));
		
		manRadioButton = new JRadioButton("男");
		manRadioButton.setSelected(true);
		manRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		girlRadioButton = new JRadioButton("女");
		girlRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		secrectRadioButton = new JRadioButton("保密");
		secrectRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(manRadioButton);
		sexButtonGroup.add(girlRadioButton);
		sexButtonGroup.add(secrectRadioButton);
		
		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(10);
		
		loginPasswordTextField = new JTextField();
		loginPasswordTextField.setColumns(10);
		
		JButton confirmButton = new JButton("确认");
		//创建一个添加学生确认按钮的监听器
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentAddAct(e);
			}
		});
		confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		confirmButton.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/确认.png")));
		
		JButton resetButton = new JButton("重置");
		//创建一个添加学生重置按钮的监听器
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetButton.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/重置.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(studentSexLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(manRadioButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(girlRadioButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(secrectRadioButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(loginPasswordLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(loginPasswordTextField))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(studentClasssLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(studentClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(studentNameLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentNameLabel)
						.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentClasssLabel)
						.addComponent(studentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginPasswordLabel)
						.addComponent(loginPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentSexLabel)
						.addComponent(manRadioButton)
						.addComponent(girlRadioButton)
						.addComponent(secrectRadioButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmButton)
						.addComponent(resetButton))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
	}

	//添加学生重置按钮的监听方法()
	protected void reset() {
		studentNameTextField.setText("");
		loginPasswordTextField.setText("");
		studentClassComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		manRadioButton.setSelected(true);
	}

	//添加学生确认按钮的监听方法()
	protected void studentAddAct(ActionEvent ae){
		String studentName = studentNameTextField.getText().toString();
		String password=loginPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this,"请填写学生姓名！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this,"请填写密码！");
			return;
		}
		StudentClass sc = (StudentClass)studentClassComboBox.getSelectedItem();
		String sex = manRadioButton.isSelected() ? manRadioButton.getText():(girlRadioButton.isSelected() ? girlRadioButton.getText():secrectRadioButton.getText());
		Student sd = new Student();
		sd.setName(studentName);
		sd.setClassID(sc.getId());
		sd.setPassword(password);
		sd.setSex(sex);
		StudentDao studentDao = new StudentDao();
		if(studentDao.addStudent(sd)){
			JOptionPane.showMessageDialog(this,"添加学生成功！");
		}else{
			JOptionPane.showMessageDialog(this,"添加学生失败！");
		}
		studentDao.closeDao();
		reset();

	}

	//在班级下拉列表中添加班级的方法()
	private void setStudentClassInfo() {
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(new StudentClass());
		for (StudentClass sc: classList) {
			studentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
}

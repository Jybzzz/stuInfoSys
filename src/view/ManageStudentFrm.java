package view;

import dao.ClassDao;
import model.Student;
import model.StudentClass;
import util.StringUtil;
import dao.StudentDao;
import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageStudentFrm extends JInternalFrame {
	private JTextField searchStudentNameTextField;
	private JTable studentListTable;
	private JTextField editStudentNameTextField;
	private JPasswordField editStudentPasswordtextField;
	private JComboBox searchStudentComboBox;
	private JComboBox editStudentClassComboBox;
	private List<StudentClass> classList;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton manRadioButton;
	private JRadioButton girlRadioButton;
	private JRadioButton secretRadioButton;
	private JButton deleteStudentButton; 

	public ManageStudentFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("学生信息管理");
		setBounds(100, 100, 700, 400);
		
		JLabel lblNewLabel = new JLabel("学生姓名：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/学生管理.png")));
		
		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("所属班级：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/班级名称.png")));

		searchStudentComboBox = new JComboBox();
		
		JButton searchButton = new JButton("查询");
		//创建一个学生信息管理中查询按钮的监听器
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchStudent(e);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/搜索.png")));
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("学生姓名：");
		lblNewLabel_2.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/学生管理.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("所属班级：");
		lblNewLabel_1_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/班级名称.png")));
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setColumns(10);
		
		editStudentClassComboBox = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("性别");
		lblNewLabel_3.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/性别.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		manRadioButton = new JRadioButton("男");
		
		girlRadioButton = new JRadioButton("女");
		
		secretRadioButton = new JRadioButton("保密");
		editSexButtonGroup = new ButtonGroup();
		editSexButtonGroup.add(manRadioButton);
		editSexButtonGroup.add(girlRadioButton);
		editSexButtonGroup.add(secretRadioButton);
		
		JLabel lblNewLabel_4 = new JLabel("登录密码：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_4.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/密码.png")));
		
		editStudentPasswordtextField = new JPasswordField();
		editStudentPasswordtextField.setColumns(10);
		
		JButton submitEditButton = new JButton("确认修改");
		//创建一个学生信息管理中确认修改按钮的监听器
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEditAct(e);
			}
		});
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitEditButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/确认.png")));
		
		deleteStudentButton = new JButton("删除学生");
		//创建一个学生信息管理中删除按钮的监听器
		deleteStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudent(e);
			}
		});
		deleteStudentButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/删除.png")));
		deleteStudentButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editStudentClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(manRadioButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(girlRadioButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(secretRadioButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editStudentPasswordtextField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteStudentButton, 0, 0, Short.MAX_VALUE)
								.addComponent(submitEditButton)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(manRadioButton)
						.addComponent(girlRadioButton)
						.addComponent(secretRadioButton)
						.addComponent(submitEditButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(editStudentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_4)
							.addComponent(editStudentPasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(deleteStudentButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
				
			}
		});
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6240\u5C5E\u73ED\u7EA7", "\u5B66\u751F\u6027\u522B", "\u767B\u5F55\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(studentListTable);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
		setTable(new Student());
		setAuthority(); 
	}

	//学生信息管理中确认修改按钮的监听方法
	protected void submitEditAct(ActionEvent e) {
		String studentName = editStudentNameTextField.getText().toString();
		String password = editStudentPasswordtextField.getText().toString();
		int index = studentListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this,"请选中要修改的内容！");
			return;
		}
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(this, "请填写学生姓名！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "请填写密码！");
			return;
		}
		Student student =  new Student();
		student.setName(studentName);
		student.setPassword(password);
		StudentClass sc = (StudentClass)editStudentClassComboBox.getSelectedItem();
		student.setClassID(sc.getId());
		student.setId(Integer.parseInt((studentListTable.getValueAt(index, 0).toString())));
		if(manRadioButton.isSelected())student.setSex(manRadioButton.getText().toString());
		if(girlRadioButton.isSelected())student.setSex(girlRadioButton.getText().toString());
		if(secretRadioButton.isSelected())student.setSex(secretRadioButton.getText().toString());
		
		StudentDao studentDao = new StudentDao();
		if(studentDao.update(student)) {
			JOptionPane.showMessageDialog(this,"更新成功！");
		}else {
			JOptionPane.showMessageDialog(this,"更新失败！");
		}
		studentDao.closeDao();
		setTable(new Student());	
	}

	//学生信息管理中删除按钮的监听方法
	protected void deleteStudent(ActionEvent e) {
		int index = studentListTable.getSelectedRow();//获取你选择的那一行
		if(index==-1) {
			JOptionPane.showMessageDialog(this,"请选中要删除的内容！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定要删除该班级的所有信息吗？")!=JOptionPane.OK_OPTION) {
			return;
		}
		StudentDao studentDao = new StudentDao();
		int id = Integer.parseInt((studentListTable.getValueAt(index, 0).toString()));//获取你要删除那一行的学生id
		if(studentDao.delete(id)) {
			JOptionPane.showMessageDialog(this,"删除成功！");
		}else {
			JOptionPane.showMessageDialog(this,"删除失败！");
		}
		studentDao.closeDao();
		setTable(new Student());
	}

	//学生信息管理中查询按钮的监听方法
	protected void searchStudent(ActionEvent e) {
		Student student =  new Student();
		student.setName(searchStudentNameTextField.getText().toString());
		StudentClass sc = (StudentClass)searchStudentComboBox.getSelectedItem();
		student.setClassID(sc.getId());
		setTable(student);
	}

	//在编辑文本框中显示出用户在学生列表中所点击的学生信息
	protected void selectedTableRow(MouseEvent e) {
		// 该方法是为了让editClassNameTextField上显示出用户在班级列表中所点击的班级名称
		DefaultTableModel dft= (DefaultTableModel)studentListTable.getModel();
		editStudentNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),1).toString());
		String className = dft.getValueAt(studentListTable.getSelectedRow(),2).toString();
		String sex = dft.getValueAt(studentListTable.getSelectedRow(),3).toString();
		editStudentPasswordtextField.setText(dft.getValueAt(studentListTable.getSelectedRow(),4).toString());
		for(int i = 0;i<editStudentClassComboBox.getItemCount();i++) {
			StudentClass  sc = (StudentClass)editStudentClassComboBox.getItemAt(i);
			if(className.equals(sc.getName())) {
				editStudentClassComboBox.setSelectedIndex(i);
			}
		}
		editSexButtonGroup.clearSelection();
		if(sex.equals(manRadioButton.getText()))manRadioButton.setSelected(true);
		if(sex.equals(girlRadioButton.getText()))girlRadioButton.setSelected(true);
		if(sex.equals(secretRadioButton.getText()))secretRadioButton.setSelected(true);
	}

	//在班级下拉列表中添加班级名称
	private void setStudentClassInfo() {
		ClassDao classDao = new ClassDao();
		classList = classDao.getClassList(new StudentClass());
		for (StudentClass sc: classList) {
			searchStudentComboBox.addItem(sc);
			editStudentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}

	//设置学生表格
	private void setTable(Student student){
		if("学生".equals(MainFrm.userType.getName())) {
			Student s = (Student)MainFrm.userObject;
			student.setName(s.getName());
			searchStudentNameTextField.setText(student.getName());
		}
		//要显示JTable组件（需要用到）TableModel接口（需要下面这个类才能实现）DefaultTableModel类
		DefaultTableModel dft =(DefaultTableModel)studentListTable.getModel();
		dft.setRowCount(0); //设置成0，把列表先清空
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.getStudentList(student);//获取学生列表
		for(Student s:studentList){
			Vector v = new Vector();
			v.add(s.getId());
			v.add(s.getName());
			v.add(getClassNameById(s.getClassID()));
			v.add(s.getSex());
			v.add(s.getPassword());
			dft.addRow(v);//将vector对象v添加到DefaultTableModel中，用addRow()方法，这是添加行数据到表格中的方法
		}
		studentDao.closeDao();
	}

	//获取班号的方法
	private String getClassNameById(int id) {
		for (StudentClass sc : classList) {
			 if(sc.getId()==id)return sc.getName();
		}
		return "";
	}

	//权限管理
	private void setAuthority() {
		if("学生".equals(MainFrm.userType.getName())) {
			Student s = (Student)MainFrm.userObject;
			searchStudentNameTextField.setEnabled(false);
			editStudentClassComboBox.setEnabled(false);
			searchStudentComboBox.setEnabled(false);
			deleteStudentButton.setEnabled(false);
		}
		
	}
}

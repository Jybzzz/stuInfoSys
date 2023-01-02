package view;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.TeacherDao;
import model.Teacher;
import util.StringUtil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageTeacherFrm extends JInternalFrame {
	private JTable teacherListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherTitleTextField;
	private JTextField editTeacherAgeTextField;
	private JPasswordField editTeacherPasswordTextField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton manRadioButton;
	private JRadioButton girlRadioButton;
	private JButton deleteTeacherButton;

	public ManageTeacherFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("教师信息管理");
		setBounds(100, 100, 590, 411);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("教师姓名：");
		lblNewLabel.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/老师.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setColumns(10);
		
		JButton searchTeacherButton = new JButton("查询");
		//创建一个教师信息管理中查询按钮的监听器
		searchTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchTeacher(e);
			}
		});
		searchTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/搜索.png")));
		searchTeacherButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6559\u5E08\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
							.addComponent(searchTeacherButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(96))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
							.addContainerGap(54, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchTeacherButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("教师姓名：");
		lblNewLabel_1.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/老师.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("教师性别：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/性别.png")));
		
		manRadioButton = new JRadioButton("男");
		manRadioButton.setSelected(true);
		
		girlRadioButton = new JRadioButton("女");
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(manRadioButton);
		sexButtonGroup.add(girlRadioButton);
		
		JLabel lblNewLabel_3 = new JLabel("教师职称：");
		lblNewLabel_3.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/职称评定.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("教师年龄：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_4.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/年龄.png")));
		
		editTeacherAgeTextField = new JTextField();
		editTeacherAgeTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("登录密码：");
		lblNewLabel_5.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/密码.png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherPasswordTextField = new JPasswordField();
		editTeacherPasswordTextField.setColumns(10);
		
		JButton editTeacherSumbitButton = new JButton("确认修改");
		//创建一个教师信息管理中确认修改按钮的监听器
		editTeacherSumbitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEditAct(e);
			}
		});
		editTeacherSumbitButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/确认.png")));
		editTeacherSumbitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		deleteTeacherButton = new JButton("删除");
		//创建一个教师信息管理中删除按钮的监听器
		deleteTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTeacher(e);
			}
		});
		deleteTeacherButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		deleteTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/删除.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(6))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(6)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(editTeacherPasswordTextField, Alignment.LEADING)
						.addComponent(editTeacherNameTextField, Alignment.LEADING)
						.addComponent(editTeacherTitleTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editTeacherSumbitButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteTeacherButton, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherAgeTextField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(manRadioButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(girlRadioButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(editTeacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(manRadioButton))
						.addComponent(girlRadioButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(editTeacherSumbitButton)
							.addComponent(deleteTeacherButton))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(editTeacherPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		teacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08\u5DE5\u53F7", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B", "\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84", "\u767B\u5F55\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(teacherListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Teacher()); 
		setAuthority();
	}

	//教师信息管理中查询按钮的监听方法
	protected void searchTeacher(ActionEvent e) {
		Teacher teacher =  new Teacher();
		teacher.setName(searchTeacherNameTextField.getText().toString());
		setTable(teacher);
	}

	//教师信息管理中删除按钮的监听方法
	protected void deleteTeacher(ActionEvent e) {
		int index = teacherListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this,"请选中要删除的内容！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定要删除吗？")!=JOptionPane.OK_OPTION) {
			return;
		}
		TeacherDao teacherDao = new TeacherDao();
		int id = Integer.parseInt((teacherListTable.getValueAt(index, 0).toString()));
		if(teacherDao.delete(id)) {
			JOptionPane.showMessageDialog(this,"删除成功！");
		}else {
			JOptionPane.showMessageDialog(this,"删除失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());
	}

	//设置教师表格
	private void setTable(Teacher teacher){
		if("老师".equals(MainFrm.userType.getName())) {
			Teacher t =(Teacher)MainFrm.userObject;
			teacher.setName(t.getName());
			searchTeacherNameTextField.setText(teacher.getName());
		}
		DefaultTableModel dft =(DefaultTableModel) teacherListTable.getModel();
		dft.setRowCount(0); //设置成0，把列表先清空
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teacherList = teacherDao.getTeacherList(teacher);
		for(Teacher t :teacherList){
			Vector v = new Vector();
			v.add(t.getJobNumber());
			v.add(t.getName());
			v.add(t.getSex());
			v.add(t.getTitle());
			v.add(t.getAge());
			v.add(t.getPassword());
			dft.addRow(v);
		}
		teacherDao.closeDao();
	}

	//在编辑文本框中显示出用户在教师列表中所点击的教师信息
	protected void selectedTableRow(MouseEvent e) {
		// 该方法是为了让editText上显示出用户在列表中所点击的信息
		DefaultTableModel dft= (DefaultTableModel)teacherListTable.getModel();
		editTeacherNameTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(),1).toString());
		String sex = dft.getValueAt(teacherListTable.getSelectedRow(),2).toString();
		editTeacherTitleTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(),3).toString());
		editTeacherAgeTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(),4).toString());
		editTeacherPasswordTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(),5).toString());
		sexButtonGroup.clearSelection();
		if(sex.equals(manRadioButton.getText()))manRadioButton.setSelected(true);
		if(sex.equals(girlRadioButton.getText()))girlRadioButton.setSelected(true);
	}

	//教师信息管理中确认修改按钮的监听方法
	protected void submitEditAct(ActionEvent e) {
		int index = teacherListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this,"请选中要修改的内容！");
			return;
		}
		String Name = editTeacherNameTextField.getText().toString();
		String sex=manRadioButton.isSelected()?manRadioButton.getText().toString():girlRadioButton.getText().toString();
		String title = editTeacherTitleTextField.getText().toString();
		int age =0;
		try {
			age = Integer.parseInt(editTeacherAgeTextField.getText().toString());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}
		String password = editTeacherPasswordTextField.getText().toString();
		
		if(StringUtil.isEmpty(Name)) {
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if(StringUtil.isEmpty(title)) {
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "教师密码必须填写！");
			return;
		}
	
		Teacher teacher =  new Teacher();
		teacher.setName(Name);
		if(manRadioButton.isSelected())teacher.setSex(manRadioButton.getText().toString());
		if(girlRadioButton.isSelected())teacher.setSex(girlRadioButton.getText().toString());
		teacher.setJobNumber(Integer.parseInt(teacherListTable.getValueAt(index,0).toString()));
		teacher.setName(Name);
		teacher.setSex(sex);
		teacher.setTitle(title);
		teacher.setAge(age);
		teacher.setPassword(password);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.update(teacher)) {
			JOptionPane.showMessageDialog(this,"修改成功！");
		}else {
			JOptionPane.showMessageDialog(this,"修改失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());	
	}

	//权限管理
	private void setAuthority() {
		if("老师".equals(MainFrm.userType.getName())) {
			deleteTeacherButton.setEnabled(false);
			searchTeacherNameTextField.setEnabled(false);
		}
	}
}

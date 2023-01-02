package view;

import dao.ClassDao;
import model.StudentClass;
import util.StringUtil;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageClassFrm extends JInternalFrame {
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;

	public ManageClassFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("班级信息管理");
		setBounds(100, 100, 670, 400);
		
		JLabel classNameLabel = new JLabel("班级名称：");
		classNameLabel.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/班级名称.png")));
		classNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("查询");
		//创建一个班级信息管理中查询按钮的监听器
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAwt(e);
			}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		searchButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/搜索.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("班级名称：");
		lblNewLabel.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/班级名称.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("班级信息：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/班级介绍.png")));
		
		editClassInfoTextArea = new JTextArea();
		
		JButton sumbitEditButton = new JButton("确认修改");
		//创建一个班级信息管理中确认修改按钮的监听器
		sumbitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumbitEditAct(e);
			}
		});
		sumbitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sumbitEditButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/确认.png")));
		
		JButton DeleteButton = new JButton("删除");
		//创建一个班级信息管理中删除按钮的监听器
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteClassAct(e);
			}
		});
		DeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		DeleteButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/删除.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addComponent(classNameLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(DeleteButton, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
								.addComponent(sumbitEditButton, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 609, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchButton)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(classNameLabel))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(sumbitEditButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(DeleteButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))))
					.addGap(97))
		);

		classListTable = new JTable();
		//给班级列表添加一个鼠标监听器
		classListTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});

		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F\u4ECB\u7ECD"
			}
		));
		classListTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		classListTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(175);

		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new StudentClass());
	}

	//班级管理中查询按钮的事件监听方法
	protected void searchAwt(ActionEvent e){
		StudentClass sc = new StudentClass();//创建一个班级对象
		sc.setName(searchClassNameTextField.getText().toString());//获取用户输入的班级名称
		setTable(sc);
	}

	//班级管理中删除按钮的事件监听方法
	protected void deleteClassAct(ActionEvent e) {
		int index = classListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this,"请选中要删除的内容！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定要删除该班级的所有信息吗？")!=JOptionPane.OK_OPTION) {
			return;
		}
		ClassDao classDao = new ClassDao();
		DefaultTableModel dft= (DefaultTableModel)classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(),0).toString());
		if(classDao.delete(id)) {
			JOptionPane.showMessageDialog(this,"删除成功！");
		}else {
			JOptionPane.showMessageDialog(this,"删除失败！");
		}
		classDao.closeDao();
		setTable(new StudentClass());
	}

	//班级管理中确认修改按钮的事件监听方法
	protected void sumbitEditAct(ActionEvent e) {
		// 确认修改的对应的方法
		int index = classListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this,"请选中要删除的内容！");
			return;
		}
		ClassDao classDao = new ClassDao();
		DefaultTableModel dft= (DefaultTableModel)classListTable.getModel();
		String className=dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo=dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName=editClassNameTextField.getText().toString();
		String editClassInfo=editClassInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editClassName)) {
			JOptionPane.showMessageDialog(this,"请填写要修改的班级名称！");
			return;
		}
		if(className.equals(editClassName)&&classInfo.equals(editClassInfoTextArea)) {
			JOptionPane.showMessageDialog(this,"您还没有做任何修改！");
			return; 
		}
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(),0).toString());
		StudentClass sc = new StudentClass();
		sc.setId(id);
		sc.setName(editClassName);
		sc.setInfo(editClassInfo);
		if(classDao.update(sc)) {
			JOptionPane.showMessageDialog(this,"更新成功！");
		}else { 
			JOptionPane.showMessageDialog(this,"更新失败！");
		}
		classDao.closeDao();
		setTable(new StudentClass());
		
	}

	//设置班级表格
	private void setTable(StudentClass studentClass){
		DefaultTableModel dft =(DefaultTableModel) classListTable.getModel();
		dft.setRowCount(0); //设置成0，把列表先清空
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(studentClass);
		for(StudentClass sc:classList){
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);
		}
		classDao.closeDao();
	}

	//在编辑文本框中显示出用户在班级列表中所点击的班级信息
	protected void selectedTableRow(MouseEvent e) {
		DefaultTableModel dft= (DefaultTableModel)classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(),1).toString());
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(),2).toString());
	}
}

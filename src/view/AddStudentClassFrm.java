package view;

import javax.swing.JInternalFrame;
import util.StringUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import dao.ClassDao;
import model.StudentClass;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentClassFrm extends JInternalFrame {
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea;

	public AddStudentClassFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("添加班级信息");
		setBounds(100, 100, 450, 300);
		
		JLabel classNameLabel = new JLabel("班级名称：");
		classNameLabel.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/班级名称.png")));
		classNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);
		
		JLabel classInfoLabel = new JLabel("班级信息：");
		classInfoLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		classInfoLabel.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/班级介绍.png")));
		
		classInfoTextArea = new JTextArea();
		
		JButton submitButton = new JButton("提交");
		//创建一个添加班级提交按钮的监听器
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitClass(e);
			}
		});
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		submitButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/确认.png")));
		
		JButton restButton = new JButton("重置");
		//创建一个添加班级重置按钮的监听器
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		restButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		restButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/重置.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(classNameLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(restButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(classInfoLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(classNameLabel))
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(classInfoLabel))
						.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(restButton)))
		);
		getContentPane().setLayout(groupLayout);

	}

	//添加班级提交按钮的监听方法
	protected void submitClass(ActionEvent e) {
		String className = classNameTextField.getText().toString();
		String classInfo = classInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(className)) {
			JOptionPane.showMessageDialog(this, "班级名称不能为空！");
			return;
		}
		StudentClass sc1 = new StudentClass();
		sc1.setName(className);
		sc1.setInfo(classInfo);
		ClassDao classDao = new ClassDao();
		if(classDao.addClass(sc1)) {
			JOptionPane.showMessageDialog(this, "班级添加成功！");
		}else {
			JOptionPane.showMessageDialog(this, "班级添加失败");
		}
		classDao.closeDao();
		resetValue(e);
	}

	//添加班级重置按钮的监听方法
	protected void resetValue(ActionEvent e) {
		classNameTextField.setText("");
		classInfoTextArea.setText("");
	}
}

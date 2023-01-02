package dao;

import model.Student;
import util.StringUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends BaseDao{
	//定义一个学生登入的方法login()
	public Student login(Student student){
        String sql ="select * from s_student where name=? and password=?";
        Student studentRst = null;
        try{
            //创建一个PreparedStatement对象prst，再通过Connection对象con的prepareStatement(String sql)方法获取sql语句
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1,student.getName());
            prst.setString(2,student.getPassword());
            ResultSet excuteQuery = prst.executeQuery();
            if(excuteQuery.next()){
                //获取该对象在数据库中所对应的字段赋给对应的属性
            	studentRst =  new Student();
            	studentRst.setId(excuteQuery.getInt("studentId"));
            	studentRst.setClassID(excuteQuery.getInt("classId"));
            	studentRst.setName(excuteQuery.getString("name"));
            	studentRst.setPassword(excuteQuery.getString("password"));
            	studentRst.setSex(excuteQuery.getString("sex"));
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentRst;
    }

	//定义一个添加学生的方法addStudent()
    public boolean addStudent(Student student) {
        String sql ="insert into s_student values(null,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getClassID());
            preparedStatement.setString(3,student.getPassword());
            preparedStatement.setString(4,student.getSex());
            if(preparedStatement.executeUpdate()>0)return true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	//定义一个修删除学生的方法delete()
	public boolean delete(int id) {
		String sql = "delete from s_student where studentId= ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//定义一个查询学生的方法getStudentList()
	public List<Student> getStudentList(Student student){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from s_student");
		if(!StringUtil.isEmpty(student.getName())){
			sqlString.append(" and name like '%"+student.getName()+"%'");
		}
		if(student.getClassID()!=0) {
			sqlString.append(" and classId ="+student.getClassID());
		}
		try {
 			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()){
				Student s = new Student();
				s.setId(executeQuery.getInt("studentId"));
				s.setName(executeQuery.getString("name"));
				s.setClassID(executeQuery.getInt("classId"));
				s.setSex(executeQuery.getString("sex"));
				s.setPassword(executeQuery.getString("password"));
				retList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}

	//定义一个修改学生的方法update()
	public boolean update(Student student) {
		 String sql = "update s_student set name=?,classId =?,sex=?,password=?where studentId= ?";
		 try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getClassID());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4,student.getPassword());
			preparedStatement.setInt(5, student.getId());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//定义一个学生修改密码的方法editPassword()
    public String editPassword(Student student,String newPassword) {
    	String sql = "select * from s_student where studentId=? and password=?";
    	PreparedStatement prst=null;
    	int id =0;
    	try {
    		prst=con.prepareStatement(sql);
    		prst.setInt(1,student.getId());
    		prst.setString(2,student.getPassword());
    		ResultSet excuteQuery = prst.executeQuery();
    		if(!excuteQuery.next()) {
    			String resString = "原密码错误！";
    			return resString;
    		}
    		id=excuteQuery.getInt("studentId");
    	} catch(SQLException el) {
    		el.printStackTrace();
    	}
    	String retString = "修改失败";
    	String sqlString = "update s_student set password = ? where studentId = ?";
        try {
        	prst = con.prepareStatement(sqlString);
			prst.setString(1,newPassword);
	        prst.setInt(2,id);
	        int rst=prst.executeUpdate();
	        if(rst>0) {
	        	retString="密码修改成功！";
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return retString;
    }
}

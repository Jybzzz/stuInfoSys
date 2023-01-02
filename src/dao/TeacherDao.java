package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Teacher;
import util.StringUtil;

public class TeacherDao extends BaseDao{
	//定义一个老师登入的方法login()
    public Teacher login(Teacher teacher){
        String sql ="select * from s_teacher where name=? and password=?";
        Teacher teacherRst = null;
        try{
            //创建一个PreparedStatement对象prst，再通过Connection对象con的prepareStatement(String sql)方法获取sql语句
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1,teacher.getName());
            prst.setString(2,teacher.getPassword());
            ResultSet excuteQuery = prst.executeQuery();
            if(excuteQuery.next()){
                //获取该对象在数据库中所对应的字段赋给对应的属性
            	teacherRst =  new Teacher();
            	teacherRst.setJobNumber(excuteQuery.getInt("teacherId"));
            	teacherRst.setName(excuteQuery.getString("name"));
               	teacherRst.setSex(excuteQuery.getString("sex"));
               	teacherRst.setTitle(excuteQuery.getString("title"));
                teacherRst.setAge(excuteQuery.getInt("age"));
            	teacherRst.setPassword(excuteQuery.getString("password"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } 
        return teacherRst;
    }

	//定义一个添加教师的方法addTeacher()
    public boolean addTeahcer(Teacher teacher) {
        String sql ="insert into s_teacher values(null,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,teacher.getName());
            preparedStatement.setString(2,teacher.getSex());
            preparedStatement.setString(3,teacher.getTitle());
            preparedStatement.setInt(4,teacher.getAge());
            preparedStatement.setString(5, teacher.getPassword());
            if(preparedStatement.executeUpdate()>0)return true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	//定义一个删除教师的方法delete()
	public boolean delete(int id) {
		String sql = "delete from s_teacher where teacherId = ?";
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

	//定义一个查询教师的方法getTeacherList()
	public List<Teacher> getTeacherList(Teacher teacher) {
		List<Teacher> retList = new ArrayList<Teacher>();
		StringBuffer sqlString = new StringBuffer("select * from s_teacher");
		if(!StringUtil.isEmpty(teacher.getName())){
			sqlString.append(" where name like '%"+teacher.getName()+"%'");
		}
		try {
 			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()){
				Teacher t = new Teacher();
				t.setJobNumber(executeQuery.getInt("teacherId"));
				t.setName(executeQuery.getString("name"));
				t.setSex(executeQuery.getString("sex"));
				t.setTitle(executeQuery.getString("title"));
				t.setAge(executeQuery.getInt("age"));
				t.setPassword(executeQuery.getString("password"));
				retList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}

	//定义一个修改教师的方法update()
	public boolean update(Teacher teacher) {
		 String sql = "update s_teacher set name=?,sex=?,title=?,age=?, password=?where teacherId = ?";
		 try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getSex());
			preparedStatement.setString(3, teacher.getTitle());
			preparedStatement.setInt(4, teacher.getAge());
			preparedStatement.setString(5,teacher.getPassword());
			preparedStatement.setInt(6, teacher.getJobNumber());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//定义一个教师修改密码的方法editPassword()
    public String editPassword(Teacher teacher,String newPassword) {
    	String sql = "select * from s_teacher where teacherId=? and password=?";
    	PreparedStatement prst=null;
    	int jobNumber =0;
    	try {
    		prst=con.prepareStatement(sql);
    		prst.setInt(1,teacher.getJobNumber());
    		prst.setString(2,teacher.getPassword());
    		ResultSet excuteQuery = prst.executeQuery();
    		if(!excuteQuery.next()) {
    			String resString = "原密码错误！";
    			return resString;
    		}
    		jobNumber=excuteQuery.getInt("teacherId");
    	} catch(SQLException el) {
    		el.printStackTrace();
    	}
    	String retString = "修改失败";
    	String sqlString = "update s_teacher set password = ? where teacherId = ?";
        try {
        	prst = con.prepareStatement(sqlString);
			prst.setString(1,newPassword);
	        prst.setInt(2,jobNumber);
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

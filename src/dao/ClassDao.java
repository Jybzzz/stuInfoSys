package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.StudentClass;
import util.StringUtil;

public class ClassDao extends BaseDao{

	//定义一个添加班级的方法addClass()
	public boolean addClass(StudentClass sc1) {
		String sql ="insert into s_class values(null,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,sc1.getName());
			preparedStatement.setString(2,sc1.getInfo());
			if(preparedStatement.executeUpdate()>0)return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//定义一个删除班级的方法delete()
	public boolean delete(int id) {
		String sql = "delete from s_class where classId = ?";
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

	//定义一个查询班级的方法getClassList()
	public List<StudentClass> getClassList(StudentClass studentClass){
		List<StudentClass> retList = new ArrayList<StudentClass>();
		String sqlString = "select * from s_class";
		if(!StringUtil.isEmpty(studentClass.getName())){
			sqlString+=" where name like '%"+studentClass.getName()+"%'";
		}
		try {
 			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()){
				StudentClass sc = new StudentClass();
				sc.setId(executeQuery.getInt("classId"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}


	//定义一个修改班级的方法update()
	public boolean update(StudentClass sc) {
		 String sql = "update s_class set name = ?,info =? where classId = ?";
		 try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			preparedStatement.setInt(3, sc.getId());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

package dao;

import model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admindao extends BaseDao{
    //定义一个管理员登入的方法login()
    public Admin login(Admin admin){
        String sql ="select * from s_admin where name=? and password=?";//定义要执行sql语句
        Admin adminRst = null;
        try{
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1,admin.getName());
            prst.setString(2,admin.getPassword());
            ResultSet excuteQuery = prst.executeQuery();
            if(excuteQuery.next()){
                //获取该对象在数据库中所对应的字段赋给对应的属性
                adminRst =  new Admin();
                adminRst.setId(excuteQuery.getInt("id"));
                adminRst.setName(excuteQuery.getString("name"));
                adminRst.setPassword(excuteQuery.getString("password"));
                adminRst.setCreateDate(excuteQuery.getString("createDate"));
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return adminRst;
    }

    //创建一个管理员修改密码的方法editPassword()
    public String editPassword(Admin admin,String newPassword) {
    	String sql = "select * from s_admin where id=? and password=?";
    	PreparedStatement prst=null;
    	int id =0;
    	try {
    		prst=con.prepareStatement(sql);
    		prst.setInt(1,admin.getId());
    		prst.setString(2,admin.getPassword());
    		ResultSet excuteQuery = prst.executeQuery();
    		if(!excuteQuery.next()) {
    			String resString = "原密码错误！";
    			return resString;
    		}
    		id=excuteQuery.getInt("id");
    	} catch(SQLException el) {
    		el.printStackTrace();
    	}
    	
    	String retString = "修改失败";
    	String sqlString = "update s_admin set password = ? where id = ?";
        try {
        	prst = con.prepareStatement(sqlString);
			prst.setString(1,newPassword);
	        prst.setInt(2,id);
	        int rst=prst.executeUpdate();
	        if(rst>0) {
	        	retString="密码修改成功！";
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return retString;
    }
}

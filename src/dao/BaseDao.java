package dao;

import util.Dbutil;

import java.sql.Connection;
import java.sql.SQLException;

//该类用于创建对数据库链接的对象con，整个项目与数据库打交道都用这个对象
public class BaseDao {
    public Connection con = new Dbutil().getCon();

    //设置一个关闭数据库连接的方法closeDao,释放资源.
    public void closeDao(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package springjdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jinpanpan on 2018/5/12.
 */
public class JdbcTemplateTest {

    /*private  JdbcTemplate jdbcTemplate;

   // 获取数据库的连接
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public void save(Person person){
        jdbcTemplate.
    }

    //使用 xml配置数据库的数据源，
 */



}



// 应用层 直连数据库 不需要 数据库连接池
class Jdbc{
    private static int insert(Person person) {
        Connection conn = JDBCUtils.getConn();
        int i = 0;
        String sql = "insert into person (Name,Age) values(?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getAge());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}



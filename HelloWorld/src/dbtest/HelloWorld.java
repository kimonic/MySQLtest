package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * lib文件夹中的mysql-connect-java-8.0.11.jar需要添加到
 * 菜单项中  Project --> Properties-->Java Build Path-->Libraries中
 * 通过Add Jars添加
 * 否则无法引用到
 * @author Administrator
 *
 */
public class HelloWorld {
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "dingzhixin";
    
	public static void main(String[] args) {
		Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("111111...");
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql,sq2;
            sql = "SELECT Token, username, password FROM users";
            
            sq2="select userbookmark.Type, users.nickname from userbookmark  \r\n" + 
            		"inner join  users " + 
            		"on userbookmark.Token = users.Token;";
            
            ResultSet rs = stmt.executeQuery(sq2);
            /**
             * 
select member.`name`,
       info.`realname`,
       member.`phone`,
       recover.`amount`,
  	   LEFT(FROM_UNIXTIME(recover.`recover_time`), 10) time
  FROM `shcf_hf_finance`.`fn_tender_recover` recover
  LEFT JOIN `shcf_hf_member`.`mb_member` member on 
  member.`id`= recover.`tender_member_id`
  LEFT JOIN `shcf_hf_member`.`mb_member_info` info on 
  info.`member_id`= member.`id`
 WHERE recover.`recover_time` BETWEEN 1525104000
   and 1527782399
 ORDER BY recover.`recover_time` asc,info.`realname` asc

             */
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
//                int id  = rs.getInt("Token");
//                String name = rs.getString("UserName");
//                String url = rs.getString("PassWord");
                String type=rs.getString("type");
                String nickname=rs.getString("nickname");
                
                // 输出数据
                System.out.print("type: " + type);
                System.out.print(",nickname: " + nickname);
                
//                System.out.print("Token: " + id);
//                System.out.print(",UsersName: " + name);
//                System.out.print(", PassWord: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
		
	}

}





























































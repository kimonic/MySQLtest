package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * lib�ļ����е�mysql-connect-java-8.0.11.jar��Ҫ��ӵ�
 * �˵�����  Project --> Properties-->Java Build Path-->Libraries��
 * ͨ��Add Jars���
 * �����޷����õ�
 * @author Administrator
 *
 */
public class HelloWorld {
	// JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "dingzhixin";
    
	public static void main(String[] args) {
		Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("111111...");
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
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
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
//                int id  = rs.getInt("Token");
//                String name = rs.getString("UserName");
//                String url = rs.getString("PassWord");
                String type=rs.getString("type");
                String nickname=rs.getString("nickname");
                
                // �������
                System.out.print("type: " + type);
                System.out.print(",nickname: " + nickname);
                
//                System.out.print("Token: " + id);
//                System.out.print(",UsersName: " + name);
//                System.out.print(", PassWord: " + url);
                System.out.print("\n");
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
		
	}

}





























































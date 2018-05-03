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
            String sql;
            sql = "SELECT id, usersname, password FROM users";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("usersname");
                String url = rs.getString("password");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", վ������: " + name);
                System.out.print(", վ�� password: " + url);
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





























































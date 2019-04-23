import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertOrderAddr {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logistics?useUnicode=true&characterEncoding=UTF-8&useSSL=true","root","19980114");
            for(int i = 0;i<100;i++){
                String number = i+"";
                String sql = "INSERT INTO order_addr(order_number) VALUES(?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setObject(1,number);
                ps.executeUpdate();
                ps.close();
            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


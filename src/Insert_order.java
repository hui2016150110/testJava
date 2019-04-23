import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Insert_order {
    public static void main(String[] args){
        try {


        Random random = new Random();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logistics?useUnicode=true&characterEncoding=UTF-8&useSSL=true","root","19980114");
        for(int i = 0;i<100;i++){
            int x = random.nextInt(85);
            String number = i+"";
            String sql = "INSERT INTO order_good(ORDER_NUMBER,account_id) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,number);
            ps.setObject(2,x);
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


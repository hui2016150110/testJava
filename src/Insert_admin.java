import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_admin {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logistics?useUnicode=true&characterEncoding=UTF-8&useSSL=true","root","19980114");

            String sql = "INSERT INTO admin(id,name,password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,0);

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

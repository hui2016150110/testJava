import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateAddrInfo {
    public static void main(String[] args){
        String number = null;
        String new_addr = "广州市天河区";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        number = "1";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://139.199.185.16:3306/logistics?useUnicode=true&characterEncoding=UTF-8&useSSL=true","root","19980114");
            String sql = "SELECT address_info,dest_addr FROM order_address WHERE order_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,number);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String info = rs.getString("address_info");
                String dest_addr = rs.getString("dest_addr");
                System.out.println(info);
                System.out.println(dest_addr);
                Date date = new Date();
                String time = df.format(date);
                String lastest_addr = info+time+" "+new_addr+";";
                sql = " UPDATE order_address set address_info = ? WHERE order_number = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,lastest_addr);
                ps.setString(2,number);
                int i = ps.executeUpdate();
                if(i!=0){
                    sql = " UPDATE transfer_order_number set transfer_name = ? WHERE order_number = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,new_addr);
                    ps.setString(2,number);
                    ps.executeUpdate();
                }
            }
            else{

            }
            ps.close();

            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

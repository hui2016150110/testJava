import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin_check extends HttpServlet{

    public admin_check(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset = UTF-8");
        ServletContext application = this.getServletContext();
        String user = application.getInitParameter("username");//数据库管理员
        String user_password = application.getInitParameter("password");//密码
        String driverClassName = application.getInitParameter("driverClassName");//驱动
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset = UTF-8");
        String admin = req.getParameter("name");
        String check = req.getParameter("check");
        PrintWriter out = resp.getWriter();
        try {
            Class.forName(driverClassName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logistics?useUnicode=true&characterEncoding=UTF-8",
                    user,user_password);
            String sql = "SELECT name,password FROM admin WHERE name = ? And password = password(?)";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1,admin);
            ps.setString(2,check);
            ResultSet rs = ps.executeQuery();
            out.write(admin+check);
            //用户密码正确
             HashMap<String,Object> hashMap = new HashMap<>();
            if(rs.next()){
                resp.sendRedirect("http://www.sf-express.com/CN/ZH/");
            }
            //用户密码错误
            else {
                hashMap.put("error","错误");

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

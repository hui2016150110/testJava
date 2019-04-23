import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InsertAddrInfo {
    public static void main(String[] args){
        String[] cities = {
                "广州市天河区",
                "广州市海珠区",
                "广州市荔湾区",
                "广州市越秀区",
                "广州市番禺区",
                "广州市花都区",
                "广州市白云区",
                "广州市南沙区",
                "广州市黄埔区",
                "广州市增城区",
                "广州市从化区",
                "广州市广州大学城",
                "深圳市南山区",
                "深圳市罗湖区",
                "深圳市福田区",
                "深圳市宝安区",
                "深圳市光明新区",
                "深圳市坪山新区",
                "深圳市大鹏新区",
                "深圳市龙岗区",
                "深圳市盐田区",
                "深圳市龙华区",
                "珠海市斗门区",
                "珠海市金湾区",
                "珠海市香洲区",
                "汕头市南澳县",
                "汕头市龙湖区",
                "汕头市金平区",
                "汕头市澄海区",
                "汕头市潮阳区",
                "汕头市潮南区",
                "汕头市濠江区",
                "韶关市南雄市",
                "韶关市乐昌市",
                "韶关市仁化县",
                "韶关市始兴县",
                "韶关市翁源县",
                "韶关市新丰县",
                "韶关市乳源瑶族自治县",
                "韶关市曲江区",
                "韶关市武江区",
                "韶关市浈江区",
                "河源市和平县",
                "河源市龙川县",
                "河源市紫金县",
                "河源市连平县",
                "河源市源城区",
                "河源市东源县",
                "梅州市兴宁市",
                "梅州市梅县区",
                "梅州市蕉岭县",
                "梅州市大埔县",
                "梅州市丰顺县",
                "梅州市五华县",
                "梅州市平远县",
                "梅州市梅江区",
                "惠州市龙门县",
                "惠州市惠阳区",
                "惠州市大亚湾区",
                "惠州市惠城区",
                "惠州市惠东县",
                "惠州市博罗县",
                "汕尾市陆河县",
                "汕尾市海丰县",
                "汕尾市城区",
                "汕尾市陆丰市",
                "东莞市中堂镇",
                "东莞市东坑镇",
                "东莞市道滘镇",
                "东莞市沙田镇",
                "东莞市高埗镇",
                "东莞市石龙镇",
                "东莞市石排镇",
                "东莞市企石镇",
                "东莞市石碣镇",
                "东莞市洪梅镇",
                "东莞市麻涌镇",
                "东莞市桥头镇",
                "东莞市望牛墩镇",
                "东莞市茶山镇",
                "东莞市谢岗镇",
                "东莞市松山湖",
                "东莞市莞城区",
                "东莞市南城区",
                "东莞市长安镇",
                "东莞市寮步镇",
                "东莞市大岭山镇",
                "东莞市常平镇",
                "东莞市厚街镇",
                "东莞市万江区",
                "东莞市樟木头镇",
                "东莞市大朗镇",
                "东莞市塘厦镇",
                "东莞市凤岗镇",
                "东莞市清溪镇",
                "东莞市横沥镇",
                "东莞市东城区",
                "东莞市黄江镇",
                "东莞市虎门镇",
                "中山市南朗镇",
                "中山市小榄镇",
                "中山市古镇",
                "中山市坦洲镇",
                "中山市黄圃镇",
                "中山市三乡镇",
                "中山市东凤镇",
                "中山市横栏镇",
                "中山市三角镇",
                "中山市南头镇",
                "中山市沙溪镇",
                "中山市五桂山镇",
                "中山市阜沙镇",
                "中山市东升镇",
                "中山市板芙镇",
                "中山市神湾镇",
                "中山市港口镇",
                "中山市大涌镇",
                "中山市火炬开发区",
                "中山市民众镇",
                "中山市沙朗镇",
                "中山市城区",
                "江门市台山市",
                "江门市新会区",
                "江门市鹤山市",
                "江门市江海区",
                "江门市蓬江区",
                "江门市开平市",
                "江门市恩平市",
                "佛山市顺德区",
                "佛山市禅城区",
                "佛山市高明区",
                "佛山市三水区",
                "佛山市南海区",
                "阳江市阳春市",
                "阳江市阳西县",
                "阳江市江城区",
                "阳江市阳东区",
                "湛江市雷州市",
                "湛江市吴川市",
                "湛江市徐闻县",
                "湛江市坡头区",
                "湛江市赤坎区",
                "湛江市霞山区",
                "湛江市经济技术开发区",
                "湛江市麻章区",
                "湛江市遂溪县",
                "湛江市廉江市",
                "茂名市信宜市",
                "茂名市茂南区",
                "茂名市电白区",
                "茂名市高州市",
                "茂名市化州市",
                "肇庆市广宁县",
                "肇庆市德庆县",
                "肇庆市怀集县",
                "肇庆市封开县",
                "肇庆市鼎湖区",
                "肇庆市端州区",
                "肇庆市四会市",
                "肇庆市高要区",
                "云浮市云安区",
                "云浮市新兴县",
                "云浮市郁南县",
                "云浮市云城区",
                "云浮市罗定市",
                "清远市连州市",
                "清远市佛冈县",
                "清远市阳山县",
                "清远市清新区",
                "清远市连山壮族瑶族自治县",
                "清远市连南瑶族自治县",
                "清远市清城区",
                "清远市英德市",
                "潮州市饶平县",
                "潮州市枫溪区",
                "潮州市湘桥区",
                "潮州市潮安区",
                "揭阳市揭西县",
                "揭阳市惠来县",
                "揭阳市东山区",
                "揭阳市普宁市",
                "揭阳市榕城区",
                "揭阳市揭东区"
        };

        try {
            Random random = new Random();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://139.199.185.16:3306/logistics?useUnicode=true&characterEncoding=UTF-8&useSSL=true","root","19980114");
            for(int i = 0;i<183;i++){
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = dateFormat.format(date);

                String sql = "UPDATE order_address set address_info = ? where address_info = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setObject(1,time+" "+cities[i]+";");
                ps.setObject(2,cities[i]+";");
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
     private static void update_transfer_order(String city,String order_number){
         try {
             Random random = new Random();
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logistics?useUnicode=true&characterEncoding=UTF-8&useSSL=true","root","19980114");
             String sql = "INSERT INTO transfer_order_number(order_number,transfer_name) values(?,?)";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setObject(1,order_number);
             ps.setObject(2,city);
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

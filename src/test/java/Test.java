import Utils.UtilsForJDBC;
import cn.hutool.db.Db;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * @author Chaos_Coke
 * @create 2020-07-18 16:19:43
 */
public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Properties properties=new Properties();
        InputStream ips = Test.class.getClassLoader().getResourceAsStream("druid.properties");
        //properties.load(Test.class.getClassLoader().getResourceAsStream("druid.properties"));
        properties.load(ips);
        DataSource ds=DruidDataSourceFactory.createDataSource(properties);
        System.out.println(ds.getConnection());
    }
    @org.junit.Test
    public void test01() throws SQLException {

            System.out.println(Db.use().getConnection());
    }

    @org.junit.Test
    public void test02(){
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        final Date date = new Date();
        String s=sdf.format(date);
        System.out.println(s);
        System.out.println(date);
    }

    @org.junit.Test
    public void test03(){
        final Calendar instance = Calendar.getInstance();
        System.out.println(instance);
    }
}

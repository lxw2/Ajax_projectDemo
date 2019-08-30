package JDBCutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import userinfo.userInfo;

import javax.sql.DataSource;
import javax.xml.transform.Templates;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class jdbcutils {
     static DataSource ds;
    static {
        //创建一个空properties集合
        Properties pro = new Properties();
        InputStream resourceAsStream = jdbcutils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(resourceAsStream);
            //将配置文件集合添加到工厂
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void me()
    {
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select * from userinfo where name = ?";
//        List<Map<String,Object>> list = template.queryForList(sql);

//        for (Map<String,Object> stringmap : list)
//        {
//            System.out.println(stringmap);
//        }
        userInfo userInfo = template.queryForObject(sql, new BeanPropertyRowMapper<>(userInfo.class),"宁玲珑");
        System.out.println(userInfo);
    }
    public static Connection getcon()
    {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DataSource getdatasoure()
    {
        return ds;
    }

    public static  userInfo getUserinfo(String username)
    {
        System.out.println(123);
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "select * from userinfo where name = ?";
        userInfo userInfo = template.queryForObject(sql, new BeanPropertyRowMapper<>(userInfo.class), username);
        return userInfo;
    }



}

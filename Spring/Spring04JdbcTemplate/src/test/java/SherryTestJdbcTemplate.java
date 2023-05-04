import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName:SherryTestJdbcTemplate
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 11:12
 **/
public class SherryTestJdbcTemplate {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void text(){
        //创建容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext(
                "SpringJdbcTemplate.xml");
        //获取JdbcTemplate对象
        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println("jdbcTemplate = " + jdbcTemplate);
        System.out.println(jdbcTemplate);
        //直接向数据库中表
//        String sql="insert into grade(name) value(?)";
//        jdbcTemplate.update(sql,"四年级");
        String sql1="delete from grade where id=?";
        jdbcTemplate.update(sql1,3);
    }

}

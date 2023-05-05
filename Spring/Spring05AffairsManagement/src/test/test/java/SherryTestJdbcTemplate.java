import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

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
////        直接向数据库中表插入数据
//        String sql="insert into sherry.study.JdbcTemplate.dao.pojo.grade(name) value(?)";
//        int result = jdbcTemplate.update(sql, "四年级");

//        //删除
//        String sql1="delete from sherry.study.JdbcTemplate.dao.pojo.grade where id=?";
//        jdbcTemplate.update(sql1,5);

////        改->将名字为四年级的id改为4
//        String sql2="update  sherry.study.JdbcTemplate.dao.pojo.grade set id=? where name=?";
//        int result1 = jdbcTemplate.update(sql2, 4,"四年级");

////        批量增
//        String sql3="insert into sherry.study.JdbcTemplate.dao.pojo.grade(id,name) values(?,?)";
//        List<Object[]> gradeList = new ArrayList<>();
//
//        gradeList.add(new Object[]{5,"五年级"});
//        gradeList.add(new Object[]{6,"六年级"});
//        gradeList.add(new Object[]{7,"七年级"});
//        gradeList.add(new Object[]{8,"八年级"});
//        jdbcTemplate.batchUpdate(sql3,gradeList);
        //查询单个对象
        /**
         * @Description 在jdbcTemplate查询单个对象中, 不能直接使用指定多个列名的形式,*为0也不行,1个列也不行
         *          * <br>必须通过创建RowMapper映射将ResultSet 中的数据映射到 Java 对象 sherry.study.JdbcTemplate.dao.pojo.Employee 中。
         * @Date  2023/5/4 
         * @Param []
         * @return void
         * @Author SHERRY
         * @Version 1.0
         **/
       // String sqlOneObject="select id,last_name,gender,email,salary,dept_id from employee
        // where " +"id=?";
//        String sqlOneObject="select * from employee where id=?";
//        RowMapper<sherry.study.JdbcTemplate.dao.pojo.Employee> rowMapper =new BeanPropertyRowMapper<>(sherry.study.JdbcTemplate.dao.pojo.Employee.class);
//        sherry.study.JdbcTemplate.dao.pojo.Employee employee=jdbcTemplate.queryForObject(sqlOneObject,rowMapper,1);
//        System.out.println("employee = " + employee);

        //查询多个对象
//        String sqlOneObject="select id,last_name,gender,email,salary,dept_id from employee";
//        RowMapper<sherry.study.JdbcTemplate.dao.pojo.Employee> rowMapper =new BeanPropertyRowMapper<>(sherry.study.JdbcTemplate.dao.pojo.Employee.class);
//        List<sherry.study.JdbcTemplate.dao.pojo.Employee> employee=jdbcTemplate.query(sqlOneObject,rowMapper);
//        for (sherry.study.JdbcTemplate.dao.pojo.Employee employee1 : employee) {
//            System.out.println(employee1);
//        }
    }

}

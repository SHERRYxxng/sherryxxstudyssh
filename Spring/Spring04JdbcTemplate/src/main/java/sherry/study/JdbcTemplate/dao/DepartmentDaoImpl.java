package sherry.study.JdbcTemplate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sherry.study.JdbcTemplate.pojo.Department;

import java.util.List;

/**
 * @ClassName:DepartmentImpl
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 19:10
 **/
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Department> selectAllDepts() {
        String sql="select id,name from department";
        RowMapper<Department> rowMapper=new BeanPropertyRowMapper<>(Department.class);
        List<Department> list =jdbcTemplate.query(sql,rowMapper);
        return list;
    }
}

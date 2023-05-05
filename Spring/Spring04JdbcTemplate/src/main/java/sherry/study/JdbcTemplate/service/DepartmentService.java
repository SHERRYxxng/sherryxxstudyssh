package sherry.study.JdbcTemplate.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sherry.study.JdbcTemplate.pojo.Department;

import java.util.List;

/**
 * @ClassName:DepartmentService
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 19:15
 **/
public interface DepartmentService {
    public List<Department> getAllDepts();
}

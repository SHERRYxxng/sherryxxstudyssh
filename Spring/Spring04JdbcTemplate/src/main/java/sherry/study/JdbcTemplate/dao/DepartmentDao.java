package sherry.study.JdbcTemplate.dao;

import sherry.study.JdbcTemplate.pojo.Department;

import java.util.List;

/**
 * @ClassName:Department
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 19:09
 **/
public interface DepartmentDao {
        public List<Department> selectAllDepts();

}

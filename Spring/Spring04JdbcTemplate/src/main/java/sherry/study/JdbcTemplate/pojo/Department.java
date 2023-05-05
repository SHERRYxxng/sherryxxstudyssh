package sherry.study.JdbcTemplate.pojo;

import java.util.List;
import java.util.Map;


public class Department {
    private  int id;
    private  String name;

    private List<Employee> emplist;
    private Map<Integer, Employee> empMap;

    @Override
    public String toString() {
        return "sherry.study.JdbcTemplate.dao.pojo.DepartmentDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emplist=" + emplist +
                ", empMap=" + empMap +
                '}';
    }

    public List<Employee> getEmplist() {
        return emplist;
    }

    public void setEmplist(List<Employee> emplist) {
        this.emplist = emplist;
    }

    public Map<Integer, Employee> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<Integer, Employee> empMap) {
        this.empMap = empMap;
    }

    public Department(int id, String name, List<Employee> emplist, Map<Integer, Employee> empMap) {
        this.id = id;
        this.name = name;
        this.emplist = emplist;
        this.empMap = empMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }
}

package sherry.study.JdbcTemplate.pojo;

import org.springframework.stereotype.Repository;

@Repository("employee")
public class Employee {
    private int id;
    private String last_name;
    private int gender;
    private String email;
    private double Salary;
    private int dept_id;
    private Department dept;
    public void initMethod(){
        System.out.println("我是初始化方法");
    }
    public void desMethod(){
        System.out.println("我是销毁方法");
    }
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Employee(int id, String last_name, int gender, String email, double salary, int dept_id, Department dept) {
        this.id = id;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        Salary = salary;
        this.dept_id = dept_id;
        this.dept = dept;
    }

    public Employee(Department dept1) {
        this.dept = dept1;
    }

    @Override
    public String toString() {
        return "sherry.study.JdbcTemplate.dao.pojo.Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", Salary=" + Salary +
                ", dept_id=" + dept_id +
                ", dept=" + dept +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Employee(int id, String last_name, int gender, String email, double salary, int dept_id) {
        this.id = id;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        Salary = salary;
        this.dept_id = dept_id;
    }

    public Employee() {

    }
}

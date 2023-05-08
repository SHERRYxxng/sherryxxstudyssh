package sherry.controller.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName:Employee
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/8 14:39
 **/
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private String[] hobbies;
    private List<String> hobbies2;
    private Department department;

    public Employee(Integer id, String lastName, String email, String[] hobbies, List<String> hobbies2, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.hobbies = hobbies;
        this.hobbies2 = hobbies2;
        this.department = department;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", hobbies2=" + hobbies2 +
                ", department=" + department +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getHobbies2() {
        return hobbies2;
    }

    public void setHobbies2(List<String> hobbies2) {
        this.hobbies2 = hobbies2;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

package sherry.study.JdbcTemplate.pojo;

/**
 * @ClassName:grade
 * @Description:SHERRY数据库中的表的grade的实现类
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/4 16:58
 **/
public class grade {
    private int id;
    private int name;


    public grade() {
    }

    public grade(int id, int name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public int getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(int name) {
        this.name = name;
    }

    public String toString() {
        return "sherry.study.JdbcTemplate.dao.pojo.grade{id = " + id + ", name = " + name + "}";
    }
}

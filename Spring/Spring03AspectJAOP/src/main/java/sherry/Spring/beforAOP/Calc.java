package sherry.Spring.beforAOP;

/**
 * @ClassName:Calc
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @Date: 2023/5/2 22:05
 **/
public interface Calc{
    /*
     * @Description 加法
     * @Date  2023/5/2 
     * @Param [a, b]
     * @return void
     * @Author SHERRY       
     * @Version 1.0
     **/
     int add(int a,int b);
    /*
     * @Description 减法
     * @Date  2023/5/2 
     * @Param [a, b]
     * @return void
     * @Author SHERRY       
     * @Version 1.0
     **/
     int sub(int a,int b);
    /*
     * @Description 乘法
     * @Date  2023/5/2 
     * @Param [a, b]
     * @return void
     * @Author SHERRY       
     * @Version 1.0
     **/
     int mul(int a,int b);
    /*
     * @Description 除法
     * @Date  2023/5/2 
     * @Param [a, b]
     * @return void
     * @Author SHERRY
     * @Version 1.0
     **/
     int div(int a,int b);
}

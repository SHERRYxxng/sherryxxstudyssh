package sherry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName:HelloWorld
 * @Description:
 * @Author: SHERRY
 * @Version: 1.0
 * @email: SHERRYth743779@gmail.com
 * @Date: 2023/5/6 15:24
 **/
@Controller
public class HelloWorld {
    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "test";
    }
    //测试REST风格获取操作
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testREST_get(@PathVariable("id") Integer id){
        System.out.println("testREST_get,传入的id的值是："+id);
        return "success";
    }

    //测试REST风格添加操作
    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testREST_post(){
        System.out.println("testREST_post,添加操作");
        return "success";
    }

    //测试REST风格更新操作
    @RequestMapping(value = "/testRest",method = RequestMethod.PUT)
    public String testREST_put(){
        System.out.println("testREST_put,更新操作");
        return "success";
    }

    //测试REST风格删除操作
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testREST_delete(@PathVariable("id") Integer id){
        System.out.println("testREST_delete,传入的id的值是："+id);
        return "success";
    }
    @RequestMapping("/testspringmvc")
    public String helloWorld(){
        System.out.println("Hello SpringMVC!");
        return "success";
    }
}

package com.lee.boot.controller;

import com.lee.boot.bean.Person;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiJing
 * @version 1.0
 */

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam MultiValueMap<String, String> params,
                                      @CookieValue("Idea-1613f353") String c,
                                      @CookieValue("Idea-1613f353") Cookie cookie) {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("id", id);
//        map.put("name", name);
//        map.put("pv", pv);
//        map.put("userAgent", userAgent);
//        map.put("header", header);
//        map.put("age", age);
//        map.put("inters", inters);
//        map.put("params", params);
        map.put("c", c);
        map.put("cookie", cookie);
        System.out.println(cookie.getName() + " ===> " + cookie.getValue());

        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", content);

        return map;
    }

    //1、请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);

        return map;
    }

    //请求路径：/boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);

        return map;
    }

    /**
     * 自定义参数绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
     *
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveuser(Person person) {

        return person;
    }
}
